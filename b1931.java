import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class b1931 {
    public static void main(String[] args) throws IOException{
        /**
         *  알고리즘 : greedy , '활동 선택 문제(Activity Selection problem)'
         *  기준: 시작, 끝, 소요시간
         *  
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>(n);

        int s,e;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list.add(new Pair(s, e));
        }
        MyComparator myComparator = new MyComparator();
        Collections.sort(list,myComparator);
    
        Pair temp = list.get(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(temp.e <= list.get(i).s){
                temp = list.get(i);
                count++;
            }
        }
        System.out.println(count);

    }
}
class Pair{
    int s,e;
    public Pair(int s, int e){
        this.s = s;
        this.e = e;
    }
    public int gap(){
        return e-s;
    }
}

class MyComparator implements Comparator<Pair> {

    public int compare(Pair p1, Pair p2) {
        if (p1.e > p2.e) {
            return 1; // x를 기준으로 오름차순
        } 
        else if(p1.e == p2.e){
            if(p1.s > p2.s){
                return 1;
            }
        }
        return -1;
    }
}
