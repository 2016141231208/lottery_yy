package cn.itedus.lottery.infrastructure.po;

import java.util.Date;

public class Strategy {
    private Long id;
    private Long strategyId;
    private String strategyDesc;
    private Integer strategyMode;
    private Integer grantType;
    private Date grantDate;
    private String extInfo;
    private Date createTime;
    private Date updateTime;
    public Long getId(){
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public Long getStrategyId(){
        return strategyId;
    }
    public void setStrategyId(){
        this.strategyId=strategyId;
    }
    public String getStrategyDesc(){
        return strategyDesc;
    }
    public void setStrategyDesc(){
        this.strategyDesc=strategyDesc;
    }
    public Integer getStrategyMode(){
        return strategyMode;
    }
    public void setStrategyMode(){
        this.strategyMode=strategyMode;
    }
    public Integer getGrantType(){
        return grantType;
    }
    public void  setGrantType(){
        this.grantType=grantType;
    }
    public Date getGrantDate(){
        return grantDate;
    }
    public void setGrantDate(){
        this.grantDate=grantDate;
    }
    public String getExtInfo(){
        return extInfo;
    }
    public void setExtInfo(){
        this.extInfo=extInfo;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public void setCreteTime(){
        this.createTime=createTime;
    }
    public Date getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(){
        this.updateTime=updateTime;
    }
}
