package cn.itedus.lottery.test.application;

import cn.itedus.lottery.application.mq.KafkaProducer;
import org.junit.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:kafka消息测试
 * @author：yanliqiao
 * @date: 2023/3/30
 * @Copyright： 练习
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerTest {
    private Logger logger= LoggerFactory.getLogger(KafkaProducerTest.class);
    @Resource
    private KafkaProducer kafkaProducer;
    @Test
    public void test_send() throws InterruptedException {
        //循环发送消息
        while(true){
            kafkaProducer.send("你好，我是Lottery 001");
            Thread.sleep(3500);
        }
    }
}
