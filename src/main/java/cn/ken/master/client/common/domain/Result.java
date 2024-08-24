package cn.ken.master.client.common.domain;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2074303239886411976L;

    private Boolean success;

    private String message;

    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
