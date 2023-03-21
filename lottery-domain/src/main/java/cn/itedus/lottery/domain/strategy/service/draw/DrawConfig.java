package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DrawConfig {
    @Resource
    private IDrawAlgorithm entiretyRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;
    protected static Map<Integer,IDrawAlgorithm> drawAlgorithmGroup=new ConcurrentHashMap<>();
    @PostConstruct
    public void init(){
        drawAlgorithmGroup.put(1,entiretyRateRandomDrawAlgorithm);
        drawAlgorithmGroup.put(2,singleRateRandomDrawAlgorithm);
    }
}
