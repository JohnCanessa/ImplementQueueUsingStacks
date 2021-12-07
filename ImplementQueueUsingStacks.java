import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions.
 * Memory Usage: 36.7 MB, less than 91.99% of Java online submissions.
 * 
 * 21 / 21 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 36.7 MB
 */
class MyQueue {

    // *** class members ****
    public Stack<Integer> s1 = null;
    public Stack<Integer> s2 = null;

    // **** class methods ****
    public MyQueue() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.s1.push(x);
    }
    
    public int pop() {

        // **** check if we can pop from s2 ****
        if (!s2.isEmpty()) return s2.pop();

        // **** check if we can move s1 to s2 and then return from s2 ****
        while (!s1.isEmpty()) s2.push(s1.pop());

        // **** ****
        return s2.pop();
    }
    
    public int peek() {
        if (s2.isEmpty()) {

            // **** ****
            while (!s1.isEmpty()) s2.push(s1.pop());

            // **** ****
            if (s2.isEmpty()) return 0;
            else return s2.peek();
        } return s2.peek();
    }
    
    public boolean empty() {
        if (s2.isEmpty()) {
            if (s1.isEmpty())
                return true;
            else return false;
        } else 
            return false;
    }
}


/**
 * 
 */
public class ImplementQueueUsingStacks {


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read commands ****
        String[] cmds = br.readLine().trim().split(", ");

        // **** read parameters ****
        int[] params = Arrays.stream(br.readLine().trim().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<<   cmds: " + Arrays.toString(cmds));
        System.out.println("main <<< params: " + Arrays.toString(params));

        // **** initialization ****
        MyQueue q = null;

        // **** loop processing commands ****
        for (int i = 0; i < cmds.length; i++) {
           switch (cmds[i]) {
                case "MyQueue":
                    q = new MyQueue();
                    System.out.println("main <<< null");
                break;

                case "push":
                    q.push(params[i]);
                    System.out.println("main <<< null");
                break;

                case "peek":
                    System.out.println("main <<< " + q.peek());
                break;

                case "pop":
                    System.out.println("main <<< " + q.pop());    
                break;

                case "empty":
                    System.out.println("main <<< " + q.empty());
                break; 
            }
        }
    }

}