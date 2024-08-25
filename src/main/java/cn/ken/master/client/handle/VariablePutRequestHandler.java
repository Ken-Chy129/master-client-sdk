package cn.ken.master.client.handle;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.common.domain.Result;

/**
 * 变量修改请求处理器
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class VariablePutRequestHandler implements RequestHandleStrategy {

    @Override
    public Result<?> handleRequest(CommandRequest commandRequest) {
        return Result.success(null);
    }
}
