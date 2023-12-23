
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class student extends user {


    private Map<course,Double> Grades=new HashMap<>() ;

    public student(String name,String faculty) {
        super(name, "Student", faculty);
    }

    public Map<course, Double> getGrades() {
        return Grades;
    }


    public void addGrade(course c,Double d){
     Grades.put(c, d);
    }

 public Double getAverage() {
    // Extract the values containing grades and calculate the average
    double sum = Grades.entrySet().stream()
            .mapToDouble(e -> e.getKey().getCredits() * Optional.ofNullable(e.getValue()).orElse(0.0))
            .sum();

    double sumOfCredits = Grades.values().parallelStream()
            .filter(Objects::nonNull)
            .reduce(0.0, (e1, e2) -> e1 + e2);

    // Avoid division by zero
    return (sumOfCredits != 0.0) ? sum / sumOfCredits : 0.0;
}


public String getState() {
    Double avg = this.getAverage();

    if (avg >= 3.50)
        return "Dean's list";
    else if (avg >= 3.00)
        return "Honour";
    else if (avg >= 2)
        return "Unsatisfactory";

    return "Probation";
}

public void readGradesFromFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            processLine(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void processLine(String line) {
    String[] parts = line.split(",");
    if (parts.length >= 3) { // Assuming the file format is correct
        for (int i = 2; i < parts.length; i++) {
            String[] gradeParts = parts[i].split("-");
            if (gradeParts.length == 2) {
                String courseName = gradeParts[0];
                Double grade = Double.parseDouble(gradeParts[1]);
                
                // Use the appropriate constructor for creating Course objects
                course courseObj = new course(courseName, 0, "DefaultFaculty");
                addGrade(courseObj, grade);
            }
        }
    }
}

    
}
