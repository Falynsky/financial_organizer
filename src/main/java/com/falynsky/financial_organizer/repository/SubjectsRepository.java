package com.falynsky.financial_organizer.repository;

import com.falynsky.financial_organizer.model.DTO.SubjectsDTO;
import com.falynsky.financial_organizer.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Integer> {

    Subjects findBySubjectId(Integer id);

    @Modifying
    @Query(value = "update Subjects s " +
            "set s.subject_id = :#{#subject.getSubjectId()}," +
            "s.forename = :#{#subject.getForename()}," +
            "s.surename = :#{#subject.getSurename()}," +
            "s.email = :#{#subject.getEmail()} " +
            "where s.subject_id = :#{#subject.getSubjectId()}", nativeQuery = true)
    void updateSubject(@Param("subject") SubjectsDTO subject);

    @Query("SELECT s FROM Subjects AS s")
    List<Subjects> findAll();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.SubjectsDTO(s.subjectId, s.forename, s.surename, s.email) FROM Subjects s")
    List<SubjectsDTO> retrieveSubjectsAsDTO();

    @Query("SELECT new com.falynsky.financial_organizer.model.DTO.SubjectsDTO(s.subjectId, s.forename, s.surename, s.email) FROM Subjects s where s.subjectId = :subjectId")
    SubjectsDTO retrieveSubjectAsDTOById(@Param("subjectId") Integer subjectId);

}
