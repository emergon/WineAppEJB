package emergon.stateless;

import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

@Remote
public interface SearchFacadeRemote {
    
    public List<String> searchWine(String wineType);
    
    public Future<String> sendMessage(String message);
}
