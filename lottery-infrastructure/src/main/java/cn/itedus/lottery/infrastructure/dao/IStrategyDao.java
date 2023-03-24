package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {
    /**
     * 查询策略配置
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * 插入配置信息
     * @param req 策略配置
     */
    void insert(Strategy req);
}
