package ac.za.tut.driver;

import ac.za.tut.entities.DriverFacadeLocal;
import ac.za.tut.vehicle.Vehicle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class CreateDriverServlet extends HttpServlet {
    @EJB
    private DriverFacadeLocal driverFacadeSBL;
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession(false);
        
            
            String vin = request.getParameter("vin");
            String numberPlate = request.getParameter("plate_number");
            String vehicleType = request.getParameter("vehicle_type");
            String model = request.getParameter("model");
            
            Part licensePart = request.getPart("license");
            
            byte[] license = getLicesnse(licensePart);
            
            Vehicle vehicle = new Vehicle(vin, numberPlate, vehicleType,model,license);
            
            if (session != null) {
            
              Driver driver = (Driver)session.getAttribute("driver");
              driver.setVehicle(vehicle);
              vehicle.setDriver(driver);
              
              driverFacadeSBL.create(driver);
              
              session.setAttribute("driver",driver);
              session.setAttribute("vehicle",vehicle);
              
              RequestDispatcher disp = request.getRequestDispatcher("driver_details_confirmation.jsp");
              disp.forward(request, response);
        }
    }

    private byte[] getLicesnse(Part licensePart) {
            byte[] license = null;
            
        try {
            
            InputStream licenseInputStream = licensePart.getInputStream();
            
            byte[] buffer = new byte[1024];
            
            ByteArrayOutputStream bios = new ByteArrayOutputStream();
            
            int readByte;
            
            while ((readByte = licenseInputStream.read(buffer)) != -1) {
                   
               bios.write(buffer, 0, readByte);
            }
           
           license = bios.toByteArray();
            
        } catch (IOException ex) {
            Logger.getLogger(CreateDriverServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return license;
    }

}