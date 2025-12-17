package com.google.firebase.crashlytics.internal.log;

/* loaded from: classes2.dex */
interface FileLogStore {
    public abstract void closeLogFile();

    public abstract void deleteLogFile();

    public abstract byte[] getLogAsBytes();

    public abstract String getLogAsString();

    public abstract void writeToLog(long l, String string2);
}
