import java.util.Scanner;

public class Bai_tap_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số phần tử của dãy
        System.out.print("Nhap so luong phan tu: ");
        int n = scanner.nextInt();

        while (n < 1) {
            System.out.print("Nhap n phai lon hon 0 moi ban nhap lai: ");
            n = scanner.nextInt();
            if (n > 1) {
                break;
            }
        }

        // Khởi tạo mảng
        int[] arr = new int[n];

        // Nhập dãy số từ người dùng
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        // Tìm phần tử lớn thứ hai
        int result = findSecondLargest(arr);
        System.out.println("Phan tu lon thu hai la: " + result);

        scanner.close();
    }

    // Hàm tìm phần tử lớn thứ hai
    private static int findSecondLargest(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return max2;
    }
}
