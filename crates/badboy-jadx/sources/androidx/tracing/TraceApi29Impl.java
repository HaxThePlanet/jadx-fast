package androidx.tracing;

import android.os.Trace;

/* loaded from: classes5.dex */
final class TraceApi29Impl {
    public static void beginAsyncSection(String methodName, int cookie) {
        Trace.beginAsyncSection(methodName, cookie);
    }

    public static void endAsyncSection(String methodName, int cookie) {
        Trace.endAsyncSection(methodName, cookie);
    }

    public static boolean isEnabled() {
        return Trace.isEnabled();
    }

    public static void setCounter(String counterName, int counterValue) {
        Trace.setCounter(counterName, (long)counterValue);
    }
}
