import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    Faculty faculty1=new Faculty("Mohammad", "klklkl@gmail.com");
    Courset course1=new Courset("Swer142", 3);
    Studentt stu1=new Studentt("Zainab", "asfdafsgh@gmail.com");
    
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
