package com.google.firebase.inappmessaging;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;

/* loaded from: classes2.dex */
public enum FetchErrorReason implements c0.c {

    UNSPECIFIED_FETCH_ERROR(false),
    SERVER_ERROR(true),
    CLIENT_ERROR(2),
    NETWORK_ERROR(3);

    private final int value;

    private static final class FetchErrorReasonVerifier implements c0.e {

        static final c0.e INSTANCE;
        static {
            FetchErrorReason.FetchErrorReasonVerifier fetchErrorReasonVerifier = new FetchErrorReason.FetchErrorReasonVerifier();
            FetchErrorReason.FetchErrorReasonVerifier.INSTANCE = fetchErrorReasonVerifier;
        }

        @Override // com.google.protobuf.c0$e
        public boolean isInRange(int i) {
            int obj1;
            obj1 = FetchErrorReason.forNumber(i) != null ? 1 : 0;
            return obj1;
        }
    }
    public static com.google.firebase.inappmessaging.FetchErrorReason forNumber(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return FetchErrorReason.NETWORK_ERROR;
                }
                return FetchErrorReason.CLIENT_ERROR;
            }
            return FetchErrorReason.SERVER_ERROR;
        }
        return FetchErrorReason.UNSPECIFIED_FETCH_ERROR;
    }

    public static c0.d<com.google.firebase.inappmessaging.FetchErrorReason> internalGetValueMap() {
        return FetchErrorReason.internalValueMap;
    }

    public static c0.e internalGetVerifier() {
        return FetchErrorReason.FetchErrorReasonVerifier.INSTANCE;
    }

    @Deprecated
    public static com.google.firebase.inappmessaging.FetchErrorReason valueOf(int i) {
        return FetchErrorReason.forNumber(i);
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
