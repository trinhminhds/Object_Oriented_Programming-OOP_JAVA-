package PhuongTienAbstract;

public class App {
    public static void main(String[] args) {
        HangSanXuat h1 = new HangSanXuat("Hang 1", "Viet Nam");
        HangSanXuat h2 = new HangSanXuat("Hang 2", "USA");
        HangSanXuat h3 = new HangSanXuat("Hang 3", "Japan");

        PhuongTienDiChuyen p1 = new XeOto("Xe Oto", h3, "Xang");
        MayBay p2 = new MayBay("May Bay", h2, "Xang");
        PhuongTienDiChuyen p3 = new XeDap("Xe Dap", h1);

        System.out.print("Lay hang san xuat ");
        System.out.println(p1.layTenHangSanXuat());

        System.out.print("Bat Dau ");
        p1.batDau();

        System.out.println(p1.layVanToc());
        System.out.println(p2.layVanToc());
        System.out.println(p3.layVanToc());

    }
}
