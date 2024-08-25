package cn.ken.master.client.handle;

import cn.ken.master.client.annotations.ControllableVariable;
import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.common.domain.Result;
import cn.ken.master.client.common.domain.Variable;
import cn.ken.master.client.core.MasterContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2024/8/23
 */
public class VariableGetAllRequestHandler implements RequestHandleStrategy {

    @Override
    public Result<List<Variable>> handleRequest(CommandRequest request) {
        Map<String, Map<String, ControllableVariable>> masterVariableMap = MasterContainer.getMasterVariableMap();
        List<Variable> variableList = new ArrayList<>();
        for (Map.Entry<String, Map<String, ControllableVariable>> entry : masterVariableMap.entrySet()) {
            String namespace = entry.getKey();
            Map<String, ControllableVariable> variableMap = entry.getValue();
            for (Map.Entry<String, ControllableVariable> variableEntry : variableMap.entrySet()) {
                String variableName = variableEntry.getKey();
                ControllableVariable controllableVariable = variableEntry.getValue();
                String description = controllableVariable.desc();
                Variable variable = new Variable(namespace, variableName, description);
                variableList.add(variable);
            }
        }
        return Result.success(variableList);
    }
}
