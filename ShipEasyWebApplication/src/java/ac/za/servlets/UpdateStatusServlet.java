package ac.za.servlets;

import ac.za.tut.entities.StatusFacadeLocal;
import ac.za.tut.shipment.Shipment;
import ac.za.tut.status.Status;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateStatusServlet extends HttpServlet {

    @EJB
    private StatusFacadeLocal statusFacadeSBL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String transportation = request.getParameter("transport");
        String method = request.getParameter("delivery_method");
        String status = request.getParameter("status");
        String futureStatus = request.getParameter("future_stats");

        if (session != null) {

            Shipment shipment = (Shipment) session.getAttribute("shipmentToUpdate");

            if (shipment != null) {

                Status updatedStatus = updateStatus(shipment, transportation, method, status, futureStatus);

                shipment.setStatus(updatedStatus);
                updatedStatus.setShipment(shipment);

                statusFacadeSBL.edit(updatedStatus);

                RequestDispatcher disp = request.getRequestDispatcher("driver_home.jsp");
                disp.forward(request, response);

            }
        }

    }

    private Status updateStatus(Shipment shipment, String transportation, String method, String status, String futureStatus) {

        Status s = shipment.getStatus();

        s.setTransportationMode(transportation);
        s.setShippingMethod(method);
        s.setStatus(status);
        s.setFutureStatus(futureStatus);

        return s;
    }

}
