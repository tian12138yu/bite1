package com.bite.MyTomCat.tomcat_implements;


import com.bite.MyTomCat.servlet_standard.HttpServlet;

public class StaticResourceHttpServlet extends HttpServlet {
    public boolean exists(String requestURI) {
        return false;
    }
}
