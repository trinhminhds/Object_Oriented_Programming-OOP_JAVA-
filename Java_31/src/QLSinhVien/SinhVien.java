package QLSinhVien;

public class SinhVien {

    private String maSinhVien;
    private String hoVaTen;
    private NgaySinh ngaySinh;
    private int diemTB;
    private Lop lop;

    public SinhVien(String maSV, String hoVaTen, NgaySinh ngaySinh, int diemTB, Lop lop) {
        this.maSinhVien = maSV;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diemTB = diemTB;
        this.lop = lop;
    }

    public String getMaSinhVien() {
        return this.maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoVaTen() {
        return this.hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public NgaySinh getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(NgaySinh ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getDiemTB() {
        return this.diemTB;
    }

    public void setDiemTB(int diemTB) {
        this.diemTB = diemTB;
    }

    public Lop getLop() {
        return this.lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public String inTenKhoa() {
        return this.lop.getTenKhoa();
    }

    public boolean xetDiem() {
        return this.diemTB >= 5;
    }

    public boolean checkNgaySinh(SinhVien sinhVienKhac) {
        return this.ngaySinh.equals(sinhVienKhac.ngaySinh);
    }

}
