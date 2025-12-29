package attendance;

import java.time.LocalDate;

public class attendance {
    public int attendanceId;
    public int studentId;
    public int courseId;
    public LocalDate date;
    public String status;

    public attendance(int studentId, int courseId, LocalDate date, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.status = status;
    }
}