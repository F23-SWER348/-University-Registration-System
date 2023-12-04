import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class faculty implements user {
 private String name;
    private String contactDetails;
    private String role;
    private Map<String, course> coursesTeaching = new HashMap<>();

    @Override
    public String getName() {
return name;

}

    @Override
    public String getRole() {
       return role;
    }

    @Override
    public String getContactDetails() {
        return contactDetails;

    }
    

    // to add teachers 
    public void addCourseTeaching(course course) {
        coursesTeaching.put(course.getName(), course);
    }

        // to remove teachers 
    public void removeCourseTeaching(String courseName) {
        coursesTeaching.remove(courseName);
    }
}
