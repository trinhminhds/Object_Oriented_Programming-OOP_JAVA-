
public class Main {
    public static void main(String[] args) {
        HoaDonCaPhe hd = new HoaDonCaPhe("Trung Nguyen", 100, 7);
        System.out.println("Tong tien: " + hd.tinhTongTien());
        System.out.println("Kiem tra khoi luong > 2kg " + hd.kiemTraKhoiLuong(2));
        System.out.println("Kiem tra tong tien > 5000 " + hd.checkTien());
        System.out.println("Giam gia " + hd.giamGia(10));
        System.out.println("So tien cuoi cung khach phai tra " + hd.sauKhiGiamGia(10));
    }
}
