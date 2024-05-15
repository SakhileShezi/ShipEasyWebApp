package ac.za.tut.updatepassword;

import ac.za.tut.entities.UserFacadeLocal;
import ac.za.tut.user.User;
import ac.za.tut.verifyuserdetails.VerifyRegistrationLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePasswordServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal userFacadeSB;
    @EJB
    private VerifyRegistrationLocal verifySBL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

        User user = userFacadeSB.findByEmail(email);
        boolean isPasswordMatch = verifySBL.verifyPassword(newPassword, confirmNewPassword);
        boolean isPassWordStrong = verifySBL.isPasswordStrong(newPassword);

        if (user != null) {

            if (isPassWordStrong) {
                
            if (isPasswordMatch) {

                user.setPassword(newPassword);
                userFacadeSB.edit(user);

                response.sendRedirect("login.jsp");
                
            } else {
                
                String passwordErr = "Password Mismatch!!";
                request.setAttribute("passwordErr", passwordErr);

                request.setAttribute("email", email);
                request.setAttribute("confirmNewPassword", confirmNewPassword);
                request.setAttribute("newPassword", newPassword);

                RequestDispatcher disp = request.getRequestDispatcher("change_password.jsp");
                disp.forward(request, response);

            }
            }else{
                
                String passwordErr = "Password does not meet the specified criteria!!";
                request.setAttribute("passwordErr", passwordErr);

                request.setAttribute("email", email);
                request.setAttribute("confirmNewPassword", confirmNewPassword);
                request.setAttribute("newPassword", newPassword);
                
                RequestDispatcher disp = request.getRequestDispatcher("change_password.jsp");
                disp.forward(request, response);
            }

        } else {

            String userNotFound = "No account found for User '"+email+"'";
            request.setAttribute("userNotFound", userNotFound);

            request.setAttribute("email", email);
            request.setAttribute("confirmNewPassword", email);
            request.setAttribute("newPassword", newPassword);

            RequestDispatcher disp = request.getRequestDispatcher("change_password.jsp");
            disp.forward(request, response);
        }

    }
}
