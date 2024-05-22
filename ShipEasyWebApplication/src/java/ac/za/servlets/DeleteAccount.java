package ac.za.servlets;

import ac.za.tut.address.Address;
import ac.za.tut.bl.UserFacadeLocal;
import ac.za.tut.product.Product;
import ac.za.tut.regservlet.RegistrationServlet;
import ac.za.tut.shipment.Shipment;
import ac.za.tut.status.Status;
import ac.za.tut.user.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sentEmail.AccountDeletionConfirmationEmail;

public class DeleteAccount extends HttpServlet {

    @EJB
    private UserFacadeLocal userFL;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {

            User user = (User) session.getAttribute("LoggedInUser");

            if (user != null) {

                userFL.removeUserAddress(user.getId());
                userFL.removeUserShipmentProduct(user.getId());
                userFL.removeUserShipmentStatus(user.getId());
                userFL.removeUserShipment(user.getId());

                userFL.remove(user);

                AccountDeletionConfirmationEmail accountDeletion = new AccountDeletionConfirmationEmail(user);

                try {

                    sentEmail.SendEmailService.sendMail(user.getEmail(), accountDeletion.getSubject(), accountDeletion.getBody());
                } catch (MessagingException ex) {
                    Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                session.invalidate();

                RequestDispatcher disp = request.getRequestDispatcher("index.html");
                disp.forward(request, response);
            }
        }
    }
}
