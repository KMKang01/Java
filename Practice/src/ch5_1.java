class aTV{
    private int size;
    public aTV(int size) {this.size=size;}
    protected int getSize(){return size;}
}

class ColorTV extends aTV{
    private int colorNum;
    ColorTV(int size, int colorNum){
        super(size);
        this.colorNum=colorNum;
    }
    public void printProperty(){System.out.println(getSize()+"인치 "+this.colorNum+"컬러");}
}

public class ch5_1 {
    public static void main(String[] args){
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();
    }
}
