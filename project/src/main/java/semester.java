import java.util.List;
import java.util.Map;

public class semester {
    private String name;
    private int year;
    private Map<String, course> courses;

//add Constructors
    public semester(String name, int year, Map<String, course> courses) {
        this.name = name;
        this.year = year;
        this.courses = courses;
    }

    //add getters
    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public Map<String, course> getCourses() {
        return courses;
    }

//add setters
    public void setName(String name) {
        this.name = name;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public void setCourses(Map<String, course> courses) {
        this.courses = courses;
    } 

    public void addCourse(course course) {
        courses.put(course.getName(), course);
    }
    
}


