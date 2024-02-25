package ProjectSach;

public class App {
    public static void main(String[] args) {
        Ngay ngay1 = new Ngay(23, 9, 2003);
        Ngay ngay2 = new Ngay(27, 8, 2004);
        Ngay ngay3 = new Ngay(5, 4, 2004);

        TacGia tacGia1 = new TacGia("Trinh Ngoc Minh", ngay1);
        TacGia tacGia2 = new TacGia("Huynh Thi Bich Yen", ngay2);
        TacGia tacGia3 = new TacGia("Nguyen Thi Thanh Tien", ngay3);

        Sach sach1 = new Sach("Lap Trinh Python", 100000, 2023, tacGia1);
        Sach sach2 = new Sach("Lap Trinh Java", 200000, 2022, tacGia2);
        Sach sach3 = new Sach("Lap Trinh C#", 150000, 2021, tacGia3);

        sach1.inTenSach();
        sach2.inTenSach();
        sach3.inTenSach();

        System.out.println("So sanh NXB sach 1 voi sach 2 " + sach1.kiemTraCungNam(sach2));
        System.out.println("So sanh NXB sach 1 voi sach 3 " + sach1.kiemTraCungNam(sach3));

        System.out.println("Sach sau khi giam 10% " + sach1.giaSauKhiGiam(10));
        System.out.println("Sach sau khi giam 20% " + sach2.giaSauKhiGiam(20));
        System.out.println("Sach sau khi giam 30% " + sach3.giaSauKhiGiam(30));
    }
}
