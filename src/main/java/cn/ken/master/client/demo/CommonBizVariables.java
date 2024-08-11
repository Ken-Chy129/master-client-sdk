package cn.ken.master.client.demo;


import cn.ken.master.client.annotations.ControllableVariable;

/**
 * 通用变量管控类
 */
public class CommonBizVariables {

    @ControllableVariable(desc = "是否开启xxxx缓存")
    public static Boolean OPEN_XXX_CACHE = Boolean.TRUE;
}
