package NhanSu;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean tieptuc = false;
        PhongNhanSu phongNhanSu = new PhongNhanSu();

        do {
            System.out.println("/nCÔNG TY LIÊN DOANH ABC");
            System.out.println("Chọn 1 - Thêm nhân sự");
            System.out.println("Chọn 2 - Liệt kê thông tin nhân sự ");
            System.out.println("Chọn 3 - Tìm theo họ tên");
            System.out.println("Chọn 4 - Thoát khỏi chương trình");
            System.out.println("Bạn chọn mục số: ");
            String chon = scanner.nextLine();

            switch (chon.trim()) {
                case "1":

                    System.out.println("Thêm mới nhân sự");
                    System.out.println("1 - Thêm mới kỹ sư");
                    System.out.println("2 - Thêm mới công nhân");
                    System.out.println("3 - Thêm mới Nhân viên");
                    System.out.println("Bạn chọn số máy");
                    String themMoi = scanner.nextLine();

                    switch (themMoi.trim()) {
                        case "1":
                            System.out.println("Thêm mới kỹ sư");
                            System.out.println("Nhập tên: ");
                            String ten = scanner.nextLine();
                            System.out.println("Nhập Tuổi: ");
                            int tuoi = scanner.nextInt();
                            System.out.println("Nhập giới tính: ");
                            String gioiTinh = scanner.nextLine();
                            System.out.println("Nhập số điện thoại: ");
                            String sdt = scanner.nextLine();
                            System.out.println("Nhập chuyên ngành đào tạo: ");
                            String chuyenNganh = scanner.nextLine();

                            NhanSu nhanSuMoi = new KySu(ten, tuoi, gioiTinh, sdt, chuyenNganh);
                            phongNhanSu.themNhanSu(nhanSuMoi);

                        case "2":
                            System.out.println("Thêm mới công nhân");
                            System.out.println("Nhập tên: ");
                            String tenCongNhan = scanner.nextLine();
                            System.out.println("Nhập Tuổi: ");
                            int tuoiCongNhan = scanner.nextInt();
                            System.out.println("Nhập giới tính: ");
                            String gioiTinhCongNhan = scanner.nextLine();
                            System.out.println("Nhập số điện thoại: ");
                            String sdtCongNhan = scanner.nextLine();
                            System.out.println("Nhập Bậc nghề: ");
                            String bacNghe = scanner.nextLine();

                            NhanSu nhanSuCongNhan = new CongNhan(tenCongNhan, tuoiCongNhan, gioiTinhCongNhan,
                                    sdtCongNhan, bacNghe);
                            phongNhanSu.themNhanSu(nhanSuCongNhan);

                        case "3":

                            System.out.println("Thêm mới Nhân Viên");
                            System.out.println("Nhập tên: ");
                            String tenNhanVien = scanner.nextLine();
                            System.out.println("Nhập Tuổi: ");
                            int tuoiNhanVien = scanner.nextInt();
                            System.out.println("Nhập giới tính: ");
                            String gioiTinhNhanVien = scanner.nextLine();
                            System.out.println("Nhập số điện thoại: ");
                            String sdtNhanVien = scanner.nextLine();
                            System.out.println("Nhập Bậc nghề: ");
                            String congViecChinh = scanner.nextLine();

                            NhanSu nhanSuNhanvien = new NhanVien(tenNhanVien, tuoiNhanVien, gioiTinhNhanVien,
                                    sdtNhanVien, congViecChinh);
                            phongNhanSu.themNhanSu(nhanSuNhanvien);

                        default:

                            break;
                    }

                default:

                    break;
            }

            switch (chon.trim()) {
                case "2":
                    System.out.println("Liệt kê thông tin nhân sự");
                    phongNhanSu.lietKe();
                default:
                    break;
            }

            switch (chon.trim()) {
                case "3":
                    System.out.println("Tìm kiếm theo họ tên");
                    System.out.println("Nhập tên: ");
                    String hotenTimKiem = scanner.nextLine();
                    NhanSu ketQuaNhanSu = phongNhanSu.timKiem(hotenTimKiem);

                    if (ketQuaNhanSu != null) {
                        System.out.println("\nNhân sự có họ tên '" + hotenTimKiem + "': " + ketQuaNhanSu);
                    } else {
                        System.out.println("\nKhông tìm thấy nhân sự có họ tên '" + hotenTimKiem + "'.");
                    }
                default:
                    break;
            }

            switch (chon.trim()) {
                case "4":
                    tieptuc = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }

            scanner.close();

        } while (tieptuc);

        // NhanSu nhanSu1 = new KySu("Nguyen Van A", 1990, "Nam", "123456789", "Công
        // nghệ thông tin");
        // NhanSu nhanSu2 = new CongNhan("Tran Thi B", 1985, "N?", "987654321", "Cấp
        // dưỡng");
        // NhanSu nhanSu3 = new NhanVien("Hoang Van C", 1988, "Nam", "456123789", "Kế
        // toán");
        // NhanSu nhanSu4 = new LanhDao("Hoang Van D", 1988, "Nam", "0456123789",
        // "Trưởng Phòng", "Công Nghệ");
        // NhanSu nhanSu5 = new ChuyenGiaNuocNgoai("Hoang Van E", 1988, "Nam",
        // "456123789", "USA",
        // "Công nghệ thông tin", 2024);

        // phongNhanSu.themNhanSu(nhanSu1);
        // phongNhanSu.themNhanSu(nhanSu2);
        // phongNhanSu.themNhanSu(nhanSu3);
        // phongNhanSu.themNhanSu(nhanSu4);
        // phongNhanSu.themNhanSu(nhanSu5);

        // // Hi?n th? danh s�ch nh�n s?
        // System.out.println("Danh sách nhân sự:");
        // phongNhanSu.lietKe();

        // // T�m ki?m hote nh�n s?
        // String hoTenCanTim = "Nguyen Van D";
        // NhanSu ketQuaTimKiem = phongNhanSu.timKiem(hoTenCanTim);

        // if (ketQuaTimKiem != null) {
        // System.out.println("\nNhân sự có họ tên '" + hoTenCanTim + "': " +
        // ketQuaTimKiem);
        // } else {
        // System.out.println("\nKhông tìm thấy nhân sự có họ tên '" + hoTenCanTim +
        // "'.");
        // }

        // // S?a th�ng tin nh�n s?
        // String hoTenMoi = "Nguyen Van r";
        // int namSinhMoi = 1991;
        // String gioiTinhMoi = "Nữ";
        // String soDienThoaiMoi = "0977122398";
        // phongNhanSu.suaThongTin(nhanSu3, hoTenMoi, namSinhMoi, gioiTinhMoi,
        // soDienThoaiMoi);
        // System.out.println("\nSau khi sửa thông tin: ");
        // phongNhanSu.lietKe();

        // // X�a h? s? xin th�i vi?c
        // phongNhanSu.xoaHoSo(nhanSu5);
        // System.out.println("\nSau khi xóa hồ sơ nhân sự xin thôi việc: ");
        // phongNhanSu.lietKe();
    }

}
