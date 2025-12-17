package com.google.firebase.database.core;

/* loaded from: classes2.dex */
public interface ThreadInitializer {

    public static final com.google.firebase.database.core.ThreadInitializer defaultInstance;
    static {
        ThreadInitializer.1 anon = new ThreadInitializer.1();
        ThreadInitializer.defaultInstance = anon;
    }

    public abstract void setDaemon(Thread thread, boolean z2);

    public abstract void setName(Thread thread, String string2);

    public abstract void setUncaughtExceptionHandler(Thread thread, java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler2);
}
