package ac.za.servlets;

import ac.za.tut.bl.UserFacadeLocal;
import ac.za.tut.user.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal userFL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("cell_nr");
        String street = request.getParameter("street_name");
        String addressL1 = request.getParameter("address");
        String postalCode = request.getParameter("postal_code");
        
        if (session != null) {
            
            User user =(User)session.getAttribute("LoggedInUser");
            
            if (user != null) {
               
              updateUser(user,name,surname,phoneNumber,street,addressL1,postalCode);
              userFL.edit(user);
              
              session.setAttribute("LoggedInUser", user);
              
              RequestDispatcher disp = request.getRequestDispatcher("profile.jsp");
              disp.forward(request, response);
              
            }
        }
        
    }

    private void updateUser(User user, String name, String surname, String phoneNumber, String street, String addressL1, String postalCode) {
     
        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phoneNumber);
        user.getAddress().setStreetName(street);
        user.getAddress().setAddressLine1(addressL1);
        user.getAddress().setPostalCode(postalCode);
        
    }

}
