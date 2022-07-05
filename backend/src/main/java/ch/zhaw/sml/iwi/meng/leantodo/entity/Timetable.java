package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Timetable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String semester;

    @OneToMany(mappedBy = "timetable")
    private List<LectureAssignment> lectureAssignments = new ArrayList<>();

    @OneToMany
    private List<Task> tasks = new ArrayList<>();

    public Timetable() {

    }

    public Timetable(String name, String semester) {
        this.name = name;
        this.semester = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<LectureAssignment> getLectureAssignments() {
        return lectureAssignments;
    }

    public void setLectureAssignments(List<LectureAssignment> lectureAssignments) {
        this.lectureAssignments = lectureAssignments;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
