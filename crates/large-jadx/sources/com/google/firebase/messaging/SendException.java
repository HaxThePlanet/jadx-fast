package com.google.firebase.messaging;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class SendException extends Exception {

    public static final int ERROR_INVALID_PARAMETERS = 1;
    public static final int ERROR_SIZE = 2;
    public static final int ERROR_TOO_MANY_MESSAGES = 4;
    public static final int ERROR_TTL_EXCEEDED = 3;
    public static final int ERROR_UNKNOWN;
    private final int errorCode;
    SendException(String string) {
        super(string);
        this.errorCode = parseErrorCode(string);
    }

    private int parseErrorCode(String string) {
        int str;
        String obj7;
        final int i = 0;
        if (string == null) {
            return i;
        }
        obj7 = string.toLowerCase(Locale.US);
        final int i2 = 4;
        final int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        switch (obj7) {
            case "service_not_available":
                obj7 = i3;
                obj7 = -1;
                break;
            case "toomanymessages":
                obj7 = i2;
                obj7 = -1;
                break;
            case "invalid_parameters":
                obj7 = i;
                obj7 = -1;
                break;
            case "messagetoobig":
                obj7 = i4;
                obj7 = -1;
                break;
            case "missing_to":
                obj7 = i5;
                obj7 = -1;
                break;
            default:
                obj7 = -1;
        }
        if (obj7 != null && obj7 != i5 && obj7 != i4 && obj7 != i3 && obj7 != i2) {
            if (obj7 != i5) {
                if (obj7 != i4) {
                    if (obj7 != i3) {
                        if (obj7 != i2) {
                            return i;
                        }
                        return i2;
                    }
                    return i3;
                }
                return i4;
            }
        }
        return i5;
    }

    @Override // java.lang.Exception
    public int getErrorCode() {
        return this.errorCode;
    }
}
