package okhttp3.internal.platform.android;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0005", d2 = {"Ljava/util/logging/LogRecord;", "", "getAndroidLevel", "(Ljava/util/logging/LogRecord;)I", "androidLevel", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class AndroidLogKt {
    public static final int access$getAndroidLevel$p(LogRecord logRecord) {
        return AndroidLogKt.getAndroidLevel(logRecord);
    }

    private static final int getAndroidLevel(LogRecord logRecord) {
        int intValue;
        int obj2;
        obj2 = logRecord.getLevel().intValue() > Level.INFO.intValue() ? 5 : obj2 == intValue ? 4 : 3;
        return obj2;
    }
}
