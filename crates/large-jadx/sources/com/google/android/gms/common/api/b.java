package com.google.android.gms.common.api;

/* loaded from: classes2.dex */
public class b {
    public static String a(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
                StringBuilder stringBuilder = new StringBuilder(32);
                stringBuilder.append("unknown status code: ");
                stringBuilder.append(i);
                return stringBuilder.toString();
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "DEVELOPER_ERROR";
            case 10:
                return "ERROR";
            case 11:
                return "INTERRUPTED";
            case 12:
                return "TIMEOUT";
            case 13:
                return "CANCELED";
            case 14:
                return "API_NOT_CONNECTED";
            case 15:
                return "DEAD_CLIENT";
            case 16:
                return "REMOTE_EXCEPTION";
            case 17:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 18:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            default:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
