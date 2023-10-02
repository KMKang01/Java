//원화를 달러로 표현
import java.util.Scanner;

public class ch2_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);//사용자의 입력값을 받아주는 클래스

        System.out.print("원화를 입력하세요(단위 원)>>");
        int won = scanner.nextInt();
        double dollar = (double)won/1100; //won은 int형 변수이므로 double로 형변환
        System.out.print(won+"원은 $"+dollar+"입니다.");
        scanner.close();
    }
}
