package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.models.InternUpdateRequest;
import com.intern.test.internmanagesys.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public List<InternEntity> saveInterns(@Valid @RequestBody List<CreateInternRequest> internEntries){
       return internService.addInterns(internEntries);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InternEntity> getAllInterns() {
        return internService.getAllInterns();
    }
    @GetMapping("/{id}")
    public InternEntity internById(@PathVariable Long id){

        return internService.getInternById(id);
    }
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public InternEntity getByName(@PathVariable String name){

        return internService.getInternByName(name);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public InternEntity delete(@PathVariable Long id){
        return internService.deleteIntern(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InternEntity change(@RequestBody InternUpdateRequest internUpdateRequest, @PathVariable Long id){

        return internService.updateIntern(internUpdateRequest,id);
    }
    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public InternEntity deleteAllInterns()
    {
        internService.deleteInterns();
        return internService.deleteInterns();
    }

}
