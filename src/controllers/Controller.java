package controllers;

import services.Action;
import services.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/*")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("@@");
        Action action = null;
        String path = requestPath(req);
        switch (path) {
            case "/users/":
                action = new Login(); break;
        }
        try {
            action.GET(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = requestPath(req);
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = requestPath(req);
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = requestPath(req);
        super.doDelete(req, resp);
    }

    protected String requestPath(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String path = uri.substring(req.getContextPath().length());
        return path;
    }

}

