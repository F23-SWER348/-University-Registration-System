import java.util.ArrayList;
import java.util.List;

public class Studentt extends Person {
    private List<Courset> completedCourses;
    private List<Courset> currentCourses;

    public Studentt(String name, String contactDetails) {
        super(name, contactDetails);
        this.completedCourses = new ArrayList<>();
        this.currentCourses = new ArrayList<>();
    }

    public List<Courset> getCompletedCourses() {
        return completedCourses;
    }

    public List<Courset> getCurrentCourses() {
        return currentCourses;
    }

    // Method to check if the student has completed a specific course
    public boolean hasCompletedCourse(Courset course) {
        return completedCourses.contains(course);
    }

    // Method to mark a course as completed for the student
    public void completeCourse(Courset course) {
        if (!completedCourses.contains(course)) {
            completedCourses.add(course);
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
}