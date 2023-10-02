//369 게임
import java.util.Scanner;

public class ch2_6 {
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("1~99 사이의 정수를 입력하시오>>");
        int n = sc.nextInt();
        if(n%10==3||n%10==6||n%10==9){ //입력 받은 정수의 첫째 자리 수가 3, 6, 9인지 확인
          if(n/10==3||n/10==6||n/10==9) //입력 받은 정수의 둘째 자리 수가 3, 6, 9인지 확인
              System.out.print("박수짝짝");
          else
              System.out.print("박수짝");
        }
        else{
            System.out.print(n);
        }
        sc.close();
    }
}
