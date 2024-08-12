package cn.ken.master.client.util;

import cn.ken.master.client.annotations.MasterConfig;

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
}
