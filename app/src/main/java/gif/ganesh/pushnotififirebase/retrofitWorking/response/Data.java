package gif.ganesh.pushnotififirebase.retrofitWorking.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data
{
    @SerializedName("attendence_id")
    @Expose
    private Integer attendenceId;
    @SerializedName("class_id")
    @Expose
    private Integer classId;
    @SerializedName("sub_allocation_id")
    @Expose
    private Integer subAllocationId;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("Month")
    @Expose
    private String month;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("time_table_id")
    @Expose
    private Integer timeTableId;
    @SerializedName("Attendence_status")
    @Expose
    private String attendenceStatus;
    @SerializedName("class_name")
    @Expose
    private String className;
    @SerializedName("timetable_status")
    @Expose
    private String timetableStatus;
    @SerializedName("academic_id")
    @Expose
    private Integer academicId;
    @SerializedName("institution_id")
    @Expose
    private Integer institutionId;
    @SerializedName("student_id")
    @Expose
    private Integer studentId;
    @SerializedName("student_roll_no")
    @Expose
    private String studentRollNo;
    @SerializedName("first_name")
    @Expose
    private String firstName;

    public Integer getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(Integer attendenceId) {
        this.attendenceId = attendenceId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getSubAllocationId() {
        return subAllocationId;
    }

    public void setSubAllocationId(Integer subAllocationId) {
        this.subAllocationId = subAllocationId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(Integer timeTableId) {
        this.timeTableId = timeTableId;
    }

    public String getAttendenceStatus() {
        return attendenceStatus;
    }

    public void setAttendenceStatus(String attendenceStatus) {
        this.attendenceStatus = attendenceStatus;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTimetableStatus() {
        return timetableStatus;
    }

    public void setTimetableStatus(String timetableStatus) {
        this.timetableStatus = timetableStatus;
    }

    public Integer getAcademicId() {
        return academicId;
    }

    public void setAcademicId(Integer academicId) {
        this.academicId = academicId;
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(String studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
