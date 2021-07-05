package com.intern.test.internmanagesys.service;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.entity.StatusType;
import com.intern.test.internmanagesys.models.CreateDesignation;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.repository.DesignationRepository;
import com.intern.test.internmanagesys.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesignationService {

    private final DesignationRepository designationRepository;

    @Autowired
    public DesignationService(DesignationRepository designationRepository){
        this.designationRepository=designationRepository;
    }

    public void stateDesignation(CreateDesignation createDesignation){
        DesignationEntity designationEntity = new DesignationEntity();
        designationEntity.setDesignationType(request.getDesignationType());
//
//    public List<DesignationEntity> addDesignation(List<CreateDesignation> internDesignations) {
//
//        List<DesignationEntity> collect = internDesignations
//                .stream()
//                .map(internPost -> DesignationEntity
//                .builder()
//                .designationType(internPost.getDesignationType())
//                .build()).collect(Collectors.toList());
        return designationRepository.save(DesignationEntity);

    }

    public List<DesignationEntity> InternsDesignation()
    {
        return designationRepository.findAll();
    }


}
