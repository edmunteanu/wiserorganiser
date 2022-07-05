package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.LectureController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Lecture;

@RestController
public class LectureEndpoint {

    @Autowired
    private LectureController lectureController;
    
    @RequestMapping(path = "api/timetables/{id}/lectures", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<Lecture> getLectures(@RequestParam(name="id") Long timetableId) {
        return lectureController.getLectures(timetableId);
    }

    @RequestMapping(path = "/api/lectures/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public Lecture getLecture(@RequestParam(name="id") Long id) {
        return lectureController.getLecture(id);
    }
}