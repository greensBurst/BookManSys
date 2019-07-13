import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckBook {
    public boolean check(String bookName) {
        boolean flag = false;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String sql = "select * from booklist where name = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,bookName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                flag = true;
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

    public boolean checkid(int id) {
        boolean flag = false;
        PreparedStatement ps =null;
        Connection con = Conn.getConnection();
        String sql = "select * from booklist where id = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                flag = true;
            } else {
                flag = false;
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
