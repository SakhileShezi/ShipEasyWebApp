package ac.za.tut.shipmenthandler;

import ac.za.tut.defaultdriver.DefaultDriver;
import ac.za.tut.driver.Driver;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ShipmentHandler implements ShipmentHandlerLocal {

    @PersistenceContext(unitName = "ShipEasyWebAppEJBModulePU")
    private EntityManager entityManager;

    @Override
    public String generateTrackingKey(String username) {

        String[] keys = {"M123@", "F11@", "S20@", "K-14.", "V11.", "U34.", "XA9r", "XV6r", "L12r", "BNBv", "XWm@", "Z3Cr"};

        Random ran = new Random();

        int index = ran.nextInt(12);

        String trakingCode = keys[index];

        int randomNum = 100 + ran.nextInt(900);

        String sub = username.substring(0, 3);

        trakingCode += sub + randomNum;

        return trakingCode;

    }

    @Override
    public String calcShipmentPrice(double weight, String type) {
        DecimalFormat df = new DecimalFormat("0.00");

        double price;

        switch (type) {
            case "Package":
                price = 25.2;
                break;
            case "Pallet":
                price = 20.0;
                break;
            case "Container":
                price = 17.15;
                break;
            default:
                price = 3.5;
                break;
        }

        price += 10.12 * weight;

        return df.format(price);

    }

    @Override
    public Driver getDriver() {
            Query driverQuery = entityManager.createQuery("SELECT d FROM Driver d");
            List<Driver> drivers = driverQuery.getResultList();

            Random random = new Random();
            Driver randomDriver = drivers.get(random.nextInt(drivers.size()));

            return randomDriver;

    }

    @Override
    public DefaultDriver getCommunityDriver() {
        
            Query query = entityManager.createQuery("SELECT d FROM DefaultDriver d");
            DefaultDriver comDriver = (DefaultDriver) query.getSingleResult();

            return comDriver;
    }

    @Override
    public Date expectedToShipOn(Date creationDate) {
       
        Random ran = new Random();
        
        int addDays = 1 + ran.nextInt(10);
        
        Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(creationDate);
        
        calendar.add(Calendar.DAY_OF_MONTH, addDays);
        
        return calendar.getTime();
        
    }
    
}

