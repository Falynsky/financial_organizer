package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {

    Subjects findBySubjectId(Integer id);

    @Modifying
    @Query("update Subjects s " +
            "set s.forename = :#{#subject.getForename()}," +
            "s.surename = :#{#subject.getSurename()}," +
            "s.email = :#{#subject.getEmail()} " +
            "where s.subjectId = :#{#subject.getSubjectId()}")
    void updateSubject(@Param("subject") Subjects subject);

}
