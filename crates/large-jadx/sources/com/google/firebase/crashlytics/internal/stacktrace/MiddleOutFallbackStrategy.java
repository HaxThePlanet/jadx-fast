package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes2.dex */
public class MiddleOutFallbackStrategy implements com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy {

    private final int maximumStackSize;
    private final com.google.firebase.crashlytics.internal.stacktrace.MiddleOutStrategy middleOutStrategy;
    private final com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy[] trimmingStrategies;
    public MiddleOutFallbackStrategy(int i, com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy... stackTraceTrimmingStrategy2Arr2) {
        super();
        this.maximumStackSize = i;
        this.trimmingStrategies = stackTraceTrimmingStrategy2Arr2;
        MiddleOutStrategy obj2 = new MiddleOutStrategy(i);
        this.middleOutStrategy = obj2;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public java.lang.StackTraceElement[] getTrimmedStackTrace(java.lang.StackTraceElement[] stackTraceElementArr) {
        int i;
        java.lang.StackTraceElement[] trimmedStackTrace;
        com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy stack;
        int length;
        int maximumStackSize;
        int obj8;
        if (stackTraceElementArr.length <= this.maximumStackSize) {
            return stackTraceElementArr;
        }
        com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy[] trimmingStrategies = this.trimmingStrategies;
        i = 0;
        trimmedStackTrace = stackTraceElementArr;
        while (i < trimmingStrategies.length) {
            if (trimmedStackTrace.length <= this.maximumStackSize) {
                break;
            } else {
            }
            trimmedStackTrace = trimmingStrategies[i].getTrimmedStackTrace(stackTraceElementArr);
            i++;
        }
        if (trimmedStackTrace.length > this.maximumStackSize) {
            trimmedStackTrace = this.middleOutStrategy.getTrimmedStackTrace(trimmedStackTrace);
        }
        return trimmedStackTrace;
    }
}
