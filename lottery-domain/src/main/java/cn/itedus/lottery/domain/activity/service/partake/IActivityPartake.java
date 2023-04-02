package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.vo.DrawOrderVO;

/**
 * @description:抽奖活动参与接口
 * @author：yanliqiao
 * @date: 2023/3/28
 * @Copyright： 练习
 */
public interface IActivityPartake {
    /**
     * 参与活动
     * @param req 入参
     * @return 领取结果
     */
    PartakeResult doPartake(PartakeReq req);
    /**
     * 保存奖品单
     * @param drawOrder 奖品单
     * @return          保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);
    void updateInvoiceMqState(String uId,Long orderId,Integer mqState);
}
