package cn.ken;

import cn.ken.master.client.demo.CommonBizVariables;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        if (CommonBizVariables.OPEN_XXX_CACHE) {
            //
        }
        Class<CommonBizVariables> aClass = CommonBizVariables.class;
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
            try {
                declaredField.set(aClass, Boolean.FALSE);
                System.out.printf(String.valueOf(declaredField.get(aClass)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
