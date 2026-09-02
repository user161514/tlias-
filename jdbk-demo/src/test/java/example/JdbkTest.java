package example;

import com.itheima.pojo.user;
import org.testng.annotations.Test;

import java.sql.*;

public class JdbkTest {
    @Test
    public void TestUpdate() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/shenren", "root", "123456");

        Statement statement = root.createStatement();
        String sql="update user set age=222 where id=1";
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        statement.close();
        root.close();

    }
    @Test
    public void TestSelect(){

                //数据库连接信息
                String url = "jdbc:mysql://localhost:3306/shenren";
                String user = "root";
                String pwd = "123456";

                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    //1.加载驱动
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    //2.获取连接
                    conn = DriverManager.getConnection(url, user, pwd);
                    //3.创建Statement
//
                    PreparedStatement preparedStatement = conn.prepareStatement("select id,username,password,name,age from user where username =? and password = ?");
                    preparedStatement.setString(1, "daqiao");
                    preparedStatement.setString(2, "123456");
                    //4.执行查询SQL
//                    String sql = "select id,username,password,name,age from user where username = 'daqiao' and password = '123456'";
                    rs = preparedStatement.executeQuery();

                    //5.遍历结果集，封装User对象
                    if(rs.next()){
                        user u = new user();
                        u.setId(rs.getInt("id"));
                        u.setUsername(rs.getString("username"));
                        u.setPassword(rs.getString("password"));
                        u.setName(rs.getString("name"));
                        u.setAge(rs.getInt("age"));

                        //输出对象到控制台，@Data注解自动生成toString
                        System.out.println(u);
                    }else{
                        System.out.println("没有查询到该用户");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //6.关闭资源
                    try{if(rs!=null) rs.close();}catch (Exception e){}
                    try{if(stmt!=null) stmt.close();}catch (Exception e){}
                    try{if(conn!=null) conn.close();}catch (Exception e){}
                }
            }
        }


