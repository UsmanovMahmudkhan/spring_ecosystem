import com.mysql.cj.jdbc.Driver;

import java.sql.*;

class Main{
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/university";
        String username="root";
        String password="test123";
        String sql="SELECT * FROM university.courses";
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet set=statement.executeQuery();
            while(set.next()){
                System.out.println(set.getString("title"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}