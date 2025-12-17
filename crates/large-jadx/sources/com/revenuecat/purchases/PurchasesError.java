package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0004R\u0019\u0010\u0008\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\u0006\u001a\u0004\u0008\t\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0011", d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "", "", "toString", "()Ljava/lang/String;", "underlyingErrorMessage", "Ljava/lang/String;", "getUnderlyingErrorMessage", "message", "getMessage", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "code", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "getCode", "()Lcom/revenuecat/purchases/PurchasesErrorCode;", "<init>", "(Lcom/revenuecat/purchases/PurchasesErrorCode;Ljava/lang/String;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class PurchasesError {

    private final com.revenuecat.purchases.PurchasesErrorCode code;
    private final String message;
    private final String underlyingErrorMessage;
    public PurchasesError(com.revenuecat.purchases.PurchasesErrorCode purchasesErrorCode, String string2) {
        n.f(purchasesErrorCode, "code");
        super();
        this.code = purchasesErrorCode;
        this.underlyingErrorMessage = string2;
        this.message = purchasesErrorCode.getDescription();
    }

    public PurchasesError(com.revenuecat.purchases.PurchasesErrorCode purchasesErrorCode, String string2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(purchasesErrorCode, obj2);
    }

    public final com.revenuecat.purchases.PurchasesErrorCode getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getUnderlyingErrorMessage() {
        return this.underlyingErrorMessage;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PurchasesError(code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", underlyingErrorMessage=");
        stringBuilder.append(this.underlyingErrorMessage);
        stringBuilder.append(", message='");
        stringBuilder.append(this.message);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}
