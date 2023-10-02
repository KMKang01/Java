import java.util.Scanner;

public class WordGameApp {
    Scanner sc = new Scanner(System.in);

    WordGameApp() {
    }

    public void run() {

        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참여하시는 인원 수를 적어주세요 >> ");
        int numOfPlayer = sc.nextInt();

        Player[] player = new Player[numOfPlayer];
        for (int i = 0; i < player.length; i++) {
            System.out.print("참가자의 이름을 입력하세요>>");
            String name = sc.next();
            player[i] = new Player(name);
        }
        /*                 <해결해야할 것>
         *          - 진 사람부터 다시 시작하도록 하려면?
         *  */
        System.out.println(player[0].name + " 님부터 게임을 시작합니다.");
        int whoseTurn = 0;
        player[whoseTurn].getWordFromUser(); //첫 번째 게임에서 0번 순서부터 게임 시작 - player[0].word = sc.next()
        String prevWord = player[whoseTurn].word; //whoseTurn이 증가하기 전 이전 순서의 단어를 기억

        while (true) {
            whoseTurn = (whoseTurn + 1) % numOfPlayer;
            player[whoseTurn].getWordFromUser(); //다음 순서가 단어를 입력
            String nextWord = player[whoseTurn].word;
            if (player[whoseTurn].checkSuccess(prevWord)) {
                prevWord = nextWord;
                continue;
            } else {
                System.out.print(player[whoseTurn].name + " 님이 패배하셨습니다.");
                player[whoseTurn].loseCount--;
            }

            System.out.println("다시 하시려면(Y/y), 그만하시려면 아무 키나 누르세요.");

            if (!player[whoseTurn].playMoreGame()) {
                //플레이어 배열에 있는 모든 사람들의 loseCount를 비교해서 가장 수가 작은 사람을 결정
                int max = player[0].loseCount;
                int tmp = 0;
                for (int i = 1; i < player.length; i++) {
                    if (player[i].loseCount > max) {
                        max = player[i].loseCount;
                        tmp = i;
                    }
                }
                System.out.print("게임이 종료되었습니다. 게임의 승자는 " + player[tmp].name + " 님입니다. 축하합니다!");
                break;
            }
            if (whoseTurn != 0) whoseTurn--;
            else whoseTurn += 2;
            //이전 순서로 돌아가기 위함
        }
    } //게임 실행 - Player를 숫자 만큼 객체 배열로 생성

    public static void main(String[] args) {
        WordGameApp wordGameApp = new WordGameApp();
        wordGameApp.run();
    }
}
//게임의 진행을 구현할 클래스

class Player {
    String name; // 플레이어의 이름
    String word; // 플레이어의 입력

    int loseCount = 0;
    Scanner sc = new Scanner(System.in);

    Player(String name) {
        this.name = name;
        this.word = "";
    }// 플레이어의 이름을 입력 받음

    public void getWordFromUser() {
        System.out.print(name + " >> ");
        this.word = sc.next();
    } // 플레이어로부터 입력을 받는 메소드

    Boolean checkSuccess(String prevWord) {
        int lastIndex = prevWord.length() - 1;
        char lastChar = prevWord.charAt(lastIndex);
        char firstChar = word.charAt(0);
        System.out.println(lastChar + ", " + firstChar);
        if (lastChar == firstChar) return true;
        else return false;
    } // 이전 단어의 마지막 글자와 입력한 단어의 첫번째 글자가 일치하는지 확인하는 메소드

    Boolean playMoreGame() {
        if (sc.next().equals("Y") || sc.next().equals("y"))
            return true;
        else return false;
    }

}
    /*
        플레이어의 이름, 순서(게임을 재개하면서 진 사람이 시작하도록 하기 위함)
        이번 턴에 어떤 단어의 입력값을 가지는 클래스
    */