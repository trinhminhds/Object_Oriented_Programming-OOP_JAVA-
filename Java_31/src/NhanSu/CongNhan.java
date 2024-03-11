package NhanSu;

public class CongNhan extends NhanSu {

    @Override
    public String toString() {
        return "Họ và tên: " + getHoVaTen() + ", Năm sinh: " + getNamSinh() + ", Giới tính: " + getGioiTinh()
                + ", Số điện thoại: " + getSoDienThoai() + ", Chuyên ngành: " + bacNghe;
    }

    private String bacNghe;

    public CongNhan(String hoVaTen, int namSinh, String gioiTinh, String soDienThoai, String bacNghe) {
        super(hoVaTen, namSinh, gioiTinh, soDienThoai);

        this.bacNghe = bacNghe;

    }

    public String getBacNghe() {
        return bacNghe;
    }

    public void setBacNghe(String bacNghe) {
        this.bacNghe = bacNghe;
    }

}
