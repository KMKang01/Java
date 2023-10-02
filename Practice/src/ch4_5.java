//2개의 클래스 만들기, 객체 배열 만들기

import java.util.Scanner;

class Circle {
    private double x, y;
    private int radius;

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 0;
    }

    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void show() {
        System.out.println("(" + this.x + "," + y + "), radius = " + this.radius);
    }

    public void whichIsBig(Circle[] c) {
        Circle tmp = new Circle();
        for (int i = 0; i < c.length; i++) {
            if (c[i].radius > tmp.radius) tmp = c[i];
        }
        System.out.print("가장 면적이 큰 원은 ");
        tmp.show();
    }
}

public class ch4_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle[] c = new Circle[3];
        for (int i = 0; i < c.length; i++) {
            System.out.print("x, y, radius >> ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            int radius = sc.nextInt();
            c[i] = new Circle(x, y, radius);
        }
        Circle tmp = new Circle();
        tmp.whichIsBig(c);
        sc.close();
    }

}
