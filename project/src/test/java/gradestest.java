import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.junit.Test;

public class gradestest {

    private student testStudent;

    @BeforeEach
   public void setUp() {
        // Initialize test data from file
        testStudent = readStudentFromFile("src/test/resources/studentFile.txt");
    }
    @Test
    public void testGetAverage() {
        // Ensure testStudent is not null before proceeding with the test
        if (testStudent != null) {
            // Act
            double average = testStudent.getAverage();

            // Assert
            assertEquals(3.75, average, 0.01); // Adjust the expected value as needed
        } else {
            // Print an error message or fail the test if testStudent is null
            System.err.println("testStudent is null. Test cannot be executed.");
        }
    }
    private student readStudentFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String name = parts[0];
                    String faculty = parts[1];
                    student studentObj = new student(name, faculty);

                    for (int i = 2; i < parts.length; i++) {
                        String[] gradeParts = parts[i].split("-");
                        if (gradeParts.length == 2) {
                            String courseName = gradeParts[0];
                            Double grade = Double.parseDouble(gradeParts[1]);
                            course courseObj = new course(courseName, 0, "DefaultFaculty");
                            studentObj.addGrade(courseObj, grade);
                        }
                    }
                    return studentObj;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if there's an issue reading from the file
    }
}
