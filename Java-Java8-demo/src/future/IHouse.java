package future;

/**
 * @author 陈梓平
 * @date 2017/10/20.
 */
public interface IHouse {
    IHouse eat();
    default void run(){
        System.out.println("hourse run");
    }
}
