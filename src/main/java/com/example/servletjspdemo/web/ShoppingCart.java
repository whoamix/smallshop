package com.example.servletjspdemo.web;

import com.example.servletjspdemo.domain.Computer;
import com.example.servletjspdemo.service.ShoppingCartService;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/shoppingcart")
public class ShoppingCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        double toPay = 0;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html");
        HttpSession session = httpServletRequest.getSession();
        ShoppingCartService shoppingCart = (ShoppingCartService) session.getAttribute("cart");

        PrintWriter out = httpServletResponse.getWriter();

        HashMap<Integer, Computer> items = shoppingCart.getCartItems();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Koszyk</title>");
        out.println("</head>");
        out.println("<body>");
        out.print("<div>\n" +
                "\t\t<div class=\"tabs\" style=\"display: inline-block; border: solid 1px #000; text-decoration: none;\"><a href='/smallshop/shoppingcart'>Shopping Card</a></div>\n" +
                "\t\t<div class=\"tabs\" style=\"display: inline-block; border: solid 1px #000; text-decoration: none;\"><a href='/smallshop/getComputerData.jsp'>Add Computer</a></div>\n" +
                "\t<div class=\"tabs\" style=\"display: inline-block; border: solid 1px #000; text-decoration: none;\"><a href='/smallshop/showAllComputer.jsp'>Shop</a></div>\n" +
                "\t<div/>");
        out.println("<h1>Produkt został dodany do twojego koszyka</h1>");
        out.println("<hr>");
        out.println("<h2>Zawartość koszyka.</h2>");
        out.println("<table border='1px'>");
        for(Map.Entry<Integer, Computer> entry : items.entrySet()) {
            out.println("<form action='deletefromcart'><input type='hidden' name='name' value='" + entry.getKey() + "'><tr><td>" + entry.getValue().getModel() + "</td><td>" + "$" + entry.getValue().getPrice() + "</td><td><input type='submit' value='delete'></td></tr></form>");
            toPay += entry.getValue().getPrice();
        }
        out.println("<table>");
        out.println("<p>");
        out.println("Łączna kwota do zapłaty: " + toPay);
        out.print("&nbsp; <form action=\"buy\"><input type=\"submit\" value=\"Kup\"/></form>");
        out.println("</body>");
        out.println("</html>");
    }
}
