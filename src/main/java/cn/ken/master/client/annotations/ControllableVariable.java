package cn.ken.master.client.annotations;

import cn.ken.master.client.callback.DefaultCallback;
import cn.ken.master.client.callback.MasterCallback;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识变量为可控制的变量，即受Master管控
 * @author Ken-Chy129
 * @date 2024/8/11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllableVariable {

    /**
     * 变量描述
     */
    String desc();

    /**
     * 自定义变量回调处理
     */
    Class<? extends MasterCallback> callback() default DefaultCallback.class ;


}
