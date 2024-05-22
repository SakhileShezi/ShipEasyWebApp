package ac.za.servlets;

import ac.za.tut.driver.Driver;
import ac.za.tut.bl.ShipmentFacadeLocal;
import ac.za.tut.shipment.Shipment;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DriverAssginedShipmentServlet extends HttpServlet {
    @EJB
    private ShipmentFacadeLocal shipmentFacadeSBL;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session =  request.getSession(false);
        
        if (session != null) {
            
               Driver driver =(Driver)session.getAttribute("LoggedInDriver");
               
               if (driver != null) {
               System.out.println("Available");
                
                   List<Shipment> sipments = shipmentFacadeSBL.getShipmentByDriverId(driver.getId());
                   session.setAttribute("driversSipments", sipments);
                   
                   RequestDispatcher disp = request.getRequestDispatcher("driver_shipments.jsp");
                   disp.forward(request, response);
            }else{
                System.out.println("Not available");
               }
        }
        
    }


}
