package cn.itedus.lottery.test.interfaces;

import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.rpc.ILotteryActivityBooth;
import cn.itedus.lottery.rpc.req.DrawReq;
import cn.itedus.lottery.rpc.req.QuantificationDrawReq;
import cn.itedus.lottery.rpc.res.DrawRes;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/30
 * @Copyright： 练习
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryActivityBoothTest {
    private Logger logger= LoggerFactory.getLogger(LotteryActivityBoothTest.class);
    @Resource
    ILotteryActivityBooth lotteryActivityBooth;
    @Test
    public void test_draw(){
        DrawReq drawReq=new DrawReq();
        drawReq.setuId("xiaofuge");
        drawReq.setActivityId(100001L);
        DrawRes drawRes = lotteryActivityBooth.doDraw(drawReq);
        logger.info("请求参数：{}", JSON.toJSONString(drawReq));
        logger.info("测试结果：{}", JSON.toJSONString(drawRes));

    }
    @Test
    public void test_doQuantificationDraw(){
        QuantificationDrawReq req=new QuantificationDrawReq();
        req.setuId("xiaofuge");
        req.setTreeId(2110081902L);
        req.setValMap(new HashMap<String, Object>() {{
            put("gender", "man");
            put("age", "18");
        }});
        DrawRes drawRes=lotteryActivityBooth.doQuantificationDraw(req);
        logger.info("请求参数：{}", JSON.toJSONString(req));
        logger.info("测试结果：{}", JSON.toJSONString(drawRes));



    }
}
