package QLSinhVien;

public class NgaySinh {
    private int ngay;
    private int thang;
    private int nam;

    public NgaySinh(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public int getNgay() {
        return this.ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return this.thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return this.nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return false;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NgaySinh other = (NgaySinh) obj;
        if (nam != other.nam)
            return false;
        if (thang != other.thang)
            return false;
        if (ngay != other.ngay)
            return false;
        return true;
    }

}
