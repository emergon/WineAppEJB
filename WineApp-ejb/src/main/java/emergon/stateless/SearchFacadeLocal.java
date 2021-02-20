package emergon.stateless;

import java.util.List;
import javax.ejb.Local;

@Local
public interface SearchFacadeLocal {
    
    public List<String> searchWine(String wineType);
}
