import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class schedule extends course{
    
    private Map<String, Map<LocalTime,LocalTime>> weeklySchedule;   // Name of the day , and map to start time and end time 
    

    public schedule(String name, int credits, String faculty) {
        super(name, credits, faculty);
        this.weeklySchedule = new HashMap<>();
    }

    // // Additional constructor for Schedule class
    // public schedule(String name, int credits, String faculty, Map<String,  List<LocalTime>> weeklySchedule) {
    //     super(name, credits, faculty);
    //     this.weeklySchedule = weeklySchedule;
    // }
// Method to add weekly meeting sessions to the schedule
// public void addWeeklyMeetingSessions(String dayOfWeek, LocalTime startTime, LocalTime endTime) {
//     MeetingSession meetingSession = new MeetingSession(dayOfWeek, startTime, endTime);
//     weeklySchedule.computeIfAbsent(dayOfWeek, k -> new ArrayList<>()).add(meetingSession);
// }
    //   // Method to create a new course with weekly meeting sessions using Optional
    // public Optional<schedule2> createCourseWithSchedule(String courseName, int credits, String faculty) {
    //     schedule2 schedule = new schedule2(courseName, credits, faculty);

    //     // Example: Add Monday 10:00 – 11:15 and Friday 9:50 – 11:05
    //     schedule.addWeeklyMeetingSessions("Monday", LocalTime.of(10, 0), LocalTime.of(11, 15));
    //     schedule.addWeeklyMeetingSessions("Friday", LocalTime.of(9, 50), LocalTime.of(11, 5));

    //     // Other operations related to course creation can be added here

    //     return Optional.of(schedule);
    // }

    
 private static class MeetingSession {
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public MeetingSession(String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}

}
