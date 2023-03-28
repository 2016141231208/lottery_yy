package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.activity.model.vo.AlterStateVO;
import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */

//在使用mybatis框架时，我们发现mapper接口是没有实现类的，取而代之的是一个xml文件。也就是说我们调用mapper接口，实际上是使用了对应的mapper.xml中定义sql语句完成数据操作的。
//Mybatis的接口不需要实现类，实际上是使用了JDK动态代理的方式创建代理对象完成的
@Mapper
public interface IActivityDao {
   /**
    * 插入数据
    * @param req 入参
    */
   void insert(Activity req);

   /**
    * 根据活动号查询活动信息
    * @param activityId 活动号
    * @return 活动信息
    */
   Activity queryActivityById(Long activityId);

   /**
    * 变更活动状态
    * @param alterStateV0 [activityId、beforeState、afterState]
    * @return 更新数量
    */
   int alterState(AlterStateVO alterStateV0);

    int subtractionActivityStock(Long activityId);
}
