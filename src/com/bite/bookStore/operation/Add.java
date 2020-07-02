package com.bite.bookStore.operation;

import com.bite.bookStore.book.Book;
import com.bite.bookStore.book.BookList;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/1 15:51
 */

public class Add implements Ioperation {


    @Override
    public void work(BookList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要添加的书名：");
        String name = scanner.nextLine();
        System.out.println("请输入要书的作者：");
        String author = scanner.nextLine();
        System.out.println("请输入要书的价格：");
        double money = scanner.nextDouble();
        System.out.println("请输入要书类型：");
        String type = scanner.next();
        Book book = new Book(name, author, money, type);
        list.addBook(book);
    }
}
