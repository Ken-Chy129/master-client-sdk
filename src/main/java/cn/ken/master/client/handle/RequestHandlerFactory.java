package cn.ken.master.client.handle;

import cn.ken.master.client.common.domain.CommandRequestTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求处理工厂类
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class RequestHandlerFactory {

    private final static Map<String, RequestHandleStrategy> HANDLERS = new HashMap<>();

    static {
        HANDLERS.put(CommandRequestTypeEnum.VARIABLE_GET.getCode(), new VariableGetRequestHandler());
        HANDLERS.put(CommandRequestTypeEnum.VARIABLE_PUT.getCode(), new VariablePutRequestHandler());
        HANDLERS.put(CommandRequestTypeEnum.VARIABLE_ALL_GET.getCode(), new VariableGetRequestHandler());
    }

    /**
     * 根据请求类型获取对应的请求处理器
     * @param requestName 请求方法名
     * @return 请求处理器
     */
    public static RequestHandleStrategy getRequestHandler(String requestName) {
        return HANDLERS.get(requestName);
    }
}
