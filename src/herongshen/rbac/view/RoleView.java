package herongshen.rbac.view;

public class RoleView {
    public static void printMenu() {
        String menu = """
                ---------------------
                       角色管理
                ---------------------
                |    0...返回上级    |
                |    1...角色列表    |
                |    2...创建角色    |
                |    3...更新角色    |
                |    4...删除角色    |
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
                case "0":
                    System.out.println("已返回上一级菜单");
                    break;
                case "1":
                    // 角色列表
                    break;
                case "2":
                    // 创建角色
                    break;
                case "3":
                    // 更新角色
                    break;
                case "4":
                    // 删除角色
                    break;
                default:
                    System.out.println("输入非法，请输入正确的菜单编号！");
            }
        } while (!"0".equals(menuChoice));
    }
}
