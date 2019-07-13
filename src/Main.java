import java.awt.print.Book;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CheckUser ku = new CheckUser();
        CurrentUser cu = new CurrentUser();
        Enter et = new Enter();

        System.out.println("欢迎使用超级图书管理系统 (￣_ ￣ )");

        boolean loop = true;
        while(loop) {
            boolean judge = false;
            loop = true;
            while(!judge) {
                System.out.println("您可以输入L键登陆已有账户，或输入R键注册一个新的账户：");
                String land = sc.next();
                if(land.equals("L")) {
                    judge = et.login();
                } else if (land.equals("R")) {
                    judge = true;
                    et.register();
                } else {
                    judge = false;
                    System.out.println("格式错误！少侠请重新来过！");
                }
            }

            if(ku.check(et.user) == 111) {               //et.user:登陆时输进去的账号和密码，在check中查找用户表中相同用户名对应的身份
                System.out.println("超级管理员" + et.user.getUsername() + "登陆成功！");
                cu.setIdentity("root");
            } else if(ku.check(et.user) == 11) {
                System.out.println("尊敬的管理员" + et.user.getUsername() + "登陆成功！祝您心情愉快！");
                cu.setIdentity("admin");
            } else if(ku.check(et.user) == 1) {
                System.out.println("普通的用户" + et.user.getUsername() + "登陆成功！祝您天天向上！");
                cu.setIdentity("user");
            }

            InWho wh = new InWho();
            while(true) {
                if(cu.getIdentity().equals("root")) {
                    wh.inRoot();
                } else if(cu.getIdentity().equals("admin")) {
                    wh.inAdmin();
                } else if(cu.getIdentity().equals("user")) {
                    wh.inUser(et.user.getUsername());
                }
                String x;
                while(true) {
                    System.out.println("输入0退出 输入1继续 输入2切换用户");
                    x = sc.next();
                    if(!(x.equals("0") || x.equals("1") || x.equals("2"))) {
                        System.out.println("格式错误！请少侠重新来过！");
                        continue;
                    } else {
                        break;
                    }
                }
                if(x.equals("0")) {
                    loop = false;
                    break;
                } else if(x.equals("1")) {
                    continue;
                } else if(x.equals("2")) {
                    loop = true;
                    break;
                }
            }
        }
    }
}
