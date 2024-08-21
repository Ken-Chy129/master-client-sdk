package cn.ken.master.client.common.domain;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, String> parameterMap;

    public CommandRequest() {
        parameterMap = new HashMap<>();
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Map<String, String> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<String, String> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public void addParameter(String key, String value) {
        parameterMap.put(key, value);
    }
}
