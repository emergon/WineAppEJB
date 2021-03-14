package emergon.stateful;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

@Stateful(name = "ShoppingCart")
public class ShoppingCartBean implements ShoppingCartLocal{

    /*
    Lifecycle callbacks
    @PrePassivate:
    Called when bean is idle for too long. The container stores bean's state to a cache.
    The method is called before instance is saved to cache.
    @PostActivate:
    Called when bean is restored from cache. A new instance with restored state is created.
    */
    private List<String> wines;
    
    @PostConstruct
    private void init(){
        wines = new ArrayList();
    }
    
    @Override
    public void addWine(String wine) {
        wines.add(wine);
    }

    @Override
    public void removeWine(String wine) {
        wines.remove(wine);
    }

    @Override
    public List<String> getWines() {
        return wines;
    }
    
    @PreDestroy
    private void saveItems(){
        System.out.println("Saving Cart Items in DB.");
    }
}
