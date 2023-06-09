import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class b1107{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine()); // 채널을 문자열로 입력받음
        int bans = Integer.parseInt(br.readLine());
        boolean ban[] = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < ban.length; i++) {
            if(i == Integer.parseInt(st.nextToken())){
                ban[i] = true;
            }
        }
        for (int i = 0; i < 1000000; i++) {
            
        }

        


    }
}