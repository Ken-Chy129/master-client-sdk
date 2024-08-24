package cn.ken.master.client.exception;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public enum MasterErrorCode {

    /**
     * 服务端连接异常
     */
    SERVER_CONNECT_ERROR(1000, "服务端连接异常"),

    /**
     * 请输入正确的服务端主机地址
     */
    SERVER_HOST_INVALID(1001, "请输入正确的服务端主机地址"),

    /**
     * 请输入正确的服务端端口号
     */
    SERVER_PORT_INVALID(1002, "请输入正确的服务端端口号"),

    /**
     * 应用名称不能为空
     */
    APP_NAME_INVALID(2, "应用名称不能为空"),

    /**
     * 要注册的变量管理类未被@MasterConfig注解标识
     */
    REGISTERED_CLAZZ_INVALID(3, "要注册的变量管理类未被@MasterConfig注解标识"),

    /**
     * 受管控变量不可访问
     */
    CONTROLLABLE_VARIABLE_INACCESSIBLE(10001, "请将受管控变量 {%s} 的访问修饰符设置为public"),


    ;

    private final Integer code;

    private final String msg;

    MasterErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
