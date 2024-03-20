
public class luongNhanVien {
    private String maNhanVien;
    private String ho;
    private String ten;
    private String chucVu;
    private int luong;

    public luongNhanVien(String maNhanVien, String ho, String ten, String chucVu, int luong) {
        this.maNhanVien = maNhanVien;
        this.ho = ho;
        this.ten = ten;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

}
