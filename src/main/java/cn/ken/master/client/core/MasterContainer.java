package cn.ken.master.client.core;

import cn.ken.master.client.annotations.Master;
import cn.ken.master.client.exception.MasterErrorCode;
import cn.ken.master.client.exception.MasterException;
import cn.ken.master.client.util.MasterUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class MasterContainer {

    /**
     * key: namespace, value: {key: name, value:Field}，todo：缓存减少反射开销
     */
    private static final Map<String, Map<String, Field>> NASTER_FIELD_MAP = new HashMap<>();

    /**
     * 添加变量管控类到上下文
     * @param masterClazz 变量管控类
     */
    public static void addVariableMaster(Class<?> masterClazz) {
        Master annotation = masterClazz.getDeclaredAnnotation(Master.class);
        assert annotation != null;
        String namespace = annotation.namespace();
        if (Objects.isNull(namespace)) {
            namespace = masterClazz.getName();
        }
        Map<String, Field> fieldMap = new HashMap<>();
        Field[] declaredFields = masterClazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (MasterUtil.isMasterVariable(declaredField)) {
                fieldMap.put(declaredField.getName(), declaredField);
            }
        }
        NASTER_FIELD_MAP.put(namespace, fieldMap);
    }

    public static Map<String, Map<String, Field>> getNasterFieldMap() {
        return NASTER_FIELD_MAP;
    }

    /**
     * 查询指定变量管控类所有可管控字段
     */
    public static Map<String, Field> getMasterField(String namespace) {
        return NASTER_FIELD_MAP.get(namespace);
    }

    /**
     * 查询指定变量管控类指定字段
     */
    public static Field getMasterField(String namespace, String name) {
        return Optional.ofNullable(NASTER_FIELD_MAP.get(namespace))
                .map(fieldMap -> fieldMap.get(name))
                .orElse(null);
    }

    /**
     * 查询指定变量管控类指定字段的值
     */
    public static Object getMasterFieldValue(String namespace, String name) {
        return Optional.ofNullable(NASTER_FIELD_MAP.get(namespace))
                .map(fieldMap -> fieldMap.get(name))
                .map(filed -> {
                    try {
                        return filed.get(null);
                    } catch (IllegalAccessException e) {
                        throw new MasterException(e.getMessage());
                    }
                })
                .orElseThrow(null);
    }

    /**
     * 修改变量值
     */
    public static void putVariableValue(String namespace, String name, String value) {

    }
}
