package lambda;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解
 * @author 陈梓平
 * @date 2017/10/21.
 */
public class Annotations {
    @Retention( RetentionPolicy.RUNTIME )//运行时
    @Target( { ElementType.TYPE_USE, ElementType.TYPE_PARAMETER } )//目标：类型使用、类型参数
    public @interface NonEmpty {
    }
    public static class Holder< @NonEmpty T > extends @NonEmpty Object {
        public void method() throws @NonEmpty Exception {
        }
    }
}
