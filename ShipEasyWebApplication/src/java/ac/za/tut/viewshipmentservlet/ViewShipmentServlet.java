package ac.za.tut.viewshipmentservlet;

import ac.za.tut.shipment.Shipment;
import ac.za.tut.user.User;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ac.za.tut.entities.ShipmentFacadeLocal;

public class ViewShipmentServlet extends HttpServlet {
    @EJB
    private ShipmentFacadeLocal shipmentFacadeSB;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession(false);
        
        List<Shipment> shipments;
        
        if (session != null) {
            
            User user =(User)session.getAttribute("LoggedInUser");
            
            if (user != null) {
                
                 shipments = shipmentFacadeSB.getShipmentByUserId(user.getId());
                 
                 session.setAttribute("shipments", shipments);
                 
                 RequestDispatcher disp = request.getRequestDispatcher("view_shipment.jsp");
                 disp.forward(request, response);
                 
            }else{
                
                 RequestDispatcher disp = request.getRequestDispatcher("user_menu.jsp");
                 disp.forward(request, response);
            
            }
        }
    }
}
