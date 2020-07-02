package com.bite.bookStore.operation;

import com.bite.bookStore.book.Book;
import com.bite.bookStore.book.BookList;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/1 15:52
 */

public class Find implements Ioperation {

    @Override
    public void work(BookList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的书名");
        String s = scanner.nextLine();
        Book book = list.find(s);
        if (book != null){
            System.out.println(book);
        }
    }
}
