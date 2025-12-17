package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes2.dex */
public class TrimmedThrowableData {

    public final com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData cause = null;
    public final String className;
    public final String localizedMessage;
    public final java.lang.StackTraceElement[] stacktrace;
    public TrimmedThrowableData(Throwable throwable, com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy stackTraceTrimmingStrategy2) {
        super();
        this.localizedMessage = throwable.getLocalizedMessage();
        this.className = throwable.getClass().getName();
        this.stacktrace = stackTraceTrimmingStrategy2.getTrimmedStackTrace(throwable.getStackTrace());
        final Throwable obj2 = throwable.getCause();
        if (obj2 != null) {
            TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(obj2, stackTraceTrimmingStrategy2);
        }
        int i = 0;
    }
}
