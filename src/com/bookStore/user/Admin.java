package com.bookStore.user;

import com.bookStore.book.BookList;
import com.bookStore.operation.Add;
import com.bookStore.operation.Delete;
import com.bookStore.operation.FindAll;

import java.util.Scanner;

/**
 * @Author tjy
 * @Date 2020/5/1 15:47
 */

public class Admin extends User {

    public Admin(String name, String password, int type) {
        super(name, password, type);
    }

    @Override
    public void menue() {
        BookList bookList = new BookList();
        while (true){
            System.out.println("****1.新增书籍****");
            System.out.println("****2.删除书籍****");
            System.out.println("****3.查看所有书籍****");
            System.out.println("****0.退出****");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (i < 0 || i > 3){
                System.out.println("输入错误！请重新输入：");
                this.menue();
            }
            switch (i){
                case 1 : new Add().work(bookList);break;
                case 2 : new Delete().work(bookList);break;
                case 3 : new FindAll().work(bookList);break;
                case 0 : System.exit(1);break;
            }
        }

    }


}
