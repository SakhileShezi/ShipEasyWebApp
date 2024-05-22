package ac.za.tut.bl;

import ac.za.tut.user.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);
    
    void removeUserAddress(Long user_id);
    void removeUserShipment(Long user_id);
    void removeUserShipmentProduct(Long user_id);
    void removeUserShipmentStatus(Long user_id);

    User find(Object id);
    
    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
    User findByEmail(String email);
    
}
