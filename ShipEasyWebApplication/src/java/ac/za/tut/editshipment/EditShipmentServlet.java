package ac.za.tut.editshipment;

import ac.za.tut.shipment.Shipment;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import ac.za.tut.bl.ShipmentFacadeLocal;
=======
import ac.za.tut.entities.ShipmentFacadeLocal;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
import javax.servlet.http.HttpSession;

public class EditShipmentServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipFacadeSB;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("edit"));

        Shipment shipment = shipFacadeSB.find(id);

             if (shipment != null) {
            
                 HttpSession session = request.getSession(false);
                 
                 session.setAttribute("shipment", shipment);
                 
                 RequestDispatcher disp = request.getRequestDispatcher("edit_shipment.jsp");
                 disp.forward(request, response);
                 
            }
             
             
        }
    }

