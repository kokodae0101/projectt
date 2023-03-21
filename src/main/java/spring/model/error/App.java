package spring.model.error;

import spring.model.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Company company = new Company();
        Course course = new Course();
        Teacher teacher = new Teacher();
        teacher.setCourse(course);
        course.setTeacher(teacher);
        course.setCompany(company);
        Groups groups = new Groups();
        Student student = new Student();
        List<Student> students = new ArrayList<>();
        student.setGroup(groups);
        students.add(student);
        groups.setStudents(students);
        groups.setCompany(company);
        List<Groups> groups1 = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        groups1.add(groups);
        courses.add(course);
        course.setGroups(groups1);
        groups.setCourses(courses);
        company.setCourse(courses);
        company.setGroups(groups1);
        repository.save(company);
    }
}
