package cn.ken.master.client.common.domain;

/**
 * @author Ken-Chy129
 * @date 2024/8/25
 */
public class VariableChange {

    protected String namespace;

    private String name;

    private String beforeValue;

    private String afterValue;

    public VariableChange() {
    }

    public VariableChange(String namespace, String name, String beforeValue, String afterValue) {
        this.namespace = namespace;
        this.name = name;
        this.beforeValue = beforeValue;
        this.afterValue = afterValue;
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

    public String getBeforeValue() {
        return beforeValue;
    }

    public void setBeforeValue(String beforeValue) {
        this.beforeValue = beforeValue;
    }

    public String getAfterValue() {
        return afterValue;
    }

    public void setAfterValue(String afterValue) {
        this.afterValue = afterValue;
    }
}
