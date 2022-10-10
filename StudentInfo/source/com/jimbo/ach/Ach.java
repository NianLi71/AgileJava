package com.jimbo.ach;

public interface Ach {
    AchResponse issueDebit(AchCredentials credentials, AchTransactionData data);

    AchResponse markTransactionAsNSF(AchCredentials credentials, AchTransactionData data, String traceCode);

    AchResponse refundTransaction(AchCredentials credentials, AchTransactionData data, String traceCode);

    AchResponse issueCredit(AchCredentials credentials, AchTransactionData data);

    AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData data, String traceCode);

    AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData data, String traceCode);
}
