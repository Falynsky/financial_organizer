package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.DTO.SubjectsDTO;
import com.falynsky.financial_organizer.model.Subjects;
import com.falynsky.financial_organizer.repository.SubjectsRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/subjects")
public class SubjectsController {

    final SubjectsRepository subjectsRepository;

    public SubjectsController(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @GetMapping("/all")
    public List<SubjectsDTO> getAllSubjects() {
        return subjectsRepository.retrieveSubjectsAsDTO();
    }

    @GetMapping("/{id}")
    public SubjectsDTO getSubject(@PathVariable("id") Integer id) {
        return subjectsRepository.retrieveSubjectAsDTOById(id);
    }

    @Transactional
    @PostMapping("/update")
    public void updateSubject(@RequestBody Subjects data) {
        subjectsRepository.updateSubject(data);
    }
}
