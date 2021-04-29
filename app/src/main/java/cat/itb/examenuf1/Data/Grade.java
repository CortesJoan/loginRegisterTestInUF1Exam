package cat.itb.examenuf1.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Grade implements Parcelable {
    String studentName;
    String module;
    boolean assistance;
    double grade;
    Date dateOfGrading;

    public Grade(String studentName, String module, boolean assistance, double grade, Date dateOfGrading) {
        this.studentName = studentName;
        this.module = module;
        this.assistance = assistance;
        this.grade = grade;
        this.dateOfGrading = dateOfGrading;
    }

    protected Grade(Parcel in) {
        studentName = in.readString();
        module = in.readString();
        assistance = in.readByte() != 0;
        grade = in.readDouble();
    }

    public static final Creator<Grade> CREATOR = new Creator<Grade>() {
        @Override
        public Grade createFromParcel(Parcel in) {
            return new Grade(in);
        }

        @Override
        public Grade[] newArray(int size) {
            return new Grade[size];
        }
    };

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isAssistance() {
        return assistance;
    }

    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateOfGrading() {
        return dateOfGrading;
    }

    public void setDateOfGrading(Date dateOfGrading) {
        this.dateOfGrading = dateOfGrading;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(studentName);
        dest.writeString(module);
        dest.writeByte((byte) (isAssistance() ? 1 : 0));
        dest.writeDouble(grade);
    }
}
