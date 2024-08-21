package cn.ken.master.client.util;

import cn.ken.master.client.annotations.MasterConfig;
import cn.ken.master.client.common.domain.CommandRequest;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Ken-Chy129
 * @date 2024/8/12
 */
public class MasterUtil {

    /**
     * 校验类是否为合法的变量管控类
     */
    public static boolean isVariableMasterClazzValid(Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        MasterConfig declaredAnnotation = clazz.getDeclaredAnnotation(MasterConfig.class);
        return declaredAnnotation != null;
    }

    /**
     * 将服务端发送的请求进行解析
     * @param rawRequest 格式为：/请求方法名?namespace=
     * @return 解析后的请求对象
     */
    public static CommandRequest parseRequest(String rawRequest) {
        CommandRequest commandRequest = new CommandRequest();
        if (StringUtil.isBlank(rawRequest)) {
            return commandRequest;
        }
        String[] split = rawRequest.split("\\?");
        if (split.length != 2) {
            return commandRequest;
        }
        String requestType = split[0];
        commandRequest.setRequestType(Integer.valueOf(requestType));
        String parameters = split[1];
        for (String parameter : parameters.split("&")) {
            if (StringUtil.isBlank(parameter)) {
                continue;
            }
            String[] pair = parameter.split("=");
            if (pair.length != 2) {
                continue;
            }
            String key = pair[0].strip();
            String value = URLDecoder.decode(pair[1].strip(), StandardCharsets.UTF_8);
            commandRequest.addParameter(key, value);
        }
        return commandRequest;
    }
}
