package spring.springconfig;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.*;
import spring.model.repository.interfacec.Repository;

import javax.persistence.StoredProcedureParameter;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private final Repository<Company, Course, Groups, Student, Teacher> repository;

    public Controller(Repository<Company, Course, Groups, Student, Teacher> repository) {
        this.repository = repository;
    }
    @GetMapping("/")
    public String menu() {
        return "menu";
    }

    @GetMapping("tableCompany")//для маппинга HTTP GET запросов на определенный метод контроллера.
    public String tableCompany(Model model) {
        model.addAttribute("company", repository.findAllCompany());
        return "tableCompany";
    }

    @GetMapping("/companyForm")
    public String saveFormatCompany() {
        return "saveCompany";

    }

    @PostMapping("/saveCompany")
    private String saveCompany(@RequestParam("companyName") String companyName,
                               @RequestParam("locatedCountry") String locatedCountry) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        repository.saveCompany(company);
        return "redirect:/tableCompany";
    }

    @GetMapping("tableCourse")
    public String tableCourse(Model model) {
        model.addAttribute("course", repository.findAllCourse());
        return "tableCourse";
    }

    @GetMapping("tableGroups")
    public String tableGroups(Model model) {
        model.addAttribute("group", repository.findAllGroup());
        return "tableGroups";
    }

    @GetMapping("tableStudents")
    public String tableStudent(Model model) {
        model.addAttribute("student", repository.findAllStudent());
        return "tableStudent";
    }

    @GetMapping("tablesTeacher")
    public String tableTeacher(Model model) {
        model.addAttribute("teacher", repository.findAllTeacher());
        return "tableTeacher";
    }


    @GetMapping("/saveCourse")
    public String saveFormCourse(Model model) {
        model.addAttribute("Course", repository.findAllCompany());
        return "saveCourse";
    }

    @PostMapping("/saveCourse1")
    private String saveCourse(
            /*принимает параметры*/      @RequestParam("courName") String courName,
                                         @RequestParam("duration") String duration,
                                         @RequestParam("id") int id
    ) {
        Company company = repository.findByIdCompany(id);
        Course course = new Course();
        course.setCourName(courName);
        course.setDuration(duration);
        course.setCompany(company);
        repository.SaveCourse(course);
        return "redirect:/tableCourse";
    }

    @GetMapping("groupsForm")
    public String saveForGroups(Model model) {/*model - это интерфейс. И мы используем его методы*/
        model.addAttribute("Company", repository.findAllCompany());
        model.addAttribute("Course", repository.findAllCourse());
        return "saveGroups";

    }

    @PostMapping("saveGroup")
    private String saveGroup(
            @RequestParam("groupName") String groupName,
            @RequestParam("dataStart") String dataStart,
            @RequestParam("dataFinish") String dataFinish,
            @RequestParam("idCom") int idCom,
            @RequestParam("idCor") int idCor
    ) {
        Company company = repository.findByIdCompany(idCom);
        List<Course> courses = new ArrayList<>();
        Course course = repository.findByIdCourse(idCor);
        Groups groups = new Groups();
        courses.add(course);
        groups.setGroupName(groupName);
        groups.setDataStart(dataStart);
        groups.setDataFinish(dataFinish);
        groups.setCompany(company);
        groups.setCourses(courses);
        repository.saveGroups(groups);
        return "redirect:/tableGroups";
    }

    @GetMapping("saveStudent")
    public String saveForStudent(Model model) {/*model - это интерфейс. И мы используем его методы*/
        model.addAttribute("Groups", repository.findAllGroup());
        return "saveStudent";
    }

    @PostMapping("saveStudent1")
    private String saveStudent(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("IdGroup") int IdGroup
    ) {
        Groups groups1 = repository.findByIdGroup(IdGroup);
        Student student = new Student();
//        groups.add(groups1);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setGroup(groups1);
        repository.saveStudent(student);
        return "redirect:/tableStudents";

    }

    @GetMapping("/Teacher")
    public String saveForTeacher(Model model) {
        model.addAttribute("Teacher", repository.findAllCourse());
        return "saveTeacher";
    }

    @PostMapping("/saveTeacher")
    private String saveTeacher(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("IdCor") int IdCor
    ) {
        Course course = repository.findByIdCourse(IdCor);
        Teacher teacher = new Teacher();
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        teacher.setCourse(course);
        repository.saveTeacher(teacher);
        return "redirect:/tablesTeacher";
    }

    @GetMapping("/updateCompany/{id}")
    public String updateCompany(
            @PathVariable("id") int id, Model model
    ) {
        Company company = repository.findByIdCompany(id);
        model.addAttribute("bute", company);
        return "updateCom";
    }

    @PostMapping("/updateCompanyPost/{id}")
    private String updateCompanys(
            @RequestParam("companyName") String companyName,
            @RequestParam("locatedCountry") String locatedCountry,
            @PathVariable("id") int id

    ) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        repository.updateCompany(id, company);
        return "redirect:/tableCompany";
    }

    @GetMapping("/updateCourse/{id}")
    public String updateCourse(
            @PathVariable("id") int id, Model model
    ) {
        Course course = repository.findByIdCourse(id);
        model.addAttribute("ibu", course);
        return "updateCour";
    }

    @PostMapping("/updateCourses/{id}")
    private String updateCourse(
            @RequestParam("courName") String courName,
            @RequestParam("duration") String duration,
            @PathVariable("id") int id
    ) {
        Course course = new Course();
        course.setCourName(courName);
        course.setDuration(duration);
        repository.updateCourse(id, course);
        return "redirect:/tableCourse";
    }

    @GetMapping("/updateGroups/{id}")
    public String updateGroupForm(@PathVariable("id") int id, Model model) {
        Groups group = repository.findByIdGroup(id);
        model.addAttribute("ind", group);
        return "updateGroupe";
    }

    @PostMapping("/updateGroup/{id}")
    public String updateGroup(
            @RequestParam("groupName") String groupName,
            @RequestParam("dataStart") String dataStart,
            @RequestParam("dataFinish") String dataFinish,
            @PathVariable int id) {
        Groups group = new Groups();
        group.setGroupName(groupName);
        group.setDataStart(dataStart);
        group.setDataFinish(dataFinish);
        repository.updateGroup(id, group);
        return "redirect:/tableGroups";
    }
    @GetMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable("id") int id, Model model){
        Student student = repository.findByIdStudent(id);
        model.addAttribute("stu", student);
        return "updateStudent";
    }
    @PostMapping("/updateStudents/{id}")
    public String updateStudent(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @PathVariable int id){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        repository.updateStudent(id,student);
        return "redirect:/tableStudents";
    }
    @GetMapping("/updateTeacher{id}")
    public String updateTeacher(@PathVariable("id") int id, Model model){
        Teacher teacher = repository.findByIdTeacher(id);
        model.addAttribute("teac", teacher);
        return "updateTeacher";
    }
    @PostMapping("/updateTeacherr{id}")
    public String updateTeacher(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @PathVariable int id){
                Teacher teacher = new Teacher();
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setEmail(email);
                repository.updateTeacher(id,teacher);
                return "updateTeacherr";
    }
    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable int id) {
        repository.deleteCompany(id);
        return "redirect:/tableCompany";
    }
    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        repository.deleteCourse(id);
        return "redirect:/tableCourse";
    }
    @GetMapping("/deleteGroups/{id}")
    public String deleteGroups(@PathVariable int id) {
        repository.deleteGroups(id);
        return "redirect:/tableGroups";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        repository.deleteGroups(id);
        return "redirect:/tableStudents";
    }
    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable int id) {
        repository.deleteGroups(id);
        return "redirect:/tablesTeacher";
    }
    @GetMapping("/find/{id}")
    public String getAll(
            @PathVariable int id,
            Model model
    ){
        model.addAttribute("co",repository.findByIdCompany(id));
        model.addAttribute("com",repository.relationShipGroups(id));
        model.addAttribute("comi",repository.relationShipCourse(id));
        for (Groups groups:repository.relationShipGroups(id)) {
            if (repository.relationShipStudent(groups.getId()).size()>=1){
                model.addAttribute("comin",repository.relationShipStudent(groups.getId()));
            }
        }
        for (Course course :repository.relationShipCourse(id)) {
            if (repository.relationShipTeacher(course.getId()).size()>=1){
                model.addAttribute("comina",repository.relationShipTeacher(course.getId()));
            }
        }
        return "com";
    }
}