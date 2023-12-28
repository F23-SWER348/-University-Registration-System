
    import java.time.DayOfWeek;
    import java.time.LocalTime;
    import java.util.ArrayList;
    import java.util.List;

    public class Faculty extends Person {

        private List<Courset> teachingCourses;
        private List<WeeklyMeeting> facultyMeetings;

        public Faculty(String name, String contactDetails) {
            super(name, contactDetails);
            this.teachingCourses = new ArrayList<>();
        }

        public List<Courset> getTeachingCourses() {
            return teachingCourses;
        }

        
        // Check if the faculty is available during the specified time
        public boolean isAvailable(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
            // Implement the logic to check faculty availability here

            // For simplicity, let's assume the faculty is always available if they have no conflicting meetings
            return facultyMeetings.stream()
                    .noneMatch(meeting ->
                            meeting.getDayOfWeek() == dayOfWeek &&
                                    !(endTime.isBefore(meeting.getStartTime()) || startTime.isAfter(meeting.getEndTime()))
                    );
        }


        // Method to add a course to the faculty's teaching schedule
        public void addTeachingCourse(Courset course) {
            if (!teachingCourses.contains(course)) {
                teachingCourses.add(course);
                System.out.println(getName() + " is now teaching the course: " + course.getName());
            } else {
                System.out.println(getName() + " is already teaching the course: " + course.getName());
                // Handle the situation where the faculty is already teaching the course
            }
        }

        // Method to remove a course from the faculty's teaching schedule
        public void removeTeachingCourse(Courset course) {
            if (teachingCourses.contains(course)) {
                teachingCourses.remove(course);
                System.out.println(getName() + " stopped teaching the course: " + course.getName());
            } else {
                System.out.println(getName() + " is not currently teaching the course: " + course.getName());
                // Handle the situation where the faculty is not teaching the course
            }
        }

        // Method to get the weekly meeting schedule for the faculty
        public List<WeeklyMeeting> getWeeklyMeetingSchedule() {
            List<WeeklyMeeting> schedule = new ArrayList<>();
            for (Courset course : teachingCourses) {
                schedule.addAll(course.getWeeklyMeetings());
            }
            return schedule;
        }
    }