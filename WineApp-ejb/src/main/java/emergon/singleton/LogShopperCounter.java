package emergon.singleton;

import java.util.logging.Logger;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@DependsOn({"ShopperCount"})
@Startup
@Singleton
public class LogShopperCounter {
    
    private final Logger log = Logger.getLogger("LogShopperCounter.class");
}
