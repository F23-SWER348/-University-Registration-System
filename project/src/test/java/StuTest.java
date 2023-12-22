import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.student;

public class StuTest {
    @Test 
void testSum1Plus1(){
   
   long answer = student.add(1, 1);
   assertEquals(2, answer);

}
}
