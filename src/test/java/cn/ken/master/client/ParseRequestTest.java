package cn.ken.master.client;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.util.MasterUtil;


/**
 * @author Ken-Chy129
 * @date 2024/8/22
 */
public class ParseRequestTest {

    public static void main(String[] args) {
        CommandRequest commandRequest = MasterUtil.parseRequest("1?namespace=hello&name=fff&value=123");
        System.out.println(commandRequest.getRequestType());
        System.out.println(commandRequest.getParameterMap());
    }
}
