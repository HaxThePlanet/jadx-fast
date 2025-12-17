package com.google.firebase.database.logging;

/* loaded from: classes2.dex */
public interface Logger {

    public static enum Level {

        DEBUG,
        INFO,
        WARN,
        ERROR,
        NONE;
    }
    public abstract com.google.firebase.database.logging.Logger.Level getLogLevel();

    public abstract void onLogMessage(com.google.firebase.database.logging.Logger.Level logger$Level, String string2, String string3, long l4);
}
