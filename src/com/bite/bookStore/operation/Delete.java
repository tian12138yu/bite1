package com.bite.bookStore.operation;

import com.bite.bookStore.book.BookList;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/1 15:52
 */

public class Delete implements Ioperation {

    @Override
    public void work(BookList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要删除的书名：");
        String name = scanner.nextLine();
        list.delete(name);
    }
}
