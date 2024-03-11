package NhanSu;

public class ChuyenGiaNuocNgoai extends NhanSu {

    private String quocTich;
    private String chuyenNganhDaoTao;
    private int ngayHetHanVisa;

    public ChuyenGiaNuocNgoai(String hoVaTen, int namSinh, String gioiTinh, String soDienThoai, String quocTich,
            String chuyenNganhDaoTao, int ngayHetHanVisa) {
        super(hoVaTen, namSinh, gioiTinh, soDienThoai);
        this.quocTich = quocTich;
        this.chuyenNganhDaoTao = chuyenNganhDaoTao;
        this.ngayHetHanVisa = ngayHetHanVisa;

    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getChuyenNganhDaoTao() {
        return chuyenNganhDaoTao;
    }

    public void setChuyenNganhDaoTao(String chuyenNganhDaoTao) {
        this.chuyenNganhDaoTao = chuyenNganhDaoTao;
    }

    public int getNgayHetHanVisa() {
        return ngayHetHanVisa;
    }

    public void setNgayHetHanVisa(int ngayHetHanVisa) {
        this.ngayHetHanVisa = ngayHetHanVisa;
    }

    @Override
    public String toString() {
        return "Họ và tên: " + getHoVaTen() + ", Năm sinh: " + getNamSinh() + ", Giới tính: " + getGioiTinh()
                + ", Số điện thoại: " + getSoDienThoai() + ", Chuyên ngành: " + quocTich + chuyenNganhDaoTao
                + ngayHetHanVisa;
    }

}
