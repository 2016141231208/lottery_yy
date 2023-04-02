package cn.itedus.lottery.domain.activity.repository;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.vo.*;

import java.util.List;

/**
 * @description:活动仓库服务(活动表、奖品表、策略表、策略明细表)
 * @author：yanliqiao
 * @date: 2023/3/23
 * @Copyright： 练习
 */
public interface IActivityRepository {
    /**
     * 添加活动配置
     * @param activity 活动配置
     */
    void addActivity(ActivityVO activity);

    /**
     * 添加奖品配置结合
     * @param awardList 奖品配置集合
     */
    void addAward(List<AwardVO> awardList);

    /**
     * 添加策略配置
     * @param strategy 策略配置
     */
    void addStrategy(StrategyVO strategy);

    /**
     * 添加策略明细配置
     * @param strategyDetailList 策略明细集合
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState,Enum<Constants.ActivityState> afterState);

    ActivityBillVO queryActivityBill(PartakeReq req);
    /**
     * 扣减活动库存
     * @param activityId   活动ID
     * @return      扣减结果
     */

    int subtractionActivityStock(Long activityId);

    List<ActivityVO> scanToDoActivityList(Long id);
}
