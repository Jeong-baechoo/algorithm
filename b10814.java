import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<tuple> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new tuple(name, age, num++));
        }
        Collections.sort(list);

        for (tuple tuple : list) {
            System.out.println(tuple.age+" "+tuple.name);
        }
        
    }
    public static class tuple implements Comparable<tuple>{
        String name;
        int age;
        int num;
        public tuple(String name, int age, int num){
            this.name = name;
            this.age = age;
            this.num = num;
        }
        @Override
        public int compareTo(tuple o) {
            if(age == o.age){
                return num - o.num;
            }
            return age - o.age;
        }
        
    }
}
