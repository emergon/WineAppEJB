package emergon.stateless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
//Session Beans can implement both Local and Remote Interfaces.
//This gives capabilities to the bean that can be accessed from local and remote clients
@Stateless(mappedName = "SearchFacade")
public class SearchFacadeBean implements SearchFacadeRemote, SearchFacadeLocal{

    Map<String,String> countryMap;
    
    public SearchFacadeBean(){
        //https://github.com/Fameing/ejb3-example
        //https://github.com/Apress/beginning-ejb-java-ee-8/tree/master/Chapter02-SessionSamples
    }
    
    @PostConstruct
    public void initializeCountryWineList(){
        countryMap = new HashMap();
        countryMap.put("Australia", "Sauvignon Blanc");
        countryMap.put("Australia", "Grenache");
        countryMap.put("France", "Gewurztraminer");
        countryMap.put("France", "Bordeaux");
    }
    
    public searchWineByCountry(String country){
        
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
    
    //Asynchronous methods immediately return to the caller without waiting for the method execution to complete
    @Asynchronous
    @Override
    public Future<String> sendMessage(String message){
        String result = "This is the message that you send:"+message;
        return new AsyncResult(result);
    }
    
    @PreDestroy
    public void clearCountries(){
        countryMap.clear();
    }
}
