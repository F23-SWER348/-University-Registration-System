import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class stuTest {
    
    @Test
    public void testGetAverage(){
        student stu1 = new student("John", "Science");
        stu1.addGrade(new course("Swer141", 3, "Science"),95.0);
        stu1.addGrade(new course("Swer142", 3, "Science"),88.0);
        double avg=stu1.getAverage();
        assertEquals(avg,3.0);
    } 

    @Test
    public void testGetStateOfStudent(){

        student stu1 = new student("John", "Science");
        stu1.addGrade(new course("Swer141", 3, "Science"),95.0);
        stu1.addGrade(new course("Swer142", 3, "Science"),88.0);  

        assertEquals(stu1.getState(),"Honour");

    }



}
