package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import l.b0;
import l.f;
import l.g;
import l.i;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0012\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 L2\u00020\u0001:\u0001LB\u0017\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020\u001c¢\u0006\u0004\u0008J\u0010KJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\u0008\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\r\u0010\u000eJ+\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\u0008\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\u0008\u0015\u0010\nJ\u001d\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\u0008\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\u0008\u001a\u0010\u001bJ/\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\u0008 \u0010!J/\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0008\u0010#\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\u0008$\u0010%J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000b¢\u0006\u0004\u0008&\u0010\u000eJ%\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\u0008*\u0010+J%\u0010/\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010.\u001a\u00020-¢\u0006\u0004\u0008/\u00100J\u001d\u00102\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0004¢\u0006\u0004\u00082\u0010\u0008J-\u00105\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\u00085\u00106J\u000f\u00107\u001a\u00020\u0006H\u0016¢\u0006\u0004\u00087\u0010\nJ+\u00109\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\u00089\u0010:R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008>\u0010?R\u0016\u0010@\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008@\u0010AR\u0016\u0010B\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008B\u0010CR\u0016\u0010D\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008D\u0010AR\u0019\u0010F\u001a\u00020E8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008F\u0010G\u001a\u0004\u0008H\u0010I¨\u0006M", d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "", "streamId", "", "byteCount", "Lkotlin/w;", "writeContinuationFrames", "(IJ)V", "connectionPreface", "()V", "Lokhttp3/internal/http2/Settings;", "peerSettings", "applyAndAckSettings", "(Lokhttp3/internal/http2/Settings;)V", "promisedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "flush", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "maxDataLength", "()I", "", "outFinished", "Ll/f;", "source", "data", "(ZILl/f;I)V", "flags", "buffer", "dataFrame", "(IILl/f;I)V", "settings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;[B)V", "windowSizeIncrement", "windowUpdate", "length", "type", "frameHeader", "(IIII)V", "close", "headerBlock", "headers", "(ZILjava/util/List;)V", "maxFrameSize", "I", "Ll/g;", "sink", "Ll/g;", "client", "Z", "hpackBuffer", "Ll/f;", "closed", "Lokhttp3/internal/http2/Hpack$Writer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "<init>", "(Ll/g;Z)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Writer implements Closeable {

    public static final okhttp3.internal.http2.Http2Writer.Companion Companion;
    private static final Logger logger;
    private final boolean client;
    private boolean closed;
    private final f hpackBuffer;
    private final okhttp3.internal.http2.Hpack.Writer hpackWriter;
    private int maxFrameSize = 16384;
    private final g sink;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0004\u0010\u0005¨\u0006\u0008", d2 = {"Lokhttp3/internal/http2/Http2Writer$Companion;", "", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        Http2Writer.Companion companion = new Http2Writer.Companion(0);
        Http2Writer.Companion = companion;
        Http2Writer.logger = Logger.getLogger(Http2.class.getName());
    }

    public Http2Writer(g g, boolean z2) {
        n.f(g, "sink");
        super();
        this.sink = g;
        this.client = z2;
        f fVar = new f();
        this.hpackBuffer = fVar;
        int obj8 = 16384;
        super(0, 0, fVar, 3, 0);
        this.hpackWriter = obj8;
    }

    private final void writeContinuationFrames(int i, long l2) {
        int i2;
        int i3 = 0;
        while (Long.compare(l2, i3) > 0) {
            long l3 = Math.min((long)maxFrameSize, obj3);
            if (Long.compare(obj8, i3) == 0) {
            } else {
            }
            i2 = 0;
            frameHeader(i, (int)l3, 9, i2);
            this.sink.write(this.hpackBuffer, l3);
            i3 = 0;
            i2 = 4;
        }
    }

    @Override // java.io.Closeable
    public final void applyAndAckSettings(okhttp3.internal.http2.Settings settings) {
        int headerTableSize;
        Object obj3;
        n.f(settings, "peerSettings");
        synchronized (this) {
            try {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                if (settings.getHeaderTableSize() != -1) {
                }
                this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
                int i3 = 0;
                frameHeader(i3, i3, 4, 1);
                this.sink.flush();
                obj3 = new IOException("closed");
                throw obj3;
                throw settings;
            }
        }
    }

    @Override // java.io.Closeable
    public void close() {
        this.closed = true;
        this.sink.close();
        return;
        synchronized (this) {
            this.closed = true;
            this.sink.close();
        }
    }

    @Override // java.io.Closeable
    public final void connectionPreface() {
        boolean loggable;
        Object[] arr;
        synchronized (this) {
            try {
                if (!this.client) {
                }
                Logger logger = Http2Writer.logger;
                if (logger.isLoggable(Level.FINE)) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(">> CONNECTION ");
                stringBuilder.append(Http2.CONNECTION_PREFACE.p());
                logger.fine(Util.format(stringBuilder.toString(), new Object[0]));
                this.sink.y1(Http2.CONNECTION_PREFACE);
                this.sink.flush();
                IOException iOException = new IOException("closed");
                throw iOException;
            }
        }
    }

    @Override // java.io.Closeable
    public final void data(boolean z, int i2, f f3, int i4) {
        int i;
        synchronized (this) {
            try {
                i = 0;
                if (z != null) {
                }
                i = 1;
                dataFrame(i2, i, f3, i4);
                IOException obj2 = new IOException("closed");
                throw obj2;
                throw z;
            }
        }
    }

    @Override // java.io.Closeable
    public final void dataFrame(int i, int i2, f f3, int i4) {
        int i3;
        int obj3;
        frameHeader(i, i4, 0, i2);
        if (i4 > 0) {
            n.d(f3);
            this.sink.write(f3, (long)i4);
        }
    }

    @Override // java.io.Closeable
    public final void flush() {
        synchronized (this) {
            try {
                this.sink.flush();
                IOException iOException = new IOException("closed");
                throw iOException;
                throw th;
            }
        }
    }

    @Override // java.io.Closeable
    public final void frameHeader(int i, int i2, int i3, int i4) {
        int i11;
        boolean frameLog;
        int i5;
        okhttp3.internal.http2.Http2 iNSTANCE;
        int i9;
        int i8;
        int i10;
        int i6;
        int i7;
        Logger logger = Http2Writer.logger;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.INSTANCE.frameLog(false, i, i2, i3, i4));
        }
        int i14 = 0;
        i11 = i2 <= this.maxFrameSize ? i5 : i14;
        if (i11 == 0) {
        } else {
            if (i12 &= i == 0) {
            } else {
                i5 = i14;
            }
            if (i5 == 0) {
            } else {
                Util.writeMedium(this.sink, i2);
                this.sink.c0(i3 &= 255);
                this.sink.c0(i4 & 255);
                this.sink.P(i &= obj11);
            }
            StringBuilder obj10 = new StringBuilder();
            obj10.append("reserved bit set: ");
            obj10.append(i);
            obj10 = new IllegalArgumentException(obj10.toString().toString());
            throw obj10;
        }
        StringBuilder obj9 = new StringBuilder();
        obj9.append("FRAME_SIZE_ERROR length > ");
        obj9.append(this.maxFrameSize);
        obj9.append(": ");
        obj9.append(i2);
        obj10 = new IllegalArgumentException(obj9.toString().toString());
        throw obj10;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    @Override // java.io.Closeable
    public final void goAway(int i, okhttp3.internal.http2.ErrorCode errorCode2, byte[] b3Arr3) {
        int i2;
        int i3;
        int obj5;
        n.f(errorCode2, "errorCode");
        n.f(b3Arr3, "debugData");
        synchronized (this) {
            try {
                final int i7 = 1;
                i3 = 0;
                if (errorCode2.getHttpCode() != -1) {
                } else {
                }
                i2 = i7;
                i2 = i3;
                if (i2 == 0) {
                } else {
                }
                frameHeader(i3, length += 8, 7, i3);
                this.sink.P(i);
                this.sink.P(errorCode2.getHttpCode());
                if (b3Arr3.length == 0) {
                }
                i3 = i7;
                if (i3 ^ 1 != 0) {
                }
                this.sink.w1(b3Arr3);
                this.sink.flush();
                IllegalArgumentException obj6 = new IllegalArgumentException("errorCode.httpCode == -1".toString());
                throw obj6;
                obj5 = new IOException("closed");
                throw obj5;
                throw i;
            }
        }
    }

    public final void headers(boolean z, int i2, List<okhttp3.internal.http2.Header> list3) {
        long size;
        int i;
        n.f(list3, "headerBlock");
        synchronized (this) {
            try {
                this.hpackWriter.writeHeaders(list3);
                size = this.hpackBuffer.size();
                long l2 = Math.min((long)obj9, obj3);
                int obj9 = Long.compare(size, l2);
                if (obj9 == null) {
                } else {
                }
                i = 4;
                i = 0;
                if (z != null) {
                }
                i |= 1;
                frameHeader(i2, (int)l2, 1, i);
                this.sink.write(this.hpackBuffer, l2);
                if (obj9 > 0) {
                }
                writeContinuationFrames(i2, size -= l2);
                IOException obj7 = new IOException("closed");
                throw obj7;
                throw z;
            }
        }
    }

    @Override // java.io.Closeable
    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    @Override // java.io.Closeable
    public final void ping(boolean z, int i2, int i3) {
        int obj4;
        synchronized (this) {
            try {
                final int i5 = 0;
                if (z != null) {
                } else {
                }
                obj4 = 1;
                obj4 = i5;
                frameHeader(i5, 8, 6, obj4);
                this.sink.P(i2);
                this.sink.P(i3);
                this.sink.flush();
                obj4 = new IOException("closed");
                throw obj4;
                throw z;
            }
        }
    }

    public final void pushPromise(int i, int i2, List<okhttp3.internal.http2.Header> list3) {
        long size;
        int i3;
        n.f(list3, "requestHeaders");
        synchronized (this) {
            try {
                this.hpackWriter.writeHeaders(list3);
                size = this.hpackBuffer.size();
                int obj10 = (int)l2;
                long l3 = (long)obj10;
                obj10 = Long.compare(size, l3);
                if (obj10 == null) {
                } else {
                }
                i3 = 4;
                i3 = 0;
                frameHeader(i, obj10 + 4, 5, i3);
                this.sink.P(i2 &= i7);
                this.sink.write(this.hpackBuffer, l3);
                if (obj10 > 0) {
                }
                writeContinuationFrames(i, size -= l3);
                IOException obj8 = new IOException("closed");
                throw obj8;
                throw i;
            }
        }
    }

    @Override // java.io.Closeable
    public final void rstStream(int i, okhttp3.internal.http2.ErrorCode errorCode2) {
        int i2;
        n.f(errorCode2, "errorCode");
        synchronized (this) {
            try {
                final int i6 = 0;
                if (errorCode2.getHttpCode() != -1) {
                } else {
                }
                i2 = 1;
                i2 = i6;
                if (i2 == 0) {
                } else {
                }
                frameHeader(i, 4, 3, i6);
                this.sink.P(errorCode2.getHttpCode());
                this.sink.flush();
                IllegalArgumentException obj5 = new IllegalArgumentException("Failed requirement.".toString());
                throw obj5;
                IOException obj4 = new IOException("closed");
                throw obj4;
                throw i;
            }
        }
    }

    @Override // java.io.Closeable
    public final void settings(okhttp3.internal.http2.Settings settings) {
        int i;
        g sink;
        int i2;
        int i3;
        n.f(settings, "settings");
        synchronized (this) {
            try {
                final int i6 = 4;
                i = 0;
                frameHeader(i, size *= 6, i6, i);
                while (i < 10) {
                    if (!settings.isSet(i)) {
                    } else {
                    }
                    if (i != i6) {
                    } else {
                    }
                    i2 = 3;
                    this.sink.I(i2);
                    this.sink.P(settings.get(i));
                    i++;
                    if (i != 7) {
                    } else {
                    }
                    i2 = i6;
                    i2 = i;
                }
                if (!settings.isSet(i)) {
                } else {
                }
                if (i != i6) {
                } else {
                }
                if (i != 7) {
                } else {
                }
                i2 = i;
                i2 = i6;
                i2 = 3;
                this.sink.I(i2);
                this.sink.P(settings.get(i));
                i++;
                this.sink.flush();
                IOException obj6 = new IOException("closed");
                throw obj6;
                throw settings;
            }
        }
    }

    @Override // java.io.Closeable
    public final void windowUpdate(int i, long l2) {
        int i3;
        int cmp;
        int i2;
        synchronized (this) {
            try {
                final int i6 = 0;
                if (Long.compare(l2, i4) != 0 && Long.compare(l2, i2) <= 0) {
                } else {
                }
                if (Long.compare(l2, i2) <= 0) {
                } else {
                }
                i3 = 1;
                i3 = i6;
                if (i3 == 0) {
                } else {
                }
                frameHeader(i, 4, 8, i6);
                this.sink.P((int)l2);
                this.sink.flush();
                StringBuilder obj5 = new StringBuilder();
                obj5.append("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ");
                obj5.append(l2);
                IllegalArgumentException obj6 = new IllegalArgumentException(obj5.toString().toString());
                throw obj6;
                obj5 = new IOException("closed");
                throw obj5;
                throw i;
            }
        }
    }
}
