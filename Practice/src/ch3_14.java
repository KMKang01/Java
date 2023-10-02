import java.util.Scanner;

public class ch3_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] course = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
        int[] score = {95, 88, 76, 62, 55};
        while (true) {
            System.out.print("과목 이름>>");
            String name = sc.next();

            if (name.equals("그만"))
                break;

            for (int i = 0; i < 5 ; i++) {
                if (course[i].equals(name)) {
                    System.out.println(name+"의 점수는 "+score[i]);
                    break;
                }
            }
        }
    }
}
