package org.example.duckling_spring.repository;

import org.example.duckling_spring.model.ReceiptModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DucklingRepository extends JpaRepository<ReceiptModel, Long> {

    ReceiptModel findReceiptModelByTitle(String title);

    ReceiptModel updateReceiptModelById(Long id);
}
