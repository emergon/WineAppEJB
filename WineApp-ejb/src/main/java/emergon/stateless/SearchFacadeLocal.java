package emergon.stateless;

import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Local;

@Local
public interface SearchFacadeLocal {
    
    public List<String> searchWine(String wineType);
    
    public Future<String> sendMessage(String message);
}
