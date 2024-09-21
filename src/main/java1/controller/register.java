package controller;

import dao.InputCondition;
import dao.impl.InputConditionImpl;
import dao.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;

import java.io.IOException;

@WebServlet(urlPatterns = { "/register" })
public class register extends HttpServlet {
    private static final long serialVersionUID = 1L;




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registerForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        // Lấy thông tin người dùng từ form đăng ký
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("confirm_password");
        String image = null;
        String fullName = req.getParameter("fullname");
        int roleid = Integer.parseInt(req.getParameter("roleid"));
        String phone = req.getParameter("phone");

        // Kiểm tra email và username
        InputConditionImpl inputCondition = new InputConditionImpl();
        boolean emailExists = !inputCondition.checkEmail(email);
        boolean usernameExists = !inputCondition.checkUsername(name);

        if (emailExists) {
            req.setAttribute("errorMessage", "Email existed. Please try again with another email.");
            req.getRequestDispatcher("registerForm.jsp").forward(req, resp);
            return;
        }

        if (usernameExists) {
            req.setAttribute("errorMessage", "Username existed. Please try again with another Username.");
            req.getRequestDispatcher("registerForm.jsp").forward(req, resp);
            return;
        }

        // Kiểm tra password và passwordConfirm
        if (!password.equals(passwordConfirm)) {
            req.setAttribute("errorMessage", "Password and Confirm Password do not match.Please try again.");
            req.getRequestDispatcher("registerForm.jsp").forward(req, resp);
            return;
        }

        // Tạo đối tượng UserModel và thiết lập các thuộc tính
        UserModel user = new UserModel();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setImage(image);
        user.setFullname(fullName);
        user.setRoleid(roleid);
        user.setPhone(phone);

        // Gọi phương thức createUser để lưu người dùng vào cơ sở dữ liệu
        UserServiceImpl userService = new UserServiceImpl();
        UserModel createdUser = userService.createUser(user);

        if (createdUser != null) {
            // Đăng ký thành công, hiển thị thông báo thành công
            req.setAttribute("successMessage", "Registered successfully");
            req.getRequestDispatcher("registerForm.jsp").forward(req, resp);
        } else {
            // Đăng ký thất bại, hiển thị thông báo lỗi
            req.setAttribute("errorMessage", "Registration failed. Please try again.");
            req.getRequestDispatcher("registerForm.jsp").forward(req, resp);
        }
    }


}
