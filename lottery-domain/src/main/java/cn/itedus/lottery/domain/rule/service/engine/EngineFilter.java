package cn.itedus.lottery.domain.rule.service.engine;

import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.rule.model.res.EngineResult;

/**
 * @description:规则过滤器引擎
 * @author：yanliqiao
 * @date: 2023/3/29
 * @Copyright： 练习
 */
public interface EngineFilter {
    EngineResult process(final DecisionMatterReq matter);
}
