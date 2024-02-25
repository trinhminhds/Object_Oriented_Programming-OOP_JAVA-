package equaldHascode.toString;

public class Main {
    public static void main(String[] args) {
        MyDate md = new MyDate(29, 4, 2025);
        MyDate md1 = new MyDate(30, 4, 2025);
        MyDate md2 = new MyDate(23, 9, 2023);

        System.out.println(md);
        System.out.println(md1);
        System.out.println(md2);

        System.out.println("md1 so sanh md: " + md1.equals(md));
        System.out.println("md1 so sanh md2: " + md1.equals(md2));

        System.out.println("HashCode md " + md.hashCode());
        System.out.println("HashCode md1 " + md1.hashCode());
        System.out.println("HashCode md2 " + md2.hashCode());
    }
}
