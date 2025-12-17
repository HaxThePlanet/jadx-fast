package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class RemoveRepeatsStrategy implements com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy {

    private final int maxRepetitions;
    public RemoveRepeatsStrategy() {
        super(1);
    }

    public RemoveRepeatsStrategy(int i) {
        super();
        this.maxRepetitions = i;
    }

    private static boolean isRepeatingSequence(java.lang.StackTraceElement[] stackTraceElementArr, int i2, int i3) {
        int i;
        int length;
        Object obj;
        final int i4 = i3 - i2;
        final int i7 = 0;
        if (i3 + i4 > stackTraceElementArr.length) {
            return i7;
        }
        i = i7;
        while (i < i4) {
            i++;
        }
        return 1;
    }

    private static java.lang.StackTraceElement[] trimRepeats(java.lang.StackTraceElement[] stackTraceElementArr, int i2) {
        int i;
        int i5;
        int i3;
        Object obj;
        int i4;
        boolean repeatingSequence;
        HashMap hashMap = new HashMap();
        java.lang.StackTraceElement[] arr = new StackTraceElement[stackTraceElementArr.length];
        final int i6 = 0;
        final int i7 = 1;
        i5 = i;
        i3 = i7;
        while (i < stackTraceElementArr.length) {
            obj = stackTraceElementArr[i];
            Object obj2 = hashMap.get(obj);
            if ((Integer)obj2 != null) {
            } else {
            }
            arr[i5] = stackTraceElementArr[i];
            i5++;
            i3 = i7;
            i4 = i;
            hashMap.put(obj, Integer.valueOf(i));
            i = i4 + 1;
            if (!RemoveRepeatsStrategy.isRepeatingSequence(stackTraceElementArr, (Integer)obj2.intValue(), i)) {
            } else {
            }
            int i8 = i - intValue;
            if (i3 < i2) {
            }
            i9 += i;
            System.arraycopy(stackTraceElementArr, i, arr, i5, i8);
            i5 += i8;
            i3++;
        }
        final java.lang.StackTraceElement[] obj10 = new StackTraceElement[i5];
        System.arraycopy(arr, i6, obj10, i6, i5);
        return obj10;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public java.lang.StackTraceElement[] getTrimmedStackTrace(java.lang.StackTraceElement[] stackTraceElementArr) {
        java.lang.StackTraceElement[] trimRepeats = RemoveRepeatsStrategy.trimRepeats(stackTraceElementArr, this.maxRepetitions);
        if (trimRepeats.length < stackTraceElementArr.length) {
            return trimRepeats;
        }
        return stackTraceElementArr;
    }
}
