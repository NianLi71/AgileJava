package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;

import static sis.report.ReportConstant.NEWLINE;

public class RosterReporter {
    static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "----" + NEWLINE;

    static final String ROSTER_REPORT_FOOTER = NEWLINE + "# Students = ";

    private final CourseSession session;

    public RosterReporter(final CourseSession session) {
        this.session = session;
    }

    public String getReport() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(ROSTER_REPORT_HEADER);

        for (Student student: session.getAllStudents()) {
            buffer.append(student.getFullName());
            buffer.append(NEWLINE);
        }

        buffer.append(ROSTER_REPORT_FOOTER).append(session.getNumberOfStudents()).append(NEWLINE);

        return buffer.toString();
    }
}