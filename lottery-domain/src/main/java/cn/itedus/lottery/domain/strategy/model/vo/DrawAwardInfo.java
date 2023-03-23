package cn.itedus.lottery.domain.strategy.model.vo;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/21
 * @Copyright： 练习
 */
public class DrawAwardInfo {
    private String rewardId;
    private Integer awardType;
    private String awardName;
    private  String awardContent;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String rewardId, Integer awardType, String awardName, String awardContent) {
        this.rewardId = rewardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }
}
