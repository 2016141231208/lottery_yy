package cn.itedus.lottery.domain.rule.service.engine;

import cn.itedus.lottery.domain.rule.service.logic.Impl.UserAgeFilter;
import cn.itedus.lottery.domain.rule.service.logic.Impl.UserGenderFilter;
import cn.itedus.lottery.domain.rule.service.logic.LogicFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:规则配置
 * @author：yanliqiao
 * @date: 2023/3/29
 * @Copyright： 练习
 */
public class EngineConfig {
    protected static Map<String, LogicFilter> logicFilterMap=new ConcurrentHashMap<>();
    @Resource
    private UserAgeFilter userAgeFilter;
    @Resource
    private UserGenderFilter userGenderFilter;
    @PostConstruct
    public void init(){
        logicFilterMap.put("userAge",userAgeFilter);
        logicFilterMap.put("userGender",userGenderFilter);
    }
}
