import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncUser {
    public boolean atu(String username) {
        boolean flag = false;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String sql = "update userlist set identity = 'user' where username = ? and identity = 'admin'";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,username);
            ps.executeUpdate();
            flag = true;
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

    public boolean uta(String username) {
        boolean flag =false;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String sql = "update userlist set identity = 'admin' where username = ? and identity = 'user'";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,username);
            ps.executeUpdate();
            flag = true;
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

    public String sel (String name) {
        String str = null;
        String sql = "select identity from userlist where username = ?";
        PreparedStatement ps= null;
        Connection con = Conn.getConnection();
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                str = rs.getString("identity");
            }
            return str;
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
        return null;
    }
}
