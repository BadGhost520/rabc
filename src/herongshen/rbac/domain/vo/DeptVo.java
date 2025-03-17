package herongshen.rbac.domain.vo;

import herongshen.rbac.domain.dto.DeptDto;

public class DeptVo {
    public int id;
    public String name;
    public String phone;
    public DeptVo() {}
    public DeptVo(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
