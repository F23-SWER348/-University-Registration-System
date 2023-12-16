import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class course {
    private String name;
    private int credits;
    private String faculty;
    private List<Staff> staff;
    private List<course> prerequisites;
    private Map<String,List<LocalTime>> weeklyTime;//day and date


    
    public course(String name, int credits, String faculty) {
        this.name = name;
        this.credits = credits;
        this.faculty = faculty;
    }


    
    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public String getFaculty() {
        return faculty;
    }
    public List<Staff> getStaff() {
        return staff;
    }
    public List<course> getPrerequisites() {
        return prerequisites;
    }
    public Map<String, List<LocalTime>> getWeeklyTime() {
        return weeklyTime;
    }

   public void addStaff(Staff x){
    //add staff to the list of staff for this course
    staff.add(x);
   }
 
   public void addPrerequisite(course x){
    //add a new course as a prereqisite for this course
    prerequisites.add(x);
   }

      public void removePrerequisite(course x){
    //add a new course as a prereqisite for this course
    prerequisites.remove(x);
   }



   


}










