package ac.za.tut.driver;

import ac.za.tut.bl.DriverFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RestartRegistrationServlet extends HttpServlet {
    
    @EJB
    private DriverFacadeLocal driverFacadeSBL;
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            
            Driver driver =(Driver) session.getAttribute("driver");
            driverFacadeSBL.remove(driver);
            
            RequestDispatcher disp = request.getRequestDispatcher("driver_registration.jsp");
            disp.forward(request, response);
            
        }
    }

}
