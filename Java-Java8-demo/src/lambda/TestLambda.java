package lambda;

import com.sun.jmx.snmp.tasks.Task;
import lambda.Streams.TaskStatus;
import org.junit.Test;

import javax.net.ssl.SSLEngineResult;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author 陈梓平
 * @date 2017/10/21.
 */
public class TestLambda {
    private final static Logger log = Logger.getLogger("TestLambda");

    /**
     * 函数接口:接口的默认方法、静态方法、静态方法
     * 只有一个函数的接口，这样的接口可以隐式转换为Lambda表达式
     */
    @FunctionalInterface
    interface MathOperation{
        //抽象方法
        int operate(int a,int b);
        //默认方法
        default String defaultMethod(){
            return "this is defaultMethod";
        }
        //静态方法
        static Car create( Supplier< Car > supplier ) {
            return supplier.get();
        }
    }

    /**
     * 函数接口:接口的默认方法、静态方法、静态方法
     */
    @Test
    public void testPlus() {
        // 不用类型声明
//        MathOperation plus = (a, b) -> a + b;
////        log.info(""+plus.operate(1, 2));
//        String s = plus.defaultMethod();
//        log.info(s);
//        Car car = MathOperation.create(Car::new);
//        car.follow(car);
    }

    /**
     * 数组使用
     * 可以用于数组、列表遍历
     */
    @Test
    public void arrayUse(){
        //1.Lambda表达式可由逗号分隔的参数列表、->符号和语句块组成
//        Arrays.asList("a","b","c","d").forEach(e ->
//            log.info(e)
//        );
        //2.Lambda表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来，类似于Java中的函数体
//        Arrays.asList("a","b","c","d").forEach(e ->{
//            log.info(e);
//          }
//        );
        //3.Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的）
//        String separator = ",";
//        Arrays.asList("a","b","c","d").forEach(e ->{
//           log.info(e+separator);
//        });
        //4.Lambda表达式有返回值，返回值的类型也由编译器推理得出。如果Lambda表达式中的语句块只有一行，则可以不用使用return语句，下列两个代码片段效果相同
//         Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
//            int result = e1.compareTo( e2 );
//            return result;
//        } );
    }

    /**
     * 方法引用
     * 可以用于对类型的方法的应用
     */
    @Test
    public void methodUse(){
        /*
         * 1.方法引用的类型是构造器引用
         * 语法是Class::new，或者更一般的形式：Class<T>::new。注意：这个构造器没有参数
         */
//        Car car = Car.create(Car::new);
//
//        List<Car> carList = Arrays.asList(car);
        /*
         *2.方法引用的类型是静态方法引用
         *语法是Class::static_method。注意：这个方法接受一个Car类型的参数。
         */
//        carList.forEach(Car::collide);
        /*
         *3.方法引用的类型是某个类的成员方法的引用
         *语法是Class::method，注意，这个方法没有定义入参。
         */
//        carList.forEach(Car::repair);
         /*
         *4.方法引用的类型是某个实例对象的成员方法的引用
         *语法是instance::method。注意：这个方法接受一个Car类型的参数：
         */
//        Consumer<Car> follow = car::follow;
//        follow.accept(car);
    }

    /**
     * 重复注解
     * 可以用于注解的嵌套和双重同义注解注解在一个方法上或者其他类型上
     */
    @Test
    public void repeatAnnoUse(){
//        RepeatAnnotations.Filter[] annotationsByType = RepeatAnnotations.Filterable.class.
//                getAnnotationsByType(RepeatAnnotations.Filter.class);
//        for (RepeatAnnotations.Filter f :annotationsByType){
//            log.info(f.value());
//        }
    }
    /**
    * 类型推断
     * 可以用于判断是否为空，根据类型给予一个默认值，可以动态修改Value基类
    */
    @Test
    public void typeUse(){
//        Value <String> value = Value.create(Value::new);
//        String orDefault = value.getOrDefault(null, Value.defaultValue());
//        Value <Integer> valueInt = Value.create(Value::new);
//        Integer orDefaultInt = valueInt.getOrDefault(null, Value.defaultValue());
//        log.info(orDefaultInt+"");
    }
    /**
     * 注解
     * 更新了注解可使用范围
     */
    @Test
    public void annoUse(){
        Annotations.Holder< String > holder = new Annotations.Holder< String >();
        @Annotations.NonEmpty Collection< @Annotations.NonEmpty String > strings = new ArrayList<>();
    }

