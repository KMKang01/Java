import java.util.Scanner;

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String meaning(String word) {
        int tmp = 0;
        String result;
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                tmp = i;
                break;
            }
            if (i == kor.length - 1 && !kor[i].equals(word)) {
                result = word + "은/는 사전에 없습니다.";
                return result;
            }
        }
        result = word + "은/는 영어로 " + eng[tmp] + "입니다.";
        return result;
    }
}

public class ch4_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");
        while (true) {
            System.out.print("한글 단어를 입력하세요 >> ");
            String input = sc.next();
            if (input.equals("그만")) break;
            System.out.println(Dictionary.meaning(input));
        }
    }
}