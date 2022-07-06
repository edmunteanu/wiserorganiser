package ch.zhaw.sml.iwi.meng.leantodo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LectureAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String startHour;
    private String endHour;
    private String day;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "timetable_id")
    private Timetable timetable;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public LectureAssignment() {

    }

    public LectureAssignment(String startHour, String endHour, String day, Timetable timetable, Lecture lecture) {
        this.startHour = startHour;
        this.endHour = endHour;
        this.day = day;
        this.timetable = timetable;
        this.lecture = lecture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
