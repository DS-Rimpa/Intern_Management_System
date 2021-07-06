package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.models.InternUpdateRequest;
import com.intern.test.internmanagesys.service.InternService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class InternControl {

    public InternControl(InternService internService) {
        this.internService = internService;
    }

    private InternService internService;


    @PostMapping("/intern")
    public ResponseEntity saveInterns(@Valid @RequestBody List<CreateInternRequest> internEntries){
        internService.addInterns(internEntries);
        return ResponseEntity.ok("Successfully created");

    }
    @GetMapping("/internFindAll")
    public ResponseEntity<List<InternEntity>> getAllInterns() {
        return ResponseEntity.ok(internService.getAllInterns());
    }
    @GetMapping("/intern/{id}")
    public ResponseEntity<InternEntity> getInternById(@PathVariable Long id){

        return ResponseEntity.ok(internService.getInternById(id));
    }
    @GetMapping("/internByName/{name}")
    public ResponseEntity<InternEntity> getInternByName(@PathVariable String name){

        return ResponseEntity.ok(internService.getInternByName(name));
    }
    @DeleteMapping("/intern/delete/{id}")
    public String deleteIntern(@PathVariable Long id){
        return internService.deleteIntern(id);
    }

    @DeleteMapping("/intern/deleteAll")
    public String deleteInterns()
    {
        internService.deleteInterns();
        return "All details deleted";
    }
    @PutMapping("/intern/{id}")
    public InternEntity updateIntern(@RequestBody InternUpdateRequest internUpdateRequest, @PathVariable Long id){

        return internService.updateIntern(internUpdateRequest,id);
    }

}
