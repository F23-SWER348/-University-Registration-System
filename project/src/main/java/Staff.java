import java.util.HashMap;
import java.util.Map;

public class Staff extends user{
    

    private Map<String, course> coursesTeaching = new HashMap<>();

    public Staff(String name,String contactDetails) {
        super(name, "Staff", contactDetails);
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



   