package cn.itedus.lottery.application.process.req;

/**
 * @description:抽奖请求
 * @author：yanliqiao
 * @date: 2023/3/28
 * @Copyright： 练习
 */
public class DrawProcessReq {
    private String uId;
    private Long activityId;
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public DrawProcessReq() {
    }
}
