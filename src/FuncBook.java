import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class FuncBook {
    public boolean add(Book book) {
        boolean flag = false;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String addsql = "insert into booklist values(?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(addsql);
            ps.setInt(1, book.getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setString(4,book.getPos());
            ps.setInt(5,book.getTot());
            ps.setInt(6,book.getNow());
            ps.executeUpdate();
            flag = true;
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean del(int id) {
        boolean flag = false;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String delsql = "delete from booklist where id = ? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(delsql);
            ps.setInt( 1,id);
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean update(Book book) {
        boolean flag = false;
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String updatesql = "update booklist set name = ?,author = ? ,pos = ?, tot = ?,now = ? where id = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(updatesql);
            ps.setString(1,book.getName());
            ps.setString(2,book.getAuthor());
            ps.setString(3,book.getPos());
            ps.setInt(4,book.getTot());
            ps.setInt(5,book.getNow());
            ps.setInt(6,book.getId());
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

    public List<Book> select(String name) {
        List<Book> books = new ArrayList<>();
        String sql = "Select * from booklist where name = ?";
        Connection con = Conn.getConnection();
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPos(rs.getString("pos"));
                book.setTot(rs.getInt("tot"));
                book.setNow(rs.getInt("now"));
                books.add(book);
                //System.out.println(book.toString());
            }
            return books;
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

    public List<Book> selnow(int id) {
        List<Book> books = new ArrayList<>();
        String sql = "Select * from booklist where id = ?";
        Connection con = Conn.getConnection();
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPos(rs.getString("pos"));
                book.setTot(rs.getInt("tot"));
                book.setNow(rs.getInt("now"));
                books.add(book);
                //System.out.println(book.toString());
            }
            return books;
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

    public List<Book> selectAll() {
        List<Book> books = new ArrayList<>();
        String sql = "Select * from booklist";
        Connection con = Conn.getConnection();
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPos(rs.getString("pos"));
                book.setTot(rs.getInt("tot"));
                book.setNow(rs.getInt("now"));
                books.add(book);
                //System.out.println(book.toString());
            }
            return books;
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

    public void borrow(int id, String date,String user) {
        PreparedStatement ps =null;
        Connection con = Conn.getConnection();
        String sql1 = "update booklist set now = now - 1 where id = ?";
        String sql2 = "insert into bblist(id,borrowtime,backtime,who) values (?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql1);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps = (PreparedStatement) con.prepareStatement(sql2);
            ps.setInt(1,id);
            ps.setString(2,date);
            ps.setString(3,"no");
            ps.setString(4,user);
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

    public void back(int id,String date,String user) {
        PreparedStatement ps = null;
        Connection con = Conn.getConnection();
        String sql1 = "update booklist set now = now + 1 where id = ?";
        String sql2 = "update bblist set backtime = ? where id = ? and who = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql1);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps = (PreparedStatement) con.prepareStatement(sql2);
            ps.setString(1,date);
            ps.setInt(2,id);
            ps.setString(3,user);
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
