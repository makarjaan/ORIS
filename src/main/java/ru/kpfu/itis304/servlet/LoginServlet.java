package ru.kpfu.itis304.servlet;

import ru.kpfu.itis304.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;


@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG  = Logger.getLogger(LoginServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Запрошена страница входа на сайт");
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        LOG.info("Попытка входа пользователя: " + login);

        if (("login".equalsIgnoreCase(login) && "password".equals(password)) || ("admin".equalsIgnoreCase(login) && "adminpas".equals(password))){
            LOG.info("Успешный вход пользователя: " + login);
            // session
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", login);
            httpSession.setMaxInactiveInterval(60 * 60);

            // cookie
            Cookie cookie = new Cookie("user", login);
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);
            resp.sendRedirect("main.jsp");
        } else {
            LOG.info("Неудачная попытка входа пользователя: " + login);
            resp.sendRedirect("/login");
        }
    }
}
