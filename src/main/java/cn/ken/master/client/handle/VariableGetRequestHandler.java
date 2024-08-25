package cn.ken.master.client.handle;

import cn.ken.master.client.common.domain.CommandRequest;
import cn.ken.master.client.common.domain.Result;

/**
 * 变量查询请求处理器
 *
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class VariableGetRequestHandler implements RequestHandleStrategy {

    @Override
    public Result<?> handleRequest(CommandRequest commandRequest) {
        return Result.success(null);
    }
}
