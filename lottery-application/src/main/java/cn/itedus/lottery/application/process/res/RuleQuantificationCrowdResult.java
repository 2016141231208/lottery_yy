package cn.itedus.lottery.application.process.res;

import cn.itedus.lottery.common.Result;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/29
 * @Copyright： 练习
 */
public class RuleQuantificationCrowdResult extends Result {
    private Long activityId;
    public RuleQuantificationCrowdResult(String code, String info) {
        super(code, info);
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
