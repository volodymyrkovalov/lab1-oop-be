package com.yourcompany.library.controller;

import com.yourcompany.library.dto.UserDTO;
import com.yourcompany.library.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("login")) {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else if (action.equalsIgnoreCase("register")) {
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("register")) {
                registerUser(req, resp);
            } else if (action.equalsIgnoreCase("login")) {
                loginUser(req, resp);
            }
        }
    }

    private void registerUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        UserDTO newUser = new UserDTO();
        newUser.setUsername(username);
        newUser.setPassword(password);  // Consider using password hashing here
        newUser.setEmail(email);

        try {
            userService.registerUser(newUser);
            req.getSession().setAttribute("user", newUser);
            resp.sendRedirect(req.getContextPath() + "/home.jsp");  // Redirect to a home page or profile page
        } catch (Exception e) {
            req.setAttribute("error", "Registration failed: " + e.getMessage());
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            UserDTO user = userService.validateUser(username, password);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/home.jsp");  // Redirect to home page after successful login
            } else {
                req.setAttribute("error", "Invalid username or password");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "Login failed: " + e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}