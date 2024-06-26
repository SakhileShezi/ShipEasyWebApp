package ac.za.tut.trackingservlet;

<<<<<<< HEAD
import ac.za.tut.driver.Driver;
import ac.za.tut.bl.DriverFacadeLocal;
import ac.za.tut.bl.ShipmentFacadeLocal;
=======
import ac.za.tut.entities.ShipmentFacadeLocal;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
import ac.za.tut.shipment.Shipment;
import ac.za.tut.status.Status;
import ac.za.tut.user.User;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.NoResultException;

public class TrackingServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipFacadeSBL;
<<<<<<< HEAD
    @EJB
    private DriverFacadeLocal driverFacadeSBL;
=======
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String trackingKey = request.getParameter("tracking_code");

        if (session != null) {
            User user = (User) session.getAttribute("LoggedInUser");

            if (user != null) {
                try {
                    Shipment shipment = shipFacadeSBL.findShipmentByTrackingCode(user.getId(), trackingKey);

                    if (shipment != null) {
                        
<<<<<<< HEAD
                        Driver driverAssingned = driverFacadeSBL.findByShipment(shipment.getAssignedDriver().getId());
                        
=======
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
                        Status status = shipment.getStatus();

                        session.setAttribute("shipment", shipment);
                        session.setAttribute("status", status);
<<<<<<< HEAD
                        session.setAttribute("driverAssingned", driverAssingned);
=======
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c

                        RequestDispatcher disp = request.getRequestDispatcher("tracking_parcel.jsp");
                        disp.forward(request, response);
                        
                    } else {
                        
                        request.setAttribute("trackingKey", trackingKey);
                        
                        String errMsg ="Incorrect Tracking code!! No Shipment/Parcel found for the provided tracking code.";
                        request.setAttribute("errMsg", errMsg);
                    }
                } catch (NoResultException e) {
                    
                    request.setAttribute("trackingKey", trackingKey);
                    
                    String errMsg ="Incorrect Tracking code!! No Shipment/Parcel found for the provided tracking code.";
                    request.setAttribute("errMsg", errMsg);
                }
            }
        }
        
        RequestDispatcher disp = request.getRequestDispatcher("track_parcel.jsp");
        disp.forward(request, response);
       
    }
}
