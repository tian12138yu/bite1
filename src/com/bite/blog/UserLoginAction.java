package com.bite.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/8 19:17
 */

public class UserLoginAction implements Action{

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名： ");
        String username = sc.nextLine();
        System.out.print("请输入密码： ");
        String password = sc.nextLine();
        String sql = "select id,nickname from users where username = ? and password = ?";
        String id = null;
        String nickname = null;
        try (Connection connection = DBUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()){
                        id = resultSet.getString("id");
                        nickname = resultSet.getString("nickname");
                    }else {
                        System.out.println("用户名或密码错误");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("错误: " + e.getMessage());
        }
        User user = new User();
        user.id = Integer.valueOf(id);
        user.nickname = nickname;
        user.username = username;
        User.login(user);

    }
}
