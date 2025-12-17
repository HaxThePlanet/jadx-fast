package com.revenuecat.purchases;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u001f\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019j\u0002\u0008\u001aj\u0002\u0008\u001bj\u0002\u0008\u001cj\u0002\u0008\u001dj\u0002\u0008\u001ej\u0002\u0008\u001fj\u0002\u0008 j\u0002\u0008!j\u0002\u0008\"j\u0002\u0008#j\u0002\u0008$j\u0002\u0008%¨\u0006&", d2 = {"Lcom/revenuecat/purchases/PurchasesErrorCode;", "", "", "code", "I", "getCode", "()I", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "UnknownError", "PurchaseCancelledError", "StoreProblemError", "PurchaseNotAllowedError", "PurchaseInvalidError", "ProductNotAvailableForPurchaseError", "ProductAlreadyPurchasedError", "ReceiptAlreadyInUseError", "InvalidReceiptError", "MissingReceiptFileError", "NetworkError", "InvalidCredentialsError", "UnexpectedBackendResponseError", "InvalidAppUserIdError", "OperationAlreadyInProgressError", "UnknownBackendError", "InvalidAppleSubscriptionKeyError", "IneligibleError", "InsufficientPermissionsError", "PaymentPendingError", "InvalidSubscriberAttributesError", "LogOutWithAnonymousUserError", "ConfigurationError", "UnsupportedError", "public_release"}, k = 1, mv = {1, 4, 0})
public enum PurchasesErrorCode {

    UnknownError(false, "Unknown error."),
    PurchaseCancelledError(false, "Unknown error."),
    StoreProblemError(false, "Unknown error."),
    PurchaseNotAllowedError(false, "Unknown error."),
    PurchaseInvalidError(false, "Unknown error."),
    ProductNotAvailableForPurchaseError(false, "Unknown error."),
    ProductAlreadyPurchasedError(false, "Unknown error."),
    ReceiptAlreadyInUseError(false, "Unknown error."),
    InvalidReceiptError(false, "Unknown error."),
    MissingReceiptFileError(false, "Unknown error."),
    NetworkError(false, "Unknown error."),
    InvalidCredentialsError(false, "Unknown error."),
    UnexpectedBackendResponseError(false, "Unknown error."),
    InvalidAppUserIdError("Unknown error.", "The app user id is not valid."),
    OperationAlreadyInProgressError(false, "The app user id is not valid."),
    UnknownBackendError("Unknown error.", "The app user id is not valid."),
    InvalidAppleSubscriptionKeyError(false, "The app user id is not valid."),
    IneligibleError("Unknown error.", "The app user id is not valid."),
    InsufficientPermissionsError(false, "The app user id is not valid."),
    PaymentPendingError("Unknown error.", "The app user id is not valid."),
    InvalidSubscriberAttributesError(false, "The app user id is not valid."),
    LogOutWithAnonymousUserError("Unknown error.", "The app user id is not valid."),
    ConfigurationError(false, "The app user id is not valid."),
    UnsupportedError("Unknown error.", "The app user id is not valid.");

    private final int code;
    private final String description;
    @Override // java.lang.Enum
    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final String getDescription() {
        return this.description;
    }
}
