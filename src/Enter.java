import java.util.Scanner;

public class Enter {
    Scanner sc = new Scanner(System.in);
    User user = new User();
    public boolean login() {
        boolean flag = false;
        System.out.println("请输入您的用户名：");
        user.setUsername(sc.next());
        System.out.println("请输入您的密码：");
        user.setPasswd(sc.next());
        CheckUser ku = new CheckUser();
        if (ku.check(user) == 0) {
            System.out.println("用户名不存在！");
            flag = false;
        } else if (ku.check(user) == 1 || ku.check(user) == 11 || ku.check(user) == 111) {
            flag = true;
        } else if (ku.check(user) == 2) {
            System.out.println("密码错误！");
            flag = false;
        }
        return flag;
    }

    public void register() {
        CheckUser ku = new CheckUser();
        RegUser ru = new RegUser();
        System.out.println("请设置您的用户名(由英文字母和数字组成且长度不超过20)：");
        while(true) {
            user.setUsername(sc.next());
            user.setPasswd("default");
            char getusername[] = user.getUsername().toCharArray();
            boolean f = false;
            for(int i = 0; i < user.getUsername().length(); i++) {
                if(!(getusername[i] >= 65  && getusername[i] <= 90 || getusername[i] >= 97  && getusername[i] <= 122 || getusername[i] >= 48  && getusername[i] <= 57)){
                    f = true;
                    break;
                }
            }
            if(f || user.getUsername().length() > 20) {
                f = false;
                System.out.println("格式错误！少侠请重新来过！");
                continue;
            } else if(ku.check(user) != 0) {
                System.out.println("用户名已存在！少侠请重新来过！");
                f= false;
                continue;
            } else {
                break;
            }
        }
        System.out.println("用户名设置成功！");
        System.out.println("请设置您的密码(由英文字母和数字组成且长度不超过20)：");
        while(true) {
            user.setPasswd(sc.next());
            char getpasswd[] = user.getPasswd().toCharArray();
            boolean f= false;
            for(int i = 0; i < user.getPasswd().length(); i++) {
                if(!(getpasswd[i] >= 65 && getpasswd[i] <= 90 || getpasswd[i] >= 97 && getpasswd[i] <= 122 || getpasswd[i] >= 48 && getpasswd[i] <=57)) {
                    f = true;
                    break;
                }
            }
            if(f || user.getPasswd().length() > 20) {
                f = false;
                System.out.println("格式错误！少侠请重新来过！");
                continue;
            } else {
                break;
            }
        }
        System.out.println("请确认您的密码：");
        String cfpasswd;
        int cnt = 1;
        while(cnt <= 3) {
            if(cnt == 3) {
                System.out.println("是否选择重新设置密码？ Y/N");
                while(true) {
                    String cf = sc.next();
                    if(cf.equals("N")) {
                        cnt = 1;
                        System.out.println("请确认您的密码：");
                        break;
                    } else if (cf.equals("Y")) {
                        System.out.println("请设置您的密码：");
                        user.setPasswd(sc.next());
                        System.out.println("请确认您的密码：");
                        cnt = 1;
                        break;
                    } else {
                        System.out.println("格式错误！少侠请重新来过！");
                        continue;
                    }
                }
            }
            cfpasswd = sc.next();
            if (!cfpasswd.equals(user.getPasswd())) {
                System.out.println("密码不一致！少侠请重新来过！");
                cnt++;
                continue;
            } else {
                break;
            }
        }
        System.out.println("密码设置成功！");
        ru.addUser(user);
        System.out.println("注册成功！");
    }
}
