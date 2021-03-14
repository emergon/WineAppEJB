package emergon.stateful;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ShoppingCartRemote {
    void addWine(String wine);
    void removeWine(String wine);
    List<String> getWines();
}
