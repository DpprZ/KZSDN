package dao;

import java.sql.*;

public class DeleteMenu {
    public boolean deleteBlog(String blogid)
    {
        boolean f=false;
        Connection conn = null;
        ResultSet res = null;
        try {
            String user = "root";
            String password = "dpprz.777";
            String Driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/cksdn?serverTimezone=GMT";
            //注册驱动
            Class.forName(Driver);
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
            String sql="delete from menu where blogid= ? ";
            PreparedStatement presta = conn.prepareStatement(sql);
            presta.setString(1, blogid);
            int update=presta.executeUpdate();
            if(update==1)
                f=true;
            return f;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return f;
    }
}
