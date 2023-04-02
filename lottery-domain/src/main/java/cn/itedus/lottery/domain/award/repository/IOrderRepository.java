package cn.itedus.lottery.domain.award.repository;

/**
 * @description:奖品表仓储服务接口
 * @author：yanliqiao
 * @date: 2023/3/30
 * @Copyright： 练习
 */
public interface IOrderRepository {
    void updateUserAwardState(String uId,Long orderId, String awardId, Integer grantState);
}
