import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class student extends user {

    Map<course,Double> Grades=new HashMap<>() ;
    List<course>courses=new ArrayList<>();

     
    public Map<course, Double> getGrades() {
        return Grades;
    }

    public List<course> getCourses() {
        return courses;
    }

    public Double getState(){
        String state;
        // Extract the values containing grades and calculate the average
        
        Double sum = Grades.entrySet().stream().mapToDouble( e -> e.getKey().getCredits() * e.getValue()).sum();
        Double sumOfCredits = Grades.values().parallelStream().reduce (0.0, (e1,e2) -> e1+e2 );

        Double average = sum / sumOfCredits;

        return average;
    }
   

}
