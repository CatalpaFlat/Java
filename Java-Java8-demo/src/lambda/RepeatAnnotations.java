package lambda;

import java.lang.annotation.*;

/**
 * @Repeatable 注解定义重复注解，实际上，
 * 这并不是语言层面的改进，而是编译器做的一个trick，底层的技术仍然相同
 */
public class RepeatAnnotations{
        /*
         * Filter类使用@Repeatable(Filters.class)注解修饰，
         * 而Filters是存放Filter注解的容器，编译器尽量对开发者屏蔽这些细节
         */
        @Target( ElementType.TYPE )
        @Retention( RetentionPolicy.RUNTIME )
        public @interface Filters {
            Filter[] value();
        }
        @Target( ElementType.TYPE )
        @Retention( RetentionPolicy.RUNTIME )
        @Repeatable( Filters.class )
        public @interface Filter {
            String value();
        }
        /*
         * Filterable接口可以用两个Filter注解注释（这里并没有提到任何关于Filters的信息）。
         */
        @Filter( "filter1" )
        @Filter( "filter2" )
        public interface Filterable {
        }

}