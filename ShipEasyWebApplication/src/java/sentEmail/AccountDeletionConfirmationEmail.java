package sentEmail;

import ac.za.tut.user.User;

public class AccountDeletionConfirmationEmail implements EmailContent{

    private User user;

    public AccountDeletionConfirmationEmail() {
    }

    public AccountDeletionConfirmationEmail(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    @Override
    public String getSubject() {
        
        return "Your Account Has Been Successfully Deleted";
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
"      <h1>Accout Deleted</h1>\n" +
"    </div>\n" +
"    <p>Dear "+user.getName()+ ",</p>\n" +
"    <p>We are writing to confirm that your request to delete your account with ShipEasy has been successfully processed.</p>\n" +
"    <p>As of today, your account and all associated data have been permanently deleted from our system. This includes your order history, personal information, and preferences. Please note that this action is irreversible.</p>\n" +
"    \n" +
"    <p>If you have any questions or need further assistance, please do not hesitate to contact our support team at info@shipeasy.com.</p>\n" +
"    <p>Thank you for your time with ShipEasy. We appreciate your business and hope to serve you again in the future.</p>\n" +
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
