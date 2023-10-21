class User {
    String name;
    String id;

    public User(String name) {
        this.name = name;
    }
}

class Ranker extends User {
    String grade;
    String power;

    public Ranker(String name) {
        super(name);
    }
}


public class UpcastingEx {
    public static void main(String[] args){
        User user1 = new Ranker("강경민");//upcasting
        Ranker ranker1;

        System.out.println(user1.name);

        user1.id="random1453";
        user1.name="김철수";

        ranker1 = (Ranker)user1;
        System.out.println(ranker1.id);
        System.out.println(ranker1.name);
        ranker1.grade="A";

        User user2;
        Ranker ranker2 = new Ranker("이승모");
        user2 = ranker2;//upcasting

        System.out.println(user2.name);

        user2.name = "황우솔";

        System.out.println(ranker2.name);
    }
}
