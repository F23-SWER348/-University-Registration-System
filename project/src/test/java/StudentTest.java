import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    private Studentt student;
    private List<Studentt> testStudents;
    private List<Courset> testCourses;
//For method hasCompletedCourse
    @Before
    public void setUp() {
        testStudents = new ArrayList<>();
        testCourses = new ArrayList<>();
        readTestDataFromFile("src/test/resources/stuudentf.txt");
        student = new Studentt("Nour", "202109947@bethlehem.edu");
    }

    private void readTestDataFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    Studentt testStudent = new Studentt(parts[0], parts[1]);
                    testStudents.add(testStudent);
                } else if (parts.length == 3) {
                    Courset testCourse = new Courset(parts[0], Integer.parseInt(parts[1]));
                    testCourses.add(testCourse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHasCompletedCourse() {
        for (Studentt testStudent : testStudents) {
            for (Courset testCourse : testCourses) {
                System.out.println("Testing course completion for student "
                        + testStudent.getName() + ": " + testCourse.getName());

                // Simulate completing a course for the student
                testStudent.completeCourse(testCourse, 90.0);

                assertTrue(testStudent.hasCompletedCourse(testCourse));
            }
        }
    }
    //---------------------------------------------------------------------------

//For completeCourse method 
    @Before
    public void setUp2() {
        // Read test data from the text file
        readTestDataFromFile2("src/test/resources/c.txt");

    }

    private void readTestDataFromFile2(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    // Assuming the first column is the name and the second is credits
                    // Create Courset objects and enroll in them as prerequisites
                    Courset testCourse = new Courset(parts[0], Integer.parseInt(parts[1]));
                    student.enrollInCourse(testCourse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCompleteCourse() {

        // Assuming you have a test data collection containing Courset objects
        // You can customize this based on your actual test data structure
        for (Courset testCourse : student.getCurrentCourses()) {
            System.out.println("Testing course completion for: " + testCourse.getName());
            student.completeCourse(testCourse, 90.0);
            assertTrue(student.hasCompletedCourse(testCourse));
            System.out.println("Course completion test passed for: " + testCourse.getName());

        }
    }

    //--------------------------------------------------------------------------------------

   @Before
    public void setUp3() {
        // Read test data from the text file
        readTestDataFromFile3("src/test/resources/c.txt");
    }

    private void readTestDataFromFile3(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Courset testCourse = new Courset(parts[0], Integer.parseInt(parts[1]));
                    student.enrollInCourse(testCourse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEnrollInCourse() {
        
        for (Courset testCourse : student.getCurrentCourses()) {
            System.out.println("Testing enrollment in course: " + testCourse.getName());
            student.enrollInCourse(testCourse);
            // Print a message based on the enrollment status
            if (student.getCurrentCourses().contains(testCourse)) {
                System.out.println("Course enrollment test passed for: " + testCourse.getName());
            } else {
                System.out.println("Course enrollment test failed for: " + testCourse.getName());
            }
        }
    }
    //-----------------------------------------------------------
    //
    
    @Before
    public void setUp4() {
        testStudents = new ArrayList<>();
        testCourses = new ArrayList<>();
        readTestDataFromFile("src/test/resources/stuudentf.txt");
    }

    private void readTestDataFromFile4(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    Studentt testStudent = new Studentt(parts[0], parts[1]);
                    testStudents.add(testStudent);
                } else if (parts.length == 3) {
                    Courset testCourse = new Courset(parts[0], Integer.parseInt(parts[1]));
                    testCourses.add(testCourse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDropCourse() {
        // Enroll the student in a course for testing
        Courset testCourse = new Courset("SWER141", 3);
        student.enrollInCourse(testCourse);

        // Drop the enrolled course
        System.out.println("Testing dropping a course for student " + student.getName() +
                ": " + testCourse.getName());
        student.dropCourse(testCourse);

        // Verify that the student is not currently enrolled in the dropped course
        assertFalse(student.getCurrentCourses().contains(testCourse));
    }
}
