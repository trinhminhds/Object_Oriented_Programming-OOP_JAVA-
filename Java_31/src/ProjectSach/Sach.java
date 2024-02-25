package ProjectSach;

public class Sach {
    private String tenSach;
    private double giaBan;
    private int namXuatBan;
    private TacGia tacGia;

    public Sach(String tenSach, double giaBan, int namXuatBan, TacGia tacGia) {

        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.namXuatBan = namXuatBan;
        this.tacGia = tacGia;

        if (namXuatBan >= 1) {
            this.namXuatBan = namXuatBan;
        } else {
            this.namXuatBan = 1;
        }

        if (giaBan >= 0) {
            this.giaBan = giaBan;
        } else {
            this.giaBan = 1;
        }

    }

    public String getTenSach() {
        return this.tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public double getGiaBan() {
        return this.giaBan;
    }

    public void setGiaBan(double giaBan) {
        if (giaBan >= 0) {
            this.giaBan = giaBan;
        }
    }

    public int getNamXuatBan() {
        return this.namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        if (namXuatBan >= 1) {
            this.namXuatBan = namXuatBan;
        }
    }

    public TacGia getTacGia() {
        return this.tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public void inTenSach() {
        System.out.println(this.tenSach);
    }

    public boolean kiemTraCungNam(Sach sachKhac) {
        return this.namXuatBan == sachKhac.namXuatBan;
    }

    public double giaSauKhiGiam(double x) {
        double giamGia = (x / 100) * this.giaBan;
        return this.giaBan - giamGia;
    }

}
