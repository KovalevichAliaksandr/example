package com.departments.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by alex on 9.2.17.
 */
public class TestServletController extends HttpServlet {
    @Override

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter=response.getWriter();
        printWriter.println( "Servlet write");
    }
}
