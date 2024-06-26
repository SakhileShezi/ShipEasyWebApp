package ac.za.shipmentservlet;

import ac.za.tut.defaultdriver.DefaultDriver;
import ac.za.tut.driver.Driver;
<<<<<<< HEAD
import ac.za.tut.bl.DefaultDriverFacadeLocal;
import ac.za.tut.bl.DriverFacadeLocal;
=======
import ac.za.tut.entities.DefaultDriverFacadeLocal;
import ac.za.tut.entities.DriverFacadeLocal;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
import ac.za.tut.shipmenthandler.ShipmentHandlerLocal;
import ac.za.tut.shipment.Shipment;
import ac.za.tut.user.User;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import ac.za.tut.bl.ShipmentFacadeLocal;
import ac.za.tut.product.Product;
import ac.za.tut.regservlet.RegistrationServlet;
import ac.za.tut.status.Status;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import sentEmail.DriverActivityMail;
import sentEmail.ShipmentConfirmationMail;
=======
import ac.za.tut.entities.ShipmentFacadeLocal;
import ac.za.tut.entities.StatusFacadeLocal;
import ac.za.tut.product.Product;
import ac.za.tut.status.Status;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c

public class CreateShipmentServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipFacadeSB;
    @EJB
    private ShipmentHandlerLocal shipHandlerFacadeSB;
    @EJB
    private DriverFacadeLocal driverFacadeSBL;
    @EJB
    private DefaultDriverFacadeLocal defDriverSBL;
<<<<<<< HEAD
=======
    @EJB
    private StatusFacadeLocal statusFacadeSBL;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String pickUpPoint = request.getParameter("pick_up_location");
        String destination = request.getParameter("destination");
        String productType = request.getParameter("shipmentType");
        double weight = Integer.parseInt(request.getParameter("weight"));

        double price = Double.parseDouble(shipHandlerFacadeSB.calcShipmentPrice(weight, productType));

        String trackingCode;

        Date creationDate = new Date();

        Date shippingDate = shipHandlerFacadeSB.expectedToShipOn(creationDate);

        Status status = new Status("ShipEasy Service", "Standard Shipping", "Shipment Confirmed", "Shipment Confirmed", shippingDate);

        if (session != null) {

            User user = (User) session.getAttribute("LoggedInUser");

            if (user != null) {
                trackingCode = shipHandlerFacadeSB.generateTrackingKey(user.getName());

                int availableDrivers = driverFacadeSBL.count();

                if (availableDrivers != 0) {

                    Driver driver = shipHandlerFacadeSB.getDriver();

                    Shipment shipment = createShipment(pickUpPoint, destination, productType, creationDate, weight, price, trackingCode, user);
                    shipment.setAssignedDriver(driver);

                    driver.getShipments().add(shipment);

                    status.setShipment(shipment);
                    shipment.setStatus(status);

<<<<<<< HEAD
                    session.setAttribute("LoggedInDriver", driver);
                    
                    shipFacadeSB.create(shipment);

                        ShipmentConfirmationMail confirmShipment = new ShipmentConfirmationMail(user.getName(), shipment);
                        DriverActivityMail driverAssignedShipment = new DriverActivityMail( shipment,driver);
                        
                        try {
                            sentEmail.SendEmailService.sendMail(user.getEmail(), confirmShipment.getSubject(),confirmShipment.getBody());
                            sentEmail.SendEmailService.sendMail(driver.getEmail(), driverAssignedShipment.getSubject(),driverAssignedShipment.getBody());
                        } catch (MessagingException ex) {
                            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
=======
                    shipFacadeSB.create(shipment);

>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
                    response.sendRedirect("ViewShipmentServlet.do");
                } else {

                    int count = defDriverSBL.count();

                    if (count != 0) {

                        DefaultDriver defaultDriver = shipHandlerFacadeSB.getCommunityDriver();

                        Shipment shipment = createShipment(pickUpPoint, destination, productType, creationDate, weight, price, trackingCode, user);
                        shipment.setAssignDefault(defaultDriver);

                        defaultDriver.getShipments().add(shipment);

                        shipment.setStatus(status);
                        status.setShipment(shipment);

                        shipFacadeSB.create(shipment);
                        response.sendRedirect("ViewShipmentServlet.do");

                    } else {

                        DefaultDriver driverCommunity = new DefaultDriver("ShipEasy Courier", "Connecting Continents, Delivering Dreams", "info@shipeasy.com", "216-87-663", "4.7");
                        defDriverSBL.create(driverCommunity);

                        Shipment shipment = createShipment(pickUpPoint, destination, productType, creationDate, weight, price, trackingCode, user);
                        shipment.setAssignDefault(driverCommunity);

                        driverCommunity.getShipments().add(shipment);

                        shipment.setStatus(status);
                        status.setShipment(shipment);

                        shipFacadeSB.create(shipment);

                        response.sendRedirect("ViewShipmentServlet.do");

                    }

                }

            }

        }

    }

    private Shipment createShipment(String pickUpPoint, String destination, String productType, Date creationDate, double weight, double price, String trackingCode, User user) {

        Product product = new Product();

        product.setTrackingCode(trackingCode);
        product.setPrice(price);
        product.setWeight(weight);
        product.setType(productType);

        Shipment ship = new Shipment();

        ship.setPickLocation(pickUpPoint);
        ship.setDestination(destination);
        ship.setCreationDate(creationDate);
        ship.setUser(user);

        product.setShipment(ship);

        ship.setProduct(product);

        return ship;
    }

}
