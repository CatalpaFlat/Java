package future;

import java.util.Arrays;

/**
 * Clojure语言
 * @author 陈梓平
 * @date 2017/10/20.
 */
public class Clojure {
    public static void main(String[] args) {
         int[] arr={1,3,4,5,6,7,8,9,10};
        //传统的处理方式：
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]%2!=0){
//                arr[i]++;
//            }
//            System.out.println(arr[i]);
//        }
        //使用函数式方式：
        Arrays.stream(arr).map(x->(x%2==0)?x:x+1).forEach(System.out::println);
        IHouse iHouse = new IHouse() {
            @Override
            public IHouse eat() {
                return null;
            }
        }.eat();
    }
}
