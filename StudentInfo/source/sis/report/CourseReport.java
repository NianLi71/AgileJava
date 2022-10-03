package sis.report;

import sis.studentinfo.CourseSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static sis.report.ReportConstant.NEWLINE;

public class CourseReport {
    private final List<CourseSession> sessions = new ArrayList<>();

    public void add(final CourseSession session) {
        sessions.add(session);
    }

    public String text() {
        Collections.sort(sessions);

        StringBuilder builder = new StringBuilder();
        for (CourseSession session: sessions) {
            builder.append(session.getDepartment()).append(' ').append(session.getNumber()).append(NEWLINE);
        }

        return builder.toString();
    }
}
