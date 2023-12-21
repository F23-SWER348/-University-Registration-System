import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class stuTest {
   
    @Test
    public void testStudentReadGradesFromFile() throws IOException {
        // Get the path for the test resources directory
        String path = "src/test/resources";

        // Create a temporary file with sample grades in the test resources directory
        String fileName = path + "/studentFile.txt";
        String fileContent = "Mohammad,Science\nSwer141,90\nSwe142,80\nEnglish102,79.5";
        Files.write(Paths.get(fileName), fileContent.getBytes());

        // Create a student
        student testStudent = new student("Mohammad", "Science");

        // Read grades from the file in the test resources directory
        String absolutePath = new File(path).getAbsolutePath();
        System.out.println(absolutePath);

        assertTrue(absolutePath.endsWith("src/test/resources"));

        testStudent.readGradesFromFile(fileName);

        // Calculate and test the average
        assertEquals(83.17, testStudent.getAverage(), 0.01);

        // Test the state
        assertEquals("Honour", testStudent.getState());

        // Clean up: Delete the temporary file
        Files.deleteIfExists(Paths.get(fileName));
    }

    @Test
    public void testGetAverage() {
        // Create a student
        student studentObj = new student("John", "Science");

        // Add grades to the student
        course course1 = new course("Math", 3, "Science");
        studentObj.addGrade(course1, 90.0);

        course course2 = new course("Physics", 4, "Science");
        studentObj.addGrade(course2, 85.0);

        // Calculate the expected average
        double expectedAverage = (course1.getCredits() * 90.0 + course2.getCredits() * 85.0)
                / (course1.getCredits() + course2.getCredits());

        // Compare with the actual average
        assertEquals(expectedAverage, studentObj.getAverage(), 0.001);
    }

    @Test
    public void testGetState() {
        // Create a student
        student studentObj = new student("Jane", "Engineering");

        // Add grades to the student
        course course1 = new course("Programming", 3, "Engineering");
        studentObj.addGrade(course1, 78.0);

        course course2 = new course("Database", 3, "Engineering");
        studentObj.addGrade(course2, 92.0);

        // Calculate the expected state
        String expectedState = "Honour"; // Assuming the average is greater than 3.00

        // Compare with the actual state
        assertEquals(expectedState, studentObj.getState());
    }

    // Add more tests as needed

}
