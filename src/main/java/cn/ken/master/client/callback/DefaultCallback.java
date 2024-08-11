package cn.ken.master.client.callback;

/**
 * 默认的回调策略，实现简单的值的修改
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class DefaultCallback implements MasterCallback {

    @Override
    public void handleValueChange(String namespace, String name, Object value) {

        // 1.通过namespace找到变量所在类

        // 2.通过name和反射拿到对应的变量值

        // 3.修改变量值
    }
}
