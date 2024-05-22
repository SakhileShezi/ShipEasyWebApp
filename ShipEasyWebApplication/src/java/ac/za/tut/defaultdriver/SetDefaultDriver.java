package ac.za.tut.defaultdriver;

<<<<<<< HEAD
import ac.za.tut.bl.DefaultDriverFacadeLocal;
=======
import ac.za.tut.entities.DefaultDriverFacadeLocal;
>>>>>>> dd3e0be14ccfb211898bb09058ab81dc8862e11c
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetDefaultDriver extends HttpServlet {

    @EJB
    private DefaultDriverFacadeLocal defDriverSBL;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int count = defDriverSBL.count();

        if (count != 0) {
            
            RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
            disp.forward(request, response);

        } else {
            DefaultDriver driverCommunity = new DefaultDriver("ShipEasy Courier", "Connecting Continents, Delivering Dreams", "info@shipeasy.com", "216-87-663", "4.7");

            defDriverSBL.create(driverCommunity);
            RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
            disp.forward(request, response);
        }

    }

}
