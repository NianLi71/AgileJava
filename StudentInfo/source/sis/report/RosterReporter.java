package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Session;
import sis.studentinfo.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static sis.report.ReportConstant.NEWLINE;

public class RosterReporter {
    static final String ROSTER_REPORT_HEADER = "Student%n-%n";

    static final String ROSTER_REPORT_FOOTER = "%n# students = %d%n";

    private final Session session;

    public RosterReporter(final Session session) {
        this.session = session;
    }

    public void writeReport(Writer writer) throws IOException {
        writeHeader(writer);
        writeBody(writer);
        writeFooter(writer);
    }

    public void writeReport(String filename) throws IOException {
        Writer bufferedWriter = new BufferedWriter(new FileWriter(filename));
        try {
            writeReport(bufferedWriter);
        } finally {
            bufferedWriter.close();
        }
    }

    private void writeHeader(Writer writer) throws IOException {
        writer.write(String.format(ROSTER_REPORT_HEADER));
    }

    private void writeBody(Writer writer) throws IOException {
        for (Student student: session.getAllStudents()) {
            writer.write(String.format(student.getFullName() + "%n"));
        }
    }

    private void writeFooter(Writer writer) throws IOException {
        writer.write(String.format(ROSTER_REPORT_FOOTER, session.getNumberOfStudents()));
    }
}