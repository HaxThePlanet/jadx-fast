package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes2.dex */
public class MiddleOutStrategy implements com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy {

    private final int trimmedSize;
    public MiddleOutStrategy(int i) {
        super();
        this.trimmedSize = i;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public java.lang.StackTraceElement[] getTrimmedStackTrace(java.lang.StackTraceElement[] stackTraceElementArr) {
        int trimmedSize = this.trimmedSize;
        if (stackTraceElementArr.length <= trimmedSize) {
            return stackTraceElementArr;
        }
        int i = trimmedSize / 2;
        final int i2 = trimmedSize - i;
        java.lang.StackTraceElement[] arr = new StackTraceElement[trimmedSize];
        int i3 = 0;
        System.arraycopy(stackTraceElementArr, i3, arr, i3, i2);
        System.arraycopy(stackTraceElementArr, length2 -= i, arr, i2, i);
        return arr;
    }
}
