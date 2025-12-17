package androidx.core.os;

import android.os.Trace;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
@Deprecated
public final class TraceCompat {

    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static class Api29Impl {
        static void beginAsyncSection(String methodName, int cookie) {
            Trace.beginAsyncSection(methodName, cookie);
        }

        static void endAsyncSection(String methodName, int cookie) {
            Trace.endAsyncSection(methodName, cookie);
        }

        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        static void setCounter(String counterName, long counterValue) {
            Trace.setCounter(counterName, counterValue);
        }
    }
    static {
    }

    public static void beginAsyncSection(String methodName, int cookie) {
        TraceCompat.Api29Impl.beginAsyncSection(methodName, cookie);
    }

    public static void beginSection(String sectionName) {
        Trace.beginSection(sectionName);
    }

    public static void endAsyncSection(String methodName, int cookie) {
        TraceCompat.Api29Impl.endAsyncSection(methodName, cookie);
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        return TraceCompat.Api29Impl.isEnabled();
    }

    public static void setCounter(String counterName, int counterValue) {
        TraceCompat.Api29Impl.setCounter(counterName, (long)counterValue);
    }
}
