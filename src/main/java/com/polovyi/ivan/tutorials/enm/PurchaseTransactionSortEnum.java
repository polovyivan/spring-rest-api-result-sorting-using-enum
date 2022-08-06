package com.polovyi.ivan.tutorials.enm;

import com.polovyi.ivan.tutorials.dto.PurchaseTransactionResponse;

import java.util.Comparator;

public enum PurchaseTransactionSortEnum implements Comparator<PurchaseTransactionResponse> {

    ASC_CREATED_AT {
        @Override
        public int compare(PurchaseTransactionResponse o1,
                PurchaseTransactionResponse o2) {
            return o1.getCreatedAt().compareTo(o2.getCreatedAt());
        }
    },
    DESC_CREATED_AT {
        @Override
        public int compare(PurchaseTransactionResponse o1,
                PurchaseTransactionResponse o2) {
            return o2.getCreatedAt().compareTo(o1.getCreatedAt());
        }
    },
    ASC_PAYMENT_TYPE {
        @Override
        public int compare(PurchaseTransactionResponse o1,
                PurchaseTransactionResponse o2) {
            return o1.getPaymentType().compareTo(o2.getPaymentType());
        }
    },
    DESC_PAYMENT_TYPE {
        @Override
        public int compare(PurchaseTransactionResponse o1,
                PurchaseTransactionResponse o2) {
            return o2.getPaymentType().compareTo(o1.getPaymentType());
        }
    },
    ASC_AMOUNT {
        @Override
        public int compare(PurchaseTransactionResponse o1,
                PurchaseTransactionResponse o2) {
            return o1.getAmount().compareTo(o2.getAmount());
        }
    },
    DESC_AMOUNT {
        @Override
        public int compare(PurchaseTransactionResponse o1,
                PurchaseTransactionResponse o2) {
            return o2.getAmount().compareTo(o1.getAmount());
        }
    }
}
