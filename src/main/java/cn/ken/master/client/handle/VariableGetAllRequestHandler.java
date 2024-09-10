package cn.ken.master.client.handle;

import cn.ken.master.client.annotations.ControllableVariable;
import cn.ken.master.client.core.MasterContainer;
import cn.ken.master.core.model.Request;
import cn.ken.master.core.model.Result;
import cn.ken.master.core.model.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2024/8/23
 */
public class VariableGetAllRequestHandler implements RequestHandleStrategy {

    @Override
    public Result<List<Variable>> handleRequest(Request request) {
        Map<String, Map<String, ControllableVariable>> masterVariableMap = MasterContainer.getAllControllableVariableMap();
        List<Variable> variableList = new ArrayList<>();
        for (var entry : masterVariableMap.entrySet()) {
            String namespace = entry.getKey();
            Map<String, ControllableVariable> variableMap = entry.getValue();
            for (var variableEntry : variableMap.entrySet()) {
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
