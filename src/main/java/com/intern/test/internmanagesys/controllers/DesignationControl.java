package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.models.InternDesignationUpdate;
import com.intern.test.internmanagesys.service.DesignationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/designation")
public class DesignationControl {

    public DesignationControl(DesignationService designationService) {
        this.designationService = designationService;
    }
    private DesignationService designationService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DesignationEntity createDesignation(@Valid @RequestBody CreateDesignationRequest createDesignationRequest){
        return designationService.addDesignation(createDesignationRequest);

    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<DesignationEntity> getAll() {
        return designationService.getAllDesignations();
    }

    @PutMapping("/{designationId}")
    @ResponseStatus(HttpStatus.OK)
    public DesignationEntity changeDesignation(@RequestBody InternDesignationUpdate designationUpdate, @PathVariable Long designationId){

        return designationService.updateDesignation(designationUpdate,designationId);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public DesignationEntity deleteInternsDesignation()
    {
        return designationService.deleteDesignations();
    }


}
