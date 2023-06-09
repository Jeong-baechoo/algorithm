import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11723{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String bit = "000000000000000000000";
        StringBuilder sb = new StringBuilder(bit);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String comman = st.nextToken();
            if(comman.equals("all")){
                sb.replace(0, 21, "111111111111111111111");
                continue;
            }
            if(comman.equals("empty")){
                sb.replace(0, 21, "000000000000000000000");
                continue;
            }

            int num = Integer.parseInt(st.nextToken());
            if(comman.equals("add")){
                sb.setCharAt(num, '1');
                continue;
            } 
            if(comman.equals("remove")){
                sb.setCharAt(num, '0');
                continue;
            }
            if(comman.equals("check")){
                ans.append(sb.charAt(num)).append('\n');
                continue;
            }
            if(comman.equals("toggle")){
                if(sb.charAt(num) == '1') sb.setCharAt(num, '0');
                else sb.setCharAt(num, '1');
                continue;
            }
        }
        System.out.println(ans);
    }
}