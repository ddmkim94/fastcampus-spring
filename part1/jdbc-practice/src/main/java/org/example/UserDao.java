package org.example;


import java.sql.*;

public class UserDao {
    public void create(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(user, sql, pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        });
    }

    // 특정 회원 조회
    public User findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ConnectionManager.getConnection();

            String sql = "SELECT * FROM USERS WHERE userId = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            User user = null;
            while (rs.next()) {
                user = new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
