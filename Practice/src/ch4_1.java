public class ch4_1 {
    public static void main(String[] args){
        TV myTV = new TV("LG",2017,32);
        myTV.show();
    }
}

class TV{
    String company;
    int madeYear;
    int inch;

    TV(){
        this.company="";
        this.madeYear=2000;
        this.inch=24;
    }
    TV(String company,int madeYear,int inch){
        this.company=company;
        this.madeYear=madeYear;
        this.inch=inch;
    }

    void show(){
        System.out.println(this.company+"에서 만든 "+this.madeYear+"년형 "+this.inch+"인치 TV");
    }
}