package com.revenuecat.purchases.common;

import android.util.Log;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\u0008\u0005\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\u0008\u0006\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\u0008\u0007\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\u0007\u0010\n¨\u0006\u000b", d2 = {"", "message", "Lkotlin/w;", "debugLog", "(Ljava/lang/String;)V", "infoLog", "warnLog", "errorLog", "Lcom/revenuecat/purchases/PurchasesError;", "error", "(Lcom/revenuecat/purchases/PurchasesError;)V", "common_release"}, k = 2, mv = {1, 4, 0})
public final class LogUtilsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            LogUtilsKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[PurchasesErrorCode.UnknownError.ordinal()] = 1;
            iArr[PurchasesErrorCode.NetworkError.ordinal()] = 2;
            iArr[PurchasesErrorCode.ReceiptAlreadyInUseError.ordinal()] = 3;
            iArr[PurchasesErrorCode.UnexpectedBackendResponseError.ordinal()] = 4;
            iArr[PurchasesErrorCode.InvalidAppUserIdError.ordinal()] = 5;
            iArr[PurchasesErrorCode.OperationAlreadyInProgressError.ordinal()] = 6;
            iArr[PurchasesErrorCode.UnknownBackendError.ordinal()] = 7;
            iArr[PurchasesErrorCode.InvalidSubscriberAttributesError.ordinal()] = 8;
            iArr[PurchasesErrorCode.PurchaseCancelledError.ordinal()] = 9;
            iArr[PurchasesErrorCode.StoreProblemError.ordinal()] = 10;
            iArr[PurchasesErrorCode.PurchaseNotAllowedError.ordinal()] = 11;
            iArr[PurchasesErrorCode.PurchaseInvalidError.ordinal()] = 12;
            iArr[PurchasesErrorCode.ProductNotAvailableForPurchaseError.ordinal()] = 13;
            iArr[PurchasesErrorCode.ProductAlreadyPurchasedError.ordinal()] = 14;
            iArr[PurchasesErrorCode.InvalidReceiptError.ordinal()] = 15;
            iArr[PurchasesErrorCode.MissingReceiptFileError.ordinal()] = 16;
            iArr[PurchasesErrorCode.InvalidAppleSubscriptionKeyError.ordinal()] = 17;
            iArr[PurchasesErrorCode.IneligibleError.ordinal()] = 18;
            iArr[PurchasesErrorCode.InsufficientPermissionsError.ordinal()] = 19;
            iArr[PurchasesErrorCode.PaymentPendingError.ordinal()] = 20;
            iArr[PurchasesErrorCode.InvalidCredentialsError.ordinal()] = 21;
        }
    }
    public static final void debugLog(String string) {
        boolean debugLogsEnabled;
        n.f(string, "message");
        if (Config.INSTANCE.getDebugLogsEnabled()) {
            Log.d("[Purchases] - DEBUG", string);
        }
    }

    public static final void errorLog(PurchasesError purchasesError) {
        com.revenuecat.purchases.common.LogIntent gOOGLE_ERROR;
        Object obj2;
        n.f(purchasesError, "error");
        switch (gOOGLE_ERROR) {
            case 1:
                LogWrapperKt.log(LogIntent.RC_ERROR, purchasesError.getMessage());
                break;
            case 2:
                LogWrapperKt.log(LogIntent.GOOGLE_ERROR, purchasesError.getMessage());
                break;
            default:
        }
    }

    public static final void errorLog(String string) {
        n.f(string, "message");
        Log.e("[Purchases] - ERROR", string);
    }

    public static final void infoLog(String string) {
        n.f(string, "message");
        Log.i("[Purchases] - INFO", string);
    }

    public static final void warnLog(String string) {
        n.f(string, "message");
        Log.w("[Purchases] - WARN", string);
    }
}
