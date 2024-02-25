package PhuongTienAbstract;

public class XeDap extends PhuongTienDiChuyen {

    public XeDap(String tenLoaiPhuongTien, HangSanXuat hangSanXuat) {
        super(tenLoaiPhuongTien, hangSanXuat);
    }

    @Override
    public double layVanToc() {
        return 20;
    }
}
