package com.polovyi.ivan.tutorials.controller;

import com.polovyi.ivan.tutorials.dto.PurchaseTransactionResponse;
import com.polovyi.ivan.tutorials.enm.PurchaseTransactionSortEnum;
import com.polovyi.ivan.tutorials.service.PurchaseTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public record PurchaseTransactionController(PurchaseTransactionService purchaseTransactionService) {

    @GetMapping(path = "/v1/purchase-transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseTransactionResponse> getAllCustomers(
            @RequestParam(required = false) String paymentType,
            @RequestParam(required = false, defaultValue = "#{T(com.polovyi.ivan.tutorials.enm.PurchaseTransactionSortEnum).ASC_CREATED_AT}")
                    PurchaseTransactionSortEnum sortEnum) {
        return purchaseTransactionService.fetchAll(paymentType, sortEnum);
    }

}
