import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.lang.Integer;

public class InWho {
    Scanner sc = new Scanner(System.in);
    FuncUser fu = new FuncUser();
    User user = new User();
    CheckUser ku = new CheckUser();
    Book book = new Book();
    FuncBook fb = new FuncBook();
    FuncBb fbb = new FuncBb();
    CheckBook cb = new CheckBook();
    CurrentUser cu = new CurrentUser();
    String tmp;
    public void inRoot() {
        user.setPasswd("default");
        while(true) {
            System.out.println("输入0查看指定用户身份 输入1提升普通用户身份 输入2降低管理用户身份");
            tmp = sc.next();
            if(!(tmp.equals("0") || tmp.equals("1") || tmp.equals("2"))) {
                System.out.println("格式错误！请少侠重新来过！");
                continue;
            } else {
                break;
            }
        }
        while(true) {
            System.out.println("请指定用户名：");
            user.setUsername(sc.next());
            if(ku.check(user) == 0) {
                System.out.println("用户不存在！请少侠重新来过！");
                continue;
            } else {
                if(tmp.equals("0")) {
                    if(fu.sel(user.getUsername()).equals("root")) {
                        System.out.println(user.getUsername()+"的身份为超级管理");
                    } else if(fu.sel(user.getUsername()).equals("admin")) {
                        System.out.println(user.getUsername()+"的身份为管理员");
                    } else if(fu.sel(user.getUsername()).equals("user")) {
                        System.out.println(user.getUsername()+"的身份为普通用户");
                    }
                } else if(tmp.equals("1")) {
                    if(fu.sel(user.getUsername()).equals("admin")) {
                        System.out.println(user.getUsername()+"已是管理员！");
                    } else if(fu.sel(user.getUsername()).equals("root")) {
                        System.out.println("超级管理用户不可更改！");
                    } else {
                        fu.uta(user.getUsername());
                        System.out.println("普通用户" + user.getUsername() + "已提升为管理员");
                    }
                } else if(tmp.equals("2")) {
                    if(fu.sel(user.getUsername()).equals("user")) {
                        System.out.println(user.getUsername()+"已是普通用户！");
                    } else if(fu.sel(user.getUsername()).equals("root")) {
                        System.out.println("超级管理用户不可更改！");
                    } else {
                        fu.atu(user.getUsername());
                        System.out.println("管理员"+user.getUsername()+"已降低为普通用户");
                    }
                }
                break;
            }
        }
    }

