package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes2.dex */
class QueueFileLogStore implements com.google.firebase.crashlytics.internal.log.FileLogStore {

    private static final Charset UTF_8;
    private com.google.firebase.crashlytics.internal.log.QueueFile logFile;
    private final int maxLogSize;
    private final File workingFile;

    private static class LogBytes {

        public final byte[] bytes;
        public final int offset;
        LogBytes(byte[] bArr, int i2) {
            super();
            this.bytes = bArr;
            this.offset = i2;
        }
    }
    static {
        QueueFileLogStore.UTF_8 = Charset.forName("UTF-8");
    }

    QueueFileLogStore(File file, int i2) {
        super();
        this.workingFile = file;
        this.maxLogSize = i2;
    }

    private void doWriteToLog(long l, String string2) {
        int stringBuilder;
        int i;
        byte[] obj5;
        com.google.firebase.crashlytics.internal.log.QueueFile obj6;
        String obj7;
        String str = " ";
        if (this.logFile == null) {
        }
        if (obj7 == null) {
            obj7 = "null";
        }
        maxLogSize /= 4;
        if (obj7.length() > i2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("...");
            stringBuilder.append(obj7.substring(length -= i2));
            obj7 = stringBuilder.toString();
        }
        Object[] arr = new Object[2];
        this.logFile.add(String.format(Locale.US, "%d %s%n", Long.valueOf(l), obj7.replaceAll("\r", str).replaceAll("\n", str)).getBytes(QueueFileLogStore.UTF_8));
        while (this.logFile.isEmpty() == null) {
            if (this.logFile.usedBytes() > this.maxLogSize) {
            }
            this.logFile.remove();
        }
        try {
        }
    }

    private com.google.firebase.crashlytics.internal.log.QueueFileLogStore.LogBytes getLogBytes() {
        com.google.firebase.crashlytics.internal.log.QueueFile logFile;
        com.google.firebase.crashlytics.internal.log.QueueFileLogStore.1 anon;
        String str;
        int i = 0;
        if (this.workingFile.exists() == null) {
            return i;
        }
        openLogFile();
        com.google.firebase.crashlytics.internal.log.QueueFile logFile2 = this.logFile;
        if (logFile2 == null) {
            return i;
        }
        int[] iArr = new int[1];
        final int i4 = 0;
        iArr[i4] = i4;
        byte[] bArr = new byte[logFile2.usedBytes()];
        anon = new QueueFileLogStore.1(this, bArr, iArr);
        this.logFile.forEach(anon);
        QueueFileLogStore.LogBytes logBytes = new QueueFileLogStore.LogBytes(bArr, iArr[i4]);
        return logBytes;
    }

    private void openLogFile() {
        com.google.firebase.crashlytics.internal.log.QueueFile queueFile;
        Object workingFile2;
        StringBuilder string;
        String workingFile;
        if (this.logFile == null) {
            queueFile = new QueueFile(this.workingFile);
            this.logFile = queueFile;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    public void closeLogFile() {
        CommonUtils.closeOrLog(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = 0;
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    public byte[] getLogAsBytes() {
        com.google.firebase.crashlytics.internal.log.QueueFileLogStore.LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        final int offset = logBytes.offset;
        final byte[] bArr = new byte[offset];
        final int i2 = 0;
        System.arraycopy(logBytes.bytes, i2, bArr, i2, offset);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    public String getLogAsString() {
        String string;
        Charset uTF_8;
        final byte[] logAsBytes = getLogAsBytes();
        if (logAsBytes != null) {
            string = new String(logAsBytes, QueueFileLogStore.UTF_8);
        } else {
            string = 0;
        }
        return string;
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    public void writeToLog(long l, String string2) {
        openLogFile();
        doWriteToLog(l, string2);
    }
}
