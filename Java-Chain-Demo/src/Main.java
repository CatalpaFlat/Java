import Channel.Channel;
import Channel.Persion;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
         new Channel().setBasicValue(2);
        String s = new Persion().setName("chen").
                setAddress("hqufhiquwhfqwiu").
                setIdCard("1674816481286714")
                .setPhone("4178471789312").toString();
        System.out.println("s:"+s);
        final int num = 2;
        Function<Integer, Integer> stringConverter = (from) -> from * num;
        System.out.println(stringConverter.apply(3));
    }
}
