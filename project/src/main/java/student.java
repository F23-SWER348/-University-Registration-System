import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class student implements user {

    Map<String,Double> Grades=new HashMap<>() ;
    List<course>courses=new ArrayList<>();


    public Map<String, Double> getGrades() {
        return Grades;
    }

    public List<course> getCourses() {
        return courses;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public String getRole() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRole'");
    }

    @Override
    public String getContactDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContactDetails'");
    }

    // public String getState(){
    //     String state;
    //     // Extract the values containing grades and calculate the average
    //     OptionalDouble average = Grades.values().stream().mapToDouble(Double::doubleValue).average();

    //     if (average.isPresent()) {
    //        if(average>)

    //     } else {
    //         System.out.println("No grades available");
    //     }
    // }
   

}
