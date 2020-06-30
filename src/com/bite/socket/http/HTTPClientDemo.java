package com.bite.socket.http;

/**
 * @Author tjy
 * @Date 2020/6/30 20:09
 */

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HTTPClientDemo {
    /**
     * https://www.baidu.com/
     * s?ie=utf-8&f=8&rsv_bp=1
     * &tn=baidu&wd=java
     * &oq=c
     * &rsv_pq=9526e7a20000429a&rsv_t=8167XcDve1pThdQq8%2BfSpwvOqfb6BTsFt1GPAKMk8d1unhAFiGNzFqz9hsA&rqlang=cn
     * &rsv_enter=1&rsv_dl=tb&rsv_btype=t&inputT=1128&rsv_sug3=6&rsv_sug1=5&rsv_sug7=100&rsv_sug2=0&rsv_sug4=1128
     * @param args
     */
    public static void main(String[] args) {
        // URL: http://www.baidu.com/s?wd=java
        String SERVER_HOST = "www.baidu.com";
        int SERVER_PORT = 80;

        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            // GET 方法的请求，不包含请求体
            String request = "GET /s?wd=java HTTP/1.0\r\nHost: www.baidu.com\r\n\r\n";
            // 成功的发送请求
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), "utf-8")
            );
            writer.print(request);
            writer.flush();

            // 等待响应
            Scanner scanner = new Scanner(socket.getInputStream(), "utf-8");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

