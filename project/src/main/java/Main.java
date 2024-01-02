import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
   
     public static void main(String[] args) {

      
            // Creating a student
            Studentt student = new Studentt("John Doe", "john.doe@example.com");
    
            // Creating a course
            Courset course = new Courset("Math 101", 3);

            // Adding a weekly meeting to the course
            course.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0)));

            // Creating a course
            Courset course2 = new Courset("English", 3);
    
            // Adding a weekly meeting to the course
            course2.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0)));
  


            // Adding the course to the student's schedule
            student.addCourse(course);
            student.addCourse(course2);

            // Displaying the student's weekly schedule
            student.printWeeklySchedule();
        
     }
}
