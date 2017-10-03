/**
 * Created by Shon on 10/2/2017.
 */
import java.util.concurrent.ThreadLocalRandom;
public class Test {
    public static void main(String[] args) {
        while(true){
            System.out.println((ThreadLocalRandom.current().nextInt(0,2)));
        }
    }
}
