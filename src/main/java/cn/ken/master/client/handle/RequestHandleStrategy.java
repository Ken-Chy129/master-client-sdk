package cn.ken.master.client.handle;

import cn.ken.master.client.common.domain.CommandRequest;

/**
 * 请求处理策略类
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public interface RequestHandleStrategy {

    void handleRequest(CommandRequest request);
}
