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
            Courset course1 = new Courset("Math 101", 3);
            course1.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(3, 0))); // Adding a weekly meeting to the course
            course1.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(4, 0)));

            // Creating a course
            Courset course2 = new Courset("Math 101", 3);
            course2.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(1, 40), LocalTime.of(2, 0)));

            // Creating a course
            Courset course3 = new Courset("English", 3);
            course3.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0)));

            // Creating a course
            Courset course5 = new Courset("Arabic120", 3);
            course5.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.SUNDAY, LocalTime.of(1, 0), LocalTime.of(2, 0)));
  
            // Adding the courses to the student's schedule
            student.addCourse(course1);
            student.addCourse(course2);
            student.addCourse(course3);
            student.addCourse(course5);

            // Displaying the student's weekly schedule
            student.printWeeklySchedule();
            student.completeCourse(course1, 0.0);
            student.completeCourse(course3, 3.0);
            student.completeCourse(course5, 2.2);
 
            
            System.out.println(student.calculateGPA()); 
            System.out.println(student.getStudentStatus()); 

            // Creating a faculty
             Faculty fac1=new Faculty("Mohammad", "123@gmail.com");

             // Creating a course
             Courset course4 = new Courset("Math 141", 3);
             course4.addWeeklyMeeting(new WeeklyMeeting(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0)));

             // Adding the courses to the faculty's schedule
             fac1.addTeachingCourse(course4);
             fac1.addTeachingCourse(course4); 

             // Displaying the faculty's weekly schedule
             System.out.println(fac1.getWeeklyMeetingSchedule());

















        
     }
}
