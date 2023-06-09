import java.util.Scanner;

public class b1676{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =  scan.nextInt();
        int two = 0;
        int five = 0;
        int ten = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while(num % 10 == 0){
                ten++;
                num = num/10;
            }
            while(num % 5 == 0){
                five++;
                num = num /5;
            }
            while(num % 2 == 0){
                two++;
                num = num/2;
            }
        }
        if(five > two){
            count += two;
        } else{
            count += five;
        }
        count += ten;
        System.out.println(count);
    }
}