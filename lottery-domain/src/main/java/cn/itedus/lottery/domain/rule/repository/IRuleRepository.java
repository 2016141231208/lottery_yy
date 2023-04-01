package cn.itedus.lottery.domain.rule.repository;

import cn.itedus.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @description:规则信息仓储服务接口
 * @author：yanliqiao
 * @date: 2023/3/29
 * @Copyright： 练习
 */
public interface IRuleRepository {
    /**
     * 查询规则决策树配置
     *
     * @param treeId    决策树ID
     * @return          决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);
}
