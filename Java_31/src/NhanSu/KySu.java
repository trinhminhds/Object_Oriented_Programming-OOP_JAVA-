package NhanSu;

public class KySu extends NhanSu {

    private String chuyenNganhDaoTao;

    public KySu(String hoVaTen, int namSinh, String gioiTinh, String soDienThoai, String chuyenNganhDaoTao) {
        super(hoVaTen, namSinh, gioiTinh, soDienThoai);
        this.chuyenNganhDaoTao = chuyenNganhDaoTao;
    }

    public String getChuyenNganhDaoTao() {
        return chuyenNganhDaoTao;
    }

    public void setChuyenNganhDaoTao(String chuyenNganhDaoTao) {
        this.chuyenNganhDaoTao = chuyenNganhDaoTao;
    }

    @Override
    public String toString() {
        return "Họ và tên: " + getHoVaTen() + ", Năm sinh: " + getNamSinh() + ", Giới tính: " + getGioiTinh()
                + ", Số điện thoại: " + getSoDienThoai() + ", Chuyên ngành: " + chuyenNganhDaoTao;
    }

}
