import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class Courset2Test {

    private static final String TEST_VALUES = "src/test/resources/Course.txt";

    @Test
    public void testAddWeeklyMeetingNoConflict() {
        Courset course = new Courset("SWER348", 3);
        Faculty faculty = new Faculty("Rawan", "rawang@bethlehem.edu");
        course.addFaculty(faculty);

        // Reading values from the file for test 1
        WeeklyMeeting meeting = readWeeklyMeetingFromTestValues(1);

        // Expecting successful addition
        course.addWeeklyMeeting(meeting);
        assertTrue(course.getWeeklyMeetings().contains(meeting));
    }

    @Test
    public void testAddWeeklyMeetingWithConflict() {
        Courset course = new Courset("SWER351", 3);
        Faculty faculty = new Faculty("Anas", "asamara@bethlehem.edu");
        course.addFaculty(faculty);

        // Reading values from the file for test 2
        WeeklyMeeting conflictingMeeting = readWeeklyMeetingFromTestValues(2);

        // Adding a conflicting weekly meeting
        WeeklyMeeting existingMeeting = new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0));
        course.addWeeklyMeeting(existingMeeting);

        // Expecting conflict and no addition
        course.addWeeklyMeeting(conflictingMeeting);
        assertFalse(course.getWeeklyMeetings().contains(conflictingMeeting));
    }

    private WeeklyMeeting readWeeklyMeetingFromTestValues(int testNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_VALUES))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("# Test " + testNumber)) {
                    return readWeeklyMeeting(reader);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Test values not found for Test " + testNumber);
    }

    private WeeklyMeeting readWeeklyMeeting(BufferedReader reader) throws IOException {
        DayOfWeek dayOfWeek = null;
        LocalTime startTime = null;
        LocalTime endTime = null;

        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "dayOfWeek":
                        dayOfWeek = DayOfWeek.valueOf(value);
                        break;
                    case "startTime":
                        startTime = LocalTime.parse(value);
                        break;
                    case "endTime":
                        endTime = LocalTime.parse(value);
                        break;
                }
            }
        }

        return new WeeklyMeeting(dayOfWeek, startTime, endTime);
    }
}
