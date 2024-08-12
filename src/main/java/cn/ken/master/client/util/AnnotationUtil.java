package cn.ken.master.client.util;

import cn.ken.master.client.annotations.MasterConfig;

/**
 * 注解工具类
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class AnnotationUtil {

    /**
     * 校验类是否为合法的变量管控类
     */
    public static Boolean isVariableMasterClazzValid(Class<?> clazz) {
        if (clazz == null) {
            return Boolean.FALSE;
        }
        MasterConfig declaredAnnotation = clazz.getDeclaredAnnotation(MasterConfig.class);
        if (declaredAnnotation == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}