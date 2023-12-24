
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class course {

    private String name;
    private int credits;
    private String faculty;
    private List<Staff> staff=new ArrayList<>();
    private List<course> prerequisites=new ArrayList<>();
    private List<schedule> schedules=new ArrayList<>();




//testtttt
    
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
    public List<schedule> getschedules() {
        return schedules;
    }

//add scheduale to the list of scheduales for this course
   public void addSchedules(schedule newSchedule) {
     schedule.createSchedule(newSchedule,schedules);
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










