import java.sql.*;

public class CheckUser {
    public int check (User user) {
        int flag = 0;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String sql = "select * from userlist where username = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ResultSet rs = ps.executeQuery();
            User ckuser = new User();
            if(!rs.next()) {
                flag = 0;
            } else {
                //rs.next();
                ckuser.setUsername(rs.getString("username"));
                ckuser.setPasswd(rs.getString("passwd"));
                ckuser.setIdentity(rs.getString("identity"));
                if(user.getUsername().equals(ckuser.getUsername())) {
                    if(user.getPasswd().equals(ckuser.getPasswd())) {
                        if(ckuser.getIdentity().equals("root")) {
                            flag = 111;      //用户名密码正确且为超级管理员
                        } else if(ckuser.getIdentity().equals("admin")) {
                            flag = 11;
                        } else if(ckuser.getIdentity().equals("user")) {
                            flag = 1;       //用户名密码正确且为普通用户
                        }
                    } else {
                        flag = 2;           //密码错误
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
