package ac.za.tut.regservlet;

import ac.za.tut.user.User;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ac.za.tut.bl.UserFacadeLocal;
import ac.za.tut.verifyuserdetails.VerifyRegistrationLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import security.SecurityFilter;
import sentEmail.WelcomeEmail;

public class RegistrationServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal userFacadeSB;
    @EJB
    private VerifyRegistrationLocal verifyFacadeSB;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone_number");
        char gender = request.getParameter("gender").charAt(0);
        String dob = request.getParameter("dob");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        Date creationDate = new Date();

        boolean isEmailValid = verifyFacadeSB.validateEmailDomain(email);
        boolean isPasswordMatch = verifyFacadeSB.verifyPassword(password, confirmPassword);
        boolean isPasswordStrong = verifyFacadeSB.isPasswordStrong(password);

        if (isEmailValid) {

            User user = userFacadeSB.findByEmail(email);

            if (user != null) {

                String userExist = "User '" + email + "' already exist!!";
                request.setAttribute("userExist", userExist);

                retainData(request, name, surname, email, dob, password, confirmPassword, creationDate, email, phoneNumber);

                RequestDispatcher disp = request.getRequestDispatcher("register.jsp");
                disp.forward(request, response);

            } else {

                if (isPasswordStrong) {

                    if (isPasswordMatch) {

                        String encypedPassword = SecurityFilter.generateHash(password);
                        System.out.println("Passsword "+encypedPassword);
                        User newUser = createNewUser(name, surname, encypedPassword, email, phoneNumber, gender, dob, creationDate);
                        userFacadeSB.create(newUser);
                        
                        WelcomeEmail welcomeEmail = new WelcomeEmail(name);
                        
                        try {
                            
                            sentEmail.SendEmailService.sendMail(email, welcomeEmail.getSubject(),welcomeEmail.getBody());
                        } catch (MessagingException ex) {
                            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        

                        RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
                        disp.forward(request, response);

                    } else {

                        String passErrMsg = "Password Mismatch!!Re-confirm Password";
                        request.setAttribute("passErrMsg", passErrMsg);

                        retainData(request, name, surname, email, dob, password, confirmPassword, creationDate, email, phoneNumber);

                        RequestDispatcher disp = request.getRequestDispatcher("register.jsp");
                        disp.forward(request, response);
                    }
                } else {

                    String passwordCriteriaErr = "Password does not meet the specified criteria!!";

                    request.setAttribute("passwordCriteriaErr", passwordCriteriaErr);

                    retainData(request, name, surname, email, dob, password, confirmPassword, creationDate, email, phoneNumber);

                    RequestDispatcher disp = request.getRequestDispatcher("register.jsp");
                    disp.forward(request, response);
                }
            }

        } else {

            String errMsg = "Not a valid email!!Consider email domain '@gmail.com'";
            request.setAttribute("errMsg", errMsg);

            retainData(request, name, surname, email, dob, password, confirmPassword, creationDate, email, phoneNumber);

            RequestDispatcher disp = request.getRequestDispatcher("register.jsp");
            disp.forward(request, response);

        }

    }

    private User createNewUser(String name, String surname, String password, String email, String phoneNumber, char gender, String dob, Date creationDate) {

        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setCreationDate(creationDate);
        user.setGender(gender);
        user.setDob(dob);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);

        return user;
    }

    private void retainData(HttpServletRequest request, String name, String surname, String email, String dob, String password, String confirmPassword, Date creationDate, String email1, String phoneNumber) {

        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("email", email);
        request.setAttribute("phoneNumber", phoneNumber);
        request.setAttribute("dob", dob);
        request.setAttribute("password", password);
        request.setAttribute("confirmPassword", confirmPassword);

    }
}
