package cn.itedus.lottery.domain.activity.service.partake;

import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.itedus.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/28
 * @Copyright： 练习
 */
public class ActivityPartakeSupport {
    @Resource
    protected IActivityRepository activityRepository;
    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }
}
