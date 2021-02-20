package emergon.stateless;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
//Session Beans can implement both Local and Remote Interfaces.
//This gives capabilities to the bean that can be accessed from local and remote clients
@Stateless(mappedName = "SearchFacade")
public class SearchFacadeBean implements SearchFacadeRemote, SearchFacadeLocal{

    public SearchFacadeBean(){
        //https://github.com/Fameing/ejb3-example
        //https://github.com/Apress/beginning-ejb-java-ee-8/tree/master/Chapter02-SessionSamples
    }

    @Override
    public List<String> searchWine(String wineType) {
        List<String> wines = new ArrayList();
        if(wineType.equals("red")){
            wines.add("Bordeaux");
            wines.add("Merlot");
        }else if(wineType.equals("white")){
            wines.add("Chardonnay");
        }
        return wines;
    }
}
