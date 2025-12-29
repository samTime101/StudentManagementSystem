package attendance;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Attendancedao {
    private List<attendance> attendanceDatabase = new ArrayList<>();

    public boolean markAttendance(attendance attendance) {
        return attendanceDatabase.add(attendance);
    }

    // Necessary for "Prevent duplicate attendance" responsibility
    public boolean attendanceExists(int studentId, int courseId, LocalDate date) {
        return attendanceDatabase.stream().anyMatch(a ->
                a.studentId == studentId &&
                        a.courseId == courseId &&
                        a.date.equals(date));
    }

    public List<attendance> getAttendanceByStudent(int studentId) {
        return attendanceDatabase.stream()
                .filter(a -> a.studentId == studentId)
                .collect(Collectors.toList());
    }

    public List<attendance> getAttendanceByCourse(int courseId) {
        return attendanceDatabase.stream()
                .filter(a -> a.courseId == courseId)
                .collect(Collectors.toList());
    }

    // Responsibility: Attendance calculation
    public double calculateAttendancePercentage(int studentId, int courseId) {
        List<attendance> records = attendanceDatabase.stream()
                .filter(a -> a.studentId == studentId && a.courseId == courseId)
                .collect(Collectors.toList());

        if (records.isEmpty()) return 0.0;

        long presentCount = records.stream()
                .filter(a -> a.status.equalsIgnoreCase("Present"))
                .count();

        return ((double) presentCount / records.size()) * 100;
    }
}