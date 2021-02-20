package emergon.stateless;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface SearchFacadeRemote {
    
    public List<String> searchWine(String wineType);
}
