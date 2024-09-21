package controller;

import dao.IUserService;
import dao.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserModel;

import java.io.IOException;

@WebServlet(urlPatterns = { "/resetpassword" })
public class forgotPass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/returnPass.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");

        String alertMsg = "";
        if (email == null || email.isEmpty()) {
            alertMsg = "Email không được để trống";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/returnPass.jsp").forward(req, resp);
            return;
        }

        IUserService service = new UserServiceImpl();
        UserModel user = service.findByEmail(email);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            req.setAttribute("msg", true);
            req.setAttribute("uname", user.getName());
            req.setAttribute("pwd", user.getPassword());
            req.getRequestDispatcher("/returnPass.jsp").forward(req, resp);
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.setAttribute("msg", false);
            req.getRequestDispatcher("/returnPass.jsp").forward(req, resp);
        }
    }
}
