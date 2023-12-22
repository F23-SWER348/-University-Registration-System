package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class semester {
    private String name;
    private int year;
    private List<course> courses=new ArrayList<>();

//add Constructors
    public semester(String name, int year, List<course> courses) {
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
        courses.add(course);
    }


    public void removeCourse(String courseCode) {
        courses.remove(courseCode);
    }


    public int getTotalCredits() {
        return courses.parallelStream().mapToInt(course::getCredits).sum();
    }


     
}


