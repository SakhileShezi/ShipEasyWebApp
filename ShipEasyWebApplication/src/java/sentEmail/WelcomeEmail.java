package sentEmail;


public class WelcomeEmail implements EmailContent{

    private String name;

    public WelcomeEmail(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public String getSubject() {
     
        return "Welcome to ShipEasy";
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
"      <h1>Welcome to ShipEasy</h1>\n" +
"    </div>\n" +
"    <p>Hi "+name+ ",</p>\n" +
"    <p>We're excited to have you on board! Thank you for choosing ShipEasy for your logistics needs.</p>\n" +
"    <p>We're confident that our comprehensive and user-friendly platform will make your shipping operations smoother and more efficient.</p>\n" +
"    \n" +
"    <p>As a new member of our community, you now have access to a range of powerful</p>\n" +
"    <p>features designed to simplify your shipping process:</p>\n" +
"    \n" +
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
