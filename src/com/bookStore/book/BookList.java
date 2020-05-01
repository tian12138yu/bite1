package com.bookStore.book;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tjy
 * @Date 2020/5/1 15:09
 */

public class BookList {

    private List al;

    public BookList() {
        al = new ArrayList<Book>();
        al.add(
                new Book("西游记","罗贯中",15.5,"文学")
        );
        al.add(
                new Book("红楼梦","罗贯中",15.5,"文学")
        );
        al.add(
                new Book("三国演义","罗贯中",15.5,"文学")
        );
    }

    public void addBook(Book book){
        al.add(book);
    }

    public void delete(String name){
        for (int x = 0; x < al.size(); x++ ){
            Book book = (Book) al.get(x);
            if (book.getName().equals(name)){
                al.remove(book);
                return;
            }
        }

        System.out.println("没有你要删除的书！");
    }

    public Book find(String name){
        for (int x = 0; x < al.size(); x++ ){
            Book book = (Book) al.get(x);
            if (book.getName().equals(name)){
                return book;
            }
        }

        System.out.println("没有你要查找的书！");
        return null;
    }

    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        for (int x = 0; x < al.size(); x++ ){
            Book book = (Book) al.get(x);
            books.add(book);
        }
        return books;
    }

    public boolean borrow(String name){
        for (int x = 0; x < al.size(); x++ ){
            Book book = (Book) al.get(x);
            if (book.getName().equals(name)){
                if (book.isBorrowed()){
                    System.out.println("书籍已被借出，请过段时间再来看！");
                    return false;
                }else {
                    book.setBorrowed(true);
                    System.out.println("借出成功！");
                    return true;
                }

            }
        }
        System.out.println("没有你想借的书！");
        return false;
    }

    public boolean back(String name) {
        for (int x = 0; x < al.size(); x++ ){
            Book book = (Book) al.get(x);
            if (book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return true;
            }
        }
        System.out.println("没有你想要归还的书！");
        return false;
    }
}
