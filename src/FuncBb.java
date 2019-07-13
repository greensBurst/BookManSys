import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncBb {
    public List<BbInfo> selId(int id) {
        List<BbInfo> bbs = new ArrayList<>();
        String sql = "select * from bblist where id = ?";
        Connection con = Conn.getConnection();
        PreparedStatement ps =null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                BbInfo bi = new BbInfo();
                bi.setId(rs.getInt("id"));
                bi.setBorrowtime(rs.getString("borrowtime"));
                bi.setBacktime(rs.getString("backtime"));
                bi.setWho(rs.getString("who"));
                bbs.add(bi);
            }
            return bbs;
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

    public List<BbInfo> selName(String name) {
        List<BbInfo> bbs = new ArrayList<>();
        String sql = "select * from bblist where who = ?";
        Connection con = Conn.getConnection();
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                BbInfo bi = new BbInfo();
                bi.setId(rs.getInt("id"));
                bi.setBorrowtime(rs.getString("borrowtime"));
                bi.setBacktime(rs.getString("backtime"));
                bi.setWho(rs.getString("who"));
                bbs.add(bi);
            }
            return bbs;
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

    public List<BbInfo> selAll() {
        List<BbInfo> bbs = new ArrayList<>();
        String sql = "select * from bblist";
        Connection con = Conn.getConnection();
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                BbInfo bi = new BbInfo();
                bi.setId(rs.getInt("id"));
                bi.setBorrowtime(rs.getString("borrowtime"));
                bi.setBacktime(rs.getString("backtime"));
                bi.setWho(rs.getString("who"));
                bbs.add(bi);
            }
            return bbs;
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

    public void delbb (int id,String user) {
        PreparedStatement ps =null;
        Connection con = Conn.getConnection();
        String sql = "delete from bblist where id = ? and who = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,user);
            ps.executeUpdate();
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
    }
}
