package ac.za.tut.updateshipment;

import ac.za.tut.bl.ProductFacadeLocal;
import ac.za.tut.bl.ShipmentFacadeLocal;
import ac.za.tut.product.Product;
import ac.za.tut.shipment.Shipment;
import ac.za.tut.shipmenthandler.ShipmentHandlerLocal;
import ac.za.tut.user.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpdateShipmentServlet extends HttpServlet {
    @EJB
    private ShipmentFacadeLocal shipFacadeSB;
    @EJB
    private ProductFacadeLocal productFacadeSB;
    @EJB
    private ShipmentHandlerLocal shipHandlerFacadeSB;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        HttpSession session = request.getSession(false);
        
        
        String pickUpPoint = request.getParameter("pick_up_location");
        String destination = request.getParameter("destination");
        String productType = request.getParameter("shipmentType");
        double weight = Integer.parseInt(request.getParameter("weight"));
        
        double price = Double.parseDouble(shipHandlerFacadeSB.calcShipmentPrice(weight,productType));
        
        
            Shipment shipment =(Shipment) session.getAttribute("shipment");
            User user = (User)session.getAttribute("LoggedInUser");
            
              if (shipment != null) {
             
                  Product product = shipment.getProduct();
                  
                shipment = updateShipment(pickUpPoint,destination,productType,weight,price,product,user);
                shipFacadeSB.edit(shipment);
                
                session.setAttribute("shipment", shipment);
                
               // RequestDispatcher disp = request.getRequestDispatcher("view_shipment.jsp");
               // disp.forward(request, response);
                response.sendRedirect("ViewShipmentServlet.do");
                
        }
          
        
    }

    private Shipment updateShipment(String pickUpPoint, String destination, String productType, double weight, double price,Product product,User user) {
        Shipment shipment = product.getShipment();
          
          product.setType(productType);
          product.setWeight(weight);
          product.setPrice(price);
       
         shipment.setPickLocation(pickUpPoint);
         shipment.setDestination(destination);
         
         shipment.setUser(user);
         
         productFacadeSB.edit(product);
         
        return shipment;
        
    }

}
