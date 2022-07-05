package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.TimetableController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Timetable;

@RestController
public class TimetableEndpoint {

    @Autowired
    private TimetableController timetableController;

    @RequestMapping(path = "/api/timetables", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<Timetable> getTimetables() {
        return timetableController.getTimetables();
    }
    
    @RequestMapping(path = "/api/timetables/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public Timetable getTimetable(@RequestParam(name="id") Long id) {
        return timetableController.getTimetable(id);
    }
}