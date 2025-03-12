package herongshen.rbac.service;

import herongshen.rbac.domain.dto.DeptDto;
import herongshen.rbac.domain.entity.Dept;
import herongshen.rbac.domain.vo.Result;

public class DeptService {
    public static int DATA_SIZE = 100;
    public static Dept[] data = new Dept[DATA_SIZE + 1];
    public static int idCounter = 1;
    public static Result create(DeptDto dto) {
        if (idCounter > DATA_SIZE) {
            return Result.failure("创建失败，超出存储容量");
        }
        Dept dept = new Dept(dto.name, dto.phone);
        dept.id = idCounter++;
        data[dept.id] = dept;
        return Result.success("创建成功", null);
    }
}
