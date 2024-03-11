package NhanSu;

public class LanhDao extends NhanSu {

    private String capLanhDao;
    private String phongBanLamViec;

    public LanhDao(String hoVaTen, int namSinh, String gioiTinh, String soDienThoai, String capLanhDao,
            String phongBanLamViec) {
        super(hoVaTen, namSinh, gioiTinh, soDienThoai);
        this.capLanhDao = capLanhDao;
        this.phongBanLamViec = phongBanLamViec;
    }

    public String getCapLanhDao() {
        return capLanhDao;
    }

    public void setCapLanhDao(String capLanhDao) {
        this.capLanhDao = capLanhDao;
    }

    public String getPhongBanLamViec() {
        return phongBanLamViec;
    }

    public void setPhongBanLamViec(String phongBanLamViec) {
        this.phongBanLamViec = phongBanLamViec;
    }

    @Override
    public String toString() {
        return "Họ và tên: " + getHoVaTen() + ", Năm sinh: " + getNamSinh() + ", Giới tính: " + getGioiTinh()
                + ", Số điện thoại: " + getSoDienThoai() + ", Chuyên ngành: " + capLanhDao + phongBanLamViec;
    }

}
