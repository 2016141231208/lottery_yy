package cn.itedus.lottery.test.application;

import cn.itedus.lottery.application.mq.producer.KafkaProducer;
import cn.itedus.lottery.application.process.req.DrawProcessReq;
import cn.itedus.lottery.application.process.res.DrawProcessResult;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.vo.InvoiceVO;
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
        InvoiceVO invoice=new InvoiceVO();
        invoice.setuId("fustack");
        invoice.setOrderId(1444540456057864192L);
        invoice.setAwardId("3");
        invoice.setAwardType(Constants.AwardType.DESC.getCode());
        invoice.setAwardName("Code");
        invoice.setAwardContent("苹果电脑");
        invoice.setShippingAddress(null);
        invoice.setExtInfo(null);

        kafkaProducer.sendLotteryInvoice(invoice);
        while(true){
            Thread.sleep(10000);
        }
    }

}
