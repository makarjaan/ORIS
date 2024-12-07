package ru.kpfu.itis304.servlet;

import ru.kpfu.itis304.dao.UserDao;
import ru.kpfu.itis304.dao.impl.UserDaoImpl;
import ru.kpfu.itis304.dto.UserDto;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;

@WebServlet(name = "usersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    private ServletContext servletContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletContext = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", new UserDaoImpl().getAll());
        req.getRequestDispatcher("users.ftl").forward(req, resp);
    }
}