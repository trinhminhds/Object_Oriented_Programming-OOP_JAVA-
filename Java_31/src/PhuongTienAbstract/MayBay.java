package PhuongTienAbstract;

public class MayBay extends PhuongTienDiChuyen {

    private String loaiNhienLieu;

    public MayBay(String tenLoaiPhuongTien, HangSanXuat hangSanXuat, String loaiNhienLieu) {
        super(tenLoaiPhuongTien, hangSanXuat);
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public void catCanh() {
        System.out.println("Cat Canh ");
    }

    public void haCanh() {
        System.out.println("Ha Canh ");
    }

    @Override
    public double layVanToc() {
        return 1000;
    }

}
