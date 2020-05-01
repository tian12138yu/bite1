package com.bookStore;

import com.bookStore.user.User;
import com.bookStore.user.UserMap;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/1 15:57
 */

public class Client {

    public static void main(String[] args) {
        while (true) {
            System.out.println("****欢迎来到图书借阅系统****");
            System.out.println("请输入账户名： ");
            UserMap userMap = new UserMap();
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            User usre = userMap.getUsre(s);
            if (usre == null){
                System.out.println("账户名不存在！");
                continue;
            }else {
                while (true){
                    System.out.println("请输入密码： ");
                    String s1 = scanner.nextLine();

                    if (usre.getPassword().equals(s1)){
                        System.out.println("登录成功！");
                        System.out.println("欢迎" + usre.getName() + "登录！");
                        usre.menue();
                    }else {
                        System.out.println("密码输入错误，请重新输入！");
                    }
                }

            }
        }


    }
}
