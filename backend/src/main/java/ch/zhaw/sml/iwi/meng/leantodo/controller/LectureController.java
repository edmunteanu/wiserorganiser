package ch.zhaw.sml.iwi.meng.leantodo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Lecture;
import ch.zhaw.sml.iwi.meng.leantodo.entity.LectureAssignmentRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.LectureRepository;

@Component
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureAssignmentRepository lectureAssignmentRepository;

    public List<Lecture> getLectures(Long timetableId) {
        return lectureAssignmentRepository.getByTimetableId(timetableId);
    }

    public Optional<Lecture> getLecture(Long id) {
        return lectureRepository.findById(id);
    }
}