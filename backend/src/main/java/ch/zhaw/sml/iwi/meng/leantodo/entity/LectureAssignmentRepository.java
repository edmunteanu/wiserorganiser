package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureAssignmentRepository extends JpaRepository<LectureAssignment, Long> {
    @Query("SELECT DISTINCT l FROM LectureAssignment la JOIN la.lecture l WHERE la.timetable.id = ?1")
    public List<Lecture> getByTimetableId(Long timetableId);
}