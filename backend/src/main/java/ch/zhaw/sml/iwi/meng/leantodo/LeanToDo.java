package ch.zhaw.sml.iwi.meng.leantodo;

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
import ch.zhaw.sml.iwi.meng.leantodo.entity.Task;
import ch.zhaw.sml.iwi.meng.leantodo.entity.TaskRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Timetable;
import ch.zhaw.sml.iwi.meng.leantodo.entity.TimetableRepository;
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
    private TimetableRepository timetableRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureAssignmentRepository assignmentRepository;

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

        // Create default user and user role assignment
        User u = new User();
        u.setLoginName("user");
        u.setPasswordHash(new BCryptPasswordEncoder().encode("user"));
        Role r = new Role();
        r.setRoleName("ROLE_USER");
        roleRepository.save(r);
        u.getRoles().add(r);
        userRepository.save(u);

        // Create dummy timetables
        Timetable timetable1 = new Timetable("W.BA.WIN.19HS.VZa", "FS2022");
        Timetable timetable2 = new Timetable("W.BA.WIN.19HS.VZb", "FS2022");
        Timetable timetable3 = new Timetable("W.BA.WIN.19HS.VZc", "FS2022");

        // Create and save dummy tasks
        Task task1 = new Task("Task 1", "Description task 1", "11:00", "12:00", "Monday", false);
        Task task2 = new Task("Task 2", "Description task 2", "14:00", "15:00", "Monday", false);
        Task task3 = new Task("Task 3", "Description task 3", "11:00", "12:00", "Monday", false);
        Task task4 = new Task("Task 4", "Description task 4", "14:00", "15:00", "Monday", false);
        Task task5 = new Task("Task 5", "Description task 5", "11:00", "12:00", "Monday", false);
        Task task6 = new Task("Task 6", "Description task 6", "14:00", "15:00", "Monday", false);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
        taskRepository.save(task5);
        taskRepository.save(task6);
        
        // Add tasks to timetables
        timetable1.getTasks().add(task1);
        timetable1.getTasks().add(task2);
        timetable2.getTasks().add(task3);
        timetable2.getTasks().add(task4);
        timetable3.getTasks().add(task5);
        timetable3.getTasks().add(task6);
        
        // Save timetables
        timetableRepository.save(timetable1);
        timetableRepository.save(timetable2);
        timetableRepository.save(timetable3);

        // Create and save lectures
        Lecture lecture1 = new Lecture("w.2DVF", "Debatte und Verhandlungsführung", "stla", "SW 124");
        Lecture lecture2 = new Lecture("w.2EER", "Ehegüter- und Erbrecht", "fisc", "MB O3.30");
        Lecture lecture6 = new Lecture("w.2RPT", "Rhetorik und Präsentationstechnik", "alma", "SW 229");
        Lecture lecture3 = new Lecture("w.2FinverR", "Finanzverfassungsrecht", "sefe", "SW 229");
        Lecture lecture4 = new Lecture("w.2SPG", "Steuerplanung- und Gestaltung", "haje", "SM O2.29");
        Lecture lecture5 = new Lecture("w.2ISPBWLStL", "Interdisziplinärer Schwerpunkt Betriebswirtschaftliche Steuerlehre", "haje", "SW 323");
        Lecture lecture7 = new Lecture("w.2ISPUR", "Interdisziplinärer Schwerpunkt Unternehmensrecht", "bsel", "MB O3.30");
        Lecture lecture8 = new Lecture("w.2ISPVRMmgt", "Interdisziplinärer Schwerpunkt Verwaltungsrecht & Mmgt.", "husi", "MY O4.09");
        Lecture lecture9 = new Lecture("w.2Mind", "Mindfulness / Mindful Leadership", "jehl", "MB O3.18");
        lectureRepository.save(lecture1);
        lectureRepository.save(lecture2);
        lectureRepository.save(lecture3);
        lectureRepository.save(lecture4);
        lectureRepository.save(lecture5);
        lectureRepository.save(lecture6);
        lectureRepository.save(lecture7);
        lectureRepository.save(lecture8);
        lectureRepository.save(lecture9);

        // Create and save lecture assignments
        LectureAssignment assignment1 = new LectureAssignment("08:00", "10:00", "Monday", timetable1, lecture1);
        LectureAssignment assignment2 = new LectureAssignment("13:00", "14:00", "Monday", timetable1, lecture2);
        LectureAssignment assignment3 = new LectureAssignment("15:00", "17:00", "Monday", timetable1, lecture3);
        LectureAssignment assignment4 = new LectureAssignment("08:00", "10:00", "Monday", timetable2, lecture4);
        LectureAssignment assignment5 = new LectureAssignment("13:00", "14:00", "Monday", timetable2, lecture5);
        LectureAssignment assignment6 = new LectureAssignment("15:00", "17:00", "Monday", timetable2, lecture6);
        LectureAssignment assignment7 = new LectureAssignment("08:00", "10:00", "Monday", timetable3, lecture7);
        LectureAssignment assignment8 = new LectureAssignment("13:00", "14:00", "Monday", timetable3, lecture8);
        LectureAssignment assignment9 = new LectureAssignment("15:00", "17:00", "Monday", timetable3, lecture9);
        assignmentRepository.save(assignment1);
        assignmentRepository.save(assignment2);
        assignmentRepository.save(assignment3);
        assignmentRepository.save(assignment4);
        assignmentRepository.save(assignment5);
        assignmentRepository.save(assignment6);
        assignmentRepository.save(assignment7);
        assignmentRepository.save(assignment8);
        assignmentRepository.save(assignment9);
    }
}
