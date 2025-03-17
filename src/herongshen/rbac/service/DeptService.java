package herongshen.rbac.service;

import java.util.Arrays;
import herongshen.rbac.domain.dto.DeptDto;
import herongshen.rbac.domain.entity.Dept;
import herongshen.rbac.domain.vo.DeptVo;
import herongshen.rbac.domain.vo.Result;
import herongshen.rbac.view.DeptView;

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
    public static DeptVo convertToVo(Dept dept) {
        return new DeptVo(dept.id, dept.name, dept.phone);
    }
    public static Result list() {
        DeptVo[] temp = new DeptVo[DATA_SIZE];
        int length = 0;
        for (int i = 1; i < idCounter; i++) {
            if (data[i] != null) {
                temp[length++] = convertToVo(data[i]);
            }
        }
        return Result.success("查询成功", Arrays.copyOf(temp, length));
    }
    public static boolean existsById(int id) {
        return id >= 1 && id < idCounter && data[id] != null;
    }
    public static Result update(DeptDto dto, int id) {
        if (!existsById(id)) {
            return Result.failure("更新失败，不存在该数据");
        }
        Dept dept = data[id];
        dept.name = dto.name;
        dept.phone = dto.phone;
        return Result.success("更新成功", null);
    }
    public static Result delete(int id) {
        if (!existsById(id)) {
            return Result.failure("删除失败，不存在该数据");
        }
        data[id] = null;
        return Result.success("删除成功", null);
    }
    public static Dept createEntity(DeptDto dto, int id) {
        Dept dept = new Dept(dto.name, dto.phone);
        dept.id = id;
        return dept;
    }
}
