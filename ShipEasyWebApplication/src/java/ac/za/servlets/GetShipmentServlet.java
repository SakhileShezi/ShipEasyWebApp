package ac.za.servlets;

import ac.za.tut.bl.ShipmentFacadeLocal;
import ac.za.tut.shipment.Shipment;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetShipmentServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipFacadeSBL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {

            Shipment shipmentToUpdate = shipFacadeSBL.find(Long.parseLong(request.getParameter("update_status")));

            if (shipmentToUpdate != null) {

                session.setAttribute("shipmentToUpdate", shipmentToUpdate);

                RequestDispatcher disp = request.getRequestDispatcher("shipment_status_update.jsp");
                disp.forward(request, response);

            }

        }
    }

}
