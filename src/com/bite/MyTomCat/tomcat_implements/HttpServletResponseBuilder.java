package com.bite.MyTomCat.tomcat_implements;


import com.bite.MyTomCat.servlet_standard.HttpServletResponse;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class HttpServletResponseBuilder {
    public static HttpServletResponse build() throws UnsupportedEncodingException {
        HttpServletResponseImpl resp = new HttpServletResponseImpl();
        return resp;
    }
}
