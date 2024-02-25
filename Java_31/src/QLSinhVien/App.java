package QLSinhVien;

public class App {
    public static void main(String[] args) {

        NgaySinh ngaySinh1 = new NgaySinh(23, 9, 2003);
        NgaySinh ngaySinh2 = new NgaySinh(27, 8, 2004);
        NgaySinh ngaySinh3 = new NgaySinh(05, 4, 2004);

        Lop lop1 = new Lop("DH001", "Khoa CNTT");
        Lop lop2 = new Lop("DH002", "Khoa DS");
        Lop lop3 = new Lop("DH003", "Khoa ANTT");

        SinhVien sinhVien1 = new SinhVien("001", "Trinh Ngoc Minh", ngaySinh1, 9, lop2);
        SinhVien sinhVien2 = new SinhVien("002", "Huynh Thi Bich Yen", ngaySinh2, 6, lop1);
        SinhVien sinhVien3 = new SinhVien("003", "Nguyen Thi Thanh Tien", ngaySinh3, 4, lop3);

        System.out.println("Ten Khoa: ");
        System.out.println("Sv1: " + sinhVien1.inTenKhoa());
        System.out.println("Sv2: " + sinhVien2.inTenKhoa());
        System.out.println("Sv3: " + sinhVien3.inTenKhoa());

        System.out.println("Kiem Tra thi dat: ");
        System.out.println("sv1: " + sinhVien1.xetDiem());
        System.out.println("Sv2: " + sinhVien2.xetDiem());
        System.out.println("Sv3: " + sinhVien3.xetDiem());

        System.out.println("Kiem tra trung ngay sinh: ");
        System.out.println("Kiem tra trung ngay sinh Sv1 voi Sv3: " + sinhVien1.checkNgaySinh(sinhVien3));
        System.out.println("Kiem tra trung ngay sinh Sv2 voi Sv1: " + sinhVien2.checkNgaySinh(sinhVien1));
        System.out.println("Kiem tra trung ngay sinh Sv3 voi Sv2: " + sinhVien3.checkNgaySinh(sinhVien2));

    }
}
