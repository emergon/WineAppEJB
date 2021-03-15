package emergon.stateless;

import emergon.stateless.interceptor.LogInterceptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
//Session Beans can implement both Local and Remote Interfaces.
//This gives capabilities to the bean that can be accessed from local and remote clients

@Stateless(mappedName = "SearchFacade")
public class SearchFacadeBean implements SearchFacadeRemote, SearchFacadeLocal {

    Map<String, List<String>> countryMap;

    public SearchFacadeBean() {
        //https://github.com/Fameing/ejb3-example
        //https://github.com/Apress/beginning-ejb-java-ee-8/tree/master/Chapter02-SessionSamples
    }

    @PostConstruct
    public void initializeCountryWineList() {
        countryMap = new HashMap();
        addWineToCountry("Australia", "Sauvignon Blanc");
        addWineToCountry("Australia", "Grenache");
        addWineToCountry("France", "Gewurztraminer");
        addWineToCountry("France", "Bordeaux");
    }
    
    private void addWineToCountry(String country, String wine){
        List<String> countryWines = countryMap.get(country);
        if(countryWines==null){
            countryWines = new ArrayList();
            countryWines.add(wine);
            countryMap.put(country, countryWines);
        }else{
           countryWines.add(wine);            
        }
    }

    @Interceptors(value = LogInterceptor.class)
    @Override
    public List<String> searchWineByCountry(String country) {
        List<String> wines = new ArrayList();
        Set<Map.Entry<String,List<String>>> entrySet = countryMap.entrySet();
        Iterator<Map.Entry<String, List<String>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> next = iterator.next();
            if (next.getKey().toLowerCase().equals(country.toLowerCase())) {
                return next.getValue();
            }
        }
        return wines;
    }

    @Override
    public List<String> searchWine(String wineType) {
        List<String> wines = new ArrayList();
        if (wineType.equals("red")) {
            wines.add("Bordeaux");
            wines.add("Merlot");
        } else if (wineType.equals("white")) {
            wines.add("Chardonnay");
        }
        return wines;
    }

    //Asynchronous methods immediately return to the caller without waiting for the method execution to complete
    @Asynchronous
    @Override
    public Future<String> sendMessage(String message) {
        String result = "This is the message that you send:" + message;
        return new AsyncResult(result);
    }

    @PreDestroy
    public void clearCountries() {
        countryMap.clear();
    }
}
