package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes2.dex */
public interface StackTraceTrimmingStrategy {
    public abstract java.lang.StackTraceElement[] getTrimmedStackTrace(java.lang.StackTraceElement[] stackTraceElementArr);
}
