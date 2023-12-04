import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class student extends user {

    Map<String,Double> Grades=new HashMap<>() ;
    List<course>courses=new ArrayList<>();


    public Map<String, Double> getGrades() {
        return Grades;
    }

    public List<course> getCourses() {
        return courses;
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
