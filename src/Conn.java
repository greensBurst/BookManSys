import java.sql.*;
public class Conn {
    public static Connection con = null; ;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("sqlconnectionmanager::找不到驱动类加载失败..");
        }
        try{
            con = DriverManager.getConnection("jdbc:mysql:"+
                            "//localhost:3306/book?useUnicode=true&characterEncoding=utf-8"
                    ,"root","root");
        }catch(SQLException e){
            System.out.println("sqlconnectionmanager::数据库获取连接失败..");
            e.printStackTrace();
        }
        if(con!=null)System.out.println("sqlconnectionmanager::数据库获取连接成功");
        else System.out.println("数据库连接失败");
        return con;
    }
}
