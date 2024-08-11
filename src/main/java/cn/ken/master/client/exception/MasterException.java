package cn.ken.master.client.exception;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class MasterException extends RuntimeException {


    public MasterException(MasterErrorCode errorCode) {
        super(errorCode.getMsg());
    }

    public MasterException(String message) {
        super((message));
    }
}
