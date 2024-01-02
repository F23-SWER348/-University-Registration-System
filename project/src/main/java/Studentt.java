import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Studentt extends Person {
    private Map<Courset,Double> completedCourses;
    private List<Courset> currentCourses;

    public Studentt(String name, String contactDetails) {
        super(name, contactDetails);
            this.completedCourses = Collections.synchronizedMap(new HashMap<>());
        this.currentCourses = Collections.synchronizedList(new ArrayList<>());
    }

    public Map<Courset,Double> getCompletedCourses() {
        return completedCourses;
    }

    public List<Courset> getCurrentCourses() {
        return currentCourses;
    }

    // Method to check if the student has completed a specific course
    public boolean hasCompletedCourse(Courset course) {
        return completedCourses.containsKey(course);
    }

    // Method to mark a course as completed for the student
    public void completeCourse(Courset course,Double grade) {
        if (!completedCourses.containsKey(course)) {
            completedCourses.put(course,grade);
            System.out.println(name + " completed the course: " + course.getName());
        } else {
            System.out.println(name + " has already completed the course: " + course.getName());
            // Handle the situation where the course is already completed
        }
    }

    // Method to enroll in a course
    public void enrollInCourse(Courset course) {
        if (!currentCourses.contains(course) && !hasCompletedCourse(course)) {
            currentCourses.add(course);
            System.out.println(name + " enrolled in the course: " + course.getName());
        } else {
            System.out.println(name + " is already enrolled or has completed the course: " + course.getName());
            // Handle the situation where the student is already enrolled or has completed the course
        }
    }

    // Method to drop a course
    public void dropCourse(Courset course) {
        if (currentCourses.contains(course)) {
            currentCourses.remove(course);
            System.out.println(name + " dropped the course: " + course.getName());
        } else {
            System.out.println(name + " is not currently enrolled in the course: " + course.getName());
            // Handle the situation where the student is not enrolled in the course
        }
    }

     // Method to print the student's weekly schedule
     public void printWeeklySchedule() {
        System.out.println("Weekly Schedule for " + getName() + ":");
        for (Courset course : currentCourses) {
            System.out.println("Course: " + course.getName());
            List<WeeklyMeeting> courseSchedule = course.getWeeklyMeetings();
            for (WeeklyMeeting meeting : courseSchedule) {
                System.out.println("Day: " + meeting.getDayOfWeek() +
                        ", Time: " + meeting.getStartTime() + " - " + meeting.getEndTime());
            }
            System.out.println("-------------------------------");
        }
    }




}