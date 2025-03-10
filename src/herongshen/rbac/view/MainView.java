package herongshen.rbac.view;

import java.util.Scanner;

public class MainView {
    // 主页
    public static void printMenu() {
        String menu = """
                ---------------------
                       RBAC系统
                ---------------------
                |    0...退出系统    |
                |    1...部门管理    |
                |    2...角色管理    |
                |    3...用户管理    |
                ---------------------
                请输入选项：""";
        System.out.println(menu);
    }
    // 用户输入
    public static Scanner input;
    static {
        input = new Scanner(System.in);
    }
    // 用户选择
    public static void show() {
        String menuChoice;
        do {
            printMenu();
            menuChoice = input.nextLine();
            switch (menuChoice) {
                case "0":
                    System.out.println("成功退出系统，欢迎再次使用！");
                    break;
                case "1":
                    // 部门管理
                    break;
                case "2":
                    // 角色管理
                    break;
                case "3":
                    // 用户管理
                    break;
                default:
                    System.out.println("输入非法，请输入正确的菜单编号！");
            }
        } while (!"0".equals(menuChoice));
        input.close();
    }
}
