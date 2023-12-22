
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class schedule {
 
    
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public schedule(String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public static void createSchedule(schedule newSchedule,List<schedule> schedules) {  //done
        // Check for conflicts with existing schedules
        boolean conflict = schedules.stream()
                            .anyMatch(e -> e.getDayOfWeek().equals(newSchedule.getDayOfWeek()) &&
                                       ((newSchedule.getStartTime().compareTo(e.getEndTime()) >= 0) ||
                                             (newSchedule.getEndTime().compareTo(e.getStartTime()) <= 0)));
        if (!conflict) {
            schedules.add(newSchedule);
        } else {
            System.out.println("Schedule conflict! Unable to add the schedule.");
        }
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

