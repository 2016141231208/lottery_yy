package cn.itedus.lottery.domain.strategy.model.vo;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/21
 * @Copyright： 练习
 */
public class DrawAwardInfo {
    private String rewardId;
    private String awardName;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String rewardId, String awardName) {
        this.rewardId = rewardId;
        this.awardName = awardName;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
