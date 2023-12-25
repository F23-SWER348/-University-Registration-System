import java.util.ArrayList;
import java.util.List;

public class UniversityRegistrationSystem {
    private List<student> students;
    private List<Staff> facultyMembers;
    private List<semester> semesters;
    private List<course> courses;

    public UniversityRegistrationSystem() {
        this.students = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
        this.semesters = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public List<student> getStudents() {
        return students;
    }

    public List<Staff> getFacultyMembers() {
        return facultyMembers;
    }

    public List<semester> getSemesters() {
        return semesters;
    }

    public List<course> getCourses() {
        return courses;
    }

    // Method to add a new student
    public void addStudent(student student) {
        students.add(student);
    }

    // Method to add a new faculty member
    public void addFacultyMember(Staff faculty) {
        facultyMembers.add(faculty);
    }

    // Method to add a new semester
    public void addSemester(semester semester) {
        semesters.add(semester);
    }

    // Method to add a new course with conflict checking
    public void addCourse(course newCourse) {
        if (!hasScheduleConflict(newCourse)) {
            courses.add(newCourse);
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Schedule conflict! The course could not be added.");
            // Handle the conflict as needed (throw an exception, show a message, etc.)
        }
    }

    // Check if there is a schedule conflict with the new course
    private boolean hasScheduleConflict(course newCourse) {
        for (course existingCourse : courses) {
            if (haveConflictingMeetings(existingCourse, newCourse)) {
                return true;
            }
        }
        return false;
    }

    // Check if two courses have conflicting meetings
    private boolean haveConflictingMeetings(course course1, course course2) {
        for (WeeklyMeeting meeting1 : course1.getWeeklyMeetings()) {
            for (WeeklyMeeting meeting2 : course2.getWeeklyMeetings()) {
                if (meeting1.getDayOfWeek() == meeting2.getDayOfWeek() &&
                        !(meeting2.getEndTime().isBefore(meeting1.getStartTime()) ||
                                meeting2.getStartTime().isAfter(meeting1.getEndTime()))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to browse available courses
    public void browseCourses() {
        for (course course : courses) {
            System.out.println(course.getName() + " - " + course.getCredits() + " credits");
        }
    }

    // Method to register a student for a class
    public void registerStudentForClass(student student, course course) {
        if (course != null && student != null && course.getPrerequisites().stream().allMatch(student::hasCompletedCourse)) {
            course.enroll(student);
            System.out.println(student.getName() + " successfully registered for " + course.getName());
        } else {
            System.out.println("Registration unsuccessful. Prerequisites not met.");
            // Handle the prerequisites not met situation as needed
        }
    }

    // Method to enter grades for a student
    public void enterGrades(student student, course course, int grade) {
        if (student != null && course != null) {
            course.enterGrades(student, course, grade);
            // Additional logic can be added based on your requirements
        }
    }
}