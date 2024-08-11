package cn.ken.master.client.core;

import cn.ken.master.client.annotations.MasterConfig;

import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class MasterConfigContext {

    /**
     * key：namespace，value：clazz
     */
    private static Map<String, Class<?>> variableMasterMap;

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
}
