import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class FacultyTest {


    //For addTeachingCourse

    @Test
    public void testAddTeachingCourseFromFile() {
        // Adjust the file path accordingly
        String filePath = "src/test/resources/Faculty.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String facultyName = data[0].trim();
                String courseName = data[1].trim();

                Faculty faculty = new Faculty(facultyName, "ContactDetails");
                Courset course = new Courset(courseName, 3);

                faculty.addTeachingCourse(course);

                assertTrue(faculty.getTeachingCourses().contains(course));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//-------------------------------------------------------------------------------------------
// For removeTeachingCourse

    @Test
    public void testRemoveTeachingCourseFromFile() {
        // Adjust the file path accordingly
        String filePath = "src/test/resources/Faculty.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String facultyName = data[0].trim();
                String courseName = data[1].trim();

                Faculty faculty = new Faculty(facultyName, "ContactDetails");
                Courset course = new Courset(courseName, 3);

               
                faculty.removeTeachingCourse(course);

                assertFalse(faculty.getTeachingCourses().contains(course));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------------------
    @Test
   public void testGetWeeklyMeetingScheduleFromFile() {
        Faculty faculty = null;

        // Adjust the file path accordingly
        String filePath = "src/test/resources/F.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;

            // Read faculty details
            if ((line = reader.readLine()) != null) {
                String[] facultyData = line.split(",");
                String facultyName = facultyData[0].trim();
                String contactDetails = facultyData[1].trim();
                faculty = new Faculty(facultyName, contactDetails);
            }

            // Read course and meeting details
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String courseName = data[0].trim();
                int credits = Integer.parseInt(data[1].trim());
                DayOfWeek dayOfWeek = DayOfWeek.valueOf(data[2].trim());
                LocalTime startTime = LocalTime.parse(data[3].trim());
                LocalTime endTime = LocalTime.parse(data[4].trim());

                Courset course = new Courset(courseName, credits);
                WeeklyMeeting meeting = new WeeklyMeeting(dayOfWeek, startTime, endTime);
                course.addWeeklyMeeting(meeting);
                faculty.addTeachingCourse(course);
            }

            List<WeeklyMeeting> schedule = faculty.getWeeklyMeetingSchedule();

            // Verify the size of the schedule
            assertEquals(2, schedule.size());

            // Verify specific meetings in the schedule
            verifyMeetingInSchedule(schedule, DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0));
            verifyMeetingInSchedule(schedule, DayOfWeek.WEDNESDAY, LocalTime.of(14, 0), LocalTime.of(16, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void verifyMeetingInSchedule(List<WeeklyMeeting> schedule, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        for (WeeklyMeeting meeting : schedule) {
            if (meeting.getDayOfWeek() == dayOfWeek &&
                    meeting.getStartTime().equals(startTime) &&
                    meeting.getEndTime().equals(endTime)) {
                return; // Meeting found in the schedule
            }
        }
        throw new AssertionError("Meeting not found in the schedule: " + dayOfWeek + " " + startTime + "-" + endTime);
    }
}
