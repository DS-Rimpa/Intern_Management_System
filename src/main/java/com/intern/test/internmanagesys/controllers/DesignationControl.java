package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.repository.DesignationRepository;
import com.intern.test.internmanagesys.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DesignationControl {

    public DesignationControl(DesignationService designationService) {
        this.designationService = designationService;
    }
    private DesignationService designationService;


    @PostMapping("/designation")
    public ResponseEntity<String> saveDesignation(@Valid @RequestBody CreateDesignationRequest createDesignationRequest){
        designationService.addDesignations(createDesignationRequest);
        return ResponseEntity.ok("Successfully Created");

    }
    @GetMapping("/getAllInternsDesignation")
    public ResponseEntity<List<DesignationEntity>> getAllInternsDesignation() {
        return ResponseEntity.ok(designationService.getAllInternsDesignation());
    }


}
