package herongshen.rbac.domain.entity;

import java.util.StringTokenizer;

public class User {
    public int id;
    public String username;
    public String name;
    public String mobile;
    public String email;
    public int deptId;
    public int roleId;
    public boolean enabled = true;
    public User() {}
    public User(String username, String name, String mobile, String email, int deptId, int roleId) {
        this.username = username;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.deptId = deptId;
        this.roleId = roleId;
    }
}
