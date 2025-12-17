package com.google.firebase.database.logging;

import java.io.PrintStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class DefaultLogger implements com.google.firebase.database.logging.Logger {

    private final Set<String> enabledComponents = null;
    private final com.google.firebase.database.logging.Logger.Level minLevel;
    public DefaultLogger(com.google.firebase.database.logging.Logger.Level logger$Level, List<String> list2) {
        HashSet hashSet;
        java.util.Collection obj3;
        super();
        if (list2 != null) {
            hashSet = new HashSet(list2);
            this.enabledComponents = hashSet;
        } else {
            obj3 = 0;
        }
        this.minLevel = level;
    }

    @Override // com.google.firebase.database.logging.Logger
    protected String buildLogMessage(com.google.firebase.database.logging.Logger.Level logger$Level, String string2, String string3, long l4) {
        Date date = new Date(l4, obj6);
        StringBuilder obj5 = new StringBuilder();
        obj5.append(date.toString());
        obj5.append(" [");
        obj5.append(level);
        obj5.append("] ");
        obj5.append(string2);
        obj5.append(": ");
        obj5.append(string3);
        return obj5.toString();
    }

    @Override // com.google.firebase.database.logging.Logger
    protected void debug(String string, String string2) {
        System.out.println(string2);
    }

    @Override // com.google.firebase.database.logging.Logger
    protected void error(String string, String string2) {
        System.err.println(string2);
    }

    @Override // com.google.firebase.database.logging.Logger
    public com.google.firebase.database.logging.Logger.Level getLogLevel() {
        return this.minLevel;
    }

    @Override // com.google.firebase.database.logging.Logger
    protected void info(String string, String string2) {
        System.out.println(string2);
    }

    @Override // com.google.firebase.database.logging.Logger
    public void onLogMessage(com.google.firebase.database.logging.Logger.Level logger$Level, String string2, String string3, long l4) {
        com.google.firebase.database.logging.Logger.Level obj2;
        String obj4;
        long obj5;
        if (shouldLog(level, string2)) {
            obj4 = buildLogMessage(level, string2, string3, l4);
            obj2 = DefaultLogger.1.$SwitchMap$com$google$firebase$database$logging$Logger$Level[level.ordinal()];
            if (obj2 != 1) {
                if (obj2 != 2) {
                    if (obj2 != 3) {
                        if (obj2 != 4) {
                        } else {
                            debug(string2, obj4);
                        }
                        obj2 = new RuntimeException("Should not reach here!");
                        throw obj2;
                    }
                    info(string2, obj4);
                } else {
                    warn(string2, obj4);
                }
            } else {
                error(string2, obj4);
            }
        }
    }

    @Override // com.google.firebase.database.logging.Logger
    protected boolean shouldLog(com.google.firebase.database.logging.Logger.Level logger$Level, String string2) {
        Set enabledComponents;
        int obj3;
        if (level.ordinal() >= this.minLevel.ordinal()) {
            if (this.enabledComponents != null && level.ordinal() <= Logger.Level.DEBUG.ordinal()) {
                if (level.ordinal() <= Logger.Level.DEBUG.ordinal()) {
                    obj3 = this.enabledComponents.contains(string2) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // com.google.firebase.database.logging.Logger
    protected void warn(String string, String string2) {
        System.out.println(string2);
    }
}
