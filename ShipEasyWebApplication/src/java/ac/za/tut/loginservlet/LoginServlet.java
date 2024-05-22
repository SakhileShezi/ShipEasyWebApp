package ac.za.tut.loginservlet;

import ac.za.tut.driver.Driver;
<<<<<<< HEAD
import ac.za.tut.bl.DriverFacadeLocal;
=======
import ac.za.tut.entities.DriverFacadeLocal;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
import ac.za.tut.user.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import ac.za.tut.bl.UserFacadeLocal;
=======
import ac.za.tut.entities.UserFacadeLocal;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
import security.SecurityFilter;

public class LoginServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal userFacadeSB;
    @EJB
    private DriverFacadeLocal driverFacadeSBL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userFacadeSB.findByEmail(username);

        Driver driver = driverFacadeSBL.findDriverByEmail(username);

        String incorrectPasswordErr;

        if (user != null) {
            
            String encryedPassword = SecurityFilter.generateHash(password);

            if (encryedPassword.equals(user.getPassword())) {

                session.setAttribute("LoggedInUser", user);

                RequestDispatcher disp = request.getRequestDispatcher("user_menu.jsp");
                disp.forward(request, response);

            } else {

                incorrectPasswordErr = "Incorrect password!!";
                request.setAttribute("incorrectPasswordErr", incorrectPasswordErr);
                
                request.setAttribute("password",password);
                request.setAttribute("username",username);

                RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
                disp.forward(request, response);

            }
        } else if (driver != null) {
            
<<<<<<< HEAD
            String encryedPassword = SecurityFilter.generateHash(password);
                
            if (encryedPassword.equals(driver.getPassword())) {

            session.setAttribute("LoggedInDriver", driver);
=======
            if (password.equals(driver.getPassword())) {

                session.setAttribute("LoggedInDriver", driver);
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c

                RequestDispatcher disp = request.getRequestDispatcher("driver_home.jsp");
                disp.forward(request, response);

            } else {

                incorrectPasswordErr = "Incorrect password!!";
<<<<<<< HEAD
                request.setAttribute("incorrectPasswordErr", incorrectPasswordErr);
=======
                request.setAttribute("errorMsg", incorrectPasswordErr);
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
                
                 request.setAttribute("password",password);
                 request.setAttribute("username",username);

                RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
                disp.forward(request, response);

            }
        } else {

            String userNotFoud = "No account found for username '"+username+"'";
            request.setAttribute("userNotFoud", userNotFoud);
            
            request.setAttribute("password",password);
            request.setAttribute("username",username);

            RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
            disp.forward(request, response);
        }

    }
}
