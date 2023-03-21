package spring.model.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.*;
import spring.model.repository.interfacec.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
@Transactional
public class Allrepository implements Repository<Company, Course, Groups, Student, Teacher> {
    @Autowired//nаходит бины
    private SessionFactory sessionFactory;


    @Override
    public List<Groups> relationShipGroups(int id) {
        List<Groups> grop = new ArrayList<>();
        Company company = findByIdCompany(id);
        for (Groups groups : findAllGroup()) {
            Groups groups1 = findByIdGroup(groups.getId());
            if (groups1.getCompany().getId() == company.getId()) {
                grop.add(groups1);
            }
        }
        return grop;
    }

    @Override
    public List<Course> relationShipCourse(int id) {
        List<Course> cour = new ArrayList<>();
        Company company = findByIdCompany(id);
        for (Course course : findAllCourse()) {
            Course course1 = findByIdCourse(course.getId());
            if (course1.getCompany().getId() == company.getId()) {
                cour.add(course1);
            }
        }
        return cour;
    }

    @Override
    public List<Student> relationShipStudent(int id) {
        List<Student> stu = new ArrayList<>();
        Groups groups = findByIdGroup(id);
        for (Student student : findAllStudent()) {
            Student student1 = findByIdStudent(student.getId());
            if (student1.getGroup().getId() == groups.getId()) {
                stu.add(student1);
            }
        }
        return stu ;
}

    @Override
    public List<Teacher> relationShipTeacher(int id) {
        List<Teacher> teac = new ArrayList<>();
        Course course = findByIdCourse(id);
        for (Teacher teacher: findAllTeacher()) {
            Teacher teacher1 = findByIdTeacher(teacher.getId());
            if (teacher1.getCourse().getId() == course.getId()) {
                teac.add(teacher1);
            }
        }
        return teac;
    }

    public List<Company> findAllCompany() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    public void saveCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
    }

    @Override
    public void SaveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void saveGroups(Groups groups) {
        Session session = sessionFactory.getCurrentSession();
        session.save(groups);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    public void deleteCompany(int id) {
        Session session = sessionFactory.getCurrentSession();
        Company company = findByIdCompany(id);
        session.delete(company);
    }

    @Override
    public void deleteCourse(int id) {
        Session session = sessionFactory.getCurrentSession();
        Course course = findByIdCourse(id);
        session.delete(course);
    }

    @Override
    public void deleteGroups(int id) {
        Session session = sessionFactory.getCurrentSession();
        Groups groups = findByIdGroup(id);
        session.delete(groups);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = findByIdStudent(id);
        session.delete(student);
    }

    @Override
    public void deleteTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = findByIdTeacher(id);
        session.delete(teacher);
    }

    public void updateCompany(int id, Company company) {
        Session session = sessionFactory.getCurrentSession();
        Company company1 = findByIdCompany(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getCompanyName());
        session.merge(company1);
    }

    @Override
    public void updateCourse(int id, Course course) {
        Session session = sessionFactory.getCurrentSession();
        Course course1 = findByIdCourse(id);
        course1.setCourName(course.getCourName());
        course1.setDuration(course.getDuration());
        session.merge(course1);
    }

    @Override
    public void updateGroup(int id, Groups groups) {
        Session session = sessionFactory.getCurrentSession();
        Groups groups1 = findByIdGroup(id);
        groups1.setGroupName(groups.getGroupName());
        groups1.setDataStart(groups.getDataStart());
        groups1.setDataFinish(groups.getDataFinish());
        session.merge(groups1);
    }

    @Override
    public void updateStudent(int id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = findByIdStudent(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        session.merge(student1);
    }

    @Override
    public void updateTeacher(int id, Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = findByIdTeacher(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        session.merge(teacher);

    }

    public Company findByIdCompany(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }

    @Override
    public Course findByIdCourse(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public Groups findByIdGroup(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Groups.class, id);
    }

    @Override
    public Student findByIdStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public Teacher findByIdTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    @Override
    public List<Course> findAllCourse() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public List<Groups> findAllGroup() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Groups c", Groups.class).getResultList();
    }

    @Override
    public List<Student> findAllStudent() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Student c", Student.class).getResultList();
    }

    @Override
    public List<Teacher> findAllTeacher() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Teacher c", Teacher.class).getResultList();
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }


}
