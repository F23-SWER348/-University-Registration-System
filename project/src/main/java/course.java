import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class course {
    private String name;
    private int credits;
    private String faculty;
    private List<faculty> staff;
    private List<course> prerequisites;
    private Map<String,List<LocalTime>> weeklyTime;


    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public String getFaculty() {
        return faculty;
    }
    public List<faculty> getStaff() {
        return staff;
    }
    public List<course> getPrerequisites() {
        return prerequisites;
    }
    public Map<String, List<LocalTime>> getWeeklyTime() {
        return weeklyTime;
    }

   public void addStaff(faculty x){
    //add staff to the list of staff for this course
    staff.add(x);
   }
 
   public void addPrerequisite(course x){
    //add a new course as a prereqisite for this course
    prerequisites.add(x);
   }




}










