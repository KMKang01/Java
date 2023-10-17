class Shape {
    public Shape next;

    public Shape() {
        next = null;
    }

    public void draw() {
        System.out.println("Shape");
    }
}

class Line extends Shape {
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }
}

public class ex5_5 {
    static void paint(Shape p) {
        p.draw();
    }

    public static void main(String[] args) {
        Shape start, last, obj;
        // start는 연결 리스트의 시작 객체, last는 연결 리스트의 마지막, obj는 다음 노드가 나타낼 객체

        start = new Line();
        last = start;

        obj = new Rect();
        last.next = obj;
        last = obj;

        obj = new Line();
        last.next = obj;
        last = obj;

        obj = new Circle();
        last.next = obj;

        Shape p = start;
        while (p != null) {
            p.draw();
            p = p.next;
        }
    }
}