public class HoaDonCaPhe {

    private String tenLoaiCaPhe;
    private double giaTien1Kg;
    protected double khoiLuong;

    public HoaDonCaPhe(String ten, double gia, double kl) {
        this.tenLoaiCaPhe = ten;
        this.giaTien1Kg = gia;
        this.khoiLuong = kl;
    }

    public double tinhTongTien() {
        return this.giaTien1Kg * this.khoiLuong;
    }

    public boolean kiemTraKhoiLuong(double kl) {

        if (this.khoiLuong > kl) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkTien() {
        return this.tinhTongTien() > 500;
    }

    public double giamGia(double gg) {
        if (this.tinhTongTien() > 500) {
            return (gg / 100) * this.tinhTongTien();
        } else {
            return 0;
        }

    }

    public double sauKhiGiamGia(double gg) {
        return tinhTongTien() - this.giamGia(gg);
    }

    public String getTenLoaiCaPhe() {
        return this.tenLoaiCaPhe;
    }

}
