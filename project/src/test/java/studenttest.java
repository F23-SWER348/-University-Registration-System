import static org.junit.Assert.assertEquals;

public class studenttest {

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
