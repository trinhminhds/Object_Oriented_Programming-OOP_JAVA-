package entity;

import java.sql.Date;

public class NhanSu {

    protected String employeeID;
    protected String lastName;
    protected String firstName;
    protected Date date;
    protected String gender;
    protected String diaChi;
    protected String phoneNum;
    protected int salary;
    protected String position;
    protected String email;

    public NhanSu(String employeeID, String firstName, String lastName, Date date, String gender, String diaChi,
            String phoneNum, int salary, String position, String email) {

        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.gender = gender;
        this.diaChi = diaChi;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.position = position;
        this.email = email;
    }

    public NhanSu(String employeeID, String firstName, String lastName, String position, int salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firstName;
    }

    public void setFirsName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
