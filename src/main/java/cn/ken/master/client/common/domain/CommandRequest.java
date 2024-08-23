package cn.ken.master.client.common.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class CommandRequest {

    /**
     * 请求名称
     */
    private String requestName;

    /**
     * 变量列表
     */
    private Map<String, String> parameterMap;

    public CommandRequest() {
        parameterMap = new HashMap<>();
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
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
