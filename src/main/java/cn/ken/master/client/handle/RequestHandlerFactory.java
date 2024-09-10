package cn.ken.master.client.handle;

import cn.ken.master.core.enums.RequestTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求处理工厂类
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class RequestHandlerFactory {

    private final static Map<Integer, RequestHandleStrategy> HANDLERS = new HashMap<>();

    static {
        HANDLERS.put(RequestTypeEnum.VARIABLE_GET.getCode(), new VariableGetRequestHandler());
        HANDLERS.put(RequestTypeEnum.VARIABLE_PUT.getCode(), new VariablePutRequestHandler());
        HANDLERS.put(RequestTypeEnum.VARIABLE_ALL_GET.getCode(), new VariableGetRequestHandler());
    }

    /**
     * 根据请求类型获取对应的请求处理器
     * @param requestCode 请求方法code
     * @return 请求处理器
     */
    public static RequestHandleStrategy getRequestHandler(int requestCode) {
        return HANDLERS.get(requestCode);
    }
}
