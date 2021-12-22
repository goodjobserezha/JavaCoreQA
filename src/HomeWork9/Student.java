package HomeWork9;

import java.util.ArrayList;
import java.util.List;


public class Student implements StudentInterface{
    private final String name;
    private final List<CourseInterface> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(Course course) {
        courses.add(course);
    }

    public List<CourseInterface> getAllCourses() {
        return courses;
    }
}
