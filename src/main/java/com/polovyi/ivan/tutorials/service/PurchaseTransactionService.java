package com.polovyi.ivan.tutorials.service;

import com.polovyi.ivan.tutorials.client.FakeClientTransaction;
import com.polovyi.ivan.tutorials.dto.PurchaseTransactionResponse;
import com.polovyi.ivan.tutorials.enm.PurchaseTransactionSortEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public record PurchaseTransactionService(FakeClientTransaction fakeClientTransaction) {

    public List<PurchaseTransactionResponse> fetchAll(String paymentType,
            PurchaseTransactionSortEnum sortEnum) {
        log.info("Fetching purchase transactions by paymentType {} and sortEnum {}", paymentType, sortEnum);

        return fakeClientTransaction.fetchAll().stream()
                .filter(transaction -> Optional.ofNullable(paymentType)
                        .map(type -> transaction.getPaymentType().equals(type))
                        .orElse(true))
                .sorted((first, next) -> sortEnum.compare(first, next))
                .collect(Collectors.toList());
    }
}
