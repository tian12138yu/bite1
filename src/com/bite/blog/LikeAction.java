package com.bite.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/10 14:49
 */

public class LikeAction implements Action {
    @Override
    public void run() {
        if (!User.isLogined()){
            System.out.println("请先登录！");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("进入点赞系统：");
        System.out.println("请输入要点赞的文章ID ：");
        int id = sc.nextInt();
        String sql = "insert into like_relations values (?,?)";
        try (Connection connection = DBUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,User.getCurrentUser().id);
                statement.setInt(2,id);
                statement.executeUpdate();
                System.out.println("点赞成功！");
            }
        }catch (SQLException e){
            System.out.println("错误: " + e.getMessage());
        }
    }
}
