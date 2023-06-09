import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// public class b3015{
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine()); // n명
//         int heights[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             heights[i] = Integer.parseInt(br.readLine());
//         }
//         Stack<Integer> stack = new Stack<>(); //사람의 번호를 저장
//         long count = 0;
//         stack.push(0);
//         for (int i = 1; i < n; i++) {
//             if(!stack.isEmpty()){
//                 if(heights[stack.peek()] < heights[i]){
//                     count ++;
//                     stack.pop();
//                 } else if (heights[stack.peek()] == heights[i]){
//                     if(heights[stack.get(0)] > heights[i]) count ++;
//                     count += stack.size();
//                     break;
//                 } else{
//                     count ++;
//                     break;
//                 }
//             }
//             stack.push(i);
//         }
//         System.out.println(count);
//     }
// }




public class b3015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n명
        Stack<Pair> stack = new Stack<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine()); //삽입할 숫자
            Pair next = new Pair(k, 1);
            while(!stack.isEmpty() && stack.peek().x <= k){
                    Pair p = stack.pop();
                    count += p.y;
                    if(p.x == k) next.y += p.y;
            }
            if(!stack.isEmpty()) count++;
            stack.push(next);
        }
        System.out.println(count);
    }
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
