import java.util.Scanner;

public class Bai_Tap_03 {
    public static void main(String[] args) {
        int n, sum = 0, number;
        float avgNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap vao so phan tu: ");
        n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            System.out.println("Nhap so o vi tri " + i + ": ");
            number = scanner.nextInt();
            if (number > 0)
                continue;
            sum += number;
        }
        avgNumber = (float) sum / n;
        System.out.println("Trung binh cong = " + avgNumber);

        scanner.close();
    }

}
