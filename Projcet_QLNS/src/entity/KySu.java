package entity;

import java.sql.Date;

public class KySu extends NhanSu {

    public KySu(String employeeID, String firstName, String lastName, Date date, String gender, String diaChi,
            String phoneNum, int salary, String position, String email) {
        super(employeeID, firstName, lastName, date, gender, diaChi, phoneNum, salary, position, email);

    }

    @Override
    public String toString() {
        return getEmployeeID() + getLastName() + getFirsName() + getDate() + getGender() + getPhoneNum();
    }

}
