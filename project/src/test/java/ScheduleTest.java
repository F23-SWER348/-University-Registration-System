import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.schedule;

public class ScheduleTest {
    private List<schedule> existingSchedules;


@Test
public void testCreateSchedule_NoConflict() {
    // Arrange
    schedule newSchedule = readScheduleFromFile("src/test/resources/schedule_data.txt");
    List<schedule> existingSchedules = new ArrayList<>();
    existingSchedules.add(new schedule("Monday", LocalTime.parse("09:00"), LocalTime.parse("10:30")));
    existingSchedules.add(new schedule("Wednesday", LocalTime.parse("13:00"), LocalTime.parse("14:30")));

    // Act
    schedule.createSchedule(newSchedule, existingSchedules);

    // Assert
    assertTrue(existingSchedules.contains(newSchedule));
}

private schedule readScheduleFromFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line = br.readLine();
        if (line != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String dayOfWeek = parts[0];
                LocalTime startTime = LocalTime.parse(parts[1]);
                LocalTime endTime = LocalTime.parse(parts[2]);
                return new schedule(dayOfWeek, startTime, endTime);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null; // Return null if there's an issue reading from the file
}

}
