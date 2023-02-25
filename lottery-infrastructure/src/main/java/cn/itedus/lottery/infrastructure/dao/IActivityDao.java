package cn.itedus.lottery.infrastructure.dao;

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

   void insert(Activity req);

   Activity queryActivityById(Long activityId);

}
