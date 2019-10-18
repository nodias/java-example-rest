package services;

import dao.UserDAO;
import dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class Login implements Action{

        @Override
        public void GET(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
                User user = null;
                String id = req.getParameter("id");
                UserDAO userDAO = new UserDAO();
                user = userDAO.getUser(id);
                resp.setStatus(200);
                resp.setContentType("application.json");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.print(user);
                out.flush();

        }

        @Override
        public void POST(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                //TODO
        }

        @Override
        public void PUT(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                //TODO
        }

        @Override
        public void DELETE(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                //TODO
        }
}
