package NhanSu;

public class App {
    public static void main(String[] args) {

        NhanSu nhanSu1 = new KySu("Nguyen Van A", 1990, "Nam", "123456789", "Công nghệ thông tin");
        NhanSu nhanSu2 = new CongNhan("Tran Thi B", 1985, "N?", "987654321", "Cấp dưỡng");
        NhanSu nhanSu3 = new NhanVien("Hoang Van C", 1988, "Nam", "456123789", "Kế toán");
        NhanSu nhanSu4 = new LanhDao("Hoang Van D", 1988, "Nam", "0456123789", "Trưởng Phòng", "Công Nghệ");
        NhanSu nhanSu5 = new ChuyenGiaNuocNgoai("Hoang Van E", 1988, "Nam", "456123789", "USA",
                "Công nghệ thông tin", 2024);

        PhongNhanSu phongNhanSu = new PhongNhanSu();
        phongNhanSu.themNhanSu(nhanSu1);
        phongNhanSu.themNhanSu(nhanSu2);
        phongNhanSu.themNhanSu(nhanSu3);
        phongNhanSu.themNhanSu(nhanSu4);
        phongNhanSu.themNhanSu(nhanSu5);

        // Hi?n th? danh s�ch nh�n s?
        System.out.println("Danh sách nhân sự:");
        phongNhanSu.lietKe();

        // T�m ki?m hote nh�n s?
        String hoTenCanTim = "Nguyen Van D";
        NhanSu ketQuaTimKiem = phongNhanSu.timKiem(hoTenCanTim);

        if (ketQuaTimKiem != null) {
            System.out.println("\nNhân sự có họ tên '" + hoTenCanTim + "': " + ketQuaTimKiem);
        } else {
            System.out.println("\nKhông tìm thấy nhân sự có họ tên '" + hoTenCanTim + "'.");
        }

        // S?a th�ng tin nh�n s?
        String hoTenMoi = "Nguyen Van r";
        int namSinhMoi = 1991;
        String gioiTinhMoi = "Nữ";
        String soDienThoaiMoi = "0977122398";
        phongNhanSu.suaThongTin(nhanSu3, hoTenMoi, namSinhMoi, gioiTinhMoi, soDienThoaiMoi);
        System.out.println("\nSau khi sửa thông tin: ");
        phongNhanSu.lietKe();

        // X�a h? s? xin th�i vi?c
        phongNhanSu.xoaHoSo(nhanSu5);
        System.out.println("\nSau khi xóa hồ sơ nhân sự xin thôi việc: ");
        phongNhanSu.lietKe();
    }

}
