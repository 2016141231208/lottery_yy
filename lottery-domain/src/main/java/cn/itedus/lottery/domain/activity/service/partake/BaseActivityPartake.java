package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:活动领取模板抽象类
 * @author：yanliqiao
 * @date: 2023/3/28
 * @Copyright： 练习
 */
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake{
    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;
    @Override
    public PartakeResult doPartake(PartakeReq req){
        // 1. 查询是否存在未执行抽奖领取活动单【user_take_activity 存在 state = 0，领取了但抽奖过程失败的，可以直接返回领取结果继续抽奖】
        UserTakeActivityVO userTakeActivityVO=this.queryNoConsumedTakeActivityOrder(req.getActivityId(),req.getuId());
        if(null!=userTakeActivityVO){
            return buildPartakeResult(userTakeActivityVO.getStrategyId(), userTakeActivityVO.getTakeId());
        }
        //2.查询活动账单
        ActivityBillVO activityBillVO=super.queryActivityBill(req);
        //3.活动信息校验处理【活动库存、状态、日期、个人参与次数】
        Result checkResult=this.checkActivityBill(req,activityBillVO);
        if(!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())){
            return new PartakeResult(checkResult.getCode(),checkResult.getInfo());
        }
        //4.扣减活动库存【目前为直接对配置库中的lottery.activity直接操作表扣库存，后续优化为Redis扣减】
        Result subtractionActivityResult=this.subtractionActivityStock(req);
        if(!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityResult.getCode())){
            return new PartakeResult(subtractionActivityResult.getCode(),subtractionActivityResult.getInfo());
        }
        //5.插入领取活动信息【个人用户把活动信息写入到用户表】
        Long takeId=idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        Result grabResult = this.grabActivity(req,activityBillVO,takeId);
        if(!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())){
            return new PartakeResult(grabResult.getCode(),grabResult.getInfo());
        }

        return buildPartakeResult(activityBillVO.getStrategyId(),takeId);

    }
    private PartakeResult buildPartakeResult(Long strategyId,Long takeId){
        PartakeResult partakeResult=new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(strategyId);
        partakeResult.setTakeId(takeId);
        return partakeResult;
    }
    protected abstract UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String getuId) ;

    /**
     * 领取活动
     *
     * @param partake 参与活动请求
     * @param bill    活动账单
     * @param takeId    领取活动ID
     * @return 领取结果
     */

    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill,Long takeId);
    /**
     * 扣减活动库存
     *
     * @param req 参与活动请求
     * @return 扣减结果
     */
    protected abstract Result subtractionActivityStock(PartakeReq req) ;
    /**
     * 活动信息校验处理，把活动库存、状态、日期、个人参与次数
     *
     * @param partake 参与活动请求
     * @param bill    活动账单
     * @return 校验结果
     */

    protected abstract Result checkActivityBill(PartakeReq partake, ActivityBillVO bill);


}
