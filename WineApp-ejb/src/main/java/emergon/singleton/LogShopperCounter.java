package emergon.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

@DependsOn({"ShopperCount"})
@Startup
@Singleton
public class LogShopperCounter {
    
    private final Logger log = Logger.getLogger("LogShopperCounter.class");
    
    @EJB
    private ShopperCountBean shopperCountBean;
    
    //log every 5 minutes
    @Schedule(minute = "*/5")
    public void logShopperCounter(Timer timer){
        String message = ">>>Scheduler running: Shopper online are:"+ shopperCountBean.getNumberOfShoppers();
        log.log(Level.INFO, message);
        String timerInfo = (String) timer.getInfo();
        log.log(Level.INFO, timerInfo);
    }
}
