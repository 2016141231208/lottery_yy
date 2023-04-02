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

    protected void updateUserAwardState(String uId, Long orderId, String awardId, Integer grantState) {
        awardRepository.updateUserAwardState(uId,orderId,awardId,grantState);
    }

}
