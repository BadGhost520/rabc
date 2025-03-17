package herongshen.rbac.view;

import herongshen.rbac.domain.dto.DeptDto;
import herongshen.rbac.domain.vo.DeptVo;
import herongshen.rbac.domain.vo.Result;
import herongshen.rbac.service.DeptService;

public class DeptView {
    public static DeptVo[] cache;
    public static void printMenu() {
        String menu = """
                ---------------------
                       部门管理
                ---------------------
                |    0...返回上级    |
                |    1...部门列表    |
                |    2...创建部门    |
                |    3...更新部门    |
                |    4...删除部门    |
                ---------------------
                请输入选项：""";
        System.out.println(menu);
    }
    public static void show() {
        String menuChoice;
        do {
            printMenu();
            menuChoice = MainView.input.nextLine();
            switch (menuChoice) {
                case "0" -> System.out.println("已返回上一级菜单");
                case "1" -> list();
                case "2" -> create();
                case "3" -> update();
                case "4" -> delete();
                default -> System.out.println("输入非法，请输入正确的菜单编号！");
            }
        } while (!"0".equals(menuChoice));
    }
    public static void list() {
        Result result = DeptService.list();
        cache = (DeptVo[]) result.data;
        System.out.println("ID\t部门名称\t部门电话");
        for (DeptVo dept : cache) {
            if (dept != null) {
                System.out.printf("%d\t%s\t%s\n", dept.id, dept.name, dept.phone);
            }
        }
    }
    public static void create() {
        System.out.println("请输入部门名称：");
        String name = MainView.input.nextLine();
        System.out.println("请输入部门电话：");
        String phone = MainView.input.nextLine();
        DeptDto dto = new DeptDto(name, phone);
        Result result = DeptService.create(dto);
        if (!result.success) {
            printError(result.message);
            return;
        }
        System.out.println(result.message);
        list();
    }
    public static void update() {
        DeptVo dept = getCacheById();
        if (dept == null) {
            return;
        }
        System.out.print("请输入部门名称，直接按回车表示不修改：");
        String name = MainView.input.nextLine();
        name = "".equals(name) ? dept.name :name;
        System.out.print("请输入部门电话，直接按回车表示不修改：");
        String phone = MainView.input.nextLine();
        phone = "".equals(phone) ? dept.phone :phone;
        DeptDto dto = new DeptDto(name, phone);
        Result result = DeptService.update(dto, dept.id);
        if (!result.success) {
            printError(result.message);
            list();
        }
    }
    public static void delete() {
        DeptVo dept = getCacheById();
        if (dept == null) {
            return;
        }
        System.out.print("输入'Y'确认删除，输入其它取消删除：");
        String confirm = MainView.input.nextLine();
        if (!"Y".equalsIgnoreCase(confirm)) {
            System.out.println("您已取消删除");
            return;
        }
        Result result = DeptService.delete(dept.id);
        if (!result.success) {
            printError(result.message);
            return;
        }
        System.out.println(result.message);
        list();
    }
    public static DeptVo getCacheById() {
        System.out.print("请输入ID，ID必须是大于0的整数");
        if (!MainView.input.hasNextInt()) {
            MainView.input.nextLine();
            printError("ID必须为整数，请输入整数值");
            return null;
        }
        int id = MainView.input.nextInt();
        MainView.input.nextLine();
        if (id < 1) {
            printError("ID必须大于0，请重新输入");
            return null;
        }
        if (cache == null) {
            Result result = DeptService.list();
            cache = (DeptVo[]) result.data;
        }
        DeptVo dept = null;
        for (DeptVo item : cache) {
            if (item.id == id) {
                System.out.println("该ID对应的数据是：");
                System.out.printf("ID：%d，名称：%s，电话：%s\n", item.id, item.name, item.phone);
                dept = item;
                break;
            }
        }
        if (dept == null) {
            printError("当前没有该ID对应的数据");
            return null;
        }
        return dept;
    }
    public static void printError(String message) {
        System.out.println("\033[31m" + message + "\033[0m");
    }
}
