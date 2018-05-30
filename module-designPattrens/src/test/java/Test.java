import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by scott on 2018/5/30.
 */
public class Test {


    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
        for (int i = 0 ; i < 10 ; i++){
            queue.add(i);
        }

        for(int i = 0 ; i <10 ;i++){
            //queue.offer()
        }

    }
}
