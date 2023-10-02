import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

//package
/*      <만들어야 할 것>
 *       콘솔의 내용이 인터페이스에 나오도록 하는 것.
 *     - 해결방안 1 : 콘솔에 출력되도록 한 println에 있는 모든 문자열들을
 *       문자열 배열을 생성해서 그대로 출력되게 하는 방법 -> 실패
 *     - 해결방안 2 : 입력이 되는 동시에 출력되어야 하는 정보들을 출력하는 방법
 *                  신호?를 주면 g.Drawstring을 실행하도록하는 방법
 *
 */
public class GBBGame extends JFrame {
    GBBPanel gbbPanel = new GBBPanel();
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    String[] msgs = {"가위 ~ 바위 ~ 보 ~ !! >>", "잘못된 입력입니다.", " ", "다시 하시겠습니까?(Y/N)", ""};
    public GBBGame() {
        setTitle("가위 바위 보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setContentPane(gbbPanel);
        setVisible(true);

        game();
    }

    int count = 0; // 각각의 경우를 표시하는 전역변수

    void game() {
        int user_win_count = 0;
        while (true) {

            String user_input;// 사용자 입력
            String[] com = {"가위", "바위", "보"};
            System.out.print(msgs[0]);
            user_input = sc.next();

            repaint();

            int com_choose = random.nextInt(3);
            int user_choose = 3;

            switch (user_input) {
                case "가위":
                    user_choose = 0;
                    break;
                case "바위":
                    user_choose = 1;
                    break;
                case "보":
                    user_choose = 2;
                    break;
                default:
                    break;
            } //사용자의 문자열 입력을 숫자로 변환하여 이후 이어지는 if문을 좀 더 쉽게 표현

            if (user_choose == 3) {
                count = 1;
                System.out.println(msgs[1]);
                continue;
            } // 첫 번째 응답이 잘못 되었을 경우

            if (com_choose == 0) {
                count = 2;
                if (user_choose == 0) {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[0] + " , 비겼습니다.";
                    System.out.println(msgs[2]);
                } else if (user_choose == 1) {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[0] + " , 당신이 이겼습니다.";
                    System.out.println(msgs[2]);
                    user_win_count++;
                } else {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[0] + " , 컴퓨터가 이겼습니다.";
                    System.out.println(msgs[2]);
                }
            } else if (com_choose == 1) {
                count = 2;
                if (user_choose == 1) {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[1] + " , 비겼습니다.";
                    System.out.println(msgs[2]);
                } else if (user_choose == 2) {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[1] + " , 당신이 이겼습니다.";
                    System.out.println(msgs[2]);
                    user_win_count++;
                } else {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[1] + " , 컴퓨터가 이겼습니다.";
                    System.out.println(msgs[2]);
                }
            } else {
                count = 2;
                if (user_choose == 2) {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[2] + " , 비겼습니다.";
                    System.out.println(msgs[2]);
                } else if (user_choose == 0) {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[2] + " , 당신이 이겼습니다.";
                    System.out.println(msgs[2]);
                    user_win_count++;
                } else {
                    msgs[2] = "나 = " + user_input + " , 컴퓨터 = " + com[2] + " , 컴퓨터가 이겼습니다.";
                    System.out.println(msgs[2]);
                }
            }
            repaint();
            String answer;
            while (true) {
                //msgs[3] = "다시 하시겠습니까?(Y/N)";
                System.out.print(msgs[3]);
                answer = sc.next();
                repaint();
                if (answer.equals("Y") || answer.equals("y")){
                    count = 0;
                    break;
                }
                else if (answer.equals("N") || answer.equals("n"))
                    break;
                else {
                    count = 3;
                    System.out.println(msgs[1]);
                } // 사용자의 응답이 잘못되었을 경우 오류 메시지를 띄우고 재질문
            }

            if (answer.equals("N") || answer.equals("n")) {
                count = 4;
                repaint();
                msgs[4] = "게임이 종료되었습니다. 당신의 승리 횟수는 " + user_win_count + "회 입니다.";
                System.out.println(msgs[4]);
                break;
            } // 사용자의 응답이 N 또는 n 일 경우 게임을 종료
        }
    }

    class GBBPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            switch (count) {
                case 0: // 시작 문구
                    g.drawString(msgs[0], 50, 50);
                    break;
                case 1: // 잘못된 응답에 보여줄 메시지
                    g.drawString(msgs[1], 50, 100);
                    g.drawString(msgs[0], 50, 50);
                    break;
                case 2: // 이번 게임의 결과를 알려주고 재시도 여부
                    g.drawString(msgs[2], 50, 150);
                    g.drawString(msgs[3], 50, 200);
                    break;
                case 3: // 재시도 여부의 잘못된 응답에 보여줄 메시지
                    g.drawString(msgs[1], 50, 100);
                    g.drawString(msgs[3], 50, 200);
                    break;
                case 4:
                    g.drawString(msgs[4], 50, 250);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        GBBGame gbbGame = new GBBGame();
        gbbGame.game();
    }
}
