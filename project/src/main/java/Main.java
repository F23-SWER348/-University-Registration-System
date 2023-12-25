import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        student stu1 = new student("John", "Science");
        stu1.addGrade(new course("Swer141", 3, "Science"),95.0);
        stu1.addGrade(new course("Swer142", 3, "Science"),88.0);   
        System.out.println(stu1.getAverage());
        System.out.println(stu1.getState());
        
        List<String> CoursesInSemester= Arrays.asList(readSemesterFile("semesterFile","Fall",2020));
   
    }

     public static String[] readSemesterFile(String fileName,String sem,int ye) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines()
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 3 && parts[0].equals(sem) && Integer.valueOf(parts[1]) == ye)
                    .findFirst()
                    .map(parts -> parts[2].split("-"))
                    .orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
