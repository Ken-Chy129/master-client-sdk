package cn.ken.master.client.common.domain;

import java.util.List;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class CommandRequest {

    /**
     * 请求类型
     * 1.查询变量值 2.修改变量值 3.批量查询变量 4.场景模板修改
     */
    private Integer requestType;

    /**
     * 变量列表
     */
    private List<Variable> variableList;

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public List<Variable> getVariableList() {
        return variableList;
    }

    public void setVariableList(List<Variable> variableList) {
        this.variableList = variableList;
    }
}
