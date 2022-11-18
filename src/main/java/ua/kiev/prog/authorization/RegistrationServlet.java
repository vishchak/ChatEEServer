package ua.kiev.prog.authorization;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class RegistrationServlet extends HttpServlet {

    private static final Map<String, String> userList = UsersList.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userList.containsKey(login)) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);

        } else {
            userList.put(login, password);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
    }
}
