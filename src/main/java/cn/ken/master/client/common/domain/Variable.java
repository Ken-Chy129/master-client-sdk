package cn.ken.master.client.common.domain;

/**
 * @author Ken-Chy129
 * @date 2024/8/11
 */
public class Variable {

    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 变量名称
     */
    private String name;

    /**
     * 变量值
     */
    private String value;

    /**
     * 描述
     */
    private String description;

    public Variable() {
    }

    public Variable(String namespace, String name, String description) {
        this.namespace = namespace;
        this.name = name;
        this.description = description;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
