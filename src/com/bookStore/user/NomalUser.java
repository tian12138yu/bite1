package com.bookStore.user;

import com.bookStore.book.BookList;
import com.bookStore.operation.*;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/1 15:50
 */

public class NomalUser extends User {

    public NomalUser(String name, String password, int type) {
        super(name, password, type);
    }

    @Override
    public void menue() {
        while (true){
            System.out.println("****1.归还书籍****");
            System.out.println("****2.借阅书籍****");
            System.out.println("****3.查看书籍****");
            System.out.println("****4.查看所有书籍****");
            System.out.println("****0.退出****");
            BookList bookList = new BookList();
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (i < 0 || i > 4){
                System.out.println("输入错误！请重新输入：");
                this.menue();
            }
            switch (i){
                case 1 : new Back().work(bookList);break;
                case 2 : new Borrow().work(bookList);break;
                case 3 : new Find().work(bookList);break;
                case 4 : new FindAll().work(bookList);break;
                case 0 : System.exit(1);break;
            }
        }
    }
}
