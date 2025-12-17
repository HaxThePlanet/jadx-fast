package com.google.firebase.inappmessaging;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;

/* loaded from: classes2.dex */
public enum DismissType implements c0.c {

    UNKNOWN_DISMISS_TYPE(false),
    AUTO(true),
    CLICK(2),
    SWIPE(3);

    private final int value;

    private static final class DismissTypeVerifier implements c0.e {

        static final c0.e INSTANCE;
        static {
            DismissType.DismissTypeVerifier dismissTypeVerifier = new DismissType.DismissTypeVerifier();
            DismissType.DismissTypeVerifier.INSTANCE = dismissTypeVerifier;
        }

        @Override // com.google.protobuf.c0$e
        public boolean isInRange(int i) {
            int obj1;
            obj1 = DismissType.forNumber(i) != null ? 1 : 0;
            return obj1;
        }
    }
    public static com.google.firebase.inappmessaging.DismissType forNumber(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return DismissType.SWIPE;
                }
                return DismissType.CLICK;
            }
            return DismissType.AUTO;
        }
        return DismissType.UNKNOWN_DISMISS_TYPE;
    }

    public static c0.d<com.google.firebase.inappmessaging.DismissType> internalGetValueMap() {
        return DismissType.internalValueMap;
    }

    public static c0.e internalGetVerifier() {
        return DismissType.DismissTypeVerifier.INSTANCE;
    }

    @Deprecated
    public static com.google.firebase.inappmessaging.DismissType valueOf(int i) {
        return DismissType.forNumber(i);
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
