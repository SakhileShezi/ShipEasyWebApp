package ac.za.servlets;

import ac.za.tut.address.Address;
import ac.za.tut.bl.AddressFacadeLocal;
import ac.za.tut.user.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetAddressServlet extends HttpServlet {
   
    @EJB
    private AddressFacadeLocal adFacadeSBL;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session != null) {
            
            User user = (User)session.getAttribute("LoggedInUser");
            
            if (user != null) {
                
                Address address = adFacadeSBL.findByUserId(user.getId());
                
                session.setAttribute("address", address);
                
                RequestDispatcher disp = request.getRequestDispatcher("profile.jsp");
                disp.forward(request, response);
            }
        }
    }


}
