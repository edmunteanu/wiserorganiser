package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureAssignmentRepository extends JpaRepository<LectureAssignment, Long> {
    @Query(value = "SELECT LECTURE.ID, LECTURE.DESCRIPTION, LECTURE.NAME, LECTURE.PROFESSOR, LECTURE.ROOM FROM LECTURE INNER JOIN LECTURE_ASSIGNMENT ON LECTURE.ID=LECTURE_ASSIGNMENT.LECTURE_ID WHERE LECTURE_ASSIGNMENT.TIMETABLE_ID=?1", nativeQuery = true)
    public List<Lecture> getByTimetableId(Long timetableId);
}