package androidx.tracing;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class Trace {

    static final int MAX_TRACE_LABEL_LENGTH = 127;
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;
    public static void beginAsyncSection(String methodName, int cookie) {
        TraceApi29Impl.beginAsyncSection(Trace.truncatedTraceSectionLabel(methodName), cookie);
    }

    private static void beginAsyncSectionFallback(String methodName, int cookie) {
        Method sAsyncTraceBeginMethod2;
        Method sAsyncTraceBeginMethod;
        Class[] arr;
        Class tYPE;
        int i;
        if (Trace.sAsyncTraceBeginMethod == null) {
            arr = new Class[3];
            Trace.sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
        }
        try {
            Trace.sAsyncTraceBeginMethod.invoke(0, /* result */);
            Trace.handleException(obj0, th);
        }
    }

    public static void beginSection(String label) {
        TraceApi18Impl.beginSection(Trace.truncatedTraceSectionLabel(label));
    }

    public static void endAsyncSection(String methodName, int cookie) {
        TraceApi29Impl.endAsyncSection(Trace.truncatedTraceSectionLabel(methodName), cookie);
    }

    private static void endAsyncSectionFallback(String methodName, int cookie) {
        Method sAsyncTraceEndMethod;
        Method sAsyncTraceEndMethod2;
        Class[] arr;
        Class tYPE;
        int i;
        if (Trace.sAsyncTraceEndMethod == null) {
            arr = new Class[3];
            Trace.sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
        }
        try {
            Trace.sAsyncTraceEndMethod.invoke(0, /* result */);
            Trace.handleException(obj0, th);
        }
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void forceEnableAppTracing() {
        boolean sHasAppTracingEnabled;
        int method;
        int i2;
        Class tYPE;
        int i;
        if (Build.VERSION.SDK_INT < 31 && !Trace.sHasAppTracingEnabled) {
            if (!Trace.sHasAppTracingEnabled) {
                int i3 = 1;
                Trace.sHasAppTracingEnabled = i3;
                Class[] arr = new Class[i3];
                arr[0] = Boolean.TYPE;
                Trace.class.getMethod("setAppTracingAllowed", arr).invoke(0, /* result */);
            }
        }
    }

    private static void handleException(String methodName, Exception exception) {
        Throwable cause = exception.getCause();
        if (exception instanceof InvocationTargetException != null && cause instanceof RuntimeException != null) {
            cause = exception.getCause();
            if (cause instanceof RuntimeException != null) {
                throw (RuntimeException)cause;
            }
            RuntimeException runtimeException = new RuntimeException(cause);
            throw runtimeException;
        }
        StringBuilder cause2 = new StringBuilder();
        Log.v("Trace", cause2.append("Unable to call ").append(methodName).append(" via reflection").toString(), exception);
    }

    public static boolean isEnabled() {
        return TraceApi29Impl.isEnabled();
    }

    private static boolean isEnabledFallback() {
        Object sIsTagEnabledMethod;
        Method method;
        Class[] arr;
        Class tYPE;
        final int i2 = 0;
        if (Trace.sIsTagEnabledMethod == null) {
            Trace.sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(i2);
            arr = new Class[1];
            Trace.sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", Long.TYPE);
        }
        return (Boolean)Trace.sIsTagEnabledMethod.invoke(i2, /* result */).booleanValue();
    }

    public static void setCounter(String counterName, int counterValue) {
        TraceApi29Impl.setCounter(Trace.truncatedTraceSectionLabel(counterName), counterValue);
    }

    private static void setCounterFallback(String counterName, int counterValue) {
        Method sTraceCounterMethod2;
        Method sTraceCounterMethod;
        Class[] arr;
        Class tYPE;
        int i;
        if (Trace.sTraceCounterMethod == null) {
            arr = new Class[3];
            Trace.sTraceCounterMethod = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
        }
        try {
            Trace.sTraceCounterMethod.invoke(0, /* result */);
            Trace.handleException(obj0, th);
        }
    }

    private static String truncatedTraceSectionLabel(String labelName) {
        final int i2 = 127;
        if (labelName.length() <= i2) {
            return labelName;
        }
        return labelName.substring(0, i2);
    }
}
