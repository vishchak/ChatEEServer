package ua.kiev.prog.authorization;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private static final Map<String, String> userList = UsersList.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userList.containsKey(login)) {
            if (userList.get(login).equals(password)) {
                resp.setStatus(HttpServletResponse.SC_OK);
            } else resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}
