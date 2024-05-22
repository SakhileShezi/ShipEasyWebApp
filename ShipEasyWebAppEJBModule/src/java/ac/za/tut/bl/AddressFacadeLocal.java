package ac.za.tut.bl;

import ac.za.tut.address.Address;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AddressFacadeLocal {

    void create(Address address);

    void edit(Address address);

    void remove(Address address);

    Address find(Object id);
    
    Address findByUserId(Long userId);

    List<Address> findAll();

    List<Address> findRange(int[] range);

    int count();
    
}
