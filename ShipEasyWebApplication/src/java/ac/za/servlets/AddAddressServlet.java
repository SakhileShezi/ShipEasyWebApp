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


public class AddAddressServlet extends HttpServlet {
    @EJB
    private AddressFacadeLocal adL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        HttpSession session = request.getSession(false);
        
        String street = request.getParameter("street_name");
        String address1 = request.getParameter("address");
        String postalCode = request.getParameter("postal_code");
        
        if (session != null) {
             
             User user = (User)session.getAttribute("LoggedInUser");
             
             if (user != null) {
                 
                 Address address = user.getAddress();
                    
                 if (address != null) {
                     
                     String errMsg = "Looks like you already added an address before!!";
                     
                     request.setAttribute("errMsg", errMsg);
                     
                     RequestDispatcher disp = request.getRequestDispatcher("add_address.jsp");
                     disp.forward(request, response);
                     
                 }else{
                     
                 address = new Address(street, address1, postalCode);
                 
                 address.setUser(user);
                 user.setAddress(address);
                 
                 adL.create(address);
                 
                 session.setAttribute("LoggedInUser", user);
                 
                 RequestDispatcher disp = request.getRequestDispatcher("profile.jsp");
                 disp.forward(request, response);
                 }
                 
                 
                 
                 
                 
                // response.sendRedirect("GetAddressServlet.do");
            }
        }
        
    }

    private Address createAddress(String street, String address1, String postalCode) {
       
        Address address = new Address(street, address1, postalCode);
        
        return address;
    }


}
