package herongshen.rbac.domain.entity;

public class Dept {
    public int id;
    public String name;
    public String phone;
    public Dept() {}
    public Dept(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
