package sentEmail;

import ac.za.tut.shipment.Shipment;

public class ShipmentConfirmationMail implements EmailContent{
     
    private String name;
    private Shipment Shipment;

    public ShipmentConfirmationMail() {
    }

    public ShipmentConfirmationMail(String name,Shipment Shipment) {
        this.name = name;
        this.Shipment = Shipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shipment getShipment() {
        return Shipment;
    }

    public void setShipment(Shipment Shipment) {
        this.Shipment = Shipment;
    }
    
    @Override
    public String getSubject() {
        
        return "Shipment Confirmation";
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
"      <h1>Shipment Request Success</h1>\n" +
"    </div>\n" +
"    <p>Dear "+name+ ",</p>\n" +
"    <p>Your shipment with the following details has been successfully created:</p>\n" +
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
" <td><b>Tracking Key:</b>"+"</td>"+                             
" <td>"+Shipment.getProduct().getTrackingCode()+"</td>"  +                             
" </tr>"+                               
" <tr>"+                               
" <td><b>Price: R</b>"+"</td>"+                             
" <td>"+Shipment.getProduct().getPrice()+"</td>"  +                             
" </tr>"+                               
" </table>"+                               
" <p>Use this '"+Shipment.getProduct().getTrackingCode()+"' tracting code to track your Parcel once collected.</p>"+                               
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
