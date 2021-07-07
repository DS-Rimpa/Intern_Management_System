package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.models.InternUpdateRequest;
import com.intern.test.internmanagesys.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/intern")
@RestController
public class InternControl {

    private InternService internService;

    @Autowired
    public void setService(InternService internService) {
        this.internService = internService;
    }


    @PostMapping("/save")
    public ResponseEntity saveInterns(@Valid @RequestBody List<CreateInternRequest> internEntries){
        internService.addInterns(internEntries);
        return ResponseEntity.ok("Successfully created");

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<InternEntity>> getAllInterns() {
        return ResponseEntity.ok(internService.getAllInterns());
    }
    @GetMapping("by/id/{id}")
    public ResponseEntity<InternEntity> getInternById(@PathVariable Long id){

        return ResponseEntity.ok(internService.getInternById(id));
    }
    @GetMapping("by/name/{name}")
    public ResponseEntity<InternEntity> getInternByName(@PathVariable String name){

        return ResponseEntity.ok(internService.getInternByName(name));
    }
    @DeleteMapping("/deleteby/id/{id}")
    public String deleteIntern(@PathVariable Long id){
        return internService.deleteIntern(id);
    }

    @PutMapping("/update/{id}")
    public InternEntity updateIntern(@RequestBody InternUpdateRequest internUpdateRequest, @PathVariable Long id){

        return internService.updateIntern(internUpdateRequest,id);
    }
    @DeleteMapping("/delete/all")
    public String deleteAllInterns()
    {
        internService.deleteInterns();
        return "All interns are deleted";
    }

}
