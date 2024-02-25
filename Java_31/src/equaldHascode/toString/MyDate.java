package equaldHascode.toString;

public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            this.day = 1;
        }

        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }

        if (year >= 2023) {
            this.year = year;
        } else {
            this.year = 1;
        }
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int d) {
        if (d >= 1 && d <= 31) {
            this.day = d;
        }
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int m) {
        if (m >= 1 && m <= 12) {
            this.month = m;
        }
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int y) {
        if (y >= 2023) {
            this.year = y;
        }
    }

    // in chuoi
    @Override
    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }

    // so sanh
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        MyDate other = (MyDate) obj;
        if (this.day != other.day)
            return false;
        if (this.month != other.month)
            return false;
        if (this.year != other.year)
            return false;
        return true;
    }

    // ham bam
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;
        return result;
    }

}
