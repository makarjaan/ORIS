package ru.kpfu.itis304.servlet;

import ru.kpfu.itis304.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "userServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(UsersServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Запрошена страница списка пользователей");
        req.setAttribute("users", List.of(new UserDto("Ivan", 100, "Ivan228")));
        req.getRequestDispatcher("users.ftl").forward(req, resp);  //можно достать обработчик для определённой страницы
    }
}
