import java.util.Collections;
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

        // Method to add a course to the semester
    public void addCourse(course course) {
        courses.put(course.getName(), course);
    }
    
    // Method to get a course by name
    public course getCourseByName(String courseName) {
        return courses.get(courseName);
    }


    // Method to view prerequisites for a course
    public List<course> viewPrerequisites(String courseName) {
        course course = getCourseByName(courseName);
        if (course != null) {
            return course.getPrerequisites();
        }
        return Collections.emptyList();
    }



     // Method to register a student for a course
    /*  public void registerStudentForCourse(student student, String courseName) {
        course course = getCourseByName(courseName);
        if (course != null) {
            course.addStudent(student);
        }
    }
    */
}


