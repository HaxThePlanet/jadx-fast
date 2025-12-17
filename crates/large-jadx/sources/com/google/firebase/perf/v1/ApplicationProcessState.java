package com.google.firebase.perf.v1;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;

/* loaded from: classes2.dex */
public enum ApplicationProcessState implements c0.c {

    APPLICATION_PROCESS_STATE_UNKNOWN(false),
    FOREGROUND(true),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);

    private final int value;

    private static final class ApplicationProcessStateVerifier implements c0.e {

        static final c0.e INSTANCE;
        static {
            ApplicationProcessState.ApplicationProcessStateVerifier applicationProcessStateVerifier = new ApplicationProcessState.ApplicationProcessStateVerifier();
            ApplicationProcessState.ApplicationProcessStateVerifier.INSTANCE = applicationProcessStateVerifier;
        }

        @Override // com.google.protobuf.c0$e
        public boolean isInRange(int i) {
            int obj1;
            obj1 = ApplicationProcessState.forNumber(i) != null ? 1 : 0;
            return obj1;
        }
    }
    public static com.google.firebase.perf.v1.ApplicationProcessState forNumber(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return ApplicationProcessState.FOREGROUND_BACKGROUND;
                }
                return ApplicationProcessState.BACKGROUND;
            }
            return ApplicationProcessState.FOREGROUND;
        }
        return ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
    }

    public static c0.d<com.google.firebase.perf.v1.ApplicationProcessState> internalGetValueMap() {
        return ApplicationProcessState.internalValueMap;
    }

    public static c0.e internalGetVerifier() {
        return ApplicationProcessState.ApplicationProcessStateVerifier.INSTANCE;
    }

    @Deprecated
    public static com.google.firebase.perf.v1.ApplicationProcessState valueOf(int i) {
        return ApplicationProcessState.forNumber(i);
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
