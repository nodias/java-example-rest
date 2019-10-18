package services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    public void GET(HttpServletRequest req, HttpServletResponse resp) throws Exception;
    public void POST(HttpServletRequest req, HttpServletResponse resp) throws Exception;
    public void PUT(HttpServletRequest req, HttpServletResponse resp) throws Exception;
    public void DELETE(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
