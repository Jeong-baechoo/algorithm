import java.util.Scanner;
import java.util.Stack;

public class b1094 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        Stack<Integer> stack = new Stack<>();
        stack.push(64);
        int sum = 64;
        int count = 1;
        while(sum > x){
            sum = 0;
            count = 0;
            int temp = stack.pop() / 2; // 남은 하나
            stack.push(temp); // 절반 넣기
            
            for (Integer integer : stack) { 
                sum += integer;
                count ++;
            }

            if(temp == 1 || sum == x){
                break;
            }
            if(sum < x){
                stack.push(temp);
                sum += temp;
            }
        }

        System.out.println(count);
    }
}
