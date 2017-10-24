package lambda;

import java.util.function.Supplier;

/**
 * 类型推断
 * @author 陈梓平
 * @date 2017/10/21.
 */
public class Value<T> {
    public static Value create(final Supplier<Value> carSupplier){
        return carSupplier.get();
    }
    public static <T> T defaultValue(){
        return null;
    }
    public T getOrDefault(T value,T defaulValue){
        return (value !=null )?value:defaulValue;
    }
}
