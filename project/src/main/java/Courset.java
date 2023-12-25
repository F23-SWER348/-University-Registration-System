import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Courset {

    private String name;
    private int credits;
    private List<Faculty> faculty;
    private List<WeeklyMeeting> weeklyMeetings;
    private List<Courset> prerequisites;
    private List<Studentt> enrolledStudents;

    public Courset(String name, int credits,Faculty faculty) {
        this.name = name;
        this.credits = credits;
        this.faculty = new ArrayList<>();
        this.weeklyMeetings = new ArrayList<>();
        this.prerequisites = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public List<Faculty> getFaculty() {
        return faculty;
    }

    public void addFaculty(Faculty newFa){
       faculty.add(newFa);
    }

    public List<WeeklyMeeting> getWeeklyMeetings() {
        return weeklyMeetings;
    }

    public List<Courset> getPrerequisites() {
        return prerequisites;
    }

    public List<Studentt> getEnrolledStudents() {
        return enrolledStudents;
    }



    // Method to add a prerequisite course
    public void addPrerequisite(Courset prerequisite) {
        prerequisites.add(prerequisite);
    }

    // Method to enroll a student in the course
    public void enroll(Studentt student) {
        if (!enrolledStudents.contains(student) && prerequisitesSatisfied(student)) {
            enrolledStudents.add(student);
            System.out.println(student.getName() + " successfully enrolled in " + name);
        } else {
            System.out.println("Enrollment unsuccessful. Prerequisites not met or already enrolled.");
            // Handle the prerequisites not met or already enrolled situation as needed
        }
    }


    // Check if the prerequisites for the course are satisfied by the student
    private boolean prerequisitesSatisfied(Studentt student) {
        return prerequisites.stream().allMatch(student::hasCompletedCourse);
    }


   // od to add a weekly meeting to the course
    public void addWeeklyMeeting(WeeklyMeeting meeting) {
        // Validate that at least one faculty is available during the meeting time
        if (isAnyFacultyAvailable(meeting.getDayOfWeek(), meeting.getStartTime(), meeting.getEndTime())) {
            weeklyMeetings.add(meeting);
            System.out.println("Weekly meeting added successfully.");
        } else {
            System.out.println("No available faculty during the specified meeting time.");
            // Handle the situation where no faculty is available as needed
        }
    }


    // Check if at least one faculty is available during the specified time
    private boolean isAnyFacultyAvailable(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        return faculty.stream().anyMatch(faculty ->
                faculty.isAvailable(dayOfWeek, startTime, endTime));
    }


}
