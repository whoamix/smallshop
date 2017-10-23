package com.example.servletjspdemo.web;

import com.example.servletjspdemo.domain.Computer;
import com.example.servletjspdemo.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/shop")
public class Shop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            ServletException, IOException {

        StorageService storage = new StorageService();
        Map<Integer, Computer> computers = storage.getShopDb();
        PrintWriter out = httpServletResponse.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<style type=\"text/css\">\n" +
                "body {\n" +
                "\tbackground-color: #1c4150;\n" +
                "\tcolor: #e8ecee;\n" +
                "}\n" +
                "#topdiv{\n" +
                "\tmargin-left: auto;\n" +
                "\tmargin-right: auto;\n" +
                "}\n" +
                ".tabs {\n" +
                "\tmargin: 5px;\n" +
                "\tdisplay: inline-block;\n" +
                "\theight: 50px;\n" +
                "\twidth: 100px;\n" +
                "\tbackground-color: #32546c;\n" +
                "\tborder: 2px solid #8da0ad;\n" +
                "\tfloat: left;\n" +
                "\ttext-align: center;\n" +
                "\t}\n" +
                "a {\n" +
                "\n" +
                "\ttext-decoration: none;\n" +
                "\tcolor: #e8ecee;\n" +
                "}\n" +
                "a:visited {\n" +
                "\tcolor: #e8ecee;\n" +
                "}\n" +
                "\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<div id=\"topdiv\">\n" +
                "\t<div class=\"tabs\"><a href='http://localhost:8080/smallshop/shoppingcard'>Shopping Card</div>\n" +
                "\t<div class=\"tabs\"><a href='http://localhost:8080/smallshop/getComputerData.jsp'>Add " +
                "Computer</div>\n" +
                "\t<div class=\"tabs\"><a href='http://localhost:8080/smallshop/shop'>Shop</a></div>\n" +
                "\t<div/>\n" +
                "<form id=\"Computers\">");
                 int i = 1;
                 for(Computer c : computers.values()) {
                     out.println("<label>" + c.getModel() + " " + c.getCpu() + " " + c.getGpu() + "<input " +
                             "type=\"checkbox\" value=\"" +i+ "\"/></label>");
                 }
                 out.println("</body>" +
                         "</html>");
    }
}
