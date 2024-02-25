package ProjectPhim;

public class NgayChieu {
    private int Ngay;
    private int Thang;
    private int Nam;

    public NgayChieu(int Ngay, int Thang, int Nam) {

        this.Ngay = Ngay;
        this.Thang = Thang;
        this.Nam = Nam;

    }

    public int getNgay() {
        return this.Ngay;
    }

    public void setNgay(int Ngay) {
        this.Ngay = Ngay;
    }

    public int getThang() {
        return this.Thang;
    }

    public void setThang(int Thang) {
        this.Thang = Thang;
    }

    public int getNam() {
        return this.Nam;
    }

    public void setNam(int Nam) {
        this.Nam = Nam;
    }

}
