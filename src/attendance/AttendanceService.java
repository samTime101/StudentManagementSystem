package attendance;

import java.time.LocalDate;

public class AttendanceService {
    private Attendancedao dao;

    public AttendanceService(Attendancedao dao) {
        this.dao = dao;
    }

    public boolean markPresent(int studentId, int courseId, LocalDate date) {
        if (dao.attendanceExists(studentId, courseId, date)) {
            System.out.println("Cannot mark attendance: Duplicate entry for " + date);
            return false;
        }
        return dao.markAttendance(new attendance(studentId, courseId, date, "Present"));
    }

    public boolean markAbsent(int studentId, int courseId, LocalDate date) {
        if (dao.attendanceExists(studentId, courseId, date)) {
            System.out.println("Cannot mark attendance: Duplicate entry for " + date);
            return false;
        }
        return dao.markAttendance(new attendance(studentId, courseId, date, "Absent"));
    }
}