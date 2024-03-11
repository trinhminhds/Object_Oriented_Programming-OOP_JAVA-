package entity;

import java.util.ArrayList;
import java.util.List;

public class PhongNhanSu {

    private List<NhanSu> danhSachNhanVien;

    public PhongNhanSu() {
        danhSachNhanVien = new ArrayList<>();
    }

    public void themNhanVien(NhanSu nhanSu) {
        danhSachNhanVien.add(nhanSu);
    }

    public void lietKeNhanSu() {
        for (NhanSu nhanSu : danhSachNhanVien) {
            System.out.println(nhanSu);
        }
    }

    public void lietKeDoiTuong(NhanSu nhanSu) {

    }

}
