package com.bite.MyTomCat.tomcat_implements;


import com.bite.MyTomCat.servlet_standard.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HttpServletResponseImpl implements HttpServletResponse {
    @Override
    public void setStatus(int status) {
        
    }

    @Override
    public void setContentType(String contentType) {

    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    public void send() {
    }
}
