import java.util.Collections;
import java.util.List;
import java.util.Map;

public class semester {
    private String name;
    private int year;
    private List<course> courses;

//add Constructors
    public semester(String name, int year, List< course> courses) {
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
    public List<course> getCourses() {
        return courses;
    }


        // Method to add a course to the semester
    public void addCourse(course course) {
        courses.add( course);
    }
    
    // Method to get a course by name
    public void removeCourse(course courseName) {
         courses.remove(courseName);
    }


    public int getTotalCredits() {
        return courses.parallelStream().mapToInt(course::getCredits).sum();
    }

// method to display Semester Information
    public void displaySemesterInfo() {
        System.out.println("Semester: " + name + " " + year);
        System.out.println("Courses:");
        courses.forEach(e -> System.out.println( e.getName()));
        System.out.println("Total Credits: " + getTotalCredits());
    }
     
}


