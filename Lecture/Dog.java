package Lecture1.Lecture1_2;

public class Dog {
    public int weightInPounds;

    public Dog(int w) {
        weightInPounds = w;
    }
    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark!");
        } else {
            System.out.println("woof!");
        }
    }
}
