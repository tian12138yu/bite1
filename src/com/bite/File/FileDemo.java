package com.bite.File;

import java.io.File;
import java.io.IOException;

/**
 * @Author tjy
 * @Date 2020/6/22 20:42
 */

public class FileDemo {
    /**
     * idea 中的相对路径是相对于运行java文件的位置，而不是创建的位置
     * @param args
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\0602\\随机.txt");
        System.out.println(file.isFile());
        System.out.println(file.getAbsolutePath());
        file.createNewFile();//创建一个文件，如果上及目录也不存在，就会报异常
        file.mkdir();//创建一个目录，如果上及目录也不存在，就会报异常
        file.mkdirs();//创建多层目录（如果上面的多层目录都不存在）
    }
}
