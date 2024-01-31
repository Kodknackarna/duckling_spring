package org.example.duckling_spring.service;

import org.example.duckling_spring.model.ReceiptModel;
import org.example.duckling_spring.repository.DucklingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void delete(Long id){
        ReceiptModel receiptModel = ducklingRepository.findReceiptModelById(id);
        ducklingRepository.delete(receiptModel);
    }

    public ReceiptModel update(Long id, ReceiptModel newReceipt){
        ReceiptModel receiptModel = ducklingRepository.findReceiptModelById(id);
        if (newReceipt.getTitle() != null) {
            receiptModel.setTitle(newReceipt.getTitle());
        }
        if (newReceipt.getDate() != null) {
            receiptModel.setDate(newReceipt.getDate());
        }
        if (newReceipt.getCategory() != null) {
            receiptModel.setCategory(newReceipt.getCategory());
        }
        if (newReceipt.getDescription() != null) {
            receiptModel.setDescription(newReceipt.getDescription());
        }
        if (newReceipt.getPrice() != null) {
            receiptModel.setPrice(newReceipt.getPrice());
        }
        if(newReceipt.getOwner()!=null) {
            receiptModel.setOwner(newReceipt.getOwner());
        }
        return ducklingRepository.save(receiptModel);
    }
}
