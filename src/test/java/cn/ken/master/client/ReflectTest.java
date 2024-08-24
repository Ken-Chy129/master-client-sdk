package cn.ken.master.client;

import cn.ken.master.client.demo.CommonBizVariables;

import java.lang.reflect.Field;

/**
 * @author Ken-Chy129
 * @date 2024/8/24
 */
public class ReflectTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field openXxxCache = CommonBizVariables.class.getDeclaredField("OPEN_XXX_CACHE");
        System.out.println(openXxxCache.getName());
        System.out.println(openXxxCache.canAccess(null));
        System.out.println(openXxxCache.get(null));
    }
}
