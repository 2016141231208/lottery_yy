package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.vo.*;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.itedus.lottery.common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:定义抽奖过程，模式模版
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec{
    private Logger logger= LoggerFactory.getLogger(AbstractDrawBase.class);

    /**
     * 检验抽奖策略是否已经初始化内存
     * @param strategyId 抽奖策略ID
     * @param strategyMode 抽奖策略模式
     * @param strategyDetailList 抽奖策略详情
     */
    private void checkAndInitRateDate(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList){

        //非单向概率，不必存入缓存
//        if(!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)){
//            return;
//        }
        IDrawAlgorithm drawAlgorithm=drawAlgorithmGroup.get(strategyMode);
        //已初始化过的数据，不必重复初始化
        if(drawAlgorithm.isExistRateTuple(strategyId)){
            return;
        }
       //解析并解析并初始化中奖概率数据到散列表
        List<AwardRateVO> awardRateVOList =new ArrayList<>(strategyDetailList.size());
        for(StrategyDetailBriefVO strategyDetail:strategyDetailList){
            awardRateVOList.add(new AwardRateVO(strategyDetail.getAwardId(),strategyDetail.getAwardRate()));
        }
        drawAlgorithm.initRateTuple(strategyId, awardRateVOList);
    }

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        //1.获取抽奖策略
        StrategyRich strategyRich=super.queryStrategyRich(req.getStrategyId());
        StrategyBriefVO strategy=strategyRich.getStrategy();
        //2.检验抽奖策略是否已经初始化到内存
        this.checkAndInitRateDate(req.getStrategyId(), strategy.getStrategyMode(),strategyRich.getStrategyDetailList());
        //3.获取不在抽奖范围中的列表，包括：奖品库存为空、风控策略、临时调整等
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());
        //4.执行抽奖算法
        String awardId=this.drawAlgorithm(req.getStrategyId(),drawAlgorithmGroup.get(strategy.getStrategyMode()),excludeAwardIds);
        //5.包装中奖结果
        return buildDrawResult(req.getuId(),req.getStrategyId(),awardId);
    }

    protected abstract List<String> queryExcludeAwardIds(Long strategyId) ;
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);
    private DrawResult buildDrawResult(String uId,Long strategyId,String awardId){
        if(null==awardId){
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}",uId,strategyId);
            return new DrawResult(uId,strategyId,Constants.DrawState.FAIL.getCode());
        }
        AwardBriefVO award=super.queryAwardInfoByAwardId(awardId);
        DrawAwardVO drawAwardVO =new DrawAwardVO(uId,award.getAwardId(),award.getAwardType(),award.getAwardName(),award.getAwardContent());
        logger.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uId, strategyId, awardId, award.getAwardName());
        return new DrawResult(uId,strategyId,Constants.DrawState.SUCCESS.getCode(), drawAwardVO);
    }
}
