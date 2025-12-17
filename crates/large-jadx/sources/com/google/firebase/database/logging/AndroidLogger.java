package com.google.firebase.database.logging;

import android.util.Log;
import java.util.List;

/* loaded from: classes2.dex */
public class AndroidLogger extends com.google.firebase.database.logging.DefaultLogger {
    public AndroidLogger(com.google.firebase.database.logging.Logger.Level logger$Level, List<String> list2) {
        super(level, list2);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected String buildLogMessage(com.google.firebase.database.logging.Logger.Level logger$Level, String string2, String string3, long l4) {
        return string3;
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void debug(String string, String string2) {
        Log.d(string, string2);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void error(String string, String string2) {
        Log.e(string, string2);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void info(String string, String string2) {
        Log.i(string, string2);
    }

    @Override // com.google.firebase.database.logging.DefaultLogger
    protected void warn(String string, String string2) {
        Log.w(string, string2);
    }
}
