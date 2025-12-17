package androidx.core.util;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes5.dex */
@Deprecated
public class LogWriter extends Writer {

    private StringBuilder mBuilder;
    private final String mTag;
    public LogWriter(String tag) {
        super();
        StringBuilder stringBuilder = new StringBuilder(128);
        this.mBuilder = stringBuilder;
        this.mTag = tag;
    }

    private void flushBuilder() {
        int mBuilder;
        int length;
        int i;
        if (this.mBuilder.length() > 0) {
            Log.d(this.mTag, this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
    }

    @Override // java.io.Writer
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer
    public void flush() {
        flushBuilder();
    }

    @Override // java.io.Writer
    public void write(char[] buf, int offset, int count) {
        int i;
        char c;
        int mBuilder;
        i = 0;
        while (i < count) {
            c = buf[offset + i];
            if (c == 10) {
            } else {
            }
            this.mBuilder.append(c);
            i++;
            flushBuilder();
        }
    }
}
