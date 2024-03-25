import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FormDangNhap implements Initializable {

    @FXML
    private Button close;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginBtn;

    @FXML
    private Hyperlink dn_dangky;

    @FXML
    private CheckBox dn_chonHienMatKhau;

    @FXML
    private TextField dn_hienMatKhau;

    @FXML
    private Hyperlink dn_quenMatKhau;

    @FXML
    private AnchorPane dangky_form;

    @FXML
    private AnchorPane dangnhap_form;

    @FXML
    private ComboBox<?> dk_cauHoi;

    @FXML
    private Button dk_close;

    @FXML
    private Button dk_dangKyBtn;

    @FXML
    private Hyperlink dk_dangnhap;

    @FXML
    private TextField dk_email;

    @FXML
    private CheckBox dk_chonHienMatKhau;

    @FXML
    private TextField dk_hienMatKhau;

    @FXML
    private TextField dk_hienXacNhanMK;

    @FXML
    private PasswordField dk_matkhau;

    @FXML
    private TextField dk_sodienthoai;

    @FXML
    private TextField dk_taikhoan;

    @FXML
    private TextField dk_traLoiCauHoi;

    @FXML
    private PasswordField dk_xacnhanmk;

    @FXML
    private ComboBox<?> dmk_cauHoi;

    @FXML
    private AnchorPane main_form;

    @FXML
    private ComboBox<?> qmk_cauHoi;

    @FXML
    private Button qmk_close;

    @FXML
    private TextField qmk_email;

    @FXML
    private Button qmk_layLaiMatKhauBtn;

    @FXML
    private TextField qmk_soDienThoai;

    @FXML
    private TextField qmk_taiKhoan;

    @FXML
    private TextField qmk_traLoiCauHoi;

    @FXML
    private Button qmk_troVeBtn;

    @FXML
    private AnchorPane quenMatKhau_form;

    @FXML
    private Button dmk_close;

    @FXML
    private Button dmk_dangNhapBtn;

    @FXML
    private Button dmk_doiMatKhauBtn;

    @FXML
    private CheckBox dmk_chonHienMatKhau;

    @FXML
    private TextField dmk_hienMatKhau;

    @FXML
    private TextField dmk_hienXacNhanMK;

    @FXML
    private PasswordField dmk_matKhau;

    @FXML
    private TextField dmk_traLoiCauHoi;

    @FXML
    private PasswordField dmk_xacNhanMK;

    @FXML
    private AnchorPane doiMatKhau_form;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet resultSet;
    private Statement statement;

    private double x = 0;
    private double y = 0;

    /*
     * Form đăng nhập nếu ta điền đúng các giá trị thì ta sẽ đi vào Form chính
     */
    public void loginAdmin() {

        // câu lệnh sql
        String sql = "SELECT * FROM Login WHERE username = ? AND password = ?";

        // kết nối sql server
        connect = connectionData.connectDangNhap();

        // Ẩn hiện mật khẩu
        if (dn_chonHienMatKhau.isSelected()) {
            password.setText(dn_hienMatKhau.getText());
        } else {
            dn_hienMatKhau.setText(password.getText());
        }

        try {

            // Truyền vào câu lệnh sql
            prepare = connect.prepareStatement(sql);

            // Gắn vào các cột tương ứng
            prepare.setString(1, userName.getText());
            prepare.setString(2, password.getText());

            // Thực hiện câu lệnh sql
            resultSet = prepare.executeQuery();

            Alert alert;

            // Kiểm tra điều kiện nếu người dùng để trống thì in ra dòng thông báo
            if (userName.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập đầy đủ thông tin");
                alert.showAndWait();

                // Nếu các giá trị điền là đúng thì in ra dòng thông báo
            } else {
                if (resultSet.next()) {

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng nhập thành công!");
                    alert.showAndWait();

                    // Nếu ta bấm vào nút đăng nhập và đăng nhập thành công thì chuyển từ Form này
                    // -> FormXuLyNhanVien.fxml
                    loginBtn.getScene().getWindow().hide(); // ẩn đi form này
                    Parent root = FXMLLoader.load(getClass().getResource("FormXuLyNhanVien.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    // Đây là sự kiện khi chuột được nhấn vào cửa sổ (root là một Node, chẳng hạn
                    // như một pane hoặc một control).
                    // Khi chuột được nhấn, vị trí x và y của sự kiện được lưu lại, dùng để tính
                    // toán vị trí mới khi di chuyển cửa sổ.
                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    // Đây là sự kiện khi chuột được di chuyển trên cửa sổ.
                    // Khi chuột được kéo, vị trí của cửa sổ được cập nhật dựa trên sự khác biệt
                    // giữa vị trí hiện tại của
                    // chuột và vị trí được lưu trữ khi chuột được nhấn.
                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getSceneX() - x);
                        stage.setY(event.getSceneY() - y);
                        stage.setOpacity(.8);
                    });

                    // Đây là sự kiện khi chuột được nhả ra sau khi di chuyển.
                    // Khi chuột được nhả ra, độ mờ của cửa sổ được đặt lại thành 1 (không mờ).
                    root.setOnMouseReleased((MouseEvent event) -> {
                        stage.setOpacity(1);
                    });

                    // Đặt kiểu của Stage thành TRANSPARENT, điều này làm cho khung viền của cửa sổ
                    // không hiển thị.
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();

                    // Ngược lại nếu các giá trị điền không đúng thì in ra dòng thông báo
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn đã nhập sai tài khoản hoặc mật khẩu. Vui lòng nhập lại!");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Các biến để kiểm tra
    private ResultSet resultSet_email, resultSet_sdt;

    /*
     * Form đăng ký
     * Giúp người dùng đăng kí 1 tài khoản để đăng nhập vào hệ thống
     * Dòng lệnh này thực hiện khi ta bấm vào nút Đăng Ký
     */
    public void logup() {

        // Ẩn hiện mật khẩu
        if (dk_chonHienMatKhau.isSelected()) {
            dk_matkhau.setText(dk_hienMatKhau.getText());
            dk_xacnhanmk.setText(dk_hienXacNhanMK.getText());
        } else {
            dk_hienMatKhau.setText(dk_matkhau.getText());
            dk_hienXacNhanMK.setText(dk_xacnhanmk.getText());
        }

        try {

            Alert alert;

            // Kiểm tra người dùng có để trống hay không nếu có thì ra dòng thông báo
            if (dk_taikhoan.getText().isEmpty() || dk_matkhau.getText().isEmpty()
                    || dk_email.getText().isEmpty() || dk_sodienthoai.getText().isEmpty()
                    || dk_cauHoi.getSelectionModel().getSelectedItem() == null
                    || dk_traLoiCauHoi.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập đầy đủ thông tin");
                alert.showAndWait();

                // Kiểm tra điều kiện mật khẩu nếu mật khẩu có độ dài nhỏ hơn 8 hoặc lớn hơn 16
                // thì in ra dòng thông báo
            } else if (dk_matkhau.getText().length() < 8 || dk_matkhau.getText().length() > 16) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Mật khẩu của bạn phải lớn hơn hoặc bằng 8 và phải nhỏ hơn hoặc bằng 16 ký tự, số");
                alert.showAndWait();

                // Kiểm tra điều kiện nếu xác nhận mật khẩu không bằng mật khẩu thì in ra dòng
                // thông báo
            } else if (!dk_matkhau.getText().equals(dk_xacnhanmk.getText())) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Mật khẩu không hợp lệ");
                alert.showAndWait();

                // Kiểm tra điều kiện nếu email không đúng định dạnh thì in ra dòng thông báo
            } else if (!dk_email.getText().matches(".*\\.(com)$") || dk_email.getText().matches(".*\\.((com)\\.vn)$")) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Email không hợp lệ đuôi email phải là .com hoặc .com.vn");
                alert.showAndWait();

                // Kiểm tra độ dài của số điện thoại nếu nhỏ hơn 10 hoặc lớn hơn 11 thì in ra
                // dòng thông báo
            } else if (dk_sodienthoai.getText().length() < 10 || dk_sodienthoai.getText().length() > 11) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Số điện thoại phải lớn hơn hoặc bằng 10 và nhỏ hơn hoặc bằng 11 số");
                alert.showAndWait();

            } else {

                // các câu lệnh in ra bảng dữ liệu trong sql
                String checkTaiKhoan = "SELECT * FROM Login WHERE username = '" + dk_taikhoan.getText() + "' ";
                String checkEmail = "SELECT * FROM Login WHERE email = '" + dk_email.getText() + "' ";
                String checkSdt = "SELECT * FROM Login WHERE sodienthoai = '" + dk_sodienthoai.getText() + "' ";

                // Kết nối sql
                connect = connectionData.connectDangNhap();

                // Thực hiện các dòng lệnh sql
                statement = connect.createStatement();
                resultSet = statement.executeQuery(checkTaiKhoan);

                statement = connect.createStatement();
                resultSet_email = statement.executeQuery(checkEmail);

                statement = connect.createStatement();
                resultSet_sdt = statement.executeQuery(checkSdt);

                // Nếu người dùng nhập tên 1 tài khoản đã có trong dữ liệu thì in ra dòng thông
                // báo
                if (resultSet.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tài Khoản này đã có người sử dụng. Mời bạn chọn tài khoản khác");
                    alert.showAndWait();
                    // Kiểm tra điều kiện email nãy đã có trong dữ liệu hay chưa nếu có thì in ra
                    // dòng thông báo
                } else if (resultSet_email.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Email này đã được đăng ký. Mời bạn chọn Email khác");
                    alert.showAndWait();
                    // Kiểm tra điều kiện nếu Số điện thoại này đã được đăng ký thì in ra dòng thông
                    // báo
                } else if (resultSet_sdt.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Số điện thoại này đã được đăng ký. Mời bạn chọn số điện thoại khác");
                    alert.showAndWait();
                } else {

                    // dòng lệnh thêm dữ liệu trong sql
                    // N'' có nghĩa mã hóa được tiếng khi ta thêm vào dữ liệu không bị lỗi
                    String sql = "INSERT INTO Login"
                            + "(username,password,email,sodienthoai,cauhoi,traloicauhoi)"
                            + "VALUES (?,?,?,?,N'?',N'?')";

                    // gắn câu lệnh sql vào
                    prepare = connect.prepareStatement(sql);
                    // gắn các giá trị vào các cột tương ứng
                    prepare.setString(1, dk_taikhoan.getText());
                    prepare.setString(2, dk_matkhau.getText());
                    prepare.setString(3, dk_email.getText());
                    prepare.setString(4, dk_sodienthoai.getText());
                    prepare.setString(5, (String) dk_cauHoi.getSelectionModel().getSelectedItem());
                    prepare.setString(6, dk_traLoiCauHoi.getText());
                    // thực hiện câu lệnh sql nếu thành công in ra dòng thông báo
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng ký thành công!");
                    alert.showAndWait();

                    // nếu đăng ký thành công thì sẽ xóa đi các giá trị cũ đã điền trước đó
                    dangKyClearFields();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Các biến để check từ từng giá trị
    private ResultSet resultSet_qmk_email, resultSet_qmk_sdt, resultSet_qmk_taiKhoan, resultSet_qmk_cauHoi,
            resultSet_qmk_traLoi;

    /*
     * Form quên mật khẩu khi người dùng điền đúng các giá trị sẽ chuyển tới Form
     * đổi mật khẩu
     */
    public void quenMatKhau() {

        Alert alert;

        // Kiểm tra các giá trị có để trống không
        if (qmk_taiKhoan.getText().isEmpty()
                || qmk_email.getText().isEmpty()
                || qmk_soDienThoai.getText().isEmpty()
                || qmk_cauHoi.getSelectionModel().getSelectedItem() == null
                || qmk_traLoiCauHoi.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();

            // Kiểm tra các giá trị có đúng với dữ liệu đã đăng ký hay không
        } else {

            // Gọi các câu lệnh sql
            String qmk_checkUsername = "SELECT * FROM Login WHERE username = '" +
                    qmk_taiKhoan.getText() + "'";
            String qmk_checkEmail = "SELECT * FROM Login WHERE email = '" +
                    qmk_email.getText() + "' ";
            String qmk_checkSdt = "SELECT * FROM Login WHERE sodienthoai = '" +
                    qmk_soDienThoai.getText() + "' ";
            String qmk_checkCauHoi = "SELECT * FROM Login WHERE cauhoi = N'" +
                    qmk_cauHoi.getSelectionModel().getSelectedItem() + "' ";
            String qmk_checkTraLoi = "SELECT * FROM Login WHERE traloicauhoi = N'" +
                    qmk_traLoiCauHoi.getText() + "' ";

            // Kết nối sql server
            connect = connectionData.connectDangNhap();

            try {

                // Thực hiện các câu lệnh sql
                statement = connect.createStatement();
                resultSet_qmk_taiKhoan = statement.executeQuery(qmk_checkUsername);

                statement = connect.createStatement();
                resultSet_qmk_email = statement.executeQuery(qmk_checkEmail);

                statement = connect.createStatement();
                resultSet_qmk_sdt = statement.executeQuery(qmk_checkSdt);

                statement = connect.createStatement();
                resultSet_qmk_cauHoi = statement.executeQuery(qmk_checkCauHoi);

                statement = connect.createStatement();
                resultSet_qmk_traLoi = statement.executeQuery(qmk_checkTraLoi);

                // Nếu giá trị Tài khoản không được tìm thấy trong cột tài khoản thì in ra dòng
                // thông báo
                if (!resultSet_qmk_taiKhoan.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tài Khoản này chưa được đăng ký. Mời bạn chọn tài khoản khác");
                    alert.showAndWait();

                    // Nếu giá trị Email không được tìm thấy trong cột email thì in ra dòng thông
                    // báo
                } else if (!resultSet_qmk_email.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Email này chưa được đăng ký. Mời bạn chọn Email khác");
                    alert.showAndWait();

                    // Nếu giá trị Số Điện Thoại không được tìm thấy trong cột số điện thoại thì in
                    // ra dòng thông báo
                } else if (!resultSet_qmk_sdt.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Số điện thoại này chưa được đăng ký. Mời bạn chọn số điện thoại khác");
                    alert.showAndWait();

                    // Nếu giá trị Câu Hỏi không được tìm thấy trong cột câu hỏi thì in ra dòng
                    // thông báo
                } else if (!resultSet_qmk_cauHoi.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Câu hỏi này không phải câu hỏi bạn đăng ký. Mời bạn chọn câu hỏi khác");
                    alert.showAndWait();

                    // Nếu giá trị Câu Trả Lời không được tìm thấy trong cột cautraloi thì in ra
                    // dòng thông báo
                } else if (!resultSet_qmk_traLoi.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Câu trả lời này không đúng. Mời bạn chọn câu trả lời khác");
                    alert.showAndWait();

                } else {
                    // Nếu các giá trị điều đúng thì chuyển từ form quên mật khẩu -> đổi mật khẩu
                    dangnhap_form.setVisible(false);
                    dangky_form.setVisible(false);
                    quenMatKhau_form.setVisible(false);
                    doiMatKhau_form.setVisible(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /*
     * Đổi mật khẩu khi ta điền chính xác các giá trị ở form quên mật khẩu
     */
    public void doiMatKhau() {

        Alert alert;

        // Ẩn hiện mật khẩu
        if (dmk_chonHienMatKhau.isSelected()) {
            dmk_matKhau.setText(dmk_hienMatKhau.getText());
            dmk_xacNhanMK.setText(dmk_hienXacNhanMK.getText());
        } else {
            dmk_hienMatKhau.setText(dmk_matKhau.getText());
            dmk_hienXacNhanMK.setText(dmk_xacNhanMK.getText());
        }

        // Kiểm tra điều kiện nếu người dùng để trống thì in ra dòng thông báo
        if (dmk_matKhau.getText().isEmpty() || dmk_xacNhanMK.getText().isEmpty()
                || dmk_cauHoi.getSelectionModel().getSelectedItem() == null
                || dmk_traLoiCauHoi.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();

            // Kiểm tra điều kiện nếu xác nhận mật khẩu không giống với mật khẩu thì in ra
            // dòng thông báo
        } else if (!dmk_matKhau.getText().equals(dmk_xacNhanMK.getText())) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Mật khẩu không hợp lệ");
            alert.showAndWait();

            // Kiểm tra điều kiện mật khẩu phải có độ dài từ 8 -> 16
        } else if (dmk_matKhau.getText().length() < 8 || dmk_matKhau.getText().length() > 16) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Mật khẩu của bạn phải lớn hơn hoặc bằng 8 và phải nhỏ hơn hoặc bằng 16 ký tự, số");
            alert.showAndWait();

        } else {

            // Dòng lệnh sql chỉnh sửa mật khẩu thành mật khẩu mới
            String updateSql = "UPDATE Login SET password = ?,cauhoi = N'?', traloicauhoi = N'?'"
                    + "WHERE username = '" + qmk_taiKhoan.getText() + "'";

            // kết nối với sql server biến connectDangNhap từ file connectionData
            connect = connectionData.connectDangNhap();

            try {

                // Nếu câu hỏi giống với câu hỏi lần trước in ra dòng thông báo
                if (dmk_cauHoi.getSelectionModel().getSelectedItem()
                        .equals(qmk_cauHoi.getSelectionModel().getSelectedItem())) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn phải chọn câu hỏi khác với câu hỏi đợt trước");
                    alert.showAndWait();

                } else {

                    // Gắn biến sql
                    prepare = connect.prepareStatement(updateSql);

                    // Truyền các giá trị vào các cột ở trên dòng SET
                    prepare.setString(1, dmk_matKhau.getText());
                    prepare.setString(2, (String) dmk_cauHoi.getSelectionModel().getSelectedItem());
                    prepare.setString(3, dmk_traLoiCauHoi.getText());

                    // Thực hiện câu lệnh sql ở trên
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đổi mật khẩu thành công");
                    alert.showAndWait();

                    // Nếu đổi thành công chuyển form đổi mật khẩu -> form đăng nhập
                    dangky_form.setVisible(false);
                    quenMatKhau_form.setVisible(false);
                    doiMatKhau_form.setVisible(false);
                    dangnhap_form.setVisible(true);

                    // Tài khoản mật khẩu để trống và ẩn TextField hiện mật khẩu và xác nhận mật
                    // khẩu
                    userName.setText("");
                    password.setVisible(true);
                    password.setText("");
                    dn_hienMatKhau.setVisible(false);
                    dn_chonHienMatKhau.setVisible(false);

                    // Xóa giá trị điền trước đó khi thực hiện xong
                    dmk_matKhau.setText("");
                    dmk_xacNhanMK.setText("");
                    dmk_cauHoi.getSelectionModel().clearSelection();
                    dmk_traLoiCauHoi.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    // List câu hỏi
    private String[] cauHoiList = { "Bạn thích ăn loại trái cây nào ?", "Bạn thích màu gì ?",
            "Bạn thích chơi môn thể thao nào ?" };

    /*
     * List câu hỏi gắn vào Combobox
     */
    @SuppressWarnings("unchecked")
    public void dk_cauHoiList() {
        List<String> listCauHoi = new ArrayList<>();

        for (String data : cauHoiList) {
            listCauHoi.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listdata = FXCollections.observableArrayList(listCauHoi);
        dk_cauHoi.setItems(listdata);

    }

    /*
     * List câu hỏi gắn vào Combobox
     */
    @SuppressWarnings("unchecked")
    public void qmk_cauHoiList() {
        List<String> listCauHoi = new ArrayList<>();

        for (String data : cauHoiList) {
            listCauHoi.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listdata = FXCollections.observableArrayList(listCauHoi);
        qmk_cauHoi.setItems(listdata);
    }

    /*
     * List câu hỏi gắn vào Combobox
     */
    @SuppressWarnings("unchecked")
    public void dmk_cauHoiList() {
        List<String> listCauHoi = new ArrayList<>();

        for (String data : cauHoiList) {
            listCauHoi.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listdata = FXCollections.observableArrayList(listCauHoi);
        dmk_cauHoi.setItems(listdata);

    }

    /*
     * Đặt lại các giá trị biến trở thành khoảng trắng
     */
    public void dangNhapClearFields() {
        userName.setText("");
        password.setText("");
    }

    /*
     * Đặt lại các giá trị biến trở thành khoảng trắng
     */
    public void dangKyClearFields() {
        dk_taikhoan.setText("");
        dk_matkhau.setText("");
        dk_xacnhanmk.setText("");
        dk_email.setText("");
        dk_sodienthoai.setText("");
        dk_cauHoi.getSelectionModel().clearSelection();
        dk_traLoiCauHoi.setText("");
    }

    /*
     * Nếu ta bấm vào hiện mật khẩu thì sẽ chuyển giá trị bên TextPass sang TextFeld
     */
    public void dn_chonHienMatKhau() {

        // Nếu checkBox hiện mật khẩu ở form đổi mật khẩu được chọn
        // Hiện mật khẩu
        if (dn_chonHienMatKhau.isSelected()) {
            dn_hienMatKhau.setText(password.getText());// lấy giá trị từ biến TextPass mật khẩu gán vào biến TextField
                                                       // hiện mật khẩu

            // Hiện ra biến TextField hiện mật khẩu và xác nhận hiện mật khẩu
            // Và ẩn biến TextPass mật khẩu và xác nhận mật khẩu
            dn_hienMatKhau.setVisible(true);
            password.setVisible(false);

        } else {// Ẩn mật khẩu

            password.setText(dn_hienMatKhau.getText());// Lấy giá trị từ biến TextField hiện mật khẩu gán vào biến
                                                       // TextPass mật khẩu

            // Hiện ra biến TextPass mật khẩu và xác nhận mật khẩu
            // Và ẩn biến TextField hiện mật khẩu và xác nhận hiện mật khẩu
            dn_hienMatKhau.setVisible(false);
            password.setVisible(true);
        }
    }

    /*
     * Nếu ta bấm vào hiện mật khẩu thì sẽ chuyển giá trị bên TextPass sang TextFeld
     */
    public void dk_chonHienMatKhau() {

        // Nếu checkBox hiện mật khẩu ở form đổi mật khẩu được chọn
        // Hiện mật khẩu
        if (dk_chonHienMatKhau.isSelected()) {
            dk_hienMatKhau.setText(dk_matkhau.getText());// lấy giá trị từ biến TextPass mật khẩu gán vào biến TextField
                                                         // hiện mật khẩu
            dk_hienXacNhanMK.setText(dk_xacnhanmk.getText());// lấy giá trị từ biến TextPass mật khẩu gán vào biến
                                                             // TextField hiện mật khẩu

            // Hiện ra biến TextField hiện mật khẩu và xác nhận hiện mật khẩu
            // Và ẩn biến TextPass mật khẩu và xác nhận mật khẩu
            dk_hienMatKhau.setVisible(true);
            dk_hienXacNhanMK.setVisible(true);
            dk_matkhau.setVisible(false);
            dk_xacnhanmk.setVisible(false);

        } else { // Ẩn mật khẩu

            dk_matkhau.setText(dk_hienMatKhau.getText());// Lấy giá trị từ biến TextField hiện mật khẩu gán vào biến
                                                         // TextPass mật khẩu
            dk_xacnhanmk.setText(dk_hienXacNhanMK.getText());// Lấy giá trị từ biến TextField hiện mật khẩu gán vào biến
                                                             // TextPass mật khẩu

            // Hiện ra biến TextPass mật khẩu và xác nhận mật khẩu
            // Và ẩn biến TextField hiện mật khẩu và xác nhận hiện mật khẩu
            dk_hienMatKhau.setVisible(false);
            dk_hienXacNhanMK.setVisible(false);
            dk_matkhau.setVisible(true);
            dk_xacnhanmk.setVisible(true);
        }
    }

    /*
     * Nếu ta bấm vào hiện mật khẩu thì sẽ chuyển giá trị bên TextPass sang TextFeld
     */
    public void dmk_chonHienMatKhau() {

        // Nếu checkBox hiện mật khẩu ở form đổi mật khẩu được chọn
        // Hiện mật khẩu
        if (dmk_chonHienMatKhau.isSelected()) {
            dmk_hienMatKhau.setText(dmk_matKhau.getText()); // lấy giá trị từ biến TextPass mật khẩu gán vào biến
                                                            // TextField hiện mật khẩu
            dmk_hienXacNhanMK.setText(dmk_xacNhanMK.getText());// lấy giá trị từ biến TextPass mật khẩu gán vào biến
                                                               // TextField hiện mật khẩu

            // Hiện ra biến TextField hiện mật khẩu và xác nhận hiện mật khẩu
            // Và ẩn biến TextPass mật khẩu và xác nhận mật khẩu
            dmk_hienMatKhau.setVisible(true);
            dmk_hienXacNhanMK.setVisible(true);
            dmk_matKhau.setVisible(false);
            dmk_xacNhanMK.setVisible(false);

            // Ngược lại nếu bỏ chọn
        } else {
            // Ẩn mật khẩu
            dmk_matKhau.setText(dmk_hienMatKhau.getText());// Lấy giá trị từ biến TextField hiện mật khẩu gán vào biến
                                                           // TextPass mật khẩu
            dmk_xacNhanMK.setText(dmk_hienXacNhanMK.getText());// Lấy giá trị từ biến TextField hiện mật khẩu gán vào
                                                               // biến TextPass mật khẩu

            // Hiện ra biến TextPass mật khẩu và xác nhận mật khẩu
            // Và ẩn biến TextField hiện mật khẩu và xác nhận hiện mật khẩu
            dmk_hienMatKhau.setVisible(false);
            dmk_hienXacNhanMK.setVisible(false);
            dmk_matKhau.setVisible(true);
            dmk_xacNhanMK.setVisible(true);
        }
    }

    // thoát khỏi chương trình
    public void close() {
        System.exit(0);
    }

    /*
     * Chuyển form đăng nhập -> đăng ký -> quên mật khẩu -> lấy lại mật khẩu
     */
    public void doiForm(ActionEvent event) {

        // nếu bấm vào nút đăng nhập ở form đăng ký hoặc đăng nhập ở form đổi mật khẩu
        // thì sẽ chuyển về form đăng nhập
        if (event.getSource() == dk_dangnhap || event.getSource() == dmk_dangNhapBtn) {

            // đặt setVisible về false là ẩn form đi còn true là hiện form lên
            dangky_form.setVisible(false);
            dangnhap_form.setVisible(true);
            quenMatKhau_form.setVisible(false);
            doiMatKhau_form.setVisible(false);

            // 2 biến này dùng để xóa tất cả nội dụng khi ta đã điền ở form trước đó khi
            // chuyển thì sẽ xóa đi
            dangNhapClearFields();
            dangKyClearFields();

            // hoặc nếu ta bấm vào quên mật khẩu ở form đăng nhập thì chuyển qua form quên
            // mật khẩu
        } else if (event.getSource() == dn_quenMatKhau) {

            dangky_form.setVisible(false);
            dangnhap_form.setVisible(false);
            quenMatKhau_form.setVisible(true);
            doiMatKhau_form.setVisible(false);

            // biến này để hiện ra list câu hỏi ở form quên mật khẩu
            qmk_cauHoiList();

            // hoặc nếu ta bấm vào đăng ký ở form đăng nhập hoặc bấm nút trở về ở form quên
            // mật khẩu thì sẽ chuyển tới form đăng ký
        } else if (event.getSource() == dn_dangky || event.getSource() == qmk_troVeBtn) {

            dangky_form.setVisible(true);
            dangnhap_form.setVisible(false);
            quenMatKhau_form.setVisible(false);
            doiMatKhau_form.setVisible(false);

            dangNhapClearFields();// biến này dùng để xóa tất cả nội dụng khi ta đã điền ở form trước đó khi
                                  // chuyển thì sẽ xóa đi
            dk_cauHoiList();// biến này để hiện ra list câu hỏi

            // hoặc nếu ta bấm vào lấy lại mật khẩu ở form quên mật khẩu sẽ chuyển tới form
            // đổi mật khẩu
        } else if (event.getSource() == qmk_layLaiMatKhauBtn) {

            dangky_form.setVisible(false);
            dangnhap_form.setVisible(false);
            quenMatKhau_form.setVisible(false);
            doiMatKhau_form.setVisible(true);

            dmk_cauHoiList();// biến này để hiện ra list câu hỏi
        }
    }

    // phương thức này để thực hiện các dòng lệnh bên trong
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dk_cauHoiList();
        qmk_cauHoiList();
        dmk_cauHoiList();

        dangKyClearFields();
        dangNhapClearFields();
    }

}
