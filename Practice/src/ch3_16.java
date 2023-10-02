//가위바위보 게임

import java.util.Random;
import java.util.Scanner;

public class ch3_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] com_choose = {"가위", "바위", "보"};
        String user_choose;

        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");

        do {
            int i = random.nextInt(3);  //Random 클래스를 이용하여 난수 발생, 난수의 범위는 괄호 안의 값 0~2
            System.out.print("가위 바위 보! >> ");
            user_choose = sc.next(); //사용자의 입력

            if (user_choose.equals("그만"))
                break;
            else {
                if (com_choose[i].equals("가위")) {
                    if (user_choose.equals("가위"))
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 비겼습니다.");
                    else if (user_choose.equals("바위"))
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 사용자가 이겼습니다.");
                    else
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 컴퓨터가 이겼습니다.");
                } else if (com_choose[i].equals("바위")) {
                    if (user_choose.equals("바위"))
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 비겼습니다.");
                    else if (user_choose.equals("보"))
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 사용자가 이겼습니다.");
                    else
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 컴퓨터가 이겼습니다.");
                } else {
                    if (user_choose.equals("보"))
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 비겼습니다.");
                    else if (user_choose.equals("가위"))
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 사용자가 이겼습니다.");
                    else
                        System.out.println("사용자 = " + user_choose + " , 컴퓨터 = " + com_choose[i] + " , 컴퓨터가 이겼습니다.");
                }
            }
        } while (true);
        System.out.println("게임을 종료합니다...");
        sc.close();
    }
}