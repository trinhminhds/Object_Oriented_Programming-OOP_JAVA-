package Java_Get_Set;

public class Main {
    public static void main(String[] args) {
        MyDate md = new MyDate(31, 1, 2024);
        System.out.println("Day " + md.getDay());
        md.setDay(50);
        System.out.println("Month " + md.getMonth());
        md.setMonth(13);
        System.out.println("Year " + md.getYear());
        md.setYear(2021);

    }
}
