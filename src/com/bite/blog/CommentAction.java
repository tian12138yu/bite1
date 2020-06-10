package com.bite.blog;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/6/10 14:49
 */

public class CommentAction implements Action {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        if (!User.isLogined()){
            System.out.println("请先登录！");
            return;
        }
        System.out.println("请输入要评论的文章ID ：");
        int id = sc.nextInt();
        System.out.println("请输入要评论的内容 ：");
        String content = sc.next();
        String sql = "insert  into comments (user_id,article_id,published_at,content) values (?,?,?,?)";

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String publishedAtStr = format.format(new Date());
        try (Connection connection = DBUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1,User.getCurrentUser().id);
                statement.setInt(2,id);
                statement.setString(3, publishedAtStr);
                statement.setString(4, content);
                statement.executeUpdate();
                System.out.println("评论成功！");
            }
        }catch (SQLException e) {
            System.out.println("错误: " + e.getMessage());
        }
    }
}
