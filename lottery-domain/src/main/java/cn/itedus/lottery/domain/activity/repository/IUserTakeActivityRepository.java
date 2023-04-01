package cn.itedus.lottery.domain.activity.repository;

import cn.itedus.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.itedus.lottery.domain.activity.model.vo.UserTakeActivityVO;

import java.util.Date;

/**
 * @description:用户参与活动仓储接口
 * @author：yanliqiao
 * @date: 2023/3/28
 * @Copyright： 练习
 */
public interface IUserTakeActivityRepository {
    /**
     * 扣减个人活动参与次数
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param uId               用户ID
     * @param partakeDate       领取时间
     * @return                  更新结果
     */

    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate);

    /**
     * 领取活动
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param uId               用户ID
     * @param takeDate          领取时间
     * @param takeId            领取ID
     */
    void takeActivity(Long activityId, String activityName, Long strategyId, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

    UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);

    void saveUserStrategyExport(DrawOrderVO drawOrder);

    int lockTakeActivity(String getuId, Long activityId,Long takeId);
}

