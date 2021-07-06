package com.intern.test.internmanagesys.service;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {
    private final DesignationRepository designationRepository;

    @Autowired

    public DesignationService(DesignationRepository designationRepository){
        this.designationRepository=designationRepository;
    }

    public List<DesignationEntity> getAllInternsDesignation()
    {
        return designationRepository.findAll();
    }



    public void addDesignations(CreateDesignationRequest designationRequest) {
        DesignationEntity designationEntity=new DesignationEntity();
        designationEntity.setDesignationType(designationRequest.getDesignationType());
        designationRepository.save(designationEntity);
    }
}
