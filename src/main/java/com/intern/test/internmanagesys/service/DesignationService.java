package com.intern.test.internmanagesys.service;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.models.InternDesignationUpdate;
import com.intern.test.internmanagesys.models.InternUpdateRequest;
import com.intern.test.internmanagesys.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public String deleteDesignations(){
        designationRepository.deleteAll();
        return "All designations deleted";
    }

    public DesignationEntity updateDesignation(InternDesignationUpdate internDesignationUpdate, Long designationId){

        Optional<DesignationEntity> byId = designationRepository.findById(designationId);
        DesignationEntity designationEntity = byId.get();

        designationEntity.setDesignationType(internDesignationUpdate.getDesignationType());
        return designationRepository.save(designationEntity);
    }

}
