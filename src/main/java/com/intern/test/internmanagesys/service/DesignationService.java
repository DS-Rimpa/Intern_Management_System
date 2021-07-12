package com.intern.test.internmanagesys.service;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.models.InternDesignationUpdate;
import com.intern.test.internmanagesys.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {
    private final DesignationRepository designationRepository;

    @Autowired

    public DesignationService(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    public List<DesignationEntity> getAllDesignations() {
        return designationRepository.findAll();
    }

    public DesignationEntity addDesignation(CreateDesignationRequest designationRequest) {
        DesignationEntity designationEntity = new DesignationEntity();
        designationEntity.setDesignationType(designationRequest.getDesignationType());
        return designationRepository.save(designationEntity);
    }

    public void deleteDesignations() {
        designationRepository.deleteAll();
    }

    public DesignationEntity updateDesignation(InternDesignationUpdate internDesignationUpdate, Long id) {
        Optional<DesignationEntity> byId = designationRepository.findById(id);
        DesignationEntity designationEntity = byId.get();
        designationEntity.setDesignationType(internDesignationUpdate.getDesignationType());
        return designationRepository.save(designationEntity);
    }

}
