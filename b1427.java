import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (char c : a) {
            sb.append(c);
        }
        sb = sb.reverse();
        System.out.println(sb);
    }
}
