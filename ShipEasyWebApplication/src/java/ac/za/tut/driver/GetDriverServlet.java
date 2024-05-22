package ac.za.tut.driver;

import ac.za.tut.bl.DriverFacadeLocal;
import ac.za.tut.verifyuserdetails.VerifyRegistrationLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import security.SecurityFilter;

public class GetDriverServlet extends HttpServlet {

    @EJB
    private VerifyRegistrationLocal verifyFacadeSB;
    @EJB
    private DriverFacadeLocal driverFacadeSBL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        String name = request.getParameter("full_names");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String contactNumber = request.getParameter("cell_nr");
        String password = request.getParameter("password");

        boolean isEmailValid = verifyFacadeSB.validateEmailDomain(email);
        boolean isPasswordStrong = verifyFacadeSB.isPasswordStrong(password);

        if (isEmailValid) {

            Driver driver = driverFacadeSBL.findDriverByEmail(email);

            if (driver != null) {

                String userExist = "User '" + email + "' already exist!!";
                request.setAttribute("userExist", userExist);

                request.setAttribute("name", name);
                request.setAttribute("surname", surname);
                request.setAttribute("email", email);
                request.setAttribute("contactNumber", contactNumber);
                request.setAttribute("password", password);

                RequestDispatcher disp = request.getRequestDispatcher("driver_registration.jsp");
                disp.forward(request, response);

            } else {

                if (isPasswordStrong) {
                    
                 String encypedPassword = SecurityFilter.generateHash(password);
                 System.out.println("Passsword "+encypedPassword);
              
                    Driver newDriver = createDriver(name, surname, email, contactNumber, encypedPassword);
                    session.setAttribute("driver", newDriver);
                    
                    RequestDispatcher disp = request.getRequestDispatcher("enter_vehicle.jsp");
                    disp.forward(request, response);
                    
                } else {

                    String passwordCriteriaErr = "Password does not meet the specified criteria!!";

                    request.setAttribute("passwordCriteriaErr", passwordCriteriaErr);

                    request.setAttribute("name", name);
                    request.setAttribute("surname", surname);
                    request.setAttribute("email", email);
                    request.setAttribute("contactNumber", contactNumber);
                    request.setAttribute("password", password);

                    RequestDispatcher disp = request.getRequestDispatcher("driver_registration.jsp");
                    disp.forward(request, response);
                }
            }

        } else {

            String errMsg = "Not a valid email!!Consider email domain '@gmail.com'";
            request.setAttribute("errMsg", errMsg);

                request.setAttribute("name", name);
                request.setAttribute("surname", surname);
                request.setAttribute("email", email);
                request.setAttribute("contactNumber", contactNumber);
                request.setAttribute("password", password);

                RequestDispatcher disp = request.getRequestDispatcher("driver_registration.jsp");
                disp.forward(request, response);

        }

    }

    private Driver createDriver(String name, String surname, String email, String contactNumber, String password) {

        return new Driver(name, surname, email, contactNumber, password);
    }

}
