package cn.ken.master.client.demo;

import cn.ken.master.client.core.MasterManager;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class Test {

    public static void main(String[] args) {
        MasterManager manager = new MasterManager();
        manager.setHost("xxx");
        manager.setPort(12949);
        manager.setAppName("test");
        manager.register(CommonBizVariables.class);
        manager.init();
    }
}
