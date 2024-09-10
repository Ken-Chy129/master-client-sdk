package cn.ken.master.client.handle;

import cn.ken.master.core.model.Request;
import cn.ken.master.core.model.Request;
import cn.ken.master.core.model.Result;
import cn.ken.master.core.constant.RequestParameterKeyConstants;
import cn.ken.master.core.model.VariableChange;
import cn.ken.master.client.core.MasterContainer;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

/**
 * 变量修改请求处理器
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class VariablePutRequestHandler implements RequestHandleStrategy {

    @Override
    public Result<VariableChange> handleRequest(Request commandRequest) {
        Map<String, String> parameterMap = commandRequest.getParameterMap();
        String namespace = parameterMap.get(RequestParameterKeyConstants.NAMESPACE);
        String name = parameterMap.get(RequestParameterKeyConstants.VARIABLE_NAME);
        String value = parameterMap.get(RequestParameterKeyConstants.VARIABLE_VALUE);
        if (Objects.isNull(namespace) || Objects.isNull(name)) {
            return Result.error("");
        }
        Field field = MasterContainer.getMasterField(namespace, name);
        if (Objects.isNull(field)) {
            return Result.error("");
        }
        try {
            String beforeValue = (String) field.get(null);
            field.set(null, value);
            return Result.success(new VariableChange(namespace, name, beforeValue, value));
        } catch (IllegalAccessException e) {
            return Result.error("");
        }
    }
}
