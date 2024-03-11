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

public class Controller implements Initializable {

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

    public void loginAdmin() {

        String sql = "SELECT * FROM Login WHERE username = ? AND password = ?";

        connect = connection.connectDangNhap();

        if (dn_chonHienMatKhau.isSelected()) {
            password.setText(dn_hienMatKhau.getText());
        } else {
            dn_hienMatKhau.setText(password.getText());
        }

        try {

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, userName.getText());
            prepare.setString(2, password.getText());

            resultSet = prepare.executeQuery();
            Alert alert;

            if (userName.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập đầy đủ thông tin");
                alert.showAndWait();

            } else {
                if (resultSet.next()) {
                    getData.username = userName.getText();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng nhập thành công!");
                    alert.showAndWait();

                    loginBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
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

    private ResultSet resultSet_email, resultSet_sdt;

    public void logup() {

        if (dk_chonHienMatKhau.isSelected()) {
            dk_matkhau.setText(dk_hienMatKhau.getText());
            dk_xacnhanmk.setText(dk_hienXacNhanMK.getText());
        } else {
            dk_hienMatKhau.setText(dk_matkhau.getText());
            dk_hienXacNhanMK.setText(dk_xacnhanmk.getText());
        }

        try {

            Alert alert;

            if (dk_taikhoan.getText().isEmpty() || dk_matkhau.getText().isEmpty()
                    || dk_email.getText().isEmpty() || dk_sodienthoai.getText().isEmpty()
                    || dk_cauHoi.getSelectionModel().getSelectedItem() == null
                    || dk_traLoiCauHoi.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập đầy đủ thông tin");
                alert.showAndWait();

            } else if (dk_matkhau.getText().length() < 8 || dk_matkhau.getText().length() > 16) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Mật khẩu của bạn phải lớn hơn hoặc bằng 8 và phải nhỏ hơn hoặc bằng 16 ký tự, số");
                alert.showAndWait();

            } else if (!dk_matkhau.getText().equals(dk_xacnhanmk.getText())) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Mật khẩu không hợp lệ");
                alert.showAndWait();

            } else if (!dk_email.getText().matches(".*\\.(com)$") || dk_email.getText().matches(".*\\.((com)\\.vn)$")) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Email không hợp lệ đuôi email phải là .com hoặc .com.vn");
                alert.showAndWait();

            } else if (dk_sodienthoai.getText().length() < 10 || dk_sodienthoai.getText().length() > 11) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Số điện thoại phải lớn hơn hoặc bằng 10 và nhỏ hơn hoặc bằng 11 số");
                alert.showAndWait();

            } else {

                String checkTaiKhoan = "SELECT * FROM Login WHERE username = '" + dk_taikhoan.getText() + "' ";
                String checkEmail = "SELECT * FROM Login WHERE email = '" + dk_email.getText() + "' ";
                String checkSdt = "SELECT * FROM Login WHERE sodienthoai = '" + dk_sodienthoai.getText() + "' ";

                connect = connection.connectDangNhap();

                statement = connect.createStatement();
                resultSet = statement.executeQuery(checkTaiKhoan);

                statement = connect.createStatement();
                resultSet_email = statement.executeQuery(checkEmail);

                statement = connect.createStatement();
                resultSet_sdt = statement.executeQuery(checkSdt);

                if (resultSet.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tài Khoản này đã có người sử dụng. Mời bạn chọn tài khoản khác");
                    alert.showAndWait();
                } else if (resultSet_email.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Email này đã được đăng ký. Mời bạn chọn Email khác");
                    alert.showAndWait();
                } else if (resultSet_sdt.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Số điện thoại này đã được đăng ký. Mời bạn chọn số điện thoại khác");
                    alert.showAndWait();
                } else {

                    String sql = "INSERT INTO Login"
                            + "(username,password,email,sodienthoai,cauhoi,traloicauhoi)"
                            + "VALUES (?,?,?,?,N'?',N'?')";

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, dk_taikhoan.getText());
                    prepare.setString(2, dk_matkhau.getText());
                    prepare.setString(3, dk_email.getText());
                    prepare.setString(4, dk_sodienthoai.getText());
                    prepare.setString(5, (String) dk_cauHoi.getSelectionModel().getSelectedItem());
                    prepare.setString(6, dk_traLoiCauHoi.getText());
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng ký thành công!");
                    alert.showAndWait();

                    dangKyClearFields();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ResultSet resultSet_qmk_email, resultSet_qmk_sdt, resultSet_qmk_taiKhoan, resultSet_qmk_cauHoi,
            resultSet_qmk_traLoi;

    public void quenMatKhau() {

        Alert alert;

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

        } else {

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

            connect = connection.connectDangNhap();

            try {

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

                if (!resultSet_qmk_taiKhoan.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Tài Khoản này chưa được đăng ký. Mời bạn chọn tài khoản khác");
                    alert.showAndWait();

                } else if (!resultSet_qmk_email.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Email này chưa được đăng ký. Mời bạn chọn Email khác");
                    alert.showAndWait();

                } else if (!resultSet_qmk_sdt.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Số điện thoại này chưa được đăng ký. Mời bạn chọn số điện thoại khác");
                    alert.showAndWait();

                } else if (!resultSet_qmk_cauHoi.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Câu hỏi này không phải câu hỏi bạn đăng ký. Mời bạn chọn câu hỏi khác");
                    alert.showAndWait();

                } else if (!resultSet_qmk_traLoi.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Câu trả lời này không đúng. Mời bạn chọn câu trả lời khác");
                    alert.showAndWait();

                } else {
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

    public void doiMatKhau() {

        Alert alert;

        if (dmk_chonHienMatKhau.isSelected()) {
            dmk_matKhau.setText(dmk_hienMatKhau.getText());
            dmk_xacNhanMK.setText(dmk_hienXacNhanMK.getText());
        } else {
            dmk_hienMatKhau.setText(dmk_matKhau.getText());
            dmk_hienXacNhanMK.setText(dmk_xacNhanMK.getText());
        }

        if (dmk_matKhau.getText().isEmpty() || dmk_xacNhanMK.getText().isEmpty()
                || dmk_cauHoi.getSelectionModel().getSelectedItem() == null
                || dmk_traLoiCauHoi.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập đầy đủ thông tin");
            alert.showAndWait();

        } else if (!dmk_matKhau.getText().equals(dmk_xacNhanMK.getText())) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Mật khẩu không hợp lệ");
            alert.showAndWait();
        } else if (dmk_matKhau.getText().length() < 8 || dmk_matKhau.getText().length() > 16) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Mật khẩu của bạn phải lớn hơn hoặc bằng 8 và phải nhỏ hơn hoặc bằng 16 ký tự, số");
            alert.showAndWait();
        } else {
            String updateSql = "UPDATE Login SET password = ?,cauhoi = N'?', traloicauhoi = N'?'"
                    + "WHERE username = '" + qmk_taiKhoan.getText() + "'";

            connect = connection.connectDangNhap();

            try {

                if (dmk_cauHoi.getSelectionModel().getSelectedItem()
                        .equals(qmk_cauHoi.getSelectionModel().getSelectedItem())) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn phải chọn câu hỏi khác với câu hỏi đợt trước");
                    alert.showAndWait();

                } else {

                    prepare = connect.prepareStatement(updateSql);
                    prepare.setString(1, dmk_matKhau.getText());
                    prepare.setString(2, (String) dmk_cauHoi.getSelectionModel().getSelectedItem());
                    prepare.setString(3, dmk_traLoiCauHoi.getText());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Đổi mật khẩu thành công");
                    alert.showAndWait();

                    dangky_form.setVisible(false);
                    quenMatKhau_form.setVisible(false);
                    doiMatKhau_form.setVisible(false);
                    dangnhap_form.setVisible(true);

                    userName.setText("");
                    password.setVisible(true);
                    password.setText("");
                    dn_hienMatKhau.setVisible(false);
                    dn_chonHienMatKhau.setVisible(false);

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

    private String[] cauHoiList = { "Bạn thích ăn loại trái cây nào ?", "Bạn thích màu gì ?",
            "Bạn thích chơi môn thể thao nào ?" };

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

    public void dangNhapClearFields() {
        userName.setText("");
        password.setText("");
    }

    public void dangKyClearFields() {
        dk_taikhoan.setText("");
        dk_matkhau.setText("");
        dk_xacnhanmk.setText("");
        dk_email.setText("");
        dk_sodienthoai.setText("");
        dk_cauHoi.getSelectionModel().clearSelection();
        dk_traLoiCauHoi.setText("");
    }

    public void dn_chonHienMatKhau() {
        if (dn_chonHienMatKhau.isSelected()) {
            dn_hienMatKhau.setText(password.getText());
            dn_hienMatKhau.setVisible(true);
            password.setVisible(false);
        } else {
            password.setText(dn_hienMatKhau.getText());
            dn_hienMatKhau.setVisible(false);
            password.setVisible(true);
        }
    }

    public void dk_chonHienMatKhau() {
        if (dk_chonHienMatKhau.isSelected()) {
            dk_hienMatKhau.setText(dk_matkhau.getText());
            dk_hienXacNhanMK.setText(dk_xacnhanmk.getText());
            dk_hienMatKhau.setVisible(true);
            dk_hienXacNhanMK.setVisible(true);
            dk_matkhau.setVisible(false);
            dk_xacnhanmk.setVisible(false);
        } else {
            dk_matkhau.setText(dk_hienMatKhau.getText());
            dk_xacnhanmk.setText(dk_hienXacNhanMK.getText());
            dk_hienMatKhau.setVisible(false);
            dk_hienXacNhanMK.setVisible(false);
            dk_matkhau.setVisible(true);
            dk_xacnhanmk.setVisible(true);
        }
    }

    public void dmk_chonHienMatKhau() {
        if (dmk_chonHienMatKhau.isSelected()) {
            dmk_hienMatKhau.setText(dmk_matKhau.getText());
            dmk_hienXacNhanMK.setText(dmk_xacNhanMK.getText());
            dmk_hienMatKhau.setVisible(true);
            dmk_hienXacNhanMK.setVisible(true);
            dmk_matKhau.setVisible(false);
            dmk_xacNhanMK.setVisible(false);
        } else {
            dmk_matKhau.setText(dmk_hienMatKhau.getText());
            dmk_xacNhanMK.setText(dmk_hienXacNhanMK.getText());
            dmk_hienMatKhau.setVisible(false);
            dmk_hienXacNhanMK.setVisible(false);
            dmk_matKhau.setVisible(true);
            dmk_xacNhanMK.setVisible(true);
        }
    }

    public void close() {
        System.exit(0);
    }

    public void doiForm(ActionEvent event) {

        if (event.getSource() == dk_dangnhap || event.getSource() == dmk_dangNhapBtn) {

            dangky_form.setVisible(false);
            dangnhap_form.setVisible(true);
            quenMatKhau_form.setVisible(false);
            doiMatKhau_form.setVisible(false);

            dangNhapClearFields();
            dangKyClearFields();

        } else if (event.getSource() == dn_quenMatKhau) {

            dangky_form.setVisible(false);
            dangnhap_form.setVisible(false);
            quenMatKhau_form.setVisible(true);
            doiMatKhau_form.setVisible(false);

            qmk_cauHoiList();

        } else if (event.getSource() == dn_dangky || event.getSource() == qmk_troVeBtn) {

            dangky_form.setVisible(true);
            dangnhap_form.setVisible(false);
            quenMatKhau_form.setVisible(false);
            doiMatKhau_form.setVisible(false);

            dangNhapClearFields();
            dk_cauHoiList();

        } else if (event.getSource() == qmk_layLaiMatKhauBtn) {

            dangky_form.setVisible(false);
            dangnhap_form.setVisible(false);
            quenMatKhau_form.setVisible(false);
            doiMatKhau_form.setVisible(true);

            dmk_cauHoiList();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dk_cauHoiList();
        qmk_cauHoiList();
        dmk_cauHoiList();

        dangKyClearFields();
        dangNhapClearFields();
    }

}
