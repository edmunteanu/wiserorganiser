package ch.zhaw.sml.iwi.meng.leantodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Timetable;
import ch.zhaw.sml.iwi.meng.leantodo.entity.TimetableRepository;

@Component
public class TimetableController {

    @Autowired
    private TimetableRepository timetableRepository;

    public List<Timetable> getTimetables() {
        return timetableRepository.findAll();
    }
    
    public Timetable getTimetable(Long id) {
        return timetableRepository.getById(id);
    }
}