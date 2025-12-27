package com.vimeo.networking.logging;

import com.vimeo.networking.Vimeo.LogLevel;
import java.io.PrintStream;

/* compiled from: ClientLogger.java */
/* loaded from: classes2.dex */
public final class ClientLogger {

    private static Vimeo.LogLevel sLogLevel;
    private static LogProvider sLoggerProvider;
    static {
        ClientLogger.sLogLevel = Vimeo.LogLevel.DEBUG;
    }

    private ClientLogger() {
        super();
    }

    public static void d(String str) {
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.DEBUG.ordinal() && ClientLogger.sLoggerProvider != null) {
            ClientLogger.sLoggerProvider.d(str);
        }
    }

    public static void e(String str) {
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.ERROR.ordinal() && ClientLogger.sLoggerProvider != null) {
            ClientLogger.sLoggerProvider.e(str);
        }
    }

    public static Vimeo.LogLevel getLogLevel() {
        return ClientLogger.sLogLevel;
    }

    public static void setLogLevel(Vimeo.LogLevel logLevel) {
        ClientLogger.sLogLevel = logLevel;
    }

    public static void setLogProvider(LogProvider logProvider) {
        ClientLogger.sLoggerProvider = logProvider;
    }

    public static void v(String str) {
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.VERBOSE.ordinal() && ClientLogger.sLoggerProvider != null) {
            ClientLogger.sLoggerProvider.v(str);
        }
    }

    public static void e(String str, Exception exc) {
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.ERROR.ordinal() && ClientLogger.sLoggerProvider != null) {
            ClientLogger.sLoggerProvider.e(str, exc);
        }
    }
}