    /**
     * 参数名称
     * 通过反向代理获取方法，使用参数名类Parameter接收获取参数名
     */
    @Test
    public void parameterNamesUse(){
//        try {
//            Method collide = Car.class.getMethod("collide", Car.class);
//            for (final Parameter parameter:collide.getParameters()){
//                log.info("Parameters:"+parameter.getName());
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }
    /**
     * Optional
     * 用于解决空指针问题,并且为其设置默认值
     */
    @Test
    public void OptionalUse(){
        //解决NullPointerException，从而避免源码被各种null检查污染
        //可能为空的值或者某个类型的值
//        Optional< String > fullName = Optional.ofNullable( null );
        /*
        * 如果Optional实例持有一个非空值，
        * 则isPresent()方法返回true，否则返回false；
        * orElseGet()方法，Optional实例持有null，则可以接受一个lambda表达式生成的默认值；
        * map()方法可以将现有的Opetional实例的值转换成新的值；
        * orElse()方法与orElseGet()方法类似，但是在持有null的时候返回传入的默认值。
        * */
//        log.info( "Full Name is set? " + fullName.isPresent() );
//        log.info( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
//        log.info( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }

    /**
     * Streams
     * 可以用于对集合的操作以及计数
     */
    @Test
    public void streamsUse(){
        Streams.Task task0 = new Streams.Task(TaskStatus.OPEN, 5);
        Streams.Task task1 = new Streams.Task(TaskStatus.OPEN, 13);
        Streams.Task task2 = new Streams.Task(TaskStatus.CLOSED, 8);
        Collection<Streams.Task> tasks = Arrays.asList(task0, task1, task2);
        //在这个task集合中一共有多少个OPEN状态的点？
//        final long totalPointsOfOpenTasks = tasks
//                .stream()
//                .filter( task -> task.getStatus() == TaskStatus.OPEN )
//                .mapToInt( Streams.Task::getPoints )
//                .sum();
//        log.info( "Total OPEN points: " + totalPointsOfOpenTasks );
        //计算所有任务的点数之和
        final double totalPoints = tasks
                .stream()
                .parallel()
                .map( task -> task.getPoints() ) // or map( Task::getPoints )
                .reduce( 0, Integer::sum );
//
//        log.info( "Total points (all tasks): " + totalPoints );
        //根据某些条件对其中的元素分组
//        final Map< TaskStatus, List< Task > > map = tasks
//                .stream()
//                .collect( Collectors.groupingBy( Streams.Task::getStatus) );
//        log.info( ""+map );
        //计算集合中每个任务的点数在集合中所占的比重
        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Streams.Task::getPoints )                     // IntStream
                .asLongStream()                       // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                    // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String>
                .collect( Collectors.toList() );                 // List< String >

        log.info( ""+result );

    }
    /**
     * Date/Time API(JSR 310)
     * 对时间的操作
     */
    @Test
    public void dataUse(){
        //1.Clock类使用时区来返回当前的纳秒时间和日期
        Clock clock = Clock.systemUTC();
//        log.info(""+clock.instant());//2017-10-23T01:19:10.818Z
//        log.info(""+clock.millis());//纳秒 1508721765888
        //2.Clock对象构建LocalDate和LocalTime类
          //LocalDate仅仅包含ISO-8601日历系统中的日期部分
//        final LocalDate date = LocalDate.now();
//        final LocalDate dateFromClock = LocalDate.now( clock );
//        log.info( ""+date );
//        log.info( ""+dateFromClock );
          //LocalTime则仅仅包含该日历系统中的时间部分
//        final LocalTime time = LocalTime.now();
//        final LocalTime timeFromClock = LocalTime.now( clock );
//        log.info( ""+time );
//        log.info( ""+timeFromClock );
          //LocalDateTime类包含了LocalDate和LocalTime的信息，但是不包含ISO-8601日历系统中的时区信息。
//        final LocalDateTime datetime = LocalDateTime.now();
//        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
//        log.info( ""+datetime );
//        log.info( ""+datetimeFromClock );
          //需要特定时区的data/time信息，则可以使用ZoneDateTime，它保存有ISO-8601日期系统的日期和时间，而且有时区信息
//        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
//        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
//        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
//        log.info( ""+ zonedDatetime );
//        log.info( ""+ zonedDatetimeFromClock );
//        log.info( ""+ zonedDatetimeFromZone );
          //Duration类，它持有的时间精确到秒和纳秒
//        final LocalDateTime from = LocalDateTime.of( 2016, Month.APRIL, 16, 0, 0, 0 );
//        final LocalDateTime to = LocalDateTime.of( 2017, Month.APRIL, 16, 23, 59, 59 );
//        final Duration duration = Duration.between( from, to );
//        log.info( "Duration in days: " + duration.toDays() );
//        log.info( "Duration in hours: " + duration.toHours() );
    }
    /**
     * Nashorn JavaScript引擎
     * 配合js
     */
    @Test
    public void nashornJSUse() throws ScriptException {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName( "JavaScript" );
//        log.info( ""+ engine.getClass().getName() );
//        log.info( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
    }
    /**
     * Base64
     * 新的Base64API也支持URL和MINE的编码解码。
     * 可以进行加密解密
     */
    @Test
    public void base64Use(){
//        final String text = "Base64 finally in Java 8!";
//        //base64加密
//        String s = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
//        log.info(""+s);
//        //base64解码
//        String s1 = new String(Base64.getDecoder().decode(s), StandardCharsets.UTF_8);
//        log.info(""+s1);
    }
    /**
     * 并行数组
     *
     */
    @Test
    public void parallelArryUse(){
        //数组排序
//        long[] arrayofLong = new long[1084];
//        Arrays.parallelSetAll(arrayofLong,
//                index -> ThreadLocalRandom.current().nextInt(1000000));
//        Arrays.stream(arrayofLong).limit(10).
//                forEach(i -> System.out.print(i+" "));
//        System.out.println("\n--------------------------------------------------------------");
//        Arrays.parallelSort(arrayofLong);
//        Arrays.stream(arrayofLong).limit(10).
//                forEach(i -> System.out.print(i+" "));
    }
    /**
     * 并发性
     */
    @Test
    public void concurrentUse(){
        //java.util.concurrent.ConcurrentHashMap类添加了新的方法来支持聚焦操作
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(20);
        //java.util.concurrentForkJoinPool类添加了新的方法来支持通用线程池操作
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //java.util.concurrent.locks.StampedLock类，
        // 用于支持基于容量的锁——该锁有三个模型用于支持读写操作（可以把这个锁当做是java.util.concurrent.locks.ReadWriteLock的替代者）。
        StampedLock stampedLock = new StampedLock();
    }
}
