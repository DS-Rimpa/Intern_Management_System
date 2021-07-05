package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateDesignation;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.service.DesignationService;
import com.intern.test.internmanagesys.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DesignationControl {

    private DesignationService designationService;

    @Autowired
    public DesignationControl(DesignationService designationService) {
        this.designationService = designationService;
    }

    @PostMapping("/api/v1/interns/designation")
    public ResponseEntity saveInternsDesignation(@Valid @RequestBody List<CreateDesignation> designationEntries){
        designationService.stateDesignation(designationEntries);
        return ResponseEntity.ok("Successfully created");

    }

    @GetMapping("/api/v1/internFindAll")
    public ResponseEntity<List<DesignationEntity>> getAllInternsDesignation() {
        return ResponseEntity.ok(DesignationEntity.InternsDesignation());
}
