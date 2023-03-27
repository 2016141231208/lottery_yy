package cn.itedus.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.itedus.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:用户领取活动表DAO
 * @author：yanliqiao
 * @date: 2023/3/27
 * @Copyright： 练习
 */
@Mapper
public interface IUserTakeActivityDao {
    /**
     * 插入用户领取活动信息
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);
}
