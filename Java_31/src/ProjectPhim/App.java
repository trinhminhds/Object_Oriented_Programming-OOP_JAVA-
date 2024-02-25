package ProjectPhim;

public class App {
    public static void main(String[] args) {

        NgayChieu ngay1 = new NgayChieu(25, 05, 2024);
        NgayChieu ngay2 = new NgayChieu(15, 05, 2023);
        NgayChieu ngay3 = new NgayChieu(23, 03, 2023);

        HangSanXuat hangSanXuat3 = new HangSanXuat("Hãng A", "VietNam");
        HangSanXuat hangSanXuat1 = new HangSanXuat("Hang B", "VietNam");
        HangSanXuat hangSanXuat2 = new HangSanXuat("Hang C", "USA");

        BoPhim boPhim1 = new BoPhim("Bố Gìa", 2020, hangSanXuat1, 65000, ngay1);
        BoPhim boPhim2 = new BoPhim("Running Man", 2021, hangSanXuat2, 70000, ngay2);
        BoPhim boPhim3 = new BoPhim("Kham pha BaLan", 2025, hangSanXuat3, 90000, ngay3);

        System.out.println("So sanh gia ve phim 1 vs phim 2 " + boPhim1.kiemTraGiaVe(boPhim2));
        System.out.println("Ten Hang " + boPhim2.tenHangSanXuat());
        System.out.println("Gia ve sau khi giam 10% : " + boPhim3.giamGia(10));

    }

}
