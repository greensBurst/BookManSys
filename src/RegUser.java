import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegUser {
    public boolean addUser(User user) {
        boolean flag = false;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String sql = "insert into userlist values (?,?,'user')";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPasswd());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();;
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
