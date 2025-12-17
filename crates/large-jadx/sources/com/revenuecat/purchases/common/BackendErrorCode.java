package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u001d\u0008\u0086\u0001\u0018\u0000 \t2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019j\u0002\u0008\u001aj\u0002\u0008\u001bj\u0002\u0008\u001cj\u0002\u0008\u001dj\u0002\u0008\u001e¨\u0006\u001f", d2 = {"Lcom/revenuecat/purchases/common/BackendErrorCode;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "BackendInvalidPlatform", "BackendStoreProblem", "BackendCannotTransferPurchase", "BackendInvalidReceiptToken", "BackendInvalidAppStoreSharedSecret", "BackendInvalidPaymentModeOrIntroPriceNotProvided", "BackendProductIdForGoogleReceiptNotProvided", "BackendInvalidPlayStoreCredentials", "BackendInternalServerError", "BackendEmptyAppUserId", "BackendInvalidAuthToken", "BackendInvalidAPIKey", "BackendBadRequest", "BackendPlayStoreQuotaExceeded", "BackendPlayStoreInvalidPackageName", "BackendPlayStoreGenericError", "BackendUserIneligibleForPromoOffer", "BackendInvalidAppleSubscriptionKey", "BackendInvalidSubscriberAttributes", "BackendInvalidSubscriberAttributesBody", "BackendProductIDsMalformed", "common_release"}, k = 1, mv = {1, 4, 0})
public enum BackendErrorCode {

    BackendInvalidPlatform(7000),
    BackendStoreProblem(7000),
    BackendCannotTransferPurchase(7000),
    BackendInvalidReceiptToken(7000),
    BackendInvalidAppStoreSharedSecret(7000),
    BackendInvalidPaymentModeOrIntroPriceNotProvided(7000),
    BackendProductIdForGoogleReceiptNotProvided(7000),
    BackendInvalidPlayStoreCredentials(7000),
    BackendInternalServerError(7000),
    BackendEmptyAppUserId(7000),
    BackendInvalidAuthToken(7000),
    BackendInvalidAPIKey(7000),
    BackendBadRequest(7000),
    BackendPlayStoreQuotaExceeded(7000),
    BackendPlayStoreInvalidPackageName(7000),
    BackendPlayStoreGenericError(7000),
    BackendUserIneligibleForPromoOffer(7000),
    BackendInvalidAppleSubscriptionKey(7000),
    BackendInvalidSubscriberAttributes(7000),
    BackendInvalidSubscriberAttributesBody(7000),
    BackendProductIDsMalformed(7000);

    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lcom/revenuecat/purchases/common/BackendErrorCode$Companion;", "", "", "backendErrorCode", "Lcom/revenuecat/purchases/common/BackendErrorCode;", "valueOf", "(I)Lcom/revenuecat/purchases/common/BackendErrorCode;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final com.revenuecat.purchases.common.BackendErrorCode valueOf(int i) {
            int i3;
            com.revenuecat.purchases.common.BackendErrorCode th;
            int i2;
            final com.revenuecat.purchases.common.BackendErrorCode[] values = BackendErrorCode.values();
            final int i4 = 0;
            i3 = i4;
            while (i3 < values.length) {
                if (values[i3].getValue() == i) {
                } else {
                }
                i2 = i4;
                i3++;
                i2 = 1;
            }
            th = 0;
            return th;
        }
    }
    @Override // java.lang.Enum
    public final int getValue() {
        return this.value;
    }
}
