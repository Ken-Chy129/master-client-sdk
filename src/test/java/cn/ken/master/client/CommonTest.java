package cn.ken.master.client;

import cn.ken.master.client.exception.MasterErrorCode;

/**
 * @author Ken-Chy129
 * @date 2024/8/24
 */
public class CommonTest {

    public static void main(String[] args) {
        System.out.println(String.format(MasterErrorCode.CONTROLLABLE_VARIABLE_INACCESSIBLE.getMsg(), "hello"));
    }
}
