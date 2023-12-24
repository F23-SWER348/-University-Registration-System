
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    Map<course,schedule> schSem=new HashMap<>() ;

    public student(String name,String faculty) {
        super(name, "Student", faculty);
    }

    public Map<course, Double> getGrades() {
        return Grades;
    }


    public void addGrade(course c,Double d){
     Grades.put(c, d);
    }

 
    public Double getAverage(){ //done

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


public void printSchedual(){

}





//  public void readGradesFromFile(String fileName) {
//         try ( BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 processLine(line);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private void processLine(String line) {

//         String[] parts = line.split(",");
//         if (parts.length >= 3) { // Assuming the file format is correct
//             for (int i = 2; i < parts.length; i++) {
//                 String[] gradeParts = parts[i].split("-");
//                 if (gradeParts.length == 2) {
//                     String courseName = gradeParts[0];
//                     Double grade = Double.parseDouble(gradeParts[1]);
//                     course courseObj = new course(courseName, 0, "DefaultFaculty"); // Adjust with appropriate values
//                     addGrade(courseObj, grade);
//                 }
//             }
//         }
//     }
    
}
