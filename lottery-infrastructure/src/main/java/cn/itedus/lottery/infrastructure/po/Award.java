package cn.itedus.lottery.infrastructure.po;

import java.util.Date;

public class Award {
   private Long id;

   private String awardId;

   private Integer awardType;
   private String awardName;
   private String awardContent;
   private Date createTime;
   private Date updateTime;
   public Long getId(){
       return id;
   }
   public void setId(Long id){
       this.id=id;
   }
   public String getAwardId(){
       return awardId;
   }
   public void setAwardId(String awardId){
       this.awardId=awardId;
   }
   public Integer getAwardType(){
       return awardType;
   }
   public void setAwardType(Integer awardType){
       this.awardType=awardType;
   }
   public String getAwardName(){
       return awardName;
   }
   public void setAwardName(String awardName){
       this.awardName=awardName;
   }
   public String getAwardContent(){
       return awardContent;
   }
   public void setAwardContent(String awardContent){
       this.awardContent=awardContent;
   }
   public Date getCreateTime(){
       return createTime;
   }
   public void setCreateTime(){
       this.createTime=createTime;
   }
   public Date getUpdateTime(){
       return updateTime;
   }
   public void setUpdateTime(){
       this.updateTime=updateTime;
   }
}