    public void inAdmin() {
        user.setPasswd("default");
        while(true) {
            System.out.println("输入0添加图书信息 输入1删除图书信息 输入2更新图书信息 输入3查看图书信息 输入4查看借还信息");
            tmp = sc.next();
            if(!(tmp.equals("0") || tmp.equals("1") || tmp.equals("2") || tmp.equals("3")|| tmp.equals("4"))) {
                System.out.println("格式错误！请少侠重新来过！");
                continue;
            } else {
                break;
            }
        }
        if(tmp.equals("0")) {
            boolean f = true;
            while(true) {
                System.out.println("请输入图书序列号：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    if(cb.checkid(Integer.parseInt(tmp))) {
                        System.out.println("该书号已存在！请少侠重新再来！");
                        f = true;
                        continue;
                    }else {
                        book.setId(Integer.parseInt(tmp));
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
            System.out.println("请输入图书名称：");
            book.setName(sc.next());
            System.out.println("请输入图书作者：");
            book.setAuthor(sc.next());
            System.out.println("请输入图书位置：");
            book.setPos(sc.next());
            int tot;
            while(true) {
                System.out.println("请输入图书数目：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    if(Integer.parseInt(tmp) < 1) {
                        System.out.println("图书数目有误！请少侠重新再来！");
                        f = true;
                        continue;
                    }else {
                        book.setTot(Integer.parseInt(tmp));
                        tot = Integer.parseInt(tmp);
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
            while(true) {
                System.out.println("请输入在架数目：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    if(Integer.parseInt(tmp) > tot || Integer.parseInt(tmp) < 0) {
                        System.out.println("在架数目有误！请少侠重新再来！");
                        f = true;
                        continue;
                    }else {
                        book.setNow(Integer.parseInt(tmp));
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
            fb.add(book);
            System.out.println("图书信息添加成功！");
        } else if(tmp.equals("1")) {
            boolean f = true;
            while(true) {
                System.out.println("请输入图书序列号：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    if(!cb.checkid(Integer.parseInt(tmp))) {
                        System.out.println("该书号不存在！");
                        f = true;
                        continue;
                    }else {
                        fb.del(Integer.parseInt(tmp));
                        System.out.println("图书"+tmp+"信息删除成功！");
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
        } else if(tmp.equals("2")) {
            boolean f = true;
            while(true) {
                System.out.println("请输入要更新的图书序列号：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        break;
                    }
                }
                if(f) {
                    if(!cb.checkid(Integer.parseInt(tmp))) {
                        System.out.println("该书号不存在！");
                        f= true;
                        continue;
                    }else {
                        book.setId(Integer.parseInt(tmp));
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
            System.out.println("请输入新的图书名称：");
            book.setName(sc.next());
            System.out.println("请输入新的图书作者：");
            book.setAuthor(sc.next());
            System.out.println("请输入新的图书位置：");
            book.setPos(sc.next());
            int tot;
            while(true) {
                System.out.println("请输入新的图书数目：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    if(Integer.parseInt(tmp) < 1) {
                        System.out.println("图书数目有误！请少侠重新再来！");
                        f = true;
                        continue;
                    }else {
                        book.setTot(Integer.parseInt(tmp));
                        tot = Integer.parseInt(tmp);
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
            while(true) {
                System.out.println("请输入新的在架数目：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    if(Integer.parseInt(tmp) > tot || Integer.parseInt(tmp) < 0) {
                        System.out.println("在架数目有误！请少侠重新再来！");
                        f = true;
                        continue;
                    }else {
                        book.setNow(Integer.parseInt(tmp));
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
            fb.update(book);
            System.out.println("图书"+book.getId()+"信息更新成功！");
        } else if(tmp.equals("3")) {
            System.out.println("输入0可查看指定图书信息 输入1可查看全部图书信息");
            String a;
            while(true) {
                a = sc.next();
                if(!(a.equals("0") || a.equals("1"))) {
                    System.out.println("格式错误！请少侠重新再来！");
                    continue;
                } else {
                    break;
                }
            }
            if(a.equals("0")) {
                System.out.println("请输入要查看的图书名称：");
                String name = sc.next();
                List<Book> L = fb.select(name);
                if(L.isEmpty()) {
                    System.out.println("图书《" + name + "》不存在！");
                } else {
                    for(int i = 0; i < L.size(); i++) {
                        System.out.println("* * * * * * * * * * ");
                        System.out.println("书号 ：" + L.get(i).getId());
                        System.out.println("书名 ：" + L.get(i).getName());
                        System.out.println("作者 ：" + L.get(i).getAuthor());
                        System.out.println("位置 ：" + L.get(i).getPos());
                        System.out.println("数目 ：" + L.get(i).getTot());
                        System.out.println("在架 ：" + L.get(i).getNow());
                        System.out.println("* * * * * * * * * * ");
                    }
                }
            } else if(a.equals("1")) {
                List<Book> L = fb.selectAll();
                if(L.isEmpty()) {
                    System.out.println("图书列表为空！");
                } else {
                    for(int i = 0; i < L.size(); i++) {
                        System.out.println("* * * * * * * * * * ");
                        System.out.println("书号 ：" + L.get(i).getId());
                        System.out.println("书名 ：" + L.get(i).getName());
                        System.out.println("作者 ：" + L.get(i).getAuthor());
                        System.out.println("位置 ：" + L.get(i).getPos());
                        System.out.println("数目 ：" + L.get(i).getTot());
                        System.out.println("在架 ：" + L.get(i).getNow());
                        System.out.println("* * * * * * * * * * ");
                    }
                }
            }
        } else if(tmp.equals("4")) {
            System.out.println("输入0可查看指定图书借还信息 输入1可查看指定用户借还信息 输入2可查看全部借还信息");
            String a;
            while(true) {
                a = sc.next();
                if(!(a.equals("0") || a.equals("1") || a.equals("2"))) {
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                } else {
                    break;
                }
            }
            if(a.equals("0")) {
                List<BbInfo> L;
                boolean f = true;
                while(true) {
                    System.out.println("请输入要查看的图书书号：");
                    String tmp = sc.next();
                    char gettmp[] = tmp.toCharArray();
                    for(int i = 0; i < tmp.length(); i++) {
                        if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                            f = false;
                            break;
                        }
                    }
                    if(f) {
                        if(!cb.checkid(Integer.parseInt(tmp))) {
                            System.out.println("该书号不存在！请少侠重新再来！");
                            f = true;
                            continue;
                        }else {
                            L = fbb.selId(Integer.parseInt(tmp));
                            break;
                        }
                    } else {
                        f = true;
                        System.out.println("格式错误！请少侠重新来过！");
                        continue;
                    }
                }
                if(L.isEmpty()) {
                    System.out.println("该图书无借还信息！");
                } else {
                    for(int i = 0; i < L.size(); i++) {
                        System.out.println("- - - - - - - - - -");
                        System.out.println("书号 ：" + L.get(i).getId());
                        System.out.println("借出 ：" + L.get(i).getBorrowtime());
                        System.out.println("归还 ：" + L.get(i).getBacktime());
                        System.out.println("用户 ：" + L.get(i).getWho());
                        System.out.println("- - - - - - - - - -");
                    }
                }
            } else if(a.equals("1")) {
                while(true) {
                    System.out.println("请输入要查看用户的用户名：");
                    String name = sc.next();
                    user.setPasswd("default");
                    user.setUsername(name);
                    if(ku.check(user) == 0) {
                        System.out.println("该用户不存在！");
                        continue;
                    } else {
                        List<BbInfo> L = fbb.selName(name);
                        if(L.isEmpty()) {
                            System.out.println("该用户无借还信息！");
                        } else {
                            for(int i = 0; i < L.size(); i++) {
                                System.out.println("- - - - - - - - - -");
                                System.out.println("书号 ：" + L.get(i).getId());
                                System.out.println("借出 ：" + L.get(i).getBorrowtime());
                                System.out.println("归还 ：" + L.get(i).getBacktime());
                                System.out.println("用户 ：" + L.get(i).getWho());
                                System.out.println("- - - - - - - - - -");
                            }
                        }
                    }
                }
            } else if(a.equals("2")) {
                List<BbInfo> L = fbb.selAll();
                if(L.isEmpty()) {
                    System.out.println("尚无任何借还信息！");
                } else {
                    for(int i = 0; i < L.size(); i++) {
                        System.out.println("- - - - - - - - - -");
                        System.out.println("书号 ：" + L.get(i).getId());
                        System.out.println("借出 ：" + L.get(i).getBorrowtime());
                        System.out.println("归还 ：" + L.get(i).getBacktime());
                        System.out.println("用户 ：" + L.get(i).getWho());
                        System.out.println("- - - - - - - - - -");
                    }
                }
            }
        }
    }
    public void inUser(String user) {
        while(true) {
            System.out.println("输入0添加借书信息 输入1添加还书信息 输入2查看图书信息");
            tmp = sc.next();
            if(!(tmp.equals("0") || tmp.equals("1") || tmp.equals("2"))) {
                System.out.println("格式错误！请少侠重新来过！");
                continue;
            } else {
                break;
            }
        }
        if(tmp.equals("2")) {
            System.out.println("输入0可查看指定图书信息 输入1可查看全部图书信息");
            String a;
            while(true) {
                a = sc.next();
                if(!(a.equals("0") || a.equals("1"))) {
                    System.out.println("格式错误！请少侠重新再来！");
                    continue;
                } else {
                    break;
                }
            }
            if(a.equals("0")) {
                System.out.println("请输入要查看的图书名称：");
                String name = sc.next();
                List<Book> L = fb.select(name);
                if(L.isEmpty()) {
                    System.out.println("图书《" + name + "》不存在！");
                } else {
                    for(int i = 0; i < L.size(); i++) {
                        System.out.println("* * * * * * * * * * ");
                        System.out.println("书号 ：" + L.get(i).getId());
                        System.out.println("书名 ：" + L.get(i).getName());
                        System.out.println("作者 ：" + L.get(i).getAuthor());
                        System.out.println("位置 ：" + L.get(i).getPos());
                        System.out.println("数目 ：" + L.get(i).getTot());
                        System.out.println("在架 ：" + L.get(i).getNow());
                        System.out.println("* * * * * * * * * * ");
                    }
                }
            } else if(a.equals("1")) {
                List<Book> L = fb.selectAll();
                if(L.isEmpty()) {
                    System.out.println("图书列表为空！");
                } else {
                    for(int i = 0; i < L.size(); i++) {
                        System.out.println("* * * * * * * * * * ");
                        System.out.println("书号 ：" + L.get(i).getId());
                        System.out.println("书名 ：" + L.get(i).getName());
                        System.out.println("作者 ：" + L.get(i).getAuthor());
                        System.out.println("位置 ：" + L.get(i).getPos());
                        System.out.println("数目 ：" + L.get(i).getTot());
                        System.out.println("在架 ：" + L.get(i).getNow());
                        System.out.println("* * * * * * * * * * ");
                    }
                }
            }
        } else if(tmp.equals("0")) {
            boolean f = true;
            int id = 0;
            while(true) {
                System.out.println("请输入所借图书书号：");
                String tmp = sc.next();
                char gettmp[] = tmp.toCharArray();
                for(int i = 0; i < tmp.length(); i++) {
                    if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                        f = false;
                        break;
                    }
                }
                if(f) {
                    if(!cb.checkid(Integer.parseInt(tmp))) {
                        System.out.println("该书号不存在！请少侠重新再来！");
                        f = true;
                        continue;
                    }else if(fb.selnow(Integer.parseInt(tmp)).get(0).getNow() < 1) {
                        System.out.println("该数在架数目不足！");
                        break;
                    }else {
                        boolean ff = false;
                        List<BbInfo> Lbb;
                        Lbb = fbb.selId(Integer.parseInt(tmp));
                        if(!Lbb.isEmpty()) {
                            for(int i = 0; i < Lbb.size(); i++) {
                                if(Lbb.get(i).getWho().equals(user) && Lbb.get(i).getBacktime().equals("no")) {
                                    System.out.println("所借该书尚未归还！");
                                    ff = true;
                                } else if((Lbb.get(i).getWho().equals(user))) {
                                    fbb.delbb(Integer.parseInt(tmp),user);
                                }
                            }
                        }
                        if(!ff) {
                            id = Integer.parseInt(tmp);
                            System.out.println("请输入借书日期：");
                            String date = sc.next();
                            fb.borrow(id,date,user);
                            System.out.println("借书信息添加成功！");
                        }
                        break;
                    }
                } else {
                    f = true;
                    System.out.println("格式错误！请少侠重新来过！");
                    continue;
                }
            }
        } else if(tmp.equals("1")) {
            boolean goon = false;
            String borrowname;
            while(true) {
                System.out.println("请输入借书人用户名：");
                borrowname = sc.next();
                if(fbb.selName(borrowname).isEmpty()) {
                    System.out.println("该用户尚无借书信息！");
                    break;
                } else {
                    goon = true;
                    break;
                }
            }
            if(goon) {
                while(true) {
                    System.out.println("请输入所还图书书号：");
                    String tmp = sc.next();
                    char gettmp[] = tmp.toCharArray();
                    for(int i = 0; i < tmp.length(); i++) {
                        if(!(gettmp[i] >= 48 && gettmp[i] <= 57)) {
                            System.out.println("书号格式错误！");
                            break;
                        }
                    }
                    boolean have = false;
                    int num = 0;
                    if(!fbb.selId(Integer.parseInt(tmp)).isEmpty()) {
                        for(int i = 0; i < fbb.selId(Integer.parseInt(tmp)).size(); i++) {
                            if(fbb.selId(Integer.parseInt(tmp)).get(i).getWho().equals(borrowname)) {
                                num = i;
                                have = true;
                                break;
                            }
                        }
                    }
                    if(!have) {
                        System.out.println("你并未借过此图书！");
                        break;
                    } else if(!fbb.selId(Integer.parseInt(tmp)).get(num).getBacktime().equals("no")) {
                        System.out.println("该书已归还！");
                        break;
                    } else {
                        Integer.parseInt(tmp);System.out.println("请输入还书日期：");
                        String date = sc.next();
                        fb.back(Integer.parseInt(tmp),date,borrowname);
                        System.out.println("还书信息添加成功！");
                        break;
                    }
                }
            }
        }
    }
}
