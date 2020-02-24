package com.falynsky.financial_organizer.controller;

import com.falynsky.financial_organizer.model.Subjects;
import com.falynsky.financial_organizer.repository.SubjectsRepository;
import org.springframework.web.bind.annotation.*;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class MainController {
    final SubjectsRepository subjectsRepository;

    public MainController(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @GetMapping("/subjects")
    public List<Subjects> getAllEmployees() {
        return subjectsRepository.findAll();
    }

    @GetMapping("/subject/{id}")
    public Subjects getEmployee(@PathVariable("id") Integer id) {
        return subjectsRepository.findBySubjectId(id);
    }

    @Transactional
    @PostMapping("/subject")
    public void updateSubject(@RequestBody Subjects data) {
        subjectsRepository.updateSubject(data);
    }


}
