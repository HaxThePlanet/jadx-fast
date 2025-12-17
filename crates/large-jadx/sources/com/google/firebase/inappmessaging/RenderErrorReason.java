package com.google.firebase.inappmessaging;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;

/* loaded from: classes2.dex */
public enum RenderErrorReason implements c0.c {

    UNSPECIFIED_RENDER_ERROR(false),
    IMAGE_FETCH_ERROR(true),
    IMAGE_DISPLAY_ERROR(2),
    IMAGE_UNSUPPORTED_FORMAT(3);

    private final int value;

    private static final class RenderErrorReasonVerifier implements c0.e {

        static final c0.e INSTANCE;
        static {
            RenderErrorReason.RenderErrorReasonVerifier renderErrorReasonVerifier = new RenderErrorReason.RenderErrorReasonVerifier();
            RenderErrorReason.RenderErrorReasonVerifier.INSTANCE = renderErrorReasonVerifier;
        }

        @Override // com.google.protobuf.c0$e
        public boolean isInRange(int i) {
            int obj1;
            obj1 = RenderErrorReason.forNumber(i) != null ? 1 : 0;
            return obj1;
        }
    }
    public static com.google.firebase.inappmessaging.RenderErrorReason forNumber(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT;
                }
                return RenderErrorReason.IMAGE_DISPLAY_ERROR;
            }
            return RenderErrorReason.IMAGE_FETCH_ERROR;
        }
        return RenderErrorReason.UNSPECIFIED_RENDER_ERROR;
    }

    public static c0.d<com.google.firebase.inappmessaging.RenderErrorReason> internalGetValueMap() {
        return RenderErrorReason.internalValueMap;
    }

    public static c0.e internalGetVerifier() {
        return RenderErrorReason.RenderErrorReasonVerifier.INSTANCE;
    }

    @Deprecated
    public static com.google.firebase.inappmessaging.RenderErrorReason valueOf(int i) {
        return RenderErrorReason.forNumber(i);
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
