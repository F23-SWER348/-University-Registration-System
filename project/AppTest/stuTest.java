

public class stuTest {
    
    @Test
     Double getAverageTest(){
     
        Grade grade1 = new Grade("Math", 3.0); 
        Grade grade2 = new Grade("Science", 4.0);
        when(Grades.entrySet()).thenReturn(new HashMap<Grade, Double>() {{
            put(grade1, 80.0); // Assuming the values are grades represented as Doubles
            put(grade2, 90.0);
        }});

        when(Grades.values()).thenReturn(new HashMap<Grade, Double>() {{
            put(grade1, 3.0);
            put(grade2, 4.0);
        }}.values());

        YourClass yourClass = new YourClass(Grades); // Assuming your method is in a class called YourClass
        Double expectedAverage = (80.0 * 3.0 + 90.0 * 4.0) / (3.0 + 4.0); // Calculate expected average

        assertEquals(expectedAverage, yourClass.getAverage());

    }

}
