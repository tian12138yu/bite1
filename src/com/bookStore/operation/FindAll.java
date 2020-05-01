package com.bookStore.operation;

import com.bookStore.book.Book;
import com.bookStore.book.BookList;

import java.util.List;

/**
 * @Author tjy
 * @Date 2020/5/1 16:18
 */

public class FindAll implements Ioperation {
    @Override
    public void work(BookList list) {
        List<Book> all = list.findAll();
        for (int x = 0; x < all.size(); x++ ){
            System.out.println(all.get(x));
        }
    }
}
