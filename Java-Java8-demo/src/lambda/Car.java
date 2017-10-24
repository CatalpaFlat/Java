package lambda;

import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * @author 陈梓平
 * @date 2017/10/21.
 */
public  class Car {
    private final static Logger log = Logger.getLogger("Car");

    public static Car create(final Supplier<Car> carSupplier){
        return carSupplier.get();
    }
    public static void collide(final Car car){
        log.info("Collide:"+car.toString());
    }
    public void repair() {
        log.info( "Repaired " + this.toString() );
    }
    public void follow( final Car another ) {
        log.info( "Following the " + another.toString() );
    }
}
