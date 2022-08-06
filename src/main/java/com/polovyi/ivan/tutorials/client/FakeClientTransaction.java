package com.polovyi.ivan.tutorials.client;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.polovyi.ivan.tutorials.dto.PurchaseTransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class FakeClientTransaction {

    private static final List<PurchaseTransactionResponse> allPurchaseTransaction;

    static {
        Faker faker = new Faker();
        allPurchaseTransaction = LongStream.range(0, 100)
                .mapToObj(i -> PurchaseTransactionResponse.builder()
                        .id(UUID.randomUUID().toString())
                        .createdAt(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 10)))))
                        .amount(new BigDecimal(faker.commerce().price().replaceAll(",", ".")))
                        .paymentType(List.of(CreditCardType.values())
                                .get(new Random().nextInt(CreditCardType.values().length)).toString())
                        .build())
                .collect(toList());
    }

    public List<PurchaseTransactionResponse> fetchAll() {
        log.info("Returning all transaction...");
        return allPurchaseTransaction;
    }

}
