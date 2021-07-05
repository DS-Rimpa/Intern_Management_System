package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class InternControl {

    private InternService internService;

    @Autowired
    public void setService(InternService internService) {
        this.internService = internService;
    }


    @PostMapping("/api/v1/intern")
    public ResponseEntity saveInterns(@Valid @RequestBody List<CreateInternRequest> internEntries){
        internService.addInterns(internEntries);
        return ResponseEntity.ok("Successfully created");

    }

    @GetMapping("/api/v1/internFindAll")
    public ResponseEntity<List<InternEntity>> getAllInterns() {
        return ResponseEntity.ok(internService.getAllInterns());
    }

}
