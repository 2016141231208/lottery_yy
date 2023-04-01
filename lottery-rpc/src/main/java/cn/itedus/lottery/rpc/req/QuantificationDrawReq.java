package cn.itedus.lottery.rpc.req;

import java.io.Serializable;
import java.util.Map;

/**
 * @description:
 * @author：yanliqiao
 * @date: 2023/3/29
 * @Copyright： 练习
 */
public class QuantificationDrawReq {
    private String uId;
    private Long treeId;
    private Map<String, Object> valMap;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }
}
