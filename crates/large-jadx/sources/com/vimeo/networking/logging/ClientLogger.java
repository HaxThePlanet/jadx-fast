package com.vimeo.networking.logging;

import com.vimeo.networking.Vimeo.LogLevel;
import java.io.PrintStream;

/* loaded from: classes2.dex */
public final class ClientLogger {

    private static Vimeo.LogLevel sLogLevel;
    private static com.vimeo.networking.logging.LogProvider sLoggerProvider;
    static {
        ClientLogger.sLogLevel = Vimeo.LogLevel.DEBUG;
    }

    public static void d(String string) {
        int sLoggerProvider;
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.DEBUG.ordinal()) {
            sLoggerProvider = ClientLogger.sLoggerProvider;
            if (sLoggerProvider != null) {
                sLoggerProvider.d(string);
            } else {
                System.out.println(string);
            }
        }
    }

    public static void e(String string) {
        int sLoggerProvider;
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.ERROR.ordinal()) {
            sLoggerProvider = ClientLogger.sLoggerProvider;
            if (sLoggerProvider != null) {
                sLoggerProvider.e(string);
            } else {
                System.out.println(string);
            }
        }
    }

    public static void e(String string, Exception exception2) {
        int sLoggerProvider;
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.ERROR.ordinal()) {
            sLoggerProvider = ClientLogger.sLoggerProvider;
            if (sLoggerProvider != null) {
                sLoggerProvider.e(string, exception2);
            } else {
                System.out.println(string);
                exception2.printStackTrace();
            }
        }
    }

    public static Vimeo.LogLevel getLogLevel() {
        return ClientLogger.sLogLevel;
    }

    public static void setLogLevel(Vimeo.LogLevel vimeo$LogLevel) {
        ClientLogger.sLogLevel = logLevel;
    }

    public static void setLogProvider(com.vimeo.networking.logging.LogProvider logProvider) {
        ClientLogger.sLoggerProvider = logProvider;
    }

    public static void v(String string) {
        int sLoggerProvider;
        if (ClientLogger.sLogLevel.ordinal() <= Vimeo.LogLevel.VERBOSE.ordinal()) {
            sLoggerProvider = ClientLogger.sLoggerProvider;
            if (sLoggerProvider != null) {
                sLoggerProvider.v(string);
            } else {
                System.out.println(string);
            }
        }
    }
}
