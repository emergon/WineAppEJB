package emergon.stateful;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ShoppingCartLocal {
    void addWine(String wine);
    void removeWine(String wine);
    List<String> getWines();
}
