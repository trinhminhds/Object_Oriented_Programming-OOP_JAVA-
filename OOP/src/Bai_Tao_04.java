import java.util.Scanner;

public class Bai_Tao_04 {
    public static void main(String[] args) {
        int n, soLuong = 0, number;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap vao so phan tu: ");
        n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            System.out.println("Nhap so o vi tri " + i + ": ");
            number = scanner.nextInt();
            if (number < 0)
                continue;
            ++soLuong;
        }

        System.out.println("Trung binh cong = " + soLuong);

        scanner.close();
    }
}