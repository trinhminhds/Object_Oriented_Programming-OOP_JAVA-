package NhanSu;

public class NhanVien extends NhanSu {

    @Override
    public String toString() {
        return "Họ và tên: " + getHoVaTen() + ", Năm sinh: " + getNamSinh() + ", Giới tính: " + getGioiTinh()
                + ", Số điện thoại: " + getSoDienThoai() + ", Chuyên ngành: " + congViecChinh;
    }

    private String congViecChinh;

    public NhanVien(String hoVaTen, int namSinh, String gioiTinh, String soDienThoai, String congViecChinh) {
        super(hoVaTen, namSinh, gioiTinh, soDienThoai);
        this.congViecChinh = congViecChinh;
    }

    public String getCongViecChinh() {
        return congViecChinh;
    }

    public void setCongViecChinh(String congViecChinh) {
        this.congViecChinh = congViecChinh;
    }

}
