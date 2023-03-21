package spring.model.repository.interfacec;

import spring.model.Course;
import spring.model.Groups;

import java.util.List;
public interface Repository<Company, Course, Group, Student, Teacher>//generate
{
    List<Groups> relationShipGroups(int id);
    List<Course> relationShipCourse(int id);
    List<Student> relationShipStudent(int id);
    List<Teacher> relationShipTeacher(int id);
    List<Company> findAllCompany();

    void saveCompany(Company company);
    void SaveCourse(Course course);
    void saveGroups(Group group);
    void saveTeacher(Teacher teacher);

    void deleteCompany(int id);
    void deleteCourse(int id);
    void deleteGroups(int id);
    void deleteStudent(int id);
    void deleteTeacher(int id);

    Company findByIdCompany(int id);
    Course findByIdCourse(int id);
    Group findByIdGroup(int id);
    Student findByIdStudent(int id);
    Teacher findByIdTeacher(int id);
    void updateCompany(int id, Company company);
    void updateCourse(int id, Course course);
    void updateGroup(int id, Group group);
    void updateStudent(int id, Student student);
    void updateTeacher(int id, Teacher teacher);


    List<Course> findAllCourse();

    List<Groups> findAllGroup();

    List<Student> findAllStudent();

    List<Teacher> findAllTeacher();
    void saveStudent(Student student);


}