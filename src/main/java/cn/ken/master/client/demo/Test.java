package cn.ken.master.client.demo;

import cn.ken.master.client.core.MasterManager;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class Test {

    public static void main(String[] args) {
        MasterManager manager = new MasterManager();
        manager.setIp("xxx");
        manager.setPort(12949);
        manager.register("demoApp", CommonBizVariables.class);
        manager.init();
    }
}
