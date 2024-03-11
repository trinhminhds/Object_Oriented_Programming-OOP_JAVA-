package NhanSu;

public class NhanSu {

    private String hoVaTen;
    private int namSinh;
    private String gioiTinh;
    private String soDienThoai;

    public NhanSu(String hoVaTen, int namSinh, String gioiTinh, String soDienThoai) {
        this.gioiTinh = gioiTinh;
        this.hoVaTen = hoVaTen;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

}
