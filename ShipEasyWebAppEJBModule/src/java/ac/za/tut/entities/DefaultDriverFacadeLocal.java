package ac.za.tut.entities;

import ac.za.tut.defaultdriver.DefaultDriver;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DefaultDriverFacadeLocal {

    void create(DefaultDriver defaultDriver);

    void edit(DefaultDriver defaultDriver);

    void remove(DefaultDriver defaultDriver);

    DefaultDriver find(Object id);

    List<DefaultDriver> findAll();

    List<DefaultDriver> findRange(int[] range);

    int count();
    
}
