package com.bite.sql;

import java.sql.*;

/**
 * @Author tjy
 * @Date 2020/6/5 19:00
 */

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
//        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
//        System.out.println(aClass.getSimpleName());
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/bite?useSSL=false&characterEncoding=utf8",
                        "root", "root");
//        select(connection);
        update(connection);
        connection.close();
        System.out.println(connection);
    }

    private static void update(Connection connection)throws SQLException  {
        Statement statement = connection.createStatement();
        String sql = "insert into student (id,sn,name) values (8,46587,'秀儿')";
        int i = statement.executeUpdate(sql);
        System.out.println("插入成功，影响了" + i + "行数据");
    }

    private static void select(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String id = resultSet.getString(1);
            String sn = resultSet.getString(2);
            String name = resultSet.getString(3);
            String qq_mail = resultSet.getString(4);
            System.out.println(id+ " " + sn + " "+ name + " " +qq_mail);
        }
        resultSet.close();
        statement.close();
    }
}
