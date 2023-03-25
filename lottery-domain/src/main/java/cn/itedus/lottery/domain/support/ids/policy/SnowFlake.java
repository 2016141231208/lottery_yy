package cn.itedus.lottery.domain.support.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:hutool 工具包下的雪花算法，15位雪花算法推荐：https://github.com/yitter/idgenerator/blob/master/Java/source/src/main/java/com/github/yitter/core/SnowWorkerM1.java
 * @author：yanliqiao
 * @date: 2023/3/25
 * @Copyright： 练习
 */
@Component
public class SnowFlake implements IIdGenerator {
    private Snowflake snowFlake;
    @PostConstruct
    public void init(){
        //long有64位
        long workerId;
        //0~31位，可以采用配置的方式使用
        try {
            workerId=NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch (Exception e){
            workerId=NetUtil.getLocalhostStr().hashCode();
        }
        workerId=workerId>>16&31;
        long dataCenterId=1L;
        snowFlake = IdUtil.createSnowflake(workerId,dataCenterId);

    }
    @Override
    public synchronized long nextId() {
        return snowFlake.nextId();
    }
}
