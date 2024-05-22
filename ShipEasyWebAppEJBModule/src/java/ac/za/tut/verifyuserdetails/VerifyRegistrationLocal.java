package ac.za.tut.verifyuserdetails;

import javax.ejb.Local;


@Local
public interface VerifyRegistrationLocal {
    
     public boolean verifyPassword(String password,String confirnPassword);
     public boolean isPasswordStrong(String password);
     public boolean validateEmailDomain(String email);
     
}
