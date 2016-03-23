package frontend.Servlets;

import dbService.DBService;
import dbService.DBServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Develop on 15.03.2016.
 */
public class SignUpServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DBService dbService = DBServiceImpl.newInstance();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        try {
            dbService.addUser(login, password);
        }
        catch (Exception e) {
            printWriter.println("Пользователь уже зарегистрирован");
        }
        response.sendRedirect("chat.html");
    }
}
