package com.intern.test.internmanagesys.service;

import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.entity.StatusType;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.models.InternUpdateRequest;
import com.intern.test.internmanagesys.repository.InternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InternService {
    private final InternRepository internRepository;

    @Autowired
    public InternService(InternRepository internRepository){
        this.internRepository=internRepository;
    }



    public List<InternEntity> addInterns(List<CreateInternRequest> interns) {

        List<InternEntity> collect = interns.stream().map(intern -> InternEntity
                .builder()
                .name(intern.getName())
                .address(intern.getAddress())
                .contact(intern.getContact())
                .postalCode(intern.getPostalCode())
                .salary(intern.getSalary())
                .status(StatusType.INACTIVE)
                .build()).collect(Collectors.toList());
        return internRepository.saveAll(collect);

    }
    public List<InternEntity> getAllInterns()
    {
        return internRepository.findAll();
    }

    public InternEntity getInternById(Long id){
        Optional<InternEntity> internOptional = internRepository.findById(id);
        return internOptional.orElseGet(InternEntity::new);
    }
    public InternEntity getInternByName(String name){
        Optional<InternEntity> internOptional = internRepository.findByName(name);
        return internOptional.orElseGet(InternEntity::new);
    }

    public InternEntity updateIntern(InternUpdateRequest internUpdateRequest, Long id){

        Optional<InternEntity> byId = internRepository.findById(id);
        InternEntity internEntity = byId.get();

        internEntity.setName(internUpdateRequest.getName());
        internEntity.setContact(internUpdateRequest.getContact());
        internEntity.setAddress(internUpdateRequest.getAddress());
        internEntity.setSalary(internUpdateRequest.getSalary());
        internEntity.setPostalCode(internUpdateRequest.getPostalCode());
        return internRepository.save(internEntity);
    }
    public InternEntity deleteIntern(Long id){
        internRepository.deleteById(id);
        return null;
    }
    public InternEntity deleteInterns(){
        internRepository.deleteAll();
        return null;
    }



}
