package com.bite.File;

/**
 * @Author tjy
 * @Date 2020/6/24 20:08
 */

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class ScanDirBroad {
    public static void main(String[] args) {
        File root = new File("测试目录\\非空目录");
        //  广度优先一定用到队列
        Queue<File> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            File node = queue.poll();
            if (node.isDirectory()) {
                System.out.println(node.getAbsolutePath() + "\\");
            } else if (node.isFile()) {
                System.out.println(node.getAbsolutePath());
            }
            // 找到 node 的所有孩子
            if (node.isDirectory()) {
                File[] children = node.listFiles();
                if (children != null) {
                    for (File child : children) {
                        queue.offer(child);
                    }
                }
            }
        }
    }
}

