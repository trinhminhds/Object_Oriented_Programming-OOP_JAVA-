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
    private BarChart<?, ?> home_chart;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEmployee;

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
    private Label home_totalPresents;

    @FXML
    private Button addEmployee_addBtn;

    @FXML
    private Button addEmployee_btn;

    @FXML
    private Button addEmployee_clearBtn;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_dateMember;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_empoyeeID;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_firstName;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_gender;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_lastName;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_phone;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_position;

    @FXML
    private TableColumn<themNhanVien, String> addEmployee_col_address;

    @FXML
    private Button addEmployee_deleteBtn;

    @FXML
    private TextField addEmployee_employee;

    @FXML
    private TextField addEmployee_firstName;

    @FXML
    private AnchorPane addEmployee_form;

    @FXML
    private ComboBox<?> addEmployee_gender;

    @FXML
    private TextField addEmployee_lastName;

    @FXML
    private TextField addEmployee_phone;

    @FXML
    private TextField addEmployee_address;

    @FXML
    private DatePicker addEmployee_birthday;

    @FXML
    private ComboBox<?> addEmployee_position;

    @FXML
    private TextField addEmployee_seach;

    @FXML
    private TableView<themNhanVien> addEmployee_tableView;

    @FXML
    private Button addEmployee_updateBtn;

    @FXML
    private Button salary_Btn;

    @FXML
    private Button salary_updateBtn;

    @FXML
    private Button salary_clearBtn;

    @FXML
    private TextField salary_employeeId;

    @FXML
    private Label salary_firstName;

    @FXML
    private AnchorPane salary_form;

    @FXML
    private Label salary_lastName;

    @FXML
    private Label salary_position;

    @FXML
    private TextField salary_salary;

    @FXML
    private TableView<luongNhanVien> salary_tableView;

    @FXML
    private TableColumn<luongNhanVien, String> salary_col_employeeID;

    @FXML
    private TableColumn<luongNhanVien, String> salary_col_firstName;

    @FXML
    private TableColumn<luongNhanVien, String> salary_col_lastName;

    @FXML
    private TableColumn<luongNhanVien, String> salary_col_position;

    @FXML
    private TableColumn<luongNhanVien, String> salary_col_salary;

    @FXML
    private Label username;

    @FXML
    private Button logout;

    @FXML
    private Button minimize;

    @FXML
    private Button close;

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet resultSet;

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

            home_totalEmployee.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void home_totalPresents() {

        String sql = "SELECT COUNT(manhanvien) AS manhanvien FROM nhanvien";
        connect = connectionData.connectQLNV();
        int countData = 0;

        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                countData = resultSet.getInt("manhanvien");
            }

            home_totalPresents.setText(String.valueOf(countData));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void home_chart() {
        home_chart.getData().clear();

        String sql = "SELECT TOP 7 ten,YEAR(ngaysinh) FROM nhanvien GROUP BY ten,ngaysinh ORDER BY ngaysinh ASC";

        connect = connectionData.connectQLNV();

        try {

            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while (resultSet.next()) {
                chart.getData().add(new XYChart.Data(resultSet.getString(1), resultSet.getInt(2)));
            }

            home_chart.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEmployeeAdd() {

        String sql = "INSERT INTO nhanvien "
                + "(manhanvien,ho,ten,gioitinh,sodienthoai,chucvu,diachi,ngaysinh)"
                + "VALUES(?,?,?,?,?,?,?,?)";

        connect = connectionData.connectQLNV();

        try {
            Alert alert;

            if (addEmployee_employee.getText().isEmpty()
                    || addEmployee_firstName.getText().isEmpty()
                    || addEmployee_lastName.getText().isEmpty()
                    || addEmployee_gender.getSelectionModel().getSelectedItem() == null
                    || addEmployee_col_phone.getText().isEmpty()
                    || addEmployee_position.getSelectionModel().getSelectedItem() == null
                    || addEmployee_birthday.getValue().toString().isEmpty()
                    || addEmployee_address.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập đầy đủ thông tin");
                alert.showAndWait();

            } else {

                String check = "SELECT manhanvien FROM nhanvien WHERE manhanvien = '"
                        + addEmployee_employee.getText() + "'";

                statement = connect.createStatement();
                resultSet = statement.executeQuery(check);

                if (resultSet.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Mã nhân viên: " + addEmployee_employee.getText()
                            + " này đã được sử dụng vui lòng nhập mã khác!");
                    alert.showAndWait();

                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addEmployee_employee.getText());
                    prepare.setString(2, addEmployee_firstName.getText());
                    prepare.setString(3, addEmployee_lastName.getText());
                    prepare.setString(4, (String) addEmployee_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(5, addEmployee_phone.getText());
                    prepare.setString(6, (String) addEmployee_position.getSelectionModel().getSelectedItem());
                    prepare.setString(7, addEmployee_address.getText());
                    prepare.setString(8, addEmployee_birthday.getValue().toString());

                    prepare.executeUpdate();

                    // String insertInfo = "INSERT INTO nhanvien "
                    // + "(manhanvien,ho,ten,chucvu,luong)"
                    // + "VALUES(?,?,?,?,?)";

                    // prepare = connect.prepareStatement(insertInfo);
                    // prepare.setString(1, addEmployee_employee.getText());
                    // prepare.setString(2, addEmployee_firstName.getText());
                    // prepare.setString(3, addEmployee_lastName.getText());
                    // prepare.setString(4, (String)
                    // addEmployee_position.getSelectionModel().getSelectedItem());
                    // prepare.setString(5, "0");

                    // prepare.executeUpdate();

                    // alert = new Alert(AlertType.INFORMATION);
                    // alert.setTitle("Infomation Message");
                    // alert.setHeaderText(null);
                    // alert.setContentText("Thêm thành công!");
                    // alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEmployeeUpdate() {

        String sql = "UPDATE nhanvien SET ho = N'" + addEmployee_firstName.getText() + "', " +
                "ten = N'" + addEmployee_lastName.getText() + "', " +
                "gioitinh = N'" + addEmployee_gender.getSelectionModel().getSelectedItem() + "', " +
                "sodienthoai = N'" + addEmployee_phone.getText() + "', " +
                "chucvu = N'" + addEmployee_position.getSelectionModel().getSelectedItem() + "', " +
                "diachi = N'" + addEmployee_address.getText() + "', " +
                "ngaysinh = N'" + addEmployee_birthday.getValue() + "' " +
                "WHERE manhanvien = N'" + addEmployee_employee.getText() + "'";

        connect = connectionData.connectQLNV();

        try {
            Alert alert;

            if (addEmployee_employee.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập mã nhân viên");
                alert.showAndWait();

            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Bạn có muốn sửa thông tin của nhân viên : " + addEmployee_employee.getText() + " không ?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    // int salary = 0;

                    // String checkData = "SELECT * FROM nhanvien WHERE masinhvien = ? '"
                    // + addEmployee_employee.getText() + "'";

                    // prepare = connect.prepareStatement(checkData);
                    // resultSet = prepare.executeQuery();

                    // while (resultSet.next()) {
                    // salary = resultSet.getInt(salary);
                    // }

                    // String updateInfo = "UPDATE nhanvien SET ho = '" +
                    // addEmployee_firstName.getText() + "', " +
                    // "ten = '" + addEmployee_lastName.getText() + "', " +
                    // "chucvu = '" + addEmployee_position.getSelectionModel().getSelectedItem() +
                    // "', " +
                    // "WHERE manhanvien = '" + addEmployee_employee.getText() + "'";

                    // prepare = connect.prepareStatement(updateInfo);
                    // prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Sửa thành công!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addEmployeeDelete() {

        String sql = "DELETE FROM nhanvien WHERE manhanvien = '" + addEmployee_employee.getText() + "'";

        connect = connectionData.connectQLNV();

        try {

            Alert alert;

            if (addEmployee_employee.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập mã nhân viên");
                alert.showAndWait();

            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Bạn thật sự muốn xóa nhân viên này: "
                        + addEmployee_employee.getText() + "không ?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    // String deleteInfo = "DELETE FROM nhanvien WHERE manhanvien = '"
                    // + addEmployee_employee.getText() + "'";

                    // prepare = connect.prepareStatement(deleteInfo);
                    // prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Xóa thành công!");
                    alert.showAndWait();

                    addEmployeeShowListData();
                    addEmployeeReset();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEmployeeReset() {
        addEmployee_employee.setText("");
        addEmployee_firstName.setText("");
        addEmployee_lastName.setText("");
        addEmployee_gender.getSelectionModel().clearSelection();
        addEmployee_position.getSelectionModel().clearSelection();
        addEmployee_phone.setText("");
        addEmployee_birthday.setValue(null);
        addEmployee_address.setText("");
    }

    public void timKiemThemNhanVien() {

        FilteredList<themNhanVien> locTimKiem = new FilteredList<>(themNhanVienList, e -> true);

        addEmployee_seach.textProperty().addListener((ObservableList, oldValue, newValue) -> {

            locTimKiem.setPredicate(predicateEmployeeData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String tuKhoaTimKiem = newValue.toLowerCase();

                if (predicateEmployeeData.getMaNhanVien().toString().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getHo().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getTen().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getGioiTinh().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getChucVu().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getSoDienThoai().toLowerCase().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getNgaySinh().toString().contains(tuKhoaTimKiem)) {
                    return true;
                } else if (predicateEmployeeData.getDiaChi().toString().contains(tuKhoaTimKiem)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<themNhanVien> sortedList = new SortedList<>(locTimKiem);

        sortedList.comparatorProperty().bind(addEmployee_tableView.comparatorProperty());
        addEmployee_tableView.setItems(sortedList);

    }

    private String[] listChucVu = { "Công nhân", "Chuyên gia nước ngoài", "Kỹ sư", "Nhân viên", "Thực tập sinh",
            "Lao động phổ thông", "Người làm bán thời gian", "Cán bộ quản lý", "Nhân sự thử việc" };

    @SuppressWarnings("unchecked")
    public void home_luongTDoiTuongList() {

        List<String> listP = new ArrayList<>();

        for (String data : listChucVu) {
            listP.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listData = FXCollections.observableArrayList(listP);
        home_luongTDoiTuongCBox.setItems(listData);

    }

    @SuppressWarnings("unchecked")
    public void home_luongTBDoiTuongList() {

        List<String> listP = new ArrayList<>();

        for (String data : listChucVu) {
            listP.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listData = FXCollections.observableArrayList(listP);
        home_luongTBDoiTuongCBox.setItems(listData);

    }

    @SuppressWarnings("unchecked")
    public void addEmployeePositionList() {

        List<String> listP = new ArrayList<>();

        for (String data : listChucVu) {
            listP.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listData = FXCollections.observableArrayList(listP);
        addEmployee_position.setItems(listData);

    }

    private String[] listGioiTinh = { "Nam", "Nữ", "Khác" };

    @SuppressWarnings("unchecked")
    public void addEmployeeGenderList() {
        List<String> listG = new ArrayList<>();

        for (String data : listGioiTinh) {
            listG.add(data);
        }

        @SuppressWarnings("rawtypes")
        ObservableList listGenderData = FXCollections.observableArrayList(listG);
        addEmployee_gender.setItems(listGenderData);

    }

    public ObservableList<themNhanVien> addEmployeeListData() {

        ObservableList<themNhanVien> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM nhanvien";

        connect = connectionData.connectQLNV();

        try {

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            themNhanVien employeeD;

            while (resultSet.next()) {

                employeeD = new themNhanVien(resultSet.getString("manhanvien"),
                        resultSet.getString("ho"),
                        resultSet.getString("ten"),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("sodienthoai"),
                        resultSet.getString("chucvu"),
                        resultSet.getString("diachi"),
                        resultSet.getDate("ngaysinh"));

                listData.add(employeeD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<themNhanVien> themNhanVienList;

    public void addEmployeeShowListData() {

        themNhanVienList = addEmployeeListData();

        addEmployee_col_empoyeeID.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
        addEmployee_col_firstName.setCellValueFactory(new PropertyValueFactory<>("ho"));
        addEmployee_col_lastName.setCellValueFactory(new PropertyValueFactory<>("ten"));
        addEmployee_col_gender.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        addEmployee_col_phone.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
        addEmployee_col_position.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
        addEmployee_col_address.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        addEmployee_col_dateMember.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));

        addEmployee_tableView.setItems(themNhanVienList);

    }

    public void addEmployeeSelect() {

        themNhanVien employeeD = addEmployee_tableView.getSelectionModel().getSelectedItem();

        int num = addEmployee_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addEmployee_employee.setText(employeeD.getMaNhanVien());
        addEmployee_firstName.setText(employeeD.getHo());
        addEmployee_lastName.setText(employeeD.getTen());
        addEmployee_phone.setText(employeeD.getSoDienThoai());
        addEmployee_address.setText(employeeD.getDiaChi());

    }

    public void salaryUpdate() {

        String sql = "UPDATE nhanvien SET luong = N'" + salary_salary.getText()
                + "' WHERE manhanvien = N'" + salary_employeeId.getText() + "'";

        connect = connectionData.connectQLNV();

        try {
            Alert alert;

            if (salary_employeeId.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng nhập mã nhân viên");
                alert.showAndWait();

            } else {

                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Infomation Message");
                alert.setHeaderText(null);
                alert.setContentText("Sửa thành công!");
                alert.showAndWait();

                salaryShowListData();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salaryReset() {
        salary_employeeId.setText("");
        salary_firstName.setText("");
        salary_lastName.setText("");
        salary_position.setText("");
        salary_salary.setText("");
    }

    public ObservableList<luongNhanVien> salaryListData() {

        ObservableList<luongNhanVien> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM nhanvien";
        connect = connectionData.connectQLNV();

        try {

            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            luongNhanVien employeeData;
            while (resultSet.next()) {
                employeeData = new luongNhanVien(resultSet.getString("manhanvien"),
                        resultSet.getString("ho"),
                        resultSet.getString("ten"),
                        resultSet.getString("chucvu"),
                        resultSet.getInt("luong"));

                listData.add(employeeData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<luongNhanVien> salaryList;

    public void salaryShowListData() {

        salaryList = salaryListData();

        salary_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
        salary_col_firstName.setCellValueFactory(new PropertyValueFactory<>("ho"));
        salary_col_lastName.setCellValueFactory(new PropertyValueFactory<>("ten"));
        salary_col_position.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
        salary_col_salary.setCellValueFactory(new PropertyValueFactory<>("luong"));

        salary_tableView.setItems(salaryList);
    }

    public void salarySelect() {
        luongNhanVien employeeData = salary_tableView.getSelectionModel().getSelectedItem();
        int num = salary_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        salary_employeeId.setText(employeeData.getMaNhanVien());
        salary_firstName.setText(employeeData.getHo());
        salary_lastName.setText(employeeData.getTen());
        salary_position.setText(employeeData.getChucVu());
        salary_salary.setText(String.valueOf(employeeData.getLuong()));
    }

    public void defautNav() {
        home_Btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == home_Btn) {

            home_form.setVisible(true);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(false);

            home_Btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            salary_Btn.setStyle("-fx-background-color:transparent");

            home_totalEmployee();
            home_totalPresents();
            home_tuoiTBCTy();
            home_chart();
            home_luongTBDoiTuong();
            home_luongTBcongty();
            home_luongTDoiTuong();
            home_luongTDoiTuongList();
            home_luongTBDoiTuongList();
            home_luongTBOnMouseClick();
            home_luongTongDTOnMouseClick();

        } else if (event.getSource() == addEmployee_btn) {

            home_form.setVisible(false);
            addEmployee_form.setVisible(true);
            salary_form.setVisible(false);

            addEmployee_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            home_Btn.setStyle("-fx-background-color:transparent");
            salary_Btn.setStyle("-fx-background-color:transparent");

            addEmployeeGenderList();
            addEmployeePositionList();
            timKiemThemNhanVien();
            addEmployeeOnMouseClickTable();

        } else if (event.getSource() == salary_Btn) {

            home_form.setVisible(false);
            addEmployee_form.setVisible(false);
            salary_form.setVisible(true);

            salary_Btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            addEmployee_btn.setStyle("-fx-background-color:transparent");
            home_Btn.setStyle("-fx-background-color:transparent");

            salaryShowListData();
            salaryOnMouseClickTable();
        }

    }

    public void addEmployeeOnMouseClickTable() {

        addEmployee_tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                themNhanVien employeeData = addEmployee_tableView.getSelectionModel().getSelectedItem();
                if (employeeData != null) {

                    addEmployee_employee.setText(employeeData.getMaNhanVien());
                    addEmployee_firstName.setText(employeeData.getHo());
                    addEmployee_lastName.setText(employeeData.getTen());
                    addEmployee_gender.getSelectionModel().getSelectedItem();
                    addEmployee_phone.setText(employeeData.getSoDienThoai());
                    addEmployee_position.getSelectionModel().getSelectedItem();
                    addEmployee_address.setText(employeeData.getDiaChi());
                    Date brithday = employeeData.getNgaySinh();
                    LocalDate localDate = sqlDateToLocalDate(brithday);
                    addEmployee_birthday.setValue(localDate);
                }
            }
        });

    }

    public void salaryOnMouseClickTable() {

        salary_tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                luongNhanVien employeeData = salary_tableView.getSelectionModel().getSelectedItem();
                if (employeeData != null) {

                    salary_employeeId.setText(employeeData.getMaNhanVien());
                    salary_firstName.setText(employeeData.getHo());
                    salary_lastName.setText(employeeData.getTen());
                    salary_position.setText(employeeData.getChucVu());
                    salary_salary.setText(String.valueOf(employeeData.getLuong()));

                }
            }
        });

    }

    public void home_luongTBOnMouseClick() {
        home_luongTBDoiTuongCBox.setOnAction(event -> {
            home_luongTBDoiTuong();
        });
    }

    public void home_luongTongDTOnMouseClick() {
        home_luongTDoiTuongCBox.setOnAction(event -> {
            home_luongTDoiTuong();
        });
    }

    public LocalDate sqlDateToLocalDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Bạn thật sự muốn đăng xuất chứ ?");
        Optional<ButtonType> option = alert.showAndWait();
        try {

            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();
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

        displayUsername();
        defautNav();

        home_totalEmployee();
        home_totalPresents();
        home_tuoiTBCTy();
        home_chart();
        home_luongTBDoiTuong();
        home_luongTBcongty();
        home_luongTDoiTuong();
        home_luongTBDoiTuongList();
        home_luongTDoiTuongList();
        home_luongTBOnMouseClick();
        home_luongTongDTOnMouseClick();

        addEmployeeGenderList();
        addEmployeePositionList();
        addEmployeeShowListData();
        addEmployeeOnMouseClickTable();

        salaryShowListData();
        salaryOnMouseClickTable();
    }
}
