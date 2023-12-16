import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class student extends user {

    private Map<course,Double> Grades=new HashMap<>() ;
    List<course>courses=new ArrayList<>();

    public student(String name,String faculty) {
        super(name, "Student", faculty);
    }

    public Map<course, Double> getGrades() {
        return Grades;
    }

    public List<course> getCourses() {
        return courses;
    }

    public void addGrade(course c,Double d){
     Grades.put(c, d);
    }

    
    public void addCourseForStu(course c){
     courses.add(c);
    }

    public Double getAverage(){
        // Extract the values containing grades and calculate the average
        
        Double sum = Grades.entrySet().stream().mapToDouble( e -> e.getKey().getCredits() * e.getValue()).sum();
        Double sumOfCredits = Grades.values().parallelStream().reduce (0.0, (e1,e2) -> e1+e2 );

        Double average = sum / sumOfCredits;

        return average;
    }
   

       public String getState(){
       Double avg=this.getAverage();

       if(avg>=3.50)
           return "Dean's list";
        else if (avg>=3.00)
           return "Honour";
        else if(avg>=2)
        return "Unsatisfactory";

        return "Proberation";
        
}

}