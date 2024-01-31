package org.example.duckling_spring.controller;


import org.example.duckling_spring.model.ReceiptModel;
import org.example.duckling_spring.service.DucklingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ducklingreceipt")
public class DucklingController {

    @Autowired
    private DucklingService ducklingService;

    @GetMapping
    public List<ReceiptModel> receiptList(){
        return ducklingService.getAll();
    }

    @PostMapping
    public void addReceipt(@RequestBody ReceiptModel receiptModel){
        ducklingService.create(receiptModel);
    }

    @PatchMapping("/{id}")
    public void updateReceipt(@PathVariable Long id, @RequestBody ReceiptModel receiptModel){
        ducklingService.update(id, receiptModel);
    }

    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id){
        ducklingService.delete(id);
    }
}
