package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0003\u0010\u0008\u001a\u0011\u0010\u0003\u001a\u00020\u0002*\u00020\t¢\u0006\u0004\u0008\u0003\u0010\n\u001a\u0011\u0010\u000c\u001a\u00020\u000b*\u00020\u0005¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u0011\u0010\u000f\u001a\u00020\u0006*\u00020\u000e¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0011\u0010\u0012¨\u0006\u0013", d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/revenuecat/purchases/PurchasesError;", "toPurchasesError", "(Ljava/lang/Exception;)Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/BackendErrorCode;", "", "underlyingErrorMessage", "(Lcom/revenuecat/purchases/common/BackendErrorCode;Ljava/lang/String;)Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "(Lcom/revenuecat/purchases/common/networking/HTTPResult;)Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "toPurchasesErrorCode", "(Lcom/revenuecat/purchases/common/BackendErrorCode;)Lcom/revenuecat/purchases/PurchasesErrorCode;", "", "getBillingResponseCodeName", "(I)Ljava/lang/String;", "billingResponseToPurchasesError", "(ILjava/lang/String;)Lcom/revenuecat/purchases/PurchasesError;", "common_release"}, k = 2, mv = {1, 4, 0})
public final class ErrorsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            ErrorsKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[BackendErrorCode.BackendStoreProblem.ordinal()] = 1;
            iArr[BackendErrorCode.BackendCannotTransferPurchase.ordinal()] = 2;
            iArr[BackendErrorCode.BackendInvalidReceiptToken.ordinal()] = 3;
            iArr[BackendErrorCode.BackendInvalidPlayStoreCredentials.ordinal()] = 4;
            iArr[BackendErrorCode.BackendInvalidAuthToken.ordinal()] = 5;
            iArr[BackendErrorCode.BackendInvalidAPIKey.ordinal()] = 6;
            iArr[BackendErrorCode.BackendInvalidPaymentModeOrIntroPriceNotProvided.ordinal()] = 7;
            iArr[BackendErrorCode.BackendProductIdForGoogleReceiptNotProvided.ordinal()] = 8;
            iArr[BackendErrorCode.BackendEmptyAppUserId.ordinal()] = 9;
            iArr[BackendErrorCode.BackendPlayStoreQuotaExceeded.ordinal()] = 10;
            iArr[BackendErrorCode.BackendPlayStoreInvalidPackageName.ordinal()] = 11;
            iArr[BackendErrorCode.BackendInvalidPlatform.ordinal()] = 12;
            iArr[BackendErrorCode.BackendPlayStoreGenericError.ordinal()] = 13;
            iArr[BackendErrorCode.BackendUserIneligibleForPromoOffer.ordinal()] = 14;
            iArr[BackendErrorCode.BackendInvalidSubscriberAttributes.ordinal()] = 15;
            iArr[BackendErrorCode.BackendInvalidSubscriberAttributesBody.ordinal()] = 16;
            iArr[BackendErrorCode.BackendInvalidAppStoreSharedSecret.ordinal()] = 17;
            iArr[BackendErrorCode.BackendInvalidAppleSubscriptionKey.ordinal()] = 18;
            iArr[BackendErrorCode.BackendBadRequest.ordinal()] = 19;
            iArr[BackendErrorCode.BackendInternalServerError.ordinal()] = 20;
            iArr[BackendErrorCode.BackendProductIDsMalformed.ordinal()] = 21;
        }
    }
    public static final PurchasesError billingResponseToPurchasesError(int i, String string2) {
        PurchasesErrorCode obj1;
        n.f(string2, "underlyingErrorMessage");
        switch (i) {
            case -3:
                obj1 = PurchasesErrorCode.StoreProblemError;
                break;
            case -2:
                obj1 = PurchasesErrorCode.PurchaseNotAllowedError;
                break;
            case -1:
                obj1 = PurchasesErrorCode.UnknownError;
                break;
            case 0:
                obj1 = PurchasesErrorCode.PurchaseCancelledError;
                break;
            case 1:
                obj1 = PurchasesErrorCode.ProductNotAvailableForPurchaseError;
                break;
            case 2:
                obj1 = PurchasesErrorCode.PurchaseInvalidError;
                break;
            case 3:
                obj1 = PurchasesErrorCode.ProductAlreadyPurchasedError;
                break;
            default:
                obj1 = PurchasesErrorCode.UnknownError;
        }
        PurchasesError purchasesError = new PurchasesError(obj1, string2);
        return purchasesError;
    }

    public static final String getBillingResponseCodeName(int i) {
        String declaredFields;
        int i3;
        Field field;
        int i2;
        declaredFields = c.a.class.getDeclaredFields();
        n.e(declaredFields, "allPossibleBillingResponseCodes");
        final int i4 = 0;
        i3 = i4;
        while (i3 < declaredFields.length) {
            field = declaredFields[i3];
            if (field.getInt(field) == i) {
            } else {
            }
            i2 = i4;
            i3++;
            i2 = 1;
        }
        field = 0;
        if (field != null && field.getName() != null) {
            if (field.getName() != null) {
            } else {
                declaredFields = String.valueOf(i);
            }
        } else {
        }
        return declaredFields;
    }

    public static final PurchasesError toPurchasesError(com.revenuecat.purchases.common.BackendErrorCode backendErrorCode, String string2) {
        n.f(backendErrorCode, "$this$toPurchasesError");
        n.f(string2, "underlyingErrorMessage");
        PurchasesError purchasesError = new PurchasesError(ErrorsKt.toPurchasesErrorCode(backendErrorCode), string2);
        return purchasesError;
    }

    public static final PurchasesError toPurchasesError(HTTPResult hTTPResult) {
        Object str;
        String str2;
        String purchasesError;
        Object unknownBackendError;
        StringBuilder stringBuilder;
        String str3;
        Object obj5;
        n.f(hTTPResult, "$this$toPurchasesError");
        str2 = "code";
        if (hTTPResult.getBody().has(str2)) {
            Objects.requireNonNull(hTTPResult.getBody().get(str2), "null cannot be cast to non-null type kotlin.Int");
        } else {
            str = 0;
        }
        unknownBackendError = "message";
        if (hTTPResult.getBody().has(unknownBackendError)) {
            Objects.requireNonNull(hTTPResult.getBody().get(unknownBackendError), "null cannot be cast to non-null type kotlin.String");
        } else {
            obj5 = "";
        }
        purchasesError = BackendErrorCode.Companion.valueOf(str.intValue());
        if (str != null && purchasesError != null && ErrorsKt.toPurchasesError(purchasesError, obj5) != null) {
            purchasesError = BackendErrorCode.Companion.valueOf(str.intValue());
            if (purchasesError != null) {
                if (ErrorsKt.toPurchasesError(purchasesError, obj5) != null) {
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Backend Code: ");
                    if (str != null) {
                    } else {
                        str = "N/A";
                    }
                    stringBuilder.append(str);
                    stringBuilder.append(" - ");
                    stringBuilder.append(obj5);
                    purchasesError = new PurchasesError(PurchasesErrorCode.UnknownBackendError, stringBuilder.toString());
                }
            } else {
            }
        } else {
        }
        return purchasesError;
    }

    public static final PurchasesError toPurchasesError(Exception exception) {
        PurchasesError purchasesError;
        boolean z;
        PurchasesErrorCode insufficientPermissionsError;
        String obj2;
        n.f(exception, "$this$toPurchasesError");
        if (exception instanceof JSONException != null) {
            purchasesError = new PurchasesError(PurchasesErrorCode.NetworkError, exception.getLocalizedMessage());
        } else {
            if (exception instanceof IOException != null) {
            } else {
                if (exception instanceof SecurityException != null) {
                    purchasesError = new PurchasesError(PurchasesErrorCode.InsufficientPermissionsError, (SecurityException)exception.getLocalizedMessage());
                } else {
                    purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, exception.getLocalizedMessage());
                }
            }
        }
        return purchasesError;
    }

    public static final PurchasesErrorCode toPurchasesErrorCode(com.revenuecat.purchases.common.BackendErrorCode backendErrorCode) {
        PurchasesErrorCode obj1;
        n.f(backendErrorCode, "$this$toPurchasesErrorCode");
        switch (obj1) {
            case 1:
                obj1 = PurchasesErrorCode.StoreProblemError;
                break;
            case 2:
                obj1 = PurchasesErrorCode.ReceiptAlreadyInUseError;
                break;
            case 3:
                obj1 = PurchasesErrorCode.InvalidReceiptError;
                break;
            case 4:
                obj1 = PurchasesErrorCode.InvalidCredentialsError;
                break;
            case 5:
                obj1 = PurchasesErrorCode.PurchaseInvalidError;
                break;
            case 6:
                obj1 = PurchasesErrorCode.InvalidAppUserIdError;
                break;
            case 7:
                obj1 = PurchasesErrorCode.StoreProblemError;
                break;
            case 8:
                obj1 = PurchasesErrorCode.ConfigurationError;
                break;
            case 9:
                obj1 = PurchasesErrorCode.StoreProblemError;
                break;
            case 10:
                obj1 = PurchasesErrorCode.IneligibleError;
                break;
            case 11:
                obj1 = PurchasesErrorCode.InvalidSubscriberAttributesError;
                break;
            case 12:
                obj1 = PurchasesErrorCode.UnexpectedBackendResponseError;
                break;
            case 13:
                obj1 = PurchasesErrorCode.UnsupportedError;
                break;
            default:
                obj1 = new NoWhenBranchMatchedException();
                throw obj1;
        }
        return obj1;
    }
}
