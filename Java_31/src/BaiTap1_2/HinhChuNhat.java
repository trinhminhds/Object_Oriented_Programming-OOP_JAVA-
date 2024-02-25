package BaiTap1_2;

public class HinhChuNhat {
    private float chieuDai;
    private float chieuRong;
    private ToaDoDiem northWestCorner;

    public HinhChuNhat(ToaDoDiem northWestCorner, float chieuDai, float chieuRong) {
        this.northWestCorner = northWestCorner;
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public float getChieuCao() {
        return chieuDai;
    }

    public void setChieuCao(float chieuDai) {
        this.chieuDai = chieuDai;
    }

    public float getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(float chieuRong) {
        this.chieuRong = chieuRong;
    }

    public ToaDoDiem getToaDoDiem() {
        return northWestCorner;
    }

    public void setToaDoDiem(ToaDoDiem northWestCorner) {
        this.northWestCorner = northWestCorner;
    }


    // Phương thức trả về tọa độ góc Tây Bắc, chiều dài và chiều rộng
    public void getInfo() {
        System.out.println("Tọa độ góc Tây Bắc: (" + northWestCorner.getX() + ", " + northWestCorner.getY() + ")");
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
    }


    //Phương thức tính khoảng cách từ góc Tây Bắc đến gốc tọa độ O
    public double khoangCachGocTayBacDenO() {
        return Math.sqrt(northWestCorner.getX() * northWestCorner.getX() + northWestCorner.getY() * northWestCorner.getY());
    }

    // Phương thức tính khoảng cách từ tâm hình chữ nhật đến gốc tọa độ O
    public double khoangCachTamDenO() {
        double centerX = northWestCorner.getX() + chieuRong / 2.0;
        double centerY = northWestCorner.getY() + chieuDai / 2.0;
        return Math.sqrt(centerX * centerX + centerY * centerY);
    }



}
