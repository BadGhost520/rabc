package herongshen.rbac.domain.entity;

public class Role {
    public int id;
    public String name;
    public String dataScope;
    public Role() {}
    public Role(String name, String dataScope) {
        this.name = name;
        this.dataScope = dataScope;
    }
}
