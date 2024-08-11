package cn.ken.master.client.exception;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public enum MasterErrorCode {

    /**
     * 服务端连接异常
     */
    SERVER_CONNECT_ERROR(1, "服务端连接异常"),

    /**
     *
     */
    PARAM_INVALID(2, "参数不合法")
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
