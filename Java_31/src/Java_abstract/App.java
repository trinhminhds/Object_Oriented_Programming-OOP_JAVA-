package Java_abstract;

public class App {
    public static void main(String[] args) {
        ToaDo td1 = new ToaDo(5, 5);
        ToaDo td2 = new ToaDo(7, 9);
        ToaDo td3 = new ToaDo(12, 1);

        Hinh h1 = new Diem(td3);
        Hinh h2 = new HinhTron(td2, 10);
        Hinh h3 = new HinhChuNhat(td1, 5, 10);

        System.out.println("Dt1 " + h1.tinhDienTich());
        System.out.println("Dt2 " + h2.tinhDienTich());
        System.out.println("Dt3 " + h3.tinhDienTich());

    }
}
