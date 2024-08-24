package cn.ken.master.client.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Master配置类
 * @author Ken-Chy129
 * @date 2024/8/12
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Master {

    /**
     * 指定用户命名空间，唯一标识一个业务类型，不可重复
     * 如果没有设置默认使用全类名
     */
    String namespace();

    /**
     * 业务定义描述
     */
    String desc();
}
