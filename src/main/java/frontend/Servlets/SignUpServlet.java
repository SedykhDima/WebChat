package frontend.Servlets;

import frontend.AccountProfile;
import frontend.UserProfile;

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
        AccountProfile accountProfile = new AccountProfile();
        accountProfile.addUser(login, new UserProfile(login, password));
        accountProfile.pushDataBase(login, accountProfile);
        PrintWriter pw = response.getWriter();
        pw.println("Registred");
    }
}
