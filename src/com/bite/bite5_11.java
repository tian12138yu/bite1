package com.bite;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/11 15:05
 */

public class bite5_11 {

    private static void testMethod(){

        System.out.println("testMethod");

    }

    public static void main(String[] args) {
        System.out.println("*******欢迎登陆********");
        System.out.println("*******请输入账号：********");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("*******请输入密码：********");
        String password = scanner.nextLine();
        if (name.equals("tjy") && password.equals("123")){
            System.out.println("登陆成功！");
        }else {
            throw new MyException("账号或密码输入错误！");
        }



    }





}
