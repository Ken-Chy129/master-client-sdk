package cn.ken.master.client.core;

import cn.ken.master.client.annotations.MasterConfig;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class MasterContainer {

    /**
     * key：namespace，value：clazz
     */
    private static Map<String, Class<?>> variableMasterMap;

    /**
     * key: namespace, value: {key: name, value:Field}，todo：缓存减少反射开销
     */
    private static Map<String, Map<String, Field>> variableFieldMap;

    /**
     * 添加变量管控类到上下文
     * @param variableMasterClazz
     */
    public static void addVariableMaster(Class<?> variableMasterClazz) {
        MasterConfig annotation = variableMasterClazz.getDeclaredAnnotation(MasterConfig.class);
        assert annotation != null;
        String namespace = annotation.namespace();
        if (namespace == null) {
            namespace = variableMasterClazz.getName();
        }
        variableMasterMap.put(namespace, variableMasterClazz);
    }

    /**
     * 注册管控变量
     */
    private static void registerVariables() {

    }

    /**
     * 查询变量值
     */
    public static String getVariableValue(String namespace, String name) {
        return "";
    }

    /**
     * 修改变量值
     */
    public static void putVariableValue(String namespace, String name, String value) {

    }
}
