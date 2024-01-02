import java.util.ArrayList;
import java.util.List;

public class Semestert {
    private String name;
    private int year;
    private List<Courset> courses;

    public Semestert(String name, int year) {
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Courset> getCourses() {
        return courses;
    }

    // Method to add a course to the semester
    public void addCourse(Courset course) {
        courses.add(course);
        System.out.println("Course added to " + name + " semester: " + course.getName());
    }

    // Method to get the course schedule for the semester
    public  List<WeeklyMeeting> getCourseSchedule() {
        List<WeeklyMeeting> schedule = new ArrayList<>();
        for (Courset course : courses) {
            schedule.addAll(course.getWeeklyMeetings());
        }
        return schedule;
    }
}