package org.example.duckling_spring.service;

import org.example.duckling_spring.model.ReceiptModel;
import org.example.duckling_spring.repository.DucklingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DucklingService {
    @Autowired
    private DucklingRepository ducklingRepository;

    public List<ReceiptModel> getAll(){
        return ducklingRepository.findAll();
    }

    public ReceiptModel getRecieptById(Long id){
        return ducklingRepository.findById(id).get();
    }

    public ReceiptModel getRecieptByTitle(String title){
        return ducklingRepository.findReceiptModelByTitle(title);
    }

    public String create(ReceiptModel receiptModel){
        ducklingRepository.save(receiptModel);
        return "success";
    }

    public void delete(ReceiptModel receiptModel){
        ducklingRepository.delete(receiptModel);
    }

    public void update(ReceiptModel receiptModel, Long id){
        ducklingRepository.findById(id); //upsert partial update
        ducklingRepository.save(receiptModel);
    }

}
