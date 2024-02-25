import java.util.Scanner;

public class ChuyenDoi {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so nguyen: ");
        n = sc.nextInt();

        while (n < 0) {
            System.out.println("Nhap lai so nguyen lon hon 0");
            n = sc.nextInt();
            if (n > 0)
                break;
        }

        String nhiPhan = "";
        while (n > 0) {
            nhiPhan = (n % 2) + nhiPhan;
            n = n / 2;
        }
        System.out.println("So he nhi phan la: " + nhiPhan);

        sc.close();
    }
}
