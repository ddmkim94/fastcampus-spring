package org.example;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final DataSource dataSource = ConnectionManager.getDataSource();

    private final String USER_SELECT = "select * from users where userId = ?";
    private final String USER_INSERT = "insert into users(userId, password, name, email) values(?, ?, ? ,?)";

    // 유저 생성
    public void create(User user) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstm = connection.prepareStatement(USER_INSERT);

        pstm.setString(1, user.getUserId());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getName());
        pstm.setString(4, user.getEmail());

        pstm.executeUpdate();
        System.out.println("회원 가입 성공!!");
    }

    // 특정 회원 조회
    public User findByUserId(String userId) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstm = connection.prepareStatement(USER_SELECT);

        pstm.setString(1, userId);
        ResultSet rs = pstm.executeQuery();

        User user = null;
        while (rs.next()) {
            String id = rs.getString("userId");
            String password = rs.getString("password");
            String name = rs.getString("name");
            String email = rs.getString("email");

            user = new User(id, password, name, email);
        }
        
        return user;
    }
}
