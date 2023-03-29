package cn.itedus.lottery.domain.activity.model.res;

import cn.itedus.lottery.common.Result;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/28
 * @Copyright： 练习
 */
public class PartakeResult extends Result {
    /**
     * 策略ID
     */
    private Long strategyId;

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

    /**
     * 领取活动ID
     */
    private Long takeId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }


}
