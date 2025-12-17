package com.google.firebase.crashlytics.internal.log;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.util.Set;

/* loaded from: classes2.dex */
public class LogFileManager {

    private static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    private static final String LOGFILE_EXT = ".temp";
    private static final String LOGFILE_PREFIX = "crashlytics-userlog-";
    static final int MAX_LOG_SIZE = 65536;
    private static final com.google.firebase.crashlytics.internal.log.LogFileManager.NoopLogStore NOOP_LOG_STORE;
    private final Context context;
    private com.google.firebase.crashlytics.internal.log.FileLogStore currentLog;
    private final com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider directoryProvider;

    public interface DirectoryProvider {
        public abstract File getLogFileDir();
    }

    private static final class NoopLogStore implements com.google.firebase.crashlytics.internal.log.FileLogStore {
        NoopLogStore(com.google.firebase.crashlytics.internal.log.LogFileManager.1 logFileManager$1) {
            super();
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public void closeLogFile() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public void deleteLogFile() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public byte[] getLogAsBytes() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public String getLogAsString() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        public void writeToLog(long l, String string2) {
        }
    }
    static {
        LogFileManager.NoopLogStore noopLogStore = new LogFileManager.NoopLogStore(0);
        LogFileManager.NOOP_LOG_STORE = noopLogStore;
    }

    public LogFileManager(Context context, com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider logFileManager$DirectoryProvider2) {
        super(context, directoryProvider2, 0);
    }

    public LogFileManager(Context context, com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider logFileManager$DirectoryProvider2, String string3) {
        super();
        this.context = context;
        this.directoryProvider = directoryProvider2;
        this.currentLog = LogFileManager.NOOP_LOG_STORE;
        setCurrentSession(string3);
    }

    private String getSessionIdForFile(File file) {
        String obj3 = file.getName();
        int lastIndexOf = obj3.lastIndexOf(".temp");
        if (lastIndexOf == -1) {
            return obj3;
        }
        return obj3.substring(20, lastIndexOf);
    }

    private File getWorkingFileForSession(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("crashlytics-userlog-");
        stringBuilder.append(string);
        stringBuilder.append(".temp");
        File file = new File(this.directoryProvider.getLogFileDir(), stringBuilder.toString());
        return file;
    }

    public void clearLog() {
        this.currentLog.deleteLogFile();
    }

    public void discardOldLogFiles(Set<String> set) {
        int length;
        int i;
        File file;
        boolean contains;
        File[] listFiles = this.directoryProvider.getLogFileDir().listFiles();
        if (listFiles != null) {
            i = 0;
            while (i < listFiles.length) {
                file = listFiles[i];
                if (set.contains(getSessionIdForFile(file)) == null) {
                }
                i++;
                file.delete();
            }
        }
    }

    public byte[] getBytesForLog() {
        return this.currentLog.getLogAsBytes();
    }

    public String getLogString() {
        return this.currentLog.getLogAsString();
    }

    public final void setCurrentSession(String string) {
        this.currentLog.closeLogFile();
        this.currentLog = LogFileManager.NOOP_LOG_STORE;
        if (string == null) {
        }
        if (!CommonUtils.getBooleanResourceValue(this.context, "com.crashlytics.CollectCustomLogs", true)) {
            Logger.getLogger().d("Preferences requested no custom logs. Aborting log file creation.");
        }
        setLogFile(getWorkingFileForSession(string), 65536);
    }

    void setLogFile(File file, int i2) {
        QueueFileLogStore queueFileLogStore = new QueueFileLogStore(file, i2);
        this.currentLog = queueFileLogStore;
    }

    public void writeToLog(long l, String string2) {
        this.currentLog.writeToLog(l, string2);
    }
}
