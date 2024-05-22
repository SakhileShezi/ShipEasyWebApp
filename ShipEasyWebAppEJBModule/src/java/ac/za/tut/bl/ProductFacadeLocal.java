package ac.za.tut.bl;

import ac.za.tut.product.Product;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ProductFacadeLocal {

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();
    
}
