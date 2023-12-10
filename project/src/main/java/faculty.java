import java.util.HashMap;
import java.util.Map;

public class faculty extends user{
    

    private Map<String, course> coursesTeaching = new HashMap<>();

    public faculty(String name, String role, String contactDetails) {
        super(name, role, contactDetails);
    }

    // Getter methods specific to Faculty
    public Map<String, course> getCoursesTeaching() {
        return coursesTeaching;
    }

    // to add course 
    public void addCourseTeaching(course course) {
        coursesTeaching.put(course.getName(), course);
    }

        // to remove course 
    public void removeCourseTeaching(String courseName) {
        coursesTeaching.remove(courseName);
    }
}



   