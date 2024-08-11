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

    private final static Map<CommandRequestTypeEnum, RequestHandleStrategy> HANDLERS = new HashMap<>();

    static {
        HANDLERS.put(CommandRequestTypeEnum.VARIABLE_GET, new VariableGetRequestHandler());
        HANDLERS.put(CommandRequestTypeEnum.VARIABLE_PUT, new VariablePutRequestHandler());
        HANDLERS.put(CommandRequestTypeEnum.VARIABLE_SCENE, new VariableGetRequestHandler());
        HANDLERS.put(CommandRequestTypeEnum.VARIABLE_BATCH_GET, new VariableGetRequestHandler());
    }

    /**
     * 根据请求类型获取对应的请求处理器
     * @param requestType 请求类型
     * @return 请求处理器
     */
    public static RequestHandleStrategy getRequestHandler(Integer requestType) {
        CommandRequestTypeEnum type = CommandRequestTypeEnum.getFromCode(requestType);
        return HANDLERS.get(type);
    }
}
