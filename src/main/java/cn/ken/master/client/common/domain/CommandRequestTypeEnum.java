package cn.ken.master.client.common.domain;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public enum CommandRequestTypeEnum {

    VARIABLE_GET(1, ""),
    VARIABLE_PUT(2, ""),
    VARIABLE_SCENE(3, ""),
    VARIABLE_BATCH_GET(4, ""),
    ;

    private final Integer code;

    private final String desc;

    CommandRequestTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CommandRequestTypeEnum getFromCode(Integer code) {
        for (CommandRequestTypeEnum value : CommandRequestTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
