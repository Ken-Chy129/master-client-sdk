package cn.ken.master.client.handle;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.core.MasterContainer;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2024/8/23
 */
public class VariableGetAllRequestHandler implements RequestHandleStrategy {

    @Override
    public void handleRequest(CommandRequest request) {
        Map<String, Map<String, Field>> nasterFieldMap = MasterContainer.getNasterFieldMap();

    }
}
