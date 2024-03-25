import java.sql.Statement;
import java.time.LocalDate;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormXuLyNhanVien implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane add;

    @FXML
    private Button home_Btn;

    @FXML
    private BarChart<?, ?> home_bieuDo;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_tongNhanVien;

    @FXML
    private Label home_luongTBDoiTuong;

    @FXML
    private ComboBox<?> home_luongTDoiTuongCBox;

    @FXML
    private ComboBox<?> home_luongTBDoiTuongCBox;

    @FXML
    private Label home_luongTBcongty;

    @FXML
    private Label home_luongTDoiTuong;

    @FXML
    private Label home_tuoiTBCTy;

    @FXML
    private Label home_tongNVCV;

    @FXML
    private ComboBox<?> home_tongnvDoiTuongCBox;

    @FXML
    private Button themNhanVien_themBtn;

    @FXML
    private Button themNhanVien_btn;

    @FXML
    private Button themNhanVien_datLaiBtn;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_ngaySinh;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_maNhanVien;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_ho;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_gioiTinh;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_ten;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_SDT;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_chucVu;

    @FXML
    private TableColumn<themNhanVien, String> themNhanVien_col_diaChi;

    @FXML
    private Button themNhanVien_xoaBtn;

    @FXML
    private TextField themNhanVien_maNhanVien;

    @FXML
    private TextField themNhanVien_ho;

    @FXML
    private AnchorPane themNhanVien_form;

    @FXML
    private ComboBox<?> themNhanVien_gioiTinh;

    @FXML
    private TextField themNhanVien_ten;

    @FXML
    private TextField themNhanVien_SDT;

    @FXML
    private TextField themNhanVien_diaChi;

    @FXML
    private DatePicker themNhanVien_ngaySinh;

    @FXML
    private ComboBox<?> themNhanVien_chucVu;

    @FXML
    private TextField themNhanVien_timKiem;

    @FXML
    private TableView<themNhanVien> themNhanVien_bangData;

    @FXML
    private Button themNhanVien_suaBtn;

    @FXML
    private TextField luong_timkiem;

    @FXML
    private Button luong_Btn;

    @FXML
    private Button luong_suaBtn;

    @FXML
    private Button luong_datLaiBtn;

    @FXML
    private TextField luong_maNhanVien;

    @FXML
    private Label luong_ho;

    @FXML
    private AnchorPane luong_form;

    @FXML
    private Label luong_ten;

    @FXML
    private Label luong_chucVu;

    @FXML
    private TextField luong_luong;

    @FXML
    private TableView<luongNhanVien> luong_bangData;

    @FXML
    private TableColumn<luongNhanVien, String> luong_col_maNhanVien;

    @FXML
    private TableColumn<luongNhanVien, String> luong_col_ho;

    @FXML
    private TableColumn<luongNhanVien, String> luong_col_ten;

    @FXML
    private TableColumn<luongNhanVien, String> luong_col_chucVu;

    @FXML
    private TableColumn<luongNhanVien, String> luong_col_luong;

    @FXML
    private Label tenTaiKhoan;

    @FXML
    private Button dangXuat;

    @FXML
    private Button minimize;

    @FXML
    private Button close;

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet resultSet;

    // Đếm tổng số lượng nhân viên
    // Hiện lên các lable trong bảng home
    public void home_totalEmployee() {

        String sql = "SELECT COUNT(manhanvien) AS manhanvien FROM nhanvien";

        connect = connectionData.connectQLNV();

        int countData = 0;

        try {
            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                countData = resultSet.getInt("manhanvien");

            }

            home_tongNhanVien.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Đếm tổng số lượng nhân viên
    // Hiện lên các lable trong bảng home
    public void home_tongNVCV() {

        String sql = "SELECT COUNT(manhanvien) AS manhanvien FROM nhanvien WHERE chucvu = N'"
                + home_tongnvDoiTuongCBox.getSelectionModel().getSelectedItem() + " '";

        connect = connectionData.connectQLNV();
        int countData = 0;

        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                countData = resultSet.getInt("manhanvien");
            }

            home_tongNVCV.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Tính độ tuổi trung bình của công ty
    // Hiện lên các lable trong bảng home
    public void home_tuoiTBCTy() {
        String sql = "SELECT AVG((YEAR(GETDATE()) - YEAR(ngaysinh))) AS dotuoi FROM nhanvien";

        connect = connectionData.connectQLNV();

        int countData = 0;

        try {

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                countData = resultSet.getInt("dotuoi");
            }

            home_tuoiTBCTy.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tính tổng trung bình lương trong công ty
    // Hiện lên các lable trong bảng home
    public void home_luongTBcongty() {
        String sql = "SELECT AVG(luong) AS luong FROM nhanvien";

        connect = connectionData.connectQLNV();

        int countData = 0;

        try {

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                countData = resultSet.getInt("luong");
            }

            home_luongTBcongty.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tính tổng trung bình luong của từng chức vụ
    // Hiện lên các lable trong bảng home
    public void home_luongTBDoiTuong() {

        String sql = "SELECT AVG(luong) AS luong FROM nhanvien WHERE chucvu = N'"
                + home_luongTBDoiTuongCBox.getSelectionModel().getSelectedItem() + "'";

        connect = connectionData.connectQLNV();

        int countData = 0;

        try {

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                countData = resultSet.getInt("luong");
            }

            home_luongTBDoiTuong.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối sau khi sử dụng xong
            try {
                if (connect != null) {
                    connect.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Tính Tổng lương của từng chức vụ
    // Hiện lên các lable trong bảng home
    public void home_luongTDoiTuong() {

        String sql = "SELECT SUM(luong) AS luong FROM nhanvien WHERE chucvu = N'"
                + home_luongTDoiTuongCBox.getSelectionModel().getSelectedItem() + "' ";

        connect = connectionData.connectQLNV();

        int countData = 0;

        try {

            statement = connect.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                countData = resultSet.getInt("luong");
            }

            home_luongTDoiTuong.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (connect != null) {
                    connect.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Tính 10 người có độ tuổi lớn nhất ở công ty
    // Hiện lên trong biểu đồ ở Form home
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void home_bieuDo() {
        home_bieuDo.getData().clear();

        String sql = "SELECT TOP 10 ho + ' ' + ten AS hoten,(YEAR(GETDATE()) - YEAR(ngaysinh)) AS tuoi FROM nhanvien ORDER BY tuoi DESC";

        connect = connectionData.connectQLNV();

        try {

            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                chart.getData().add(new XYChart.Data(resultSet.getString(1), resultSet.getInt(2)));
            }

            home_bieuDo.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * Thêm nhân viên
     * Nếu ta bấm vào nút thêm nhân viên trong Form thêm nhân viên thì sẽ thêm nhân
     * viên 1 trong data
     */
    public void themNhanVien_themBtn() {

        // câu lệnh sql thêm dữ liệu
        String sql = "INSERT INTO nhanvien "
                + "(manhanvien,ho,ten,gioitinh,sodienthoai,chucvu,diachi,ngaysinh)"
                + "VALUES(?,?,?,?,?,?,?,?)";

        // kết nối sql server
        connect = connectionData.connectQLNV();

        try {
            Alert alert;

            // Kiểm tra điều kiện nếu người dùng để trong sẽ in ra dòng thông báo
            if (themNhanVien_maNhanVien.getText().isEmpty()
                    || themNhanVien_ho.getText().isEmpty()
                    || themNhanVien_ten.getText().isEmpty()
                    || themNhanVien_gioiTinh.getSelectionModel().getSelectedItem() == null
                    || themNhanVien_col_SDT.getText().isEmpty()
                    || themNhanVien_chucVu.getSelectionModel().getSelectedItem() == null
                    || themNhanVien_ngaySinh.getValue().toString().isEmpty()
                    || themNhanVien_diaChi.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập đầy đủ thông tin");
                alert.showAndWait();

            } else {

                String check = "SELECT manhanvien FROM nhanvien WHERE manhanvien = '"
                        + themNhanVien_maNhanVien.getText() + "'";
                // Thực hiện câu lệnh sql
                statement = connect.createStatement();
                resultSet = statement.executeQuery(check);

                // Nếu Mã nhân viên đã có trong dữ liệu thì in ra dòng thông báo
                if (resultSet.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Mã nhân viên: " + themNhanVien_maNhanVien.getText()
                            + " này đã được sử dụng vui lòng nhập mã khác!");
                    alert.showAndWait();

                } else {

                    prepare = connect.prepareStatement(sql);
                    // gắn các giá trị vào các cột
                    prepare.setString(1, themNhanVien_maNhanVien.getText());
                    prepare.setString(2, themNhanVien_ho.getText());
                    prepare.setString(3, themNhanVien_ten.getText());
                    prepare.setString(4, (String) themNhanVien_gioiTinh.getSelectionModel().getSelectedItem());
                    prepare.setString(5, themNhanVien_SDT.getText());
                    prepare.setString(6, (String) themNhanVien_chucVu.getSelectionModel().getSelectedItem());
                    prepare.setString(7, themNhanVien_diaChi.getText());
                    prepare.setString(8, themNhanVien_ngaySinh.getValue().toString());

                    // thực hiện câu lệnh
                    prepare.executeUpdate();

                    themNhanVien_hienThiListData();// hiển thị
                    themNhanVien_datLaiBtn();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * Sửa thông tin nhân viên
     * Nếu ta bấm vào nút sửa trong Form thêm nhân viên thì ta sẽ cập nhật thông tin
     * của 1 nhân viên nào đó
     */
    public void themNhanVien_suaBtn() {

        // gắn các giá trị vào điều kiện của sql
        String sql = "UPDATE nhanvien SET ho = N'" + themNhanVien_ho.getText() + "', " +
                "ten = N'" + themNhanVien_ten.getText() + "', " +
                "gioitinh = N'" + themNhanVien_gioiTinh.getSelectionModel().getSelectedItem() + "', " +
                "sodienthoai = N'" + themNhanVien_SDT.getText() + "', " +
                "chucvu = N'" + themNhanVien_chucVu.getSelectionModel().getSelectedItem() + "', " +
                "diachi = N'" + themNhanVien_diaChi.getText() + "', " +
                "ngaysinh = N'" + themNhanVien_ngaySinh.getValue() + "' " +
                "WHERE manhanvien = N'" + themNhanVien_maNhanVien.getText() + "'";

        connect = connectionData.connectQLNV();

        try {
            Alert alert;

            // kiểm tra mã nhân viên người dùng có để trống hay không
            if (themNhanVien_maNhanVien.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập mã nhân viên");
                alert.showAndWait();

            } else {
                // hỏi lại 1 lần nữa người dùng có muốn sửa không
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Bạn có muốn sửa thông tin của nhân viên : " + themNhanVien_maNhanVien.getText() + " không ?");
                Optional<ButtonType> option = alert.showAndWait();

                // Nếu người dùng bấm ok thì thực hiện câu lệnh
                if (option.get().equals(ButtonType.OK)) {

                    // thực hiện câu lệnh sql
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Sửa thành công!");
                    alert.showAndWait();

                    themNhanVien_hienThiListData();// hiển thị bảng dữ liệu
                    themNhanVien_datLaiBtn();// nếu đã thêm thành công thì các giá trị điền trước đó sẽ bị xóa
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * Xóa Nhân Viên
     * Nếu bấm vào nút xóa trong Form thêm nhân viên thì 1 dữ liệu của nhân viên sẽ
     * bị xóa khỏi data
     */
    public void themNhanVien_xoaBtn() {

        String sql = "DELETE FROM nhanvien WHERE manhanvien = '" + themNhanVien_maNhanVien.getText() + "'";

        connect = connectionData.connectQLNV();

        try {

            Alert alert;
            // Kiểm tra điều kiện người dùng đã nhập mã nhân viên hay chưa nếu chưa in ra
            // dòng thông báo
            if (themNhanVien_maNhanVien.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập mã nhân viên");
                alert.showAndWait();

            } else {
                // Hỏi lại người dùng 1 lần nữa có muốn xóa hay không
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn thật sự muốn xóa nhân viên này: "
                        + themNhanVien_maNhanVien.getText() + "không ?");

                Optional<ButtonType> option = alert.showAndWait();

                // Nếu người dùng bấm OK thì dữ liệu của mã nhân viên sẽ bị xóa
                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Xóa thành công!");
                    alert.showAndWait();

                    themNhanVien_hienThiListData(); // hiển thị danh sách nhân viên trong bảng
                    themNhanVien_datLaiBtn();// nếu xóa thành công thì dữ liệu nhập trước đó sẽ bị xóa
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Đặt lại Nhân viên viên
     * Nếu ta bấm vào nút đặt lại thì toàn bộ thông tin ta nhập trước đó sẽ bị xóa
     */
    public void themNhanVien_datLaiBtn() {
        themNhanVien_maNhanVien.setText("");
        themNhanVien_ho.setText("");
        themNhanVien_ten.setText("");
        themNhanVien_gioiTinh.getSelectionModel().clearSelection();// đây là lựa chọn nên ta sẽ xóa lựa chọn đó
        themNhanVien_chucVu.getSelectionModel().clearSelection();
        themNhanVien_SDT.setText("");
        themNhanVien_ngaySinh.setValue(null);
        themNhanVien_diaChi.setText("");
    }

    /*
     * Tìm Kiếm Nhân Viên
     * Nếu điền vào ô tìm kiếm ở form thêm nhân viên thì bảng danh sách nhân viên sẽ
     * tự động lọc
     * cho ta những nhân viên có kí tự mà ta đã điền ở trên
     */
    public void themNhanVien_timKiem() {

        // Tạo một FilteredList mới, nó chứa danh sách nhân viên ban đầu
        // themNhanVien_List.
        FilteredList<themNhanVien> locTimKiem = new FilteredList<>(themNhanVien_List, e -> true);

        // Mỗi khi nội dung của trường này thay đổi, sự kiện này sẽ được kích hoạt.
        themNhanVien_timKiem.textProperty().addListener((ObservableList, giaTriCu, giaTriMoi) -> {

            // Đặt một bộ lọc cho locTimKiem. Mỗi mục trong danh sách locTimKiem sẽ được
            // kiểm tra bởi bộ lọc này.
            locTimKiem.setPredicate(locNhanSu -> {

                // Nếu từ khoá tìm kiếm (giaTriMoi) là rỗng hoặc null, tất cả các mục sẽ được
                // hiển thị.
                if (giaTriMoi == null || giaTriMoi.isEmpty()) {
                    return true;
                }

                // Nếu một trong các trường của mục chứa từ khoá tìm kiếm (chuyển thành chữ
                // thường để so sánh), mục đó sẽ được hiển thị.

                String tuKhoaTimKiem = giaTriMoi.toLowerCase();

                if (locNhanSu.getMaNhanVien().toString().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (locNhanSu.getHo().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (locNhanSu.getTen().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (locNhanSu.getGioiTinh().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (locNhanSu.getChucVu().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (locNhanSu.getSoDienThoai().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (locNhanSu.getNgaySinh().toString().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (locNhanSu.getDiaChi().toString().contains(tuKhoaTimKiem)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        // Tạo một SortedList từ locTimKiem, để sắp xếp các mục dựa trên một bộ so sánh
        // đã được chỉ định.
        SortedList<themNhanVien> sortedList = new SortedList<>(locTimKiem);

        // Liên kết bộ so sánh của sortedList với bộ so sánh của themNhanVien_bangData
        // (chắc chắn rằng cả hai sẽ được sắp xếp theo cùng một cách)
        sortedList.comparatorProperty().bind(themNhanVien_bangData.comparatorProperty());

        // Đặt danh sách hiển thị của bảng (hoặc danh sách) hiển thị nhân viên thành
        // sortedList,
        // do đó chỉ các mục đã được lọc và sắp xếp sẽ được hiển thị
        themNhanVien_bangData.setItems(sortedList);

    }

    // danh sách các chức vụ
    private String[] listChucVu = { "Công nhân", "Chuyên gia nước ngoài", "Kỹ sư", "Nhân viên", "Thực tập sinh",
            "Lao động phổ thông", "Người làm bán thời gian", "Cán bộ quản lý", "Nhân sự thử việc" };

    // Gắn danh sách chức vụ vào combobox
    @SuppressWarnings("unchecked")
    public void home_luongTDoiTuongComB() {

        List<String> listP = new ArrayList<>();

        for (String data : listChucVu) {
            listP.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listData = FXCollections.observableArrayList(listP);
        home_luongTDoiTuongCBox.setItems(listData);

    }

    // Gắn danh sách chức vụ vào combobox
    @SuppressWarnings("unchecked")
    public void home_luongTBDoiTuongComB() {

        List<String> listP = new ArrayList<>();

        for (String data : listChucVu) {
            listP.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listData = FXCollections.observableArrayList(listP);
        home_luongTBDoiTuongCBox.setItems(listData);

    }

    // Gắn danh sách chức vụ vào combobox
    @SuppressWarnings("unchecked")
    public void home_tongNVCVComB() {

        List<String> listP = new ArrayList<>();

        for (String data : listChucVu) {
            listP.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listData = FXCollections.observableArrayList(listP);
        home_tongnvDoiTuongCBox.setItems(listData);

    }

    // Gắn danh sách chức vụ vào combobox
    @SuppressWarnings("unchecked")
    public void themNhanVien_chucVuCombox() {

        List<String> listP = new ArrayList<>();

        for (String data : listChucVu) {
            listP.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listData = FXCollections.observableArrayList(listP);
        themNhanVien_chucVu.setItems(listData);

    }

    // danh sách các giới tính
    private String[] listGioiTinh = { "Nam", "Nữ", "Khác" };

    // gắn danh sách giới tính vào combobox
    @SuppressWarnings("unchecked")
    public void themNhanVien_gioiTinhcombox() {
        List<String> listG = new ArrayList<>();

        for (String data : listGioiTinh) {
            listG.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listGenderData = FXCollections.observableArrayList(listG);
        themNhanVien_gioiTinh.setItems(listGenderData);

    }

    /*
     * Lấy dữ liệu danh sách nhân viên mà ta thực hiện câu lệnh sql trong bảng nhân
     * viên
     */
    public ObservableList<themNhanVien> themNhanVien_listData() {

        ObservableList<themNhanVien> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM nhanvien";

        connect = connectionData.connectQLNV();

        try {

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            themNhanVien nhanVien_data;

            while (resultSet.next()) {

                nhanVien_data = new themNhanVien(resultSet.getString("manhanvien"),
                        resultSet.getString("ho"),
                        resultSet.getString("ten"),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("sodienthoai"),
                        resultSet.getString("chucvu"),
                        resultSet.getString("diachi"),
                        resultSet.getDate("ngaysinh"));

                listData.add(nhanVien_data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<themNhanVien> themNhanVien_List;

    /*
     * Hiển thị danh sách nhân viên trong table view
     * Lấy tất cả dữ liệu mà ta thực hiện câu lệnh sql trong bảng nhân viên gán vào
     * table view
     */
    public void themNhanVien_hienThiListData() {

        themNhanVien_List = themNhanVien_listData();

        // gắn dữ liệu vào từng cột trong table view trong form thêm nhân viên
        themNhanVien_col_maNhanVien.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
        themNhanVien_col_ho.setCellValueFactory(new PropertyValueFactory<>("ho"));
        themNhanVien_col_ten.setCellValueFactory(new PropertyValueFactory<>("ten"));
        themNhanVien_col_gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        themNhanVien_col_SDT.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
        themNhanVien_col_chucVu.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
        themNhanVien_col_diaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        themNhanVien_col_ngaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));

        themNhanVien_bangData.setItems(themNhanVien_List);

    }

    /*
     * Tìm Kiếm Nhân Viên
     * Nếu điền vào ô tìm kiếm ở form thêm nhân viên thì bảng danh sách nhân viên sẽ
     * tự động lọc
     * cho ta những nhân viên có kí tự mà ta đã điền ở trên
     */
    public void luong_timKiem() {

        // Tạo một FilteredList mới, nó chứa danh sách nhân viên ban đầu
        // themNhanVien_List.
        FilteredList<luongNhanVien> locTimKiem = new FilteredList<>(luong_List, e -> true);

        // Mỗi khi nội dung của trường này thay đổi, sự kiện này sẽ được kích hoạt.
        luong_timkiem.textProperty().addListener((ObservableList, giaTriCu, giaTriMoi) -> {

            // Đặt một bộ lọc cho locTimKiem. Mỗi mục trong danh sách locTimKiem sẽ được
            // kiểm tra bởi bộ lọc này.
            locTimKiem.setPredicate(predicateEmployeeData -> {

                // Nếu từ khoá tìm kiếm (giaTriMoi) là rỗng hoặc null, tất cả các mục sẽ được
                // hiển thị.
                if (giaTriMoi == null || giaTriMoi.isEmpty()) {
                    return true;
                }

                // Nếu một trong các trường của mục chứa từ khoá tìm kiếm (chuyển thành chữ
                // thường để so sánh), mục đó sẽ được hiển thị.
                String tuKhoaTimKiem = giaTriMoi.toLowerCase();

                if (predicateEmployeeData.getMaNhanVien().toString().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getHo().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getTen().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getChucVu().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (String.valueOf(predicateEmployeeData.getLuong()).contains(tuKhoaTimKiem)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        // Tạo một SortedList từ locTimKiem, để sắp xếp các mục dựa trên một bộ so sánh
        // đã được chỉ định.
        SortedList<luongNhanVien> sortedList = new SortedList<>(locTimKiem);

        // Liên kết bộ so sánh của sortedList với bộ so sánh của themNhanVien_bangData
        // (chắc chắn rằng cả hai sẽ được sắp xếp theo cùng một cách)
        sortedList.comparatorProperty().bind(luong_bangData.comparatorProperty());

        // Đặt danh sách hiển thị của bảng (hoặc danh sách) hiển thị nhân viên thành
        // sortedList,
        // do đó chỉ các mục đã được lọc và sắp xếp sẽ được hiển thị
        luong_bangData.setItems(sortedList);

    }

    /*
     * Sửa thông tin nhân viên
     * Nếu ta bấm vào nút sửa trong Form lương nhân viên thì ta sẽ cập nhật thông
     * tin
     * của 1 nhân viên nào đó
     */
    public void luong_sua() {

        String sql = "UPDATE nhanvien SET luong = N'" + luong_luong.getText()
                + "' WHERE manhanvien = N'" + luong_maNhanVien.getText() + "'";

        connect = connectionData.connectQLNV();

        try {
            Alert alert;

            // kiểm tra điều kiện giá trị rỗng hoặc null
            if (luong_maNhanVien.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập mã nhân viên");
                alert.showAndWait();

            } else {

                // thực hiện câu lệnh sql
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Infomation Message");
                alert.setHeaderText(null);
                alert.setContentText("Sửa thành công!");
                alert.showAndWait();

                luong_datLai();// đặt lại khi ta sửa thành công
                luong_hienThiListData(); // hiển thị danh sách nhân viên
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Đặt lại Nhân viên viên
     * Nếu ta bấm vào nút đặt lại thì toàn bộ thông tin ta nhập trước đó sẽ bị xóa
     */
    public void luong_datLai() {
        luong_maNhanVien.setText("");
        luong_ho.setText("");
        luong_ten.setText("");
        luong_chucVu.setText("");
        luong_luong.setText("");
    }

    /*
     * Lấy dữ liệu danh sách nhân viên mà ta thực hiện câu lệnh sql trong bảng nhân
     * viên
     */
    public ObservableList<luongNhanVien> luong_ListData() {

        ObservableList<luongNhanVien> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM nhanvien";
        connect = connectionData.connectQLNV();

        try {

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            luongNhanVien nhanVien_data;
            while (resultSet.next()) {
                nhanVien_data = new luongNhanVien(resultSet.getString("manhanvien"),
                        resultSet.getString("ho"),
                        resultSet.getString("ten"),
                        resultSet.getString("chucvu"),
                        resultSet.getInt("luong"));

                listData.add(nhanVien_data);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<luongNhanVien> luong_List;

    /*
     * Hiển thị danh sách nhân viên trong table view
     * Lấy tất cả dữ liệu mà ta thực hiện câu lệnh sql trong bảng nhân viên gán vào
     * table view
     */
    public void luong_hienThiListData() {

        luong_List = luong_ListData();

        luong_col_maNhanVien.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
        luong_col_ho.setCellValueFactory(new PropertyValueFactory<>("ho"));
        luong_col_ten.setCellValueFactory(new PropertyValueFactory<>("ten"));
        luong_col_chucVu.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
        luong_col_luong.setCellValueFactory(new PropertyValueFactory<>("luong"));

        luong_bangData.setItems(luong_List);
    }

    /*
     * Màu mặc định ta vào form chính thì hiện ra các màu này
     */
    public void mauMacDinh() {

        // các dòng lệnh ngôn ngữ css thêm màu cho nút Home
        home_Btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);" +
                "-fx-background-radius: 15px;");

        themNhanVien_btn.setStyle("-fx-background-color:transparent;"
                + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                "  -fx-border-radius: 15px;");

        luong_Btn.setStyle("-fx-background-color:transparent;"
                + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                "  -fx-border-radius: 15px;");
    }

    /*
     * Sự kiện Chuyển Form
     */
    public void chuyen_Form(ActionEvent event) {

        // nếu ta bấm vào nút home thì sẽ hiện ra Form Home
        if (event.getSource() == home_Btn) {

            home_form.setVisible(true);
            themNhanVien_form.setVisible(false);
            luong_form.setVisible(false);

            // Màu của nút home sẽ được hiện ra
            // Các nút còn lại sẽ bị ẩn màu đi
            home_Btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);" +
                    "-fx-background-radius: 15px;");
            themNhanVien_btn.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                    "  -fx-border-radius: 15px;");
            luong_Btn.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                    "  -fx-border-radius: 15px;");

            // các giá trị này sẽ thực hiện ở bảng này
            home_totalEmployee();
            home_tongNVCV();
            home_tuoiTBCTy();
            home_bieuDo();
            home_luongTBDoiTuong();
            home_luongTBcongty();
            home_luongTDoiTuong();
            home_tongNVCVComB();
            home_luongTDoiTuongComB();
            home_luongTBDoiTuongComB();
            home_luongTBOnMouseClick();
            home_luongTongDTOnMouseClick();
            home_tongNVCVOnMouseClick();

            // nếu ta bấm vào nút thêm nhân viên viên thì hiện ra Form thêm nhân viên
        } else if (event.getSource() == themNhanVien_btn) {

            home_form.setVisible(false);
            themNhanVien_form.setVisible(true);
            luong_form.setVisible(false);

            // Màu của nút Thêm nhân viên sẽ hiện màu
            // còn cá nút còn lại sẽ bị ẩn màu đi
            themNhanVien_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);" +
                    "-fx-background-radius: 15px;");
            home_Btn.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                    "  -fx-border-radius: 15px;");
            luong_Btn.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                    "  -fx-border-radius: 15px;");

            // các giá trị này sẽ thực hiện ở bảng này
            themNhanVien_gioiTinhcombox();
            themNhanVien_chucVuCombox();
            themNhanVien_timKiem();
            themNhanVien_OnMouseClickTable();

            // Nếu ta bấm vào nút lương thì hiện ra Form Lương nhân viên
        } else if (event.getSource() == luong_Btn) {

            home_form.setVisible(false);
            themNhanVien_form.setVisible(false);
            luong_form.setVisible(true);

            // Màu của nút Lương nhân viên sẽ hiện màu
            // còn cá nút còn lại sẽ bị ẩn màu đi
            luong_Btn.setStyle(
                    "-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);" +
                            "-fx-background-radius: 15px;");

            themNhanVien_btn.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                    "  -fx-border-radius: 15px;");

            home_Btn.setStyle("-fx-background-color:transparent;"
                    + "-fx-border-color: linear-gradient(to bottom right, #272b3f, #256b51);" +
                    "  -fx-border-radius: 15px;");

            // các giá trị này sẽ thực hiện ở bảng này
            luong_hienThiListData();
            luong_OnMouseClickTable();
            luong_timKiem();
        }

    }

    // Nếu cick vào hàng nào trong table view trong bảng thêm nhân viên thì sẽ các
    // giá trị sẽ hiện lên các TextFiel
    public void themNhanVien_OnMouseClickTable() {

        themNhanVien_bangData.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                themNhanVien nhanVien_data = themNhanVien_bangData.getSelectionModel().getSelectedItem();
                if (nhanVien_data != null) {

                    themNhanVien_maNhanVien.setText(nhanVien_data.getMaNhanVien());
                    themNhanVien_ho.setText(nhanVien_data.getHo());
                    themNhanVien_ten.setText(nhanVien_data.getTen());
                    themNhanVien_gioiTinh.getSelectionModel().getSelectedItem();
                    themNhanVien_SDT.setText(nhanVien_data.getSoDienThoai());
                    themNhanVien_chucVu.getSelectionModel().getSelectedItem();
                    themNhanVien_diaChi.setText(nhanVien_data.getDiaChi());
                    Date ngaySinh = nhanVien_data.getNgaySinh();
                    LocalDate localDate = sqlDateToLocalDate(ngaySinh);
                    themNhanVien_ngaySinh.setValue(localDate);
                }
            }
        });

    }

    // Nếu cick vào hàng nào trong bảng dữ liệu trong Lương nhân viên thì sẽ các giá
    // trị sẽ hiện lên các TextFiel
    public void luong_OnMouseClickTable() {

        luong_bangData.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                luongNhanVien nhanVien_data = luong_bangData.getSelectionModel().getSelectedItem();
                if (nhanVien_data != null) {

                    luong_maNhanVien.setText(nhanVien_data.getMaNhanVien());
                    luong_ho.setText(nhanVien_data.getHo());
                    luong_ten.setText(nhanVien_data.getTen());
                    luong_chucVu.setText(nhanVien_data.getChucVu());
                    luong_luong.setText(String.valueOf(nhanVien_data.getLuong()));

                }
            }
        });

    }

    // chọn đối tượng cho home_luongTBDoiTuong
    public void home_luongTBOnMouseClick() {
        home_luongTBDoiTuongCBox.setOnAction(event -> {
            home_luongTBDoiTuong();
        });
    }

    // Chọn đối tượng cho biến home_luongTDoiTuong
    public void home_luongTongDTOnMouseClick() {
        home_luongTDoiTuongCBox.setOnAction(event -> {
            home_luongTDoiTuong();
        });
    }

    // Chọn đối tượng cho biến home_luongTDoiTuong
    public void home_tongNVCVOnMouseClick() {
        home_tongnvDoiTuongCBox.setOnAction(event -> {
            home_tongNVCV();
        });
    }

    // Chuyển đổi kiểu dữ liệu
    public LocalDate sqlDateToLocalDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }

    private double x = 0;
    private double y = 0;

    /*
     * Nếu bấm vào nút đăng xuất thì sẽ chuyển từ Form này sang Form
     * FormDangNhap.fxml
     */
    public void dangXuat() {

        // Dòng thông báo cho người dùng nếu thoát bấm ok không thì vẫn ở lại form này
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Bạn thật sự muốn đăng xuất chứ ?");
        Optional<ButtonType> option = alert.showAndWait();
        try {

            // Nếu người dùng bấm ok thì thoát, còn không thì vẫn ở lại form này
            if (option.get().equals(ButtonType.OK)) {

                dangXuat.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FormDangNhap.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getSceneX() - x);
                    stage.setY(event.getSceneY() - y);
                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {

                    stage.setOpacity(1);

                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // đóng màn hình trên màn hình chính
    public void close() {
        System.exit(0);
    }

    // thu màn hình
    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mauMacDinh();

        home_totalEmployee();
        home_tongNVCV();
        home_tuoiTBCTy();
        home_bieuDo();
        home_luongTBDoiTuong();
        home_luongTBcongty();
        home_luongTDoiTuong();
        home_luongTBDoiTuongComB();
        home_luongTDoiTuongComB();
        home_tongNVCVComB();
        home_luongTBOnMouseClick();
        home_luongTongDTOnMouseClick();
        home_luongTBOnMouseClick();

        themNhanVien_gioiTinhcombox();
        themNhanVien_chucVuCombox();
        themNhanVien_hienThiListData();
        themNhanVien_OnMouseClickTable();

        luong_hienThiListData();
        luong_OnMouseClickTable();
    }
}
