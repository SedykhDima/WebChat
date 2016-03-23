package frontend.Servlets;

import dbService.DBService;
import dbService.DBServiceImpl;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Develop on 15.03.2016.
 */
public class SignInServlet  extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DBService dbService = DBServiceImpl.newInstance();
        UsersDataSet usersDataSet = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        try {
            usersDataSet = dbService.getUserProfile(login);
            if (password.equals(usersDataSet.getPassword())) {
                printWriter.println("Authorized: " + usersDataSet.getLogin());
                printWriter.println(usersDataSet.getPassword());
                response.sendRedirect("chat.html");
            }
            else printWriter.println("Пароль введен неверно");
            response.sendRedirect("index.html");
        }
        catch (NullPointerException e) {
            printWriter.println("Пользователь не существует");
            response.sendRedirect("index.html");
        }
    }
}
