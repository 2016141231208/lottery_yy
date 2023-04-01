package cn.itedus.lottery.rpc.res;

import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/29
 * @Copyright： 练习
 */
public class DrawRes extends Result implements Serializable {
    private AwardDTO awardDTO;

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }

    public DrawRes(String code, String info) {
        super(code, info);
    }
}
