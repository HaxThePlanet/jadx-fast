package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\n\u0010\u0008J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\t\u0010\u0008¨\u0006\u000b", d2 = {"Lokhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "Ljava/util/logging/LogRecord;", "record", "Lkotlin/w;", "publish", "(Ljava/util/logging/LogRecord;)V", "flush", "()V", "close", "<init>", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidLogHandler extends Handler {

    public static final okhttp3.internal.platform.android.AndroidLogHandler INSTANCE;
    static {
        AndroidLogHandler androidLogHandler = new AndroidLogHandler();
        AndroidLogHandler.INSTANCE = androidLogHandler;
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        n.f(logRecord, "record");
        final String loggerName = logRecord.getLoggerName();
        n.e(loggerName, "record.loggerName");
        final String message = logRecord.getMessage();
        n.e(message, "record.message");
        AndroidLog.INSTANCE.androidLog$okhttp(loggerName, AndroidLogKt.access$getAndroidLevel$p(logRecord), message, logRecord.getThrown());
    }
}
