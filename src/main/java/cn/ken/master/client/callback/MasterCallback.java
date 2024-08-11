package cn.ken.master.client.callback;

/**
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public interface MasterCallback {

    /**
     * 处理变量修改回调函数，通过namespace+name唯一确认一个可管理变量
     * @param namespace 变量所属的命名空间
     * @param name 变量名
     * @param value 变量值
     */
    void handleValueChange(String namespace, String name, Object value);


}
