
public class Methods {

    int x = 5;

    static void myMethod(String fname) {
        System.out.println(fname + " I just got executed!");
    }

    public static void main(String[] args) {
        myMethod("Liam");
        myMethod("Jenny");
        myMethod("Anja");
    }
}
