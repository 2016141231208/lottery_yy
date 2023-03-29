package cn.itedus.lottery.application.process.res;

import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.strategy.model.vo.DrawAwardInfo;

import javax.naming.spi.DirStateFactory;

/**
 * @description:活动抽奖结果
 * @author：yanliqiao
 * @date: 2023/3/28
 * @Copyright： 练习
 */
public class DrawProcessResult extends Result {
    private DrawAwardInfo drawAwardInfo;
    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardInfo drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }
}
