package controller;

import java.io.IOException;

import dao.IUserService;
import dao.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.UserModel;

@WebServlet(urlPatterns = { "/login", "/dangnhap" })
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String ten = req.getParameter("uname");
        String pass = req.getParameter("psw");
        String remember = req.getParameter("remember");
        boolean isRemember = false;
        if ("on".equals(remember)) {
            isRemember = true;
        }
        String alertMsg = "";
        if (ten == null || ten.isEmpty() || pass == null || pass.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
            return;
        }
        IUserService service = new UserServiceImpl();
        UserModel user = service.login(ten, pass);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            req.setAttribute("msg", true);
            req.setAttribute("uname", user.getName());
            req.setAttribute("pwd", user.getPassword());
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.setAttribute("msg", false);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        }
    }
}
