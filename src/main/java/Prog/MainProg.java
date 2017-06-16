package Prog;


public class MainProg {

    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        System.out.println("final " + a + ":" + b);
        System.out.println("------");
        a = a + b;
        System.out.println(a + ":" + b);
        b = a - b;
        System.out.println(a + ":" + b);
        a = a - b;
        System.out.println("final " + a + ":" + b);
        System.out.println("------");
        a = a ^ b;
        System.out.println(a + ":" + b);
        b = a ^ b;
        System.out.println(a + ":" + b);
        a = a ^ b;
        System.out.println("final " + a + ":" + b);
    }
}
