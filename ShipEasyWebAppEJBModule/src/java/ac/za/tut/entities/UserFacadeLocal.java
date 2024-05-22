package ac.za.tut.entities;

import ac.za.tut.user.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
    User findByEmail(String email);
    
}
