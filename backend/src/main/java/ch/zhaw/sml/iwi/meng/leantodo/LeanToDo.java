package ch.zhaw.sml.iwi.meng.leantodo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Lecture;
import ch.zhaw.sml.iwi.meng.leantodo.entity.LectureAssignment;
import ch.zhaw.sml.iwi.meng.leantodo.entity.LectureAssignmentRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.LectureRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Role;
import ch.zhaw.sml.iwi.meng.leantodo.entity.RoleRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.StudyGroup;
import ch.zhaw.sml.iwi.meng.leantodo.entity.StudyGroupRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Task;
import ch.zhaw.sml.iwi.meng.leantodo.entity.TaskRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Timetable;
import ch.zhaw.sml.iwi.meng.leantodo.entity.TimetableRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ToDo;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ToDoRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.User;
import ch.zhaw.sml.iwi.meng.leantodo.entity.UserRepository;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class LeanToDo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LeanToDo.class, args);
        
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private StudyGroupRepository groupRepository;

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureAssignmentRepository assignmentRepository;
    
    @Autowired
    private ToDoRepository toDoRepository;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    // This is only really relevant for development, where we have different servers for frontend and backend
                    .allowedOrigins("http://localhost:8100")
                    .allowedMethods("GET", "PUT", "POST", "DELETE")
                    // AllowCredentials is necessary, as it sets 'Access-Control-Allow-Credentials'. 
                    // Otherwise Angular's HttpClient will not pass the Cookie back.
                    .allowCredentials(true);
            }
        };
    }

    @Override
    public void run(String... args) throws Exception {
        User u = new User();
        u.setLoginName("user");
        u.setPasswordHash(new BCryptPasswordEncoder().encode("user"));
        Role r = new Role();
        r.setRoleName("ROLE_USER");
        roleRepository.save(r);
        u.getRoles().add(r);
        userRepository.save(u);

        ToDo toDo = new ToDo();
        toDo.setTitle("Finish This app");
        toDo.setOwner("user");
        toDoRepository.save(toDo);

        toDo = new ToDo();
        toDo.setTitle("Reply to student");
        toDo.setOwner("user");
        toDoRepository.save(toDo);

        StudyGroup group = new StudyGroup();
        group.setName("W.BA.WIN.21HS.VZb");

        Timetable timetable = new Timetable();
        timetable.setSemester("HS2019");

        Task task = new Task();
        task.setName("Task 1");
        task.setDescription("Description task 1");
        task.setDate(new Date());
        task.setDone(false);
        taskRepository.save(task);
        
        timetable.getTasks().add(task);
        timetableRepository.save(timetable);

        group.getTimetables().add(timetable);
        groupRepository.save(group);

        Lecture lecture = new Lecture();
        lecture.setName("FSWD");
        lecture.setDescription("Full Stack Web Development");
        lecture.setProfessor("Max Meisterhans");
        lecture.setRoom("SI O4.04");
        lectureRepository.save(lecture);

        LectureAssignment assignment = new LectureAssignment();
        assignment.setLecture(lecture);
        assignment.setTimetable(timetable);
        assignment.setDate(new Date());
        assignmentRepository.save(assignment);
    }
}
