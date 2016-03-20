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
        DBService dbService = new DBServiceImpl();
        UsersDataSet usersDataSet = dbService.getUserProfile(login);
        PrintWriter pw = response.getWriter();
        pw.println("Authorized: " + usersDataSet.getLogin());
        pw.println(usersDataSet.getPassword());
    }
}
