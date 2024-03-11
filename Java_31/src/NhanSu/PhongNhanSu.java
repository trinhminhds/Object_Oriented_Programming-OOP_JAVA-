package NhanSu;

import java.util.ArrayList;
import java.util.List;

public class PhongNhanSu {

    private List<NhanSu> danhSachCongTyABC;

    public PhongNhanSu() {
        danhSachCongTyABC = new ArrayList<>();
    }

    public void themNhanSu(NhanSu congTyABC) {
        danhSachCongTyABC.add(congTyABC);
    }

    public void lietKe() {
        for (NhanSu congTyABC : danhSachCongTyABC) {
            System.out.println(congTyABC);
        }
    }

    public NhanSu timKiem(String hoTen) {
        for (NhanSu congTyABC : danhSachCongTyABC) {
            if (congTyABC.getHoVaTen().equals(hoTen)) {
                return congTyABC;
            }
        }
        return null;
    }

    public void suaThongTin(NhanSu congTyABC, String hoVaTenMoi, int namSinhMoi, String gioiTinhMoi,
            String soDienThoaiMoi) {
        congTyABC.setHoVaTen(hoVaTenMoi);
        congTyABC.setNamSinh(namSinhMoi);
        congTyABC.setGioiTinh(gioiTinhMoi);
        congTyABC.setSoDienThoai(soDienThoaiMoi);
    }

    public void xoaHoSo(NhanSu congTyABC) {
        danhSachCongTyABC.remove(congTyABC);
    }

}
