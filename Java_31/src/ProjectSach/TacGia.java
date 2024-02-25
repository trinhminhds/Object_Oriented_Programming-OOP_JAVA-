package ProjectSach;

public class TacGia {
    private String tenTacGia;
    private Ngay ngaySinh;

    public TacGia(String tenTacGia, Ngay ngaySinh) {
        this.tenTacGia = tenTacGia;
        this.ngaySinh = ngaySinh;
    }

    public String getTenTacGia() {
        return this.tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public Ngay getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Ngay ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
