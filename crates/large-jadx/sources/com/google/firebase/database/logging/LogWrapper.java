package com.google.firebase.database.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class LogWrapper {

    private final String component;
    private final com.google.firebase.database.logging.Logger logger;
    private final String prefix;
    public LogWrapper(com.google.firebase.database.logging.Logger logger, String string2) {
        super(logger, string2, 0);
    }

    public LogWrapper(com.google.firebase.database.logging.Logger logger, String string2, String string3) {
        super();
        this.logger = logger;
        this.component = string2;
        this.prefix = string3;
    }

    private static String exceptionStacktrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    private long now() {
        return System.currentTimeMillis();
    }

    private String toLog(String string, Object... object2Arr2) {
        int length;
        String obj2;
        Object obj3;
        if (object2Arr2.length > 0) {
            obj2 = String.format(string, object2Arr2);
        }
        if (this.prefix == null) {
        } else {
            obj3 = new StringBuilder();
            obj3.append(this.prefix);
            obj3.append(" - ");
            obj3.append(obj2);
            obj2 = obj3.toString();
        }
        return obj2;
    }

    public void debug(String string, Throwable throwable2, Object... object3Arr3) {
        boolean logsDebug;
        com.google.firebase.database.logging.Logger.Level dEBUG;
        String component;
        String str;
        long l;
        String obj7;
        Object[] obj9;
        if (logsDebug() && throwable2 != null) {
            if (throwable2 != null) {
                obj9 = new StringBuilder();
                obj9.append(toLog(string, object3Arr3));
                obj9.append("\n");
                obj9.append(LogWrapper.exceptionStacktrace(throwable2));
                obj7 = obj9.toString();
            }
            this.logger.onLogMessage(Logger.Level.DEBUG, this.component, obj7, now());
        }
    }

    public void debug(String string, Object... object2Arr2) {
        debug(string, 0, object2Arr2);
    }

    public void error(String string, Throwable throwable2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toLog(string, new Object[0]));
        stringBuilder.append("\n");
        stringBuilder.append(LogWrapper.exceptionStacktrace(throwable2));
        this.logger.onLogMessage(Logger.Level.ERROR, this.component, stringBuilder.toString(), now());
    }

    public void info(String string) {
        this.logger.onLogMessage(Logger.Level.INFO, this.component, toLog(string, new Object[0]), now());
    }

    public boolean logsDebug() {
        int i;
        i = this.logger.getLogLevel().ordinal() <= Logger.Level.DEBUG.ordinal() ? 1 : 0;
        return i;
    }

    public void warn(String string) {
        warn(string, 0);
    }

    public void warn(String string, Throwable throwable2) {
        Object[] stringBuilder;
        String obj7;
        if (throwable2 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(toLog(string, new Object[0]));
            stringBuilder.append("\n");
            stringBuilder.append(LogWrapper.exceptionStacktrace(throwable2));
            obj7 = stringBuilder.toString();
        }
        this.logger.onLogMessage(Logger.Level.WARN, this.component, obj7, now());
    }
}
