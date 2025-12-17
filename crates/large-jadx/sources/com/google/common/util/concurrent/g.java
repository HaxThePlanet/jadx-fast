package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class g {

    private String a = null;
    private Boolean b = null;
    private Integer c = null;
    private java.lang.Thread.UncaughtExceptionHandler d = null;
    private ThreadFactory e = null;

    class a implements ThreadFactory {

        final ThreadFactory a;
        final String b;
        final AtomicLong c;
        final Boolean v;
        final Integer w;
        final java.lang.Thread.UncaughtExceptionHandler x;
        a(ThreadFactory threadFactory, String string2, AtomicLong atomicLong3, Boolean boolean4, Integer integer5, java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler6) {
            this.a = threadFactory;
            this.b = string2;
            this.c = atomicLong3;
            this.v = boolean4;
            this.w = integer5;
            this.x = uncaughtExceptionHandler6;
            super();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str;
            Boolean booleanValue;
            Integer intValue;
            Object[] arr;
            int i;
            Long valueOf;
            final Thread obj6 = this.a.newThread(runnable);
            str = this.b;
            if (str != null) {
                arr = new Object[1];
                obj6.setName(g.a(str, arr));
            }
            booleanValue = this.v;
            if (booleanValue != null) {
                obj6.setDaemon(booleanValue.booleanValue());
            }
            intValue = this.w;
            if (intValue != null) {
                obj6.setPriority(intValue.intValue());
            }
            java.lang.Thread.UncaughtExceptionHandler exc = this.x;
            if (exc != null) {
                obj6.setUncaughtExceptionHandler(exc);
            }
            return obj6;
        }
    }
    public g() {
        super();
        final int i = 0;
    }

    static String a(String string, Object[] object2Arr2) {
        return g.d(string, object2Arr2);
    }

    private static ThreadFactory c(com.google.common.util.concurrent.g g) {
        int i;
        ThreadFactory obj9;
        final String str = g.a;
        if (g.e != null) {
        } else {
            obj9 = Executors.defaultThreadFactory();
        }
        if (str != null) {
            obj9 = new AtomicLong(0, obj8);
        } else {
            obj9 = 0;
        }
        super(obj9, str, obj9, g.b, g.c, g.d);
        return obj9;
    }

    private static String d(String string, Object... object2Arr2) {
        return String.format(Locale.ROOT, string, object2Arr2);
    }

    public ThreadFactory b() {
        return g.c(this);
    }

    public com.google.common.util.concurrent.g e(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    public com.google.common.util.concurrent.g f(String string) {
        Object[] arr = new Object[1];
        final int i2 = 0;
        arr[i2] = Integer.valueOf(i2);
        g.d(string, arr);
        this.a = string;
        return this;
    }
}
