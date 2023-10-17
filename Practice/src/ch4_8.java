import java.util.Scanner;

class Phone {
    //필드
    private String name;
    private String tel;

    public Phone() {
        this.name = "홍길동";
        this.tel = "000-0000";
    }

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public Boolean search(String name) {
        if (this.name.equals(name)) return true;
        else return false;
    }

    public void show() {
        System.out.println(this.name + "의 번호는 " + this.tel + " 입니다.");
    }
}

public class ch4_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("인원수 >> ");
        int num = sc.nextInt();

        Phone[] phonebook = new Phone[num];
        for (int i = 0; i < phonebook.length; i++) {
            System.out.print("이름과 전화번호 (이름과 번호를 space bar로 띄워서 입력해주세요) >> ");
            String name = sc.next();
            String telNum = sc.next();
            phonebook[i] = new Phone(name, telNum);
        }
        System.out.println("저장되었습니다...");
        while (true) {
            System.out.print("검색할 이름 >> ");
            String name = sc.next();

            if (name.equals("그만")) break;

            for (int i = 0; i < phonebook.length; i++) {
                if (phonebook[i].search(name)) {
                    phonebook[i].show();
                    break;
                }
                if((i==phonebook.length-1)&& !phonebook[i].search(name))
                    System.out.println(name + "은/는 전화번호부에 없는 이름입니다.");
            }
        }
        sc.close();
    }
}
