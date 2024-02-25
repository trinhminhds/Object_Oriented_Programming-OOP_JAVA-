package QLSinhVien;

public class Lop {

    private String tenLop;
    private String tenKhoa;

    public Lop(String tenLop, String tenKhoa) {
        this.tenLop = tenLop;
        this.tenKhoa = tenKhoa;
    }

    public String getTenLop() {
        return this.tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenKhoa() {
        return this.tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
