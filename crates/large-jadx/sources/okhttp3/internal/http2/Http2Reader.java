package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.d;
import kotlin.h0.g;
import l.d0;
import l.e0;
import l.f;
import l.h;
import l.i;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 .2\u00020\u0001:\u0003./0B\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010!\u001a\u00020\u001b¢\u0006\u0004\u0008,\u0010-J/\u0010\t\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\t\u0010\nJ5\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ/\u0010\u0010\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0010\u0010\nJ/\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0011\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J/\u0010\u0013\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0013\u0010\nJ/\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0014\u0010\nJ/\u0010\u0015\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0015\u0010\nJ/\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0016\u0010\nJ/\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0017\u0010\nJ/\u0010\u0018\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0018\u0010\nJ\u0015\u0010\u0019\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008*\u0010+¨\u00061", d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "handler", "", "length", "flags", "streamId", "Lkotlin/w;", "readHeaders", "(Lokhttp3/internal/http2/Http2Reader$Handler;III)V", "padding", "", "Lokhttp3/internal/http2/Header;", "readHeaderBlock", "(IIII)Ljava/util/List;", "readData", "readPriority", "(Lokhttp3/internal/http2/Http2Reader$Handler;I)V", "readRstStream", "readSettings", "readPushPromise", "readPing", "readGoAway", "readWindowUpdate", "readConnectionPreface", "(Lokhttp3/internal/http2/Http2Reader$Handler;)V", "", "requireSettings", "nextFrame", "(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z", "close", "()V", "client", "Z", "Lokhttp3/internal/http2/Hpack$Reader;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Ll/h;", "source", "Ll/h;", "<init>", "(Ll/h;Z)V", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Reader implements Closeable {

    public static final okhttp3.internal.http2.Http2Reader.Companion Companion;
    private static final Logger logger;
    private final boolean client;
    private final okhttp3.internal.http2.Http2Reader.ContinuationSource continuation;
    private final okhttp3.internal.http2.Hpack.Reader hpackReader;
    private final h source;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ%\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00088\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000f", d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "", "length", "flags", "padding", "lengthWithoutPadding", "(III)I", "Ljava/util/logging/Logger;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final Logger getLogger() {
            return Http2Reader.access$getLogger$cp();
        }

        public final int lengthWithoutPadding(int i, int i2, int i3) {
            int obj3;
            if (i2 &= 8 != 0) {
                i--;
            }
            if (i3 > obj3) {
            } else {
                return obj3 -= i3;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PROTOCOL_ERROR padding ");
            stringBuilder.append(i3);
            stringBuilder.append(" > remaining length ");
            stringBuilder.append(obj3);
            IOException obj4 = new IOException(stringBuilder.toString());
            throw obj4;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008f\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0004H&¢\u0006\u0004\u0008\n\u0010\u000bJ5\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u00042\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\u0008\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH&¢\u0006\u0004\u0008\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\u0008\u001f\u0010 J'\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\u0008$\u0010%J\u001f\u0010(\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\u0008(\u0010)J/\u0010-\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\u0008-\u0010.J-\u00101\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u000c\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\u00081\u00102J?\u00109\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\"2\u0006\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020&H&¢\u0006\u0004\u00089\u0010:¨\u0006;", d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "", "inFinished", "", "streamId", "Ll/h;", "source", "length", "Lkotlin/w;", "data", "(ZILl/h;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "ackSettings", "()V", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Ll/i;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Ll/i;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Ll/i;Ljava/lang/String;IJ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Handler {
        public abstract void ackSettings();

        public abstract void alternateService(int i, String string2, i i3, String string4, int i5, long l6);

        public abstract void data(boolean z, int i2, h h3, int i4);

        public abstract void goAway(int i, okhttp3.internal.http2.ErrorCode errorCode2, i i3);

        public abstract void headers(boolean z, int i2, int i3, List<okhttp3.internal.http2.Header> list4);

        public abstract void ping(boolean z, int i2, int i3);

        public abstract void priority(int i, int i2, int i3, boolean z4);

        public abstract void pushPromise(int i, int i2, List<okhttp3.internal.http2.Header> list3);

        public abstract void rstStream(int i, okhttp3.internal.http2.ErrorCode errorCode2);

        public abstract void settings(boolean z, okhttp3.internal.http2.Settings settings2);

        public abstract void windowUpdate(int i, long l2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\u0008%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000e\u0010\u0004R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0011\u001a\u0004\u0008\u0017\u0010\u0013\"\u0004\u0008\u0018\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u0011\u001a\u0004\u0008\u001d\u0010\u0013\"\u0004\u0008\u001e\u0010\u0015R\"\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u001f\u0010\u0011\u001a\u0004\u0008 \u0010\u0013\"\u0004\u0008!\u0010\u0015R\"\u0010\"\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\"\u0010\u0011\u001a\u0004\u0008#\u0010\u0013\"\u0004\u0008$\u0010\u0015¨\u0006'", d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Ll/d0;", "Lkotlin/w;", "readContinuationHeader", "()V", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "Ll/e0;", "timeout", "()Ll/e0;", "close", "", "left", "I", "getLeft", "()I", "setLeft", "(I)V", "flags", "getFlags", "setFlags", "Ll/h;", "source", "Ll/h;", "streamId", "getStreamId", "setStreamId", "padding", "getPadding", "setPadding", "length", "getLength", "setLength", "<init>", "(Ll/h;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class ContinuationSource implements d0 {

        private int flags;
        private int left;
        private int length;
        private int padding;
        private final h source;
        private int streamId;
        public ContinuationSource(h h) {
            n.f(h, "source");
            super();
            this.source = h;
        }

        private final void readContinuationHeader() {
            Object companion;
            boolean frameLog;
            Level fINE;
            int streamId;
            int length;
            int i;
            int flags;
            int medium = Util.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            int i3 = 255;
            int i2 = Util.and(this.source.readByte(), i3);
            this.flags = Util.and(this.source.readByte(), i3);
            companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, i2, this.flags));
            }
            int &= i6;
            this.streamId = i5;
            if (i2 != 9) {
            } else {
                if (i5 != this.streamId) {
                } else {
                }
                IOException iOException = new IOException("TYPE_CONTINUATION streamId changed");
                throw iOException;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i2);
            stringBuilder.append(" != TYPE_CONTINUATION");
            IOException iOException2 = new IOException(stringBuilder.toString());
            throw iOException2;
        }

        @Override // l.d0
        public void close() {
        }

        @Override // l.d0
        public final int getFlags() {
            return this.flags;
        }

        @Override // l.d0
        public final int getLeft() {
            return this.left;
        }

        @Override // l.d0
        public final int getLength() {
            return this.length;
        }

        @Override // l.d0
        public final int getPadding() {
            return this.padding;
        }

        @Override // l.d0
        public final int getStreamId() {
            return this.streamId;
        }

        @Override // l.d0
        public long read(f f, long l2) {
            String str;
            int i;
            long l;
            n.f(f, "sink");
            int left = this.left;
            i = -1;
            while (left == 0) {
                this.source.skip((long)padding);
                this.padding = 0;
                readContinuationHeader();
                left = this.left;
                i = -1;
            }
            final long obj7 = this.source.read(f, Math.min(l2, obj9));
            if (Long.compare(obj7, i) == 0) {
                return i;
            }
            this.left = obj9 -= i3;
            return obj7;
        }

        @Override // l.d0
        public final void setFlags(int i) {
            this.flags = i;
        }

        @Override // l.d0
        public final void setLeft(int i) {
            this.left = i;
        }

        @Override // l.d0
        public final void setLength(int i) {
            this.length = i;
        }

        @Override // l.d0
        public final void setPadding(int i) {
            this.padding = i;
        }

        @Override // l.d0
        public final void setStreamId(int i) {
            this.streamId = i;
        }

        @Override // l.d0
        public e0 timeout() {
            return this.source.timeout();
        }
    }
    static {
        Http2Reader.Companion companion = new Http2Reader.Companion(0);
        Http2Reader.Companion = companion;
        Logger logger = Logger.getLogger(Http2.class.getName());
        n.e(logger, "Logger.getLogger(Http2::class.java.name)");
        Http2Reader.logger = logger;
    }

    public Http2Reader(h h, boolean z2) {
        n.f(h, "source");
        super();
        this.source = h;
        this.client = z2;
        Http2Reader.ContinuationSource continuationSource = new Http2Reader.ContinuationSource(h);
        this.continuation = continuationSource;
        super(continuationSource, 4096, 0, 4, 0);
        this.hpackReader = obj8;
    }

    public static final Logger access$getLogger$cp() {
        return Http2Reader.logger;
    }

    private final void readData(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        int i7;
        int i6;
        int i;
        int i5;
        if (i4 == 0) {
        } else {
            i6 = 0;
            i7 = i3 & 1 != 0 ? i : i6;
            if (i3 & 32 != 0) {
            } else {
                i = i6;
            }
            if (i != 0) {
            } else {
                if (i3 & 8 != 0) {
                    i6 = Util.and(this.source.readByte(), 255);
                }
                final h obj7 = this.source;
                handler.data(i7, i4, obj7, Http2Reader.Companion.lengthWithoutPadding(i2, i3, i6));
                this.source.skip((long)i6);
            }
            IOException obj5 = new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            throw obj5;
        }
        obj5 = new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        throw obj5;
    }

    private final void readGoAway(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        i iVar;
        long l;
        int obj6 = 8;
        if (i2 < obj6) {
        } else {
            if (i4 != 0) {
            } else {
                int int = this.source.readInt();
                i2 -= obj6;
                obj6 = ErrorCode.Companion.fromHttp2(int);
                if (obj6 == null) {
                } else {
                    iVar = i.c;
                    if (obj5 > 0) {
                        iVar = this.source.B((long)obj5);
                    }
                    handler.goAway(this.source.readInt(), obj6, iVar);
                }
                StringBuilder obj5 = new StringBuilder();
                obj5.append("TYPE_GOAWAY unexpected error code: ");
                obj5.append(int);
                IOException obj4 = new IOException(obj5.toString());
                throw obj4;
            }
            obj4 = new IOException("TYPE_GOAWAY streamId != 0");
            throw obj4;
        }
        obj6 = new StringBuilder();
        obj6.append("TYPE_GOAWAY length < 8: ");
        obj6.append(i2);
        obj4 = new IOException(obj6.toString());
        throw obj4;
    }

    private final List<okhttp3.internal.http2.Header> readHeaderBlock(int i, int i2, int i3, int i4) {
        this.continuation.setLeft(i);
        okhttp3.internal.http2.Http2Reader.ContinuationSource obj2 = this.continuation;
        obj2.setLength(obj2.getLeft());
        this.continuation.setPadding(i2);
        this.continuation.setFlags(i3);
        this.continuation.setStreamId(i4);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        int i6;
        int i;
        int i5;
        int obj5;
        if (i4 == 0) {
        } else {
            i6 = i3 & 1 != 0 ? 1 : i;
            if (i3 & 8 != 0) {
                i = Util.and(this.source.readByte(), 255);
            }
            if (i3 & 32 != 0) {
                readPriority(handler, i4);
                i2 += -5;
            }
            handler.headers(i6, i4, -1, readHeaderBlock(Http2Reader.Companion.lengthWithoutPadding(obj5, i3, i), i, i3, i4));
        }
        IOException obj4 = new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        throw obj4;
    }

    private final void readPing(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        int i;
        if (i2 != 8) {
        } else {
            if (i4 != 0) {
            } else {
                if (i3 &= i != 0) {
                } else {
                    i = 0;
                }
                handler.ping(i, this.source.readInt(), this.source.readInt());
            }
            IOException obj2 = new IOException("TYPE_PING streamId != 0");
            throw obj2;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("TYPE_PING length != 8: ");
        obj4.append(i2);
        obj2 = new IOException(obj4.toString());
        throw obj2;
    }

    private final void readPriority(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2) {
        int i;
        int int = this.source.readInt();
        final int i6 = 1;
        i = i4 &= int != 0 ? i6 : 0;
        handler.priority(i2, int &= i7, i8 += i6, i);
    }

    private final void readPriority(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        if (i2 != 5) {
        } else {
            if (i4 == 0) {
            } else {
                readPriority(handler, i4);
            }
            IOException obj1 = new IOException("TYPE_PRIORITY streamId == 0");
            throw obj1;
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("TYPE_PRIORITY length: ");
        obj3.append(i2);
        obj3.append(" != 5");
        obj1 = new IOException(obj3.toString());
        throw obj1;
    }

    private final void readPushPromise(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        int i;
        int i5;
        if (i4 == 0) {
        } else {
            if (i3 & 8 != 0) {
                i = Util.and(this.source.readByte(), 255);
            } else {
                i = 0;
            }
            handler.pushPromise(i4, int &= i8, readHeaderBlock(Http2Reader.Companion.lengthWithoutPadding(i2 += -4, i3, i), i, i3, i4));
        }
        IOException obj4 = new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        throw obj4;
    }

    private final void readRstStream(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        if (i2 != 4) {
        } else {
            if (i4 == 0) {
            } else {
                int obj2 = this.source.readInt();
                okhttp3.internal.http2.ErrorCode obj3 = ErrorCode.Companion.fromHttp2(obj2);
                if (obj3 == null) {
                } else {
                    handler.rstStream(i4, obj3);
                }
                obj3 = new StringBuilder();
                obj3.append("TYPE_RST_STREAM unexpected error code: ");
                obj3.append(obj2);
                IOException obj1 = new IOException(obj3.toString());
                throw obj1;
            }
            obj1 = new IOException("TYPE_RST_STREAM streamId == 0");
            throw obj1;
        }
        obj3 = new StringBuilder();
        obj3.append("TYPE_RST_STREAM length: ");
        obj3.append(i2);
        obj3.append(" != 4");
        obj1 = new IOException(obj3.toString());
        throw obj1;
    }

    private final void readSettings(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        int i6;
        int i;
        int int;
        int i5;
        int i7;
        if (i4 != 0) {
        } else {
            int obj11 = 1;
            if (i3 &= obj11 != 0) {
                if (i2 != 0) {
                } else {
                    handler.ackSettings();
                }
                IOException obj8 = new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                throw obj8;
            }
            if (i2 % 6 != 0) {
            } else {
                Settings obj10 = new Settings();
                final int i8 = 0;
                d obj9 = g.k(g.l(i8, i2), 6);
                i6 = obj9.d();
                final int i10 = obj9.g();
                obj9 = obj9.h();
                if (obj9 >= 0) {
                    if (i6 <= i10) {
                        i = Util.and(this.source.readShort(), 65535);
                        int = this.source.readInt();
                        i7 = 4;
                        while (i != 2) {
                            i = i7;
                            obj10.set(i, int);
                            i6 += obj9;
                            i = Util.and(this.source.readShort(), 65535);
                            int = this.source.readInt();
                            i7 = 4;
                            i = 7;
                        }
                        obj9 = new StringBuilder();
                        obj9.append("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ");
                        obj9.append(int);
                        obj8 = new IOException(obj9.toString());
                        throw obj8;
                    }
                } else {
                    if (i6 >= i10) {
                    }
                }
                handler.settings(i8, obj10);
            }
            obj10 = new StringBuilder();
            obj10.append("TYPE_SETTINGS length % 6 != 0: ");
            obj10.append(i2);
            obj8 = new IOException(obj10.toString());
            throw obj8;
        }
        obj8 = new IOException("TYPE_SETTINGS streamId != 0");
        throw obj8;
    }

    private final void readWindowUpdate(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler, int i2, int i3, int i4) {
        int obj5 = 4;
        if (i2 != obj5) {
        } else {
            long obj4 = Util.and(this.source.readInt(), Integer.MAX_VALUE);
            if (Long.compare(obj4, i5) == 0) {
            } else {
                handler.windowUpdate(i4, obj4);
            }
            IOException obj3 = new IOException("windowSizeIncrement was 0");
            throw obj3;
        }
        obj5 = new StringBuilder();
        obj5.append("TYPE_WINDOW_UPDATE length !=4: ");
        obj5.append(i2);
        obj3 = new IOException(obj5.toString());
        throw obj3;
    }

    @Override // java.io.Closeable
    public void close() {
        this.source.close();
    }

    @Override // java.io.Closeable
    public final boolean nextFrame(boolean z, okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler2) {
        int medium;
        boolean frameLog;
        int i4;
        int i2;
        int i3;
        int i5;
        int i;
        int obj12;
        n.f(handler2, "handler");
        this.source.V1(9);
        medium = Util.readMedium(this.source);
        if (medium > 16384) {
        } else {
            int i8 = 255;
            final int i9 = Util.and(this.source.readByte(), i8);
            final int i10 = Util.and(this.source.readByte(), i8);
            final int i11 = int & i4;
            final Logger logger = Http2Reader.logger;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.INSTANCE.frameLog(true, i11, medium, i9, i10));
            }
            if (z != 0) {
                if (i9 != 4) {
                } else {
                    try {
                        StringBuilder obj13 = new StringBuilder();
                        obj13.append("Expected a SETTINGS frame but was ");
                        obj13.append(Http2.INSTANCE.formattedType$okhttp(i9));
                        obj12 = new IOException(obj13.toString());
                        throw obj12;
                        this.source.skip((long)medium);
                        readWindowUpdate(handler2, medium, i10, i11);
                        readGoAway(handler2, medium, i10, i11);
                        readPing(handler2, medium, i10, i11);
                    }
                    readData(handler2, medium, i10, i11);
                    return 1;
                }
            }
        }
        obj13 = new StringBuilder();
        obj13.append("FRAME_SIZE_ERROR: ");
        obj13.append(medium);
        obj12 = new IOException(obj13.toString());
        throw obj12;
    }

    @Override // java.io.Closeable
    public final void readConnectionPreface(okhttp3.internal.http2.Http2Reader.Handler http2Reader$Handler) {
        boolean client;
        Logger logger;
        boolean loggable;
        Object[] arr;
        boolean obj6;
        n.f(handler, "handler");
        int i = 1;
        if (this.client) {
            if (!nextFrame(i, handler)) {
            } else {
            }
            obj6 = new IOException("Required SETTINGS preface not received");
            throw obj6;
        }
        i cONNECTION_PREFACE = Http2.CONNECTION_PREFACE;
        obj6 = this.source.B((long)i2);
        logger = Http2Reader.logger;
        if (logger.isLoggable(Level.FINE)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<< CONNECTION ");
            stringBuilder2.append(obj6.p());
            logger.fine(Util.format(stringBuilder2.toString(), new Object[0]));
        }
        if (z ^= i != 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a connection header but was ");
        stringBuilder.append(obj6.E());
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }
}
