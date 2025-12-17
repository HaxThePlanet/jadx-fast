package com.google.firebase.perf.v1;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;

/* loaded from: classes2.dex */
public enum SessionVerbosity implements c0.c {

    SESSION_VERBOSITY_NONE(false),
    GAUGES_AND_SYSTEM_EVENTS(true);

    private final int value;

    private static final class SessionVerbosityVerifier implements c0.e {

        static final c0.e INSTANCE;
        static {
            SessionVerbosity.SessionVerbosityVerifier sessionVerbosityVerifier = new SessionVerbosity.SessionVerbosityVerifier();
            SessionVerbosity.SessionVerbosityVerifier.INSTANCE = sessionVerbosityVerifier;
        }

        @Override // com.google.protobuf.c0$e
        public boolean isInRange(int i) {
            int obj1;
            obj1 = SessionVerbosity.forNumber(i) != null ? 1 : 0;
            return obj1;
        }
    }
    public static com.google.firebase.perf.v1.SessionVerbosity forNumber(int i) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return null;
            }
            return SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS;
        }
        return SessionVerbosity.SESSION_VERBOSITY_NONE;
    }

    public static c0.d<com.google.firebase.perf.v1.SessionVerbosity> internalGetValueMap() {
        return SessionVerbosity.internalValueMap;
    }

    public static c0.e internalGetVerifier() {
        return SessionVerbosity.SessionVerbosityVerifier.INSTANCE;
    }

    @Deprecated
    public static com.google.firebase.perf.v1.SessionVerbosity valueOf(int i) {
        return SessionVerbosity.forNumber(i);
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
