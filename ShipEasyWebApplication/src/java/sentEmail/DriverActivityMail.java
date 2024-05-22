package sentEmail;

import ac.za.tut.driver.Driver;
import ac.za.tut.shipment.Shipment;


public class DriverActivityMail implements EmailContent{

    private Shipment Shipment;
    private Driver driver;

    public DriverActivityMail() {
    }

    public DriverActivityMail(Shipment Shipment, Driver driver) {
        this.Shipment = Shipment;
        this.driver = driver;
    }

    public Shipment getShipment() {
        return Shipment;
    }

    public void setShipment(Shipment Shipment) {
        this.Shipment = Shipment;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
            
    
    @Override
    public String getSubject() {
       
        return "New Shipment Assingned";
        
    }

    @Override
    public String getBody() {
        
        String message ="<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"  <style>\n" +
"    body {\n" +
"      font-family: Arial, sans-serif;\n" +
"      background-color: #f4f4f4;\n" +
"      margin: 0;\n" +
"      padding: 0;\n" +
"    }\n" +
"    .container {\n" +
"      background-color: #ffffff;\n" +
"      width: 600px;\n" +
"      margin: 0 auto;\n" +
"      padding: 20px;\n" +
"    }\n" +
"    .header {\n" +
"      background-color: #007bff;\n" +
"      color: #ffffff;\n" +
"      padding: 10px;\n" +
"      text-align: center;\n" +
"    }\n" +
"    .footer {\n" +
"      background-color: #333;\n" +
"      color: #ffffff;\n" +
"      padding: 10px;\n" +
"      text-align: center;\n" +
"      font-size: 12px;\n" +
"    }\n" +
"  </style>\n" +
"</head>\n" +
"<body>\n" +
"  <div class=\"container\">\n" +
"    <div class=\"header\">\n" +
"      <h1>New Shipment Assigned</h1>\n" +
"    </div>\n" +
"    <p>Dear "+driver.getFullNames()+ ",</p>\n" +
"    <p>We hope this email finds you well.</p>\n" +
"     \n" +
"    <p>We are pleased to inform you that you have been randomly selected to handle a new shipment.</p>\n" +
"    <p>Below are the details of the shipment assigned to you:</p>\n" +
"     \n" +
"     <hr />" +
" <table>"+                               
" <tr>"+                               
" <td><b>Pick-Up-Location:</b>"+"</td>"+                             
" <td>"+Shipment.getPickLocation()+"</td>"  +                             
" </tr>"+                               
" <tr>"+                               
" <td><b>Destination:</b>"+"</td>"+                             
" <td>"+Shipment.getDestination()+"</td>"  +                             
" </tr>"+                               
" <tr>"+                               
" <td><b>Weight(kg):</b>"+"</td>"+                             
" <td>"+Shipment.getProduct().getWeight()+"</td>"  +                             
" </tr>"+                               
" <tr>"+                               
" <td><b>Product:</b>"+"</td>"+                             
" <td>"+Shipment.getProduct().getType()+"</td>"  +                             
" </tr>"+                               
" <tr>"+                               
" <td><b>Delivery Deadline:</b>"+"</td>"+                             
" <td>"+Shipment.getStatus().getDeliveryDate()+"</td>"  +                             
" </tr>"+                               
" </table>"+                               
"     <hr />" +
"     \n" +
"    <p>Please ensure you review the details thoroughly and confirm your availability to handle this shipment.</p>\n" +
"    <p>It is important to adhere to the schedule to ensure timely delivery and customer satisfaction.</p>\n" +
"     \n" +
"    <p>The ShipEasy Team</p>\n" +
"    <div class=\"footer\">\n" +
"      <p>© 2024 ShipEasy. All rights reserved.</p>\n" +
"    </div>\n" +
"  </div>\n" +
"</body>\n" +
"</html>";
        
        return message;
        
    }
    
    
}
