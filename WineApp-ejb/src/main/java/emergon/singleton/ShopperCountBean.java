package emergon.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup//Eager Initialization
@Singleton(name = "ShopperCount")
public class ShopperCountBean {
    
    private int shopperCounter;
    
    @PostConstruct
    private void init(){
        System.out.println("Starting ShopperCountBean");
        resetCounter();
    }
    
    public void incrementNumberOfShoppers(){
        shopperCounter++;
    }
    
    public int getNumberOfShoppers(){
        return shopperCounter;
    }
    
    public void resetCounter(){
        shopperCounter = 0;
    }
    
    @PreDestroy
    public void destroyingShopperCountBean(){
        System.out.println("Finishing ShopperCountBean!!");
    }
}
