package com.bite.bookStore.operation;

import com.bite.bookStore.book.BookList;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/1 15:53
 */

public class Back implements Ioperation {

    @Override
    public void work(BookList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要归还的书名：");
        String name = scanner.nextLine();
        list.back(name);
    }
}
