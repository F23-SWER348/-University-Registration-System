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

    public void addCourse(String courseCode, course course) {
        courses.put(courseCode, course);
    }

    public void removeCourse(String courseCode) {
        courses.remove(courseCode);
    }

    public boolean hasCourse(String courseCode) {
        return courses.containsKey(courseCode);
    }

    public course getCourse(String courseCode) {
        return courses.get(courseCode);
    }


    public int getTotalCredits() {
        return courses.values().stream()
                .mapToInt(course::getCredits)
                .sum();
    }

// method to display Semester Information
    public void displaySemesterInfo() {
        System.out.println("Semester: " + name + " " + year);
        System.out.println("Courses:");
        courses.forEach((code, course) ->
                System.out.println(code + ": " + course.getName())
        );
        System.out.println("Total Credits: " + getTotalCredits());
    }
     
}


