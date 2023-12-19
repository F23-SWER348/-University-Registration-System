import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Staff extends user{
    

    private List<course> coursesTeaching = new ArrayList<>();

    public Staff(String name, String role, String contactDetails) {
        super(name, "Staff", contactDetails);
    }

    // Getter methods specific to Faculty
    public List<course> getCoursesTeaching() {
        return coursesTeaching;
    }

    // to add course 
    public void addCourseTeaching(course course) {
        coursesTeaching.add(course);
    }

        // to remove course 
    public void removeCourseTeaching(course co) {
        coursesTeaching.remove(co);
    }
}



   