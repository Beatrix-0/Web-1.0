public class AdvisedCourse {
    String StudentId;
    String CourseCode ;

    public AdvisedCourse(String StudentId, String CourseCode) {
        this.StudentId = StudentId;
        this.CourseCode = CourseCode;
    }

    public String toString() {
        return StudentId + "," + CourseCode;
    }
}
