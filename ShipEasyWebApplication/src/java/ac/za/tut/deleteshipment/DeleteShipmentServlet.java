package ac.za.tut.deleteshipment;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import ac.za.tut.bl.ShipmentFacadeLocal;
=======
import ac.za.tut.entities.ShipmentFacadeLocal;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c

public class DeleteShipmentServlet extends HttpServlet {

    @EJB
    private ShipmentFacadeLocal shipFacadeSB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        
        if (session != null) {

               shipFacadeSB.remove(shipFacadeSB.find(Long.parseLong(request.getParameter("delete"))));
             
               response.sendRedirect("ViewShipmentServlet.do");
               
            }
        }

    }

