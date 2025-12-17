package com.google.firebase.auth.internal;

import android.accounts.Account;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.material.datepicker.j;
import com.google.firebase.FirebaseApp.UiExecutor;
import com.google.firebase.crashlytics.R.id;
import f.c.a.e.y.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzai {
    public static Status zza(String string) {
        int length;
        String[] obj3 = string.split(":", 2);
        int i3 = 0;
        obj3[i3] = obj3[i3].trim();
        final int i5 = 1;
        length = obj3[i5];
        if (!TextUtils.isEmpty(string) && obj3.length > i5 && length != null) {
            obj3 = string.split(":", 2);
            i3 = 0;
            obj3[i3] = obj3[i3].trim();
            i5 = 1;
            if (obj3.length > i5) {
                length = obj3[i5];
                if (length != null) {
                    obj3[i5] = length.trim();
                }
            }
            obj3 = Arrays.asList(obj3);
            if (obj3.size() > i5) {
                return zzai.zzb((String)obj3.get(i3), (String)obj3.get(i5));
            }
            return zzai.zzb((String)obj3.get(i3), 0);
        }
        obj3 = new Status(17499);
        return obj3;
    }

    private static Status zzb(String string, String string2) {
        boolean equals;
        int i2;
        int i;
        Object obj2;
        Object obj;
        final int i4 = 1;
        switch (string) {
            case "USER_CANCELLED":
                i2 = 67;
                i2 = -1;
                break;
            case "INVALID_RECIPIENT_EMAIL":
                i2 = 28;
                i2 = -1;
                break;
            case "WEB_CONTEXT_ALREADY_PRESENTED":
                i2 = 47;
                i2 = -1;
                break;
            case "INTERNAL_SUCCESS_SIGN_OUT":
                i2 = 64;
                i2 = -1;
                break;
            case "INVALID_IDP_RESPONSE":
                i2 = 4;
                i2 = -1;
                break;
            case "DYNAMIC_LINK_NOT_ACTIVATED":
                i2 = 45;
                i2 = -1;
                break;
            case "QUOTA_EXCEEDED":
                i2 = 39;
                i2 = -1;
                break;
            case "WEB_NETWORK_REQUEST_FAILED":
                i2 = 41;
                i2 = -1;
                break;
            case "EXPIRED_OOB_CODE":
                i2 = 25;
                i2 = -1;
                break;
            case "INVALID_OOB_CODE":
                i2 = 24;
                i2 = -1;
                break;
            case "MISSING_EMAIL":
                i2 = 29;
                i2 = -1;
                break;
            case "INVALID_CODE":
                i2 = 34;
                i2 = -1;
                break;
            case "TOKEN_EXPIRED":
                i2 = 23;
                i2 = -1;
                break;
            case "INVALID_TENANT_ID":
                i2 = 50;
                i2 = -1;
                break;
            case "INVALID_SESSION_INFO":
                i2 = 36;
                i2 = -1;
                break;
            case "SECOND_FACTOR_EXISTS":
                i2 = 60;
                i2 = -1;
                break;
            case "INVALID_EMAIL":
                i2 = 7;
                i2 = -1;
                break;
            case "ADMIN_ONLY_OPERATION":
                i2 = 58;
                i2 = -1;
                break;
            case "MISSING_OR_INVALID_NONCE":
                i2 = 66;
                i2 = -1;
                break;
            case "INVALID_CERT_HASH":
                i2 = 40;
                i2 = -1;
                break;
            case "NO_SUCH_PROVIDER":
                i2 = 0;
                i2 = -1;
                break;
            case "MFA_ENROLLMENT_NOT_FOUND":
                i2 = 57;
                i2 = -1;
                break;
            case "MISSING_PASSWORD":
                i2 = 30;
                i2 = -1;
                break;
            case "CREDENTIAL_TOO_OLD_LOGIN_AGAIN":
                i2 = 20;
                i2 = -1;
                break;
            case "TIMEOUT":
                i2 = 14;
                i2 = -1;
                break;
            case "OPERATION_NOT_ALLOWED":
                i2 = 17;
                i2 = -1;
                break;
            case "WEB_INTERNAL_ERROR":
                i2 = 42;
                i2 = -1;
                break;
            case "SECOND_FACTOR_LIMIT_EXCEEDED":
                i2 = 61;
                i2 = -1;
                break;
            case "MISSING_MFA_ENROLLMENT_ID":
                i2 = 55;
                i2 = -1;
                break;
            case "USER_NOT_FOUND":
                i2 = 9;
                i2 = -1;
                break;
            case "WEAK_PASSWORD":
                i2 = 16;
                i2 = -1;
                break;
            case "EMAIL_NOT_FOUND":
                i2 = 8;
                i2 = -1;
                break;
            case "UNSUPPORTED_FIRST_FACTOR":
                i2 = 62;
                i2 = -1;
                break;
            case "INVALID_SENDER":
                i2 = 27;
                i2 = -1;
                break;
            case "MISSING_PHONE_NUMBER":
                i2 = 31;
                i2 = -1;
                break;
            case "INVALID_DYNAMIC_LINK_DOMAIN":
                i2 = 51;
                i2 = -1;
                break;
            case "MISSING_MFA_PENDING_CREDENTIAL":
                i2 = 54;
                i2 = -1;
                break;
            case "EMAIL_EXISTS":
                i2 = 10;
                i2 = -1;
                break;
            case "INVALID_ID_TOKEN":
                i2 = 13;
                i2 = -1;
                break;
            case "WEB_STORAGE_UNSUPPORTED":
                i2 = 43;
                i2 = -1;
                break;
            case "PASSWORD_LOGIN_DISABLED":
                i2 = 18;
                i2 = -1;
                break;
            case "UNVERIFIED_EMAIL":
                i2 = 59;
                i2 = -1;
                break;
            case "REJECTED_CREDENTIAL":
                i2 = 52;
                i2 = -1;
                break;
            case "INVALID_MFA_PENDING_CREDENTIAL":
                i2 = 56;
                i2 = -1;
                break;
            case "INVALID_VERIFICATION_PROOF":
                i2 = 37;
                i2 = -1;
                break;
            case "INVALID_PROVIDER_ID":
                i2 = 46;
                i2 = -1;
                break;
            case "CREDENTIAL_MISMATCH":
                i2 = i4;
                i2 = -1;
                break;
            case "WEB_CONTEXT_CANCELED":
                i2 = 48;
                i2 = -1;
                break;
            case "REQUIRES_SECOND_FACTOR_AUTH":
                i2 = 53;
                i2 = -1;
                break;
            case "MISSING_CLIENT_IDENTIFIER":
                i2 = 65;
                i2 = -1;
                break;
            case "INVALID_MESSAGE_PAYLOAD":
                i2 = 26;
                i2 = -1;
                break;
            case "RESET_PASSWORD_EXCEED_LIMIT":
                i2 = 22;
                i2 = -1;
                break;
            case "INVALID_PENDING_TOKEN":
                i2 = 3;
                i2 = -1;
                break;
            case "INVALID_CUSTOM_TOKEN":
                i2 = 2;
                i2 = -1;
                break;
            case "INVALID_PASSWORD":
                i2 = 11;
                i2 = -1;
                break;
            case "<<Network Error>>":
                i2 = 15;
                i2 = -1;
                break;
            case "SESSION_EXPIRED":
                i2 = 38;
                i2 = -1;
                break;
            case "MISSING_CODE":
                i2 = 33;
                i2 = -1;
                break;
            case "FEDERATED_USER_ID_ALREADY_LINKED":
                i2 = 12;
                i2 = -1;
                break;
            case "INVALID_IDENTIFIER":
                i2 = 6;
                i2 = -1;
                break;
            case "USER_DISABLED":
                i2 = 5;
                i2 = -1;
                break;
            case "INVALID_PHONE_NUMBER":
                i2 = 32;
                i2 = -1;
                break;
            case "INVALID_APP_CREDENTIAL":
                i2 = 19;
                i2 = -1;
                break;
            case "TOO_MANY_ATTEMPTS_TRY_LATER":
                i2 = 21;
                i2 = -1;
                break;
            case "MISSING_CONTINUE_URI":
                i2 = 44;
                i2 = -1;
                break;
            case "MISSING_SESSION_INFO":
                i2 = 35;
                i2 = -1;
                break;
            case "EMAIL_CHANGE_NEEDS_VERIFICATION":
                i2 = 63;
                i2 = -1;
                break;
            case "UNSUPPORTED_TENANT_OPERATION":
                i2 = 49;
                i2 = -1;
                break;
            default:
                i2 = -1;
        }
        final int i5 = 17499;
        switch (i2) {
            case 0:
                i = 17016;
                break;
            case 1:
                i = 17002;
                break;
            case 2:
                i = 17000;
                break;
            case 3:
                i = 17004;
                break;
            case 4:
                i = 17005;
                break;
            case 5:
                i = 17008;
                break;
            case 6:
                i = 17011;
                break;
            case 7:
                i = 17007;
                break;
            case 8:
                i = 17009;
                break;
            case 9:
                i = 17025;
                break;
            case 10:
                i = 17017;
                break;
            case 11:
                i = 17020;
                break;
            case 12:
                i = 17026;
                break;
            case 13:
                i = 17006;
                break;
            case 14:
                i = 17028;
                break;
            case 15:
                i = 17014;
                break;
            case 16:
                i = 17010;
                break;
            case 17:
                i = 17021;
                break;
            case 18:
                i = 17030;
                break;
            case 19:
                i = 17029;
                break;
            case 20:
                i = 17031;
                break;
            case 21:
                i = 17032;
                break;
            case 22:
                i = 17033;
                break;
            case 23:
                i = 17034;
                break;
            case 24:
                i = 17035;
                break;
            case 25:
                i = 17041;
                break;
            case 26:
                i = 17042;
                break;
            case 27:
                i = 17043;
                break;
            case 28:
                i = 17044;
                break;
            case 29:
                i = 17045;
                break;
            case 30:
                i = 17046;
                break;
            case 31:
                i = 17049;
                break;
            case 32:
                i = 17051;
                break;
            case 33:
                i = 17052;
                break;
            case 34:
                i = 17064;
                break;
            case 35:
                i = 17061;
                break;
            case 36:
                i = 17062;
                break;
            case 37:
                i = 17065;
                break;
            case 38:
                i = 17040;
                break;
            case 39:
                i = 17068;
                break;
            case 40:
                i = 17071;
                break;
            case 41:
                i = 17057;
                break;
            case 42:
                i = 17058;
                break;
            case 43:
                i = 17073;
                break;
            case 44:
                i = 17079;
                break;
            case 45:
                i = 17074;
                break;
            case 46:
                i = 17075;
                break;
            case 47:
                i = 17078;
                break;
            case 48:
                i = 17081;
                break;
            case 49:
                i = 17082;
                break;
            case 50:
                i = 17083;
                break;
            case 51:
                i = 17084;
                break;
            case 52:
                i = 17085;
                break;
            case 53:
                i = 17086;
                break;
            case 54:
                i = 17087;
                break;
            case 55:
                i = 17088;
                break;
            case 56:
                i = 17089;
                break;
            case 57:
                i = 17090;
                break;
            case 58:
                i = 17091;
                break;
            case 59:
                i = 17093;
                break;
            case 60:
                i = 17094;
                break;
            case 61:
                i = 18001;
                break;
            default:
                i = i5;
        }
        if (i == i5 && string2 != null) {
            if (string2 != null) {
                StringBuilder stringBuilder = new StringBuilder(i7 += length2);
                stringBuilder.append(string);
                stringBuilder.append(":");
                stringBuilder.append(string2);
                Status status = new Status(i5, stringBuilder.toString());
                return status;
            }
            Status obj7 = new Status(i5, string);
            return obj7;
        }
        Status obj6 = new Status(i, string2);
        return obj6;
    }
}
