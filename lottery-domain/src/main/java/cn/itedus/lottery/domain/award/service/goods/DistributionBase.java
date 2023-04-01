package cn.itedus.lottery.domain.award.service.goods;
import cn.itedus.lottery.domain.award.repository.IOrderRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/23
 * @Copyright： 练习
 */
public abstract class DistributionBase {
    protected Logger logger= LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IOrderRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer code, String info) {
        // TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uId：{}", uId);
    }

}
