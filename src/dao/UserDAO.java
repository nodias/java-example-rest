package dao;

import dto.User;

import java.io.PrintWriter;
import java.sql.*;

public class UserDAO {
    Connection con;
    Statement st;
    PrintWriter out;

    public User getUser(String id) throws SQLException, ClassNotFoundException {
        User user = null;
        con = getPGConnection("jdbc:postgresql://54.180.2.92:5432/postgres", "admin", "admin");
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT id,name,password FROM javawebbasic.user WHERE id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    private Connection getPGConnection(String url, String user, String pwd) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, pwd);
        return con;
    }

//    private Connection getConnection(){
//        Context context = null;
//        DataSource dataSource = null;
//        Connection connection = null;
//        try {
//            context = new InitialContext();
//            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Postgres");
//            connection = dataSource.getConnection();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return connection;
//    }
}
