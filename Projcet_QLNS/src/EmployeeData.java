import java.sql.Date;

public class EmployeeData {
    private String maNhanVien;
    private String ho;
    private String ten;
    private String gioiTinh;
    private String soDienThoai;
    private String chucVu;
    private Date ngaySinh;
    private int luong;
    private String diaChi;

    public EmployeeData(String maNhanVien, String ho, String ten, String gioiTinh, String soDienThoai,
            String chucVu, String diaChi, Date ngaySinh) {
        this.maNhanVien = maNhanVien;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.chucVu = chucVu;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public EmployeeData(String maNhanVien, String ho, String ten, String chucVu, int luong) {
        this.maNhanVien = maNhanVien;
        this.ho = ho;
        this.ten = ten;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public int getLuong() {
        return luong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
