//사각형 객체 연습
class Rectangle {
    int x, y, width, height;

    Rectangle() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.println("(" + this.x + ", " + this.y + ")에서 크기가 " + this.width + "x" + this.height + "인 사각형");
    }

    public boolean contain(Rectangle r) {
        if ((this.x <= r.x) && (this.x + this.width >= r.x + r.width) && (this.y <= r.y) && (this.y + this.height >= r.y + r.height))
            return true;
        else return false;
    }
}

public class ch4_4 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);
        Rectangle a = new Rectangle();
        Rectangle b = new Rectangle(3,3,12,12);
        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contain(r)) System.out.println("t는 r을 포함합니다.");
        if (t.contain(s)) System.out.println("t는 s를 포함합니다.");
        if (t.contain(a)) System.out.println("t는 a를 포합합니다.");
        if (t.contain(b)) System.out.println("t는 b를 포함합니다.");
    }
}