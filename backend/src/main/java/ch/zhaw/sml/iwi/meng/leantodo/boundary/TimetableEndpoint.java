package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Optional<Timetable> getTimetable(@PathVariable(name="id") Long id) {
        return timetableController.getTimetable(id);
    }
}