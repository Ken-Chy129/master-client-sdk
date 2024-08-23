package cn.ken.master.client.common.domain;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public enum CommandRequestTypeEnum {

    VARIABLE_GET("getByNamespace"),
    VARIABLE_PUT("put"),
    VARIABLE_ALL_GET("getAll"),
    ;


    private final String code;

    CommandRequestTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static CommandRequestTypeEnum getFromCode(String code) {
        for (CommandRequestTypeEnum value : CommandRequestTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
