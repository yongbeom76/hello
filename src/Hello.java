import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hello {
    public static void main(String[] args) {
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/kh_project";
        String password = "*khacademy!";
        try {
            // 접속후 쿼리 날리기
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users_answer";
            ResultSet resultSet = statement.executeQuery(query);
            String format = "%-15s%-15s%-15s%n";
            System.out.printf(format,"USER_ID","QUESTION_ID","ANSWER_ID");
            
            while(resultSet.next()) {
                String value = resultSet.getString(1);
                String value2 = resultSet.getString(2);
                String value3 = resultSet.getString(3);
                System.out.printf(format,value,value2,value3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
