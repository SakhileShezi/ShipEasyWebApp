package ac.za.tut.verifyuserdetails;

import javax.ejb.Stateless;


@Stateless
public class VerifyRegistration implements VerifyRegistrationLocal {

    @Override
    public boolean verifyPassword(String password, String confirnPassword) {
        boolean isPasswordValid = false;
        
        if (password.equals(confirnPassword)) {
            
            isPasswordValid = true;
            
        }
        
        return isPasswordValid;
        
    }

    @Override
    public boolean validateEmailDomain(String email) {
        boolean validEmail = false;
        
        String domain = email.substring(email.length() -10);
        
        if (domain.equals("@gmail.com")) {
            
            validEmail = true;
        }
       
        return validEmail;
    }

    @Override
    public boolean isPasswordStrong(String password) {
        
        boolean isStrong = false;
        
        int len = password.length();
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(c)) {
                lowercaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            }else{
                 specialCharCount++;
            }
        }
        
        if ((len >= 7)&&(uppercaseCount >= 1)&&(specialCharCount >= 1)&&(digitCount >= 1)&&(lowercaseCount >= 4)) {
             
            isStrong = true;
        } 
        
        return isStrong;
    }

    
}
