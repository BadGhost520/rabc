package herongshen.rbac.view;

public class UserView {
    public static void printMenu() {
        String menu = """
                ---------------------
                       用户管理
                ---------------------
                |    0...返回上级    |
                |    1...用户列表    |
                |    2...创建用户    |
                |    3...更新用户    |
                |    4...切换状态    |
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
                    // 用户列表
                    break;
                case "2":
                    // 创建用户
                    break;
                case "3":
                    // 更新用户
                    break;
                case "4":
                    // 删除用户
                    break;
                default:
                    System.out.println("输入非法，请输入正确的菜单编号！");
            }
        } while (!"0".equals(menuChoice));
    }
}
