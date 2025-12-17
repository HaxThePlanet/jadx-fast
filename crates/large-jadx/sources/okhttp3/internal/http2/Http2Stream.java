package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import l.b0;
import l.d;
import l.d0;
import l.e0;
import l.f;
import l.h;
import okhttp3.Headers;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\t\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\r\u0018\u0000 u2\u00020\u0001:\u0004uvwxB3\u0008\u0000\u0012\u0006\u0010A\u001a\u00020(\u0012\u0006\u0010c\u001a\u00020b\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010-\u001a\u00020\u0006\u0012\u0008\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0004\u0008s\u0010tJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\n\u0010\u000bJ\r\u0010\u000c\u001a\u00020\t¢\u0006\u0004\u0008\u000c\u0010\u000bJ+\u0010\u0013\u001a\u00020\u00122\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0004\u0008\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\u0008\u001a\u0010\u0019J\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\u0008\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\u0008\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\u0008\"\u0010#J\u0015\u0010$\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008$\u0010%J\u001d\u0010*\u001a\u00020\u00122\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\u0008*\u0010+J\u001d\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0006¢\u0006\u0004\u0008.\u0010/J\u0015\u00100\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u00080\u0010%J\u000f\u00103\u001a\u00020\u0012H\u0000¢\u0006\u0004\u00081\u00102J\u0015\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u000204¢\u0006\u0004\u00086\u00107J\u000f\u00109\u001a\u00020\u0012H\u0000¢\u0006\u0004\u00088\u00102J\u000f\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0004\u0008:\u00102R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0005\u0010<\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R\u0019\u0010A\u001a\u00020(8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008A\u0010B\u001a\u0004\u0008C\u0010DR*\u0010F\u001a\u0002042\u0006\u0010E\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\u0008F\u0010G\u001a\u0004\u0008H\u0010I\"\u0004\u0008J\u00107R*\u0010K\u001a\u0002042\u0006\u0010E\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\u0008K\u0010G\u001a\u0004\u0008L\u0010I\"\u0004\u0008M\u00107R \u0010\u0018\u001a\u00060NR\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0018\u0010O\u001a\u0004\u0008P\u0010QR\u001c\u0010S\u001a\u0008\u0012\u0004\u0012\u00020\t0R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008S\u0010TR\u0013\u0010U\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\u0008U\u0010VR*\u0010W\u001a\u0002042\u0006\u0010E\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\u0008W\u0010G\u001a\u0004\u0008X\u0010I\"\u0004\u0008Y\u00107R \u0010[\u001a\u00060ZR\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008[\u0010\\\u001a\u0004\u0008]\u0010^R*\u0010_\u001a\u0002042\u0006\u0010E\u001a\u0002048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\u0008_\u0010G\u001a\u0004\u0008`\u0010I\"\u0004\u0008a\u00107R\u0019\u0010c\u001a\u00020b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008c\u0010d\u001a\u0004\u0008e\u0010fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0003\u0010g\u001a\u0004\u0008h\u0010i\"\u0004\u0008j\u0010%R\u0013\u0010k\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\u0008k\u0010VR \u0010'\u001a\u00060lR\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008'\u0010m\u001a\u0004\u0008n\u0010oR\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008p\u0010qR \u0010\u001a\u001a\u00060NR\u00020\u00008\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u001a\u0010O\u001a\u0004\u0008r\u0010Q¨\u0006y", d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Ljava/io/IOException;", "errorException", "", "closeInternal", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)Z", "Lokhttp3/Headers;", "takeHeaders", "()Lokhttp3/Headers;", "trailers", "", "Lokhttp3/internal/http2/Header;", "responseHeaders", "outFinished", "flushHeaders", "Lkotlin/w;", "writeHeaders", "(Ljava/util/List;ZZ)V", "enqueueTrailers", "(Lokhttp3/Headers;)V", "Ll/e0;", "readTimeout", "()Ll/e0;", "writeTimeout", "Ll/d0;", "getSource", "()Ll/d0;", "Ll/b0;", "getSink", "()Ll/b0;", "rstStatusCode", "close", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "closeLater", "(Lokhttp3/internal/http2/ErrorCode;)V", "Ll/h;", "source", "", "length", "receiveData", "(Ll/h;I)V", "headers", "inFinished", "receiveHeaders", "(Lokhttp3/Headers;Z)V", "receiveRstStream", "cancelStreamIfNecessary$okhttp", "()V", "cancelStreamIfNecessary", "", "delta", "addBytesToWriteWindow", "(J)V", "checkOutNotClosed$okhttp", "checkOutNotClosed", "waitForIo$okhttp", "waitForIo", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "id", "I", "getId", "()I", "<set-?>", "readBytesAcknowledged", "J", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Ljava/util/ArrayDeque;", "headersQueue", "Ljava/util/ArrayDeque;", "isOpen", "()Z", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Http2Connection;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "isLocallyInitiated", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "hasResponseHeaders", "Z", "getWriteTimeout$okhttp", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Stream {

    public static final okhttp3.internal.http2.Http2Stream.Companion Companion = null;
    public static final long EMIT_BUFFER_SIZE = 16384L;
    private final okhttp3.internal.http2.Http2Connection connection;
    private okhttp3.internal.http2.ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final okhttp3.internal.http2.Http2Stream.StreamTimeout readTimeout;
    private final okhttp3.internal.http2.Http2Stream.FramingSink sink;
    private final okhttp3.internal.http2.Http2Stream.FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final okhttp3.internal.http2.Http2Stream.StreamTimeout writeTimeout;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "", "EMIT_BUFFER_SIZE", "J", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\u0008\u0008\u0002\u0010!\u001a\u00020\u0002¢\u0006\u0004\u0008$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0012\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0006R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008!\u0010\u0014\u001a\u0004\u0008\"\u0010\u0016\"\u0004\u0008#\u0010\u0006¨\u0006&", d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Ll/b0;", "", "outFinishedOnLastFrame", "Lkotlin/w;", "emitFrame", "(Z)V", "Ll/f;", "source", "", "byteCount", "write", "(Ll/f;J)V", "flush", "()V", "Ll/e0;", "timeout", "()Ll/e0;", "close", "closed", "Z", "getClosed", "()Z", "setClosed", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "sendBuffer", "Ll/f;", "finished", "getFinished", "setFinished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class FramingSink implements b0 {

        private boolean closed;
        private boolean finished;
        private final f sendBuffer;
        final okhttp3.internal.http2.Http2Stream this$0;
        private Headers trailers;
        public FramingSink(okhttp3.internal.http2.Http2Stream http2Stream, boolean z2) {
            this.this$0 = http2Stream;
            super();
            this.finished = z2;
            f obj1 = new f();
            this.sendBuffer = obj1;
        }

        public FramingSink(okhttp3.internal.http2.Http2Stream http2Stream, boolean z2, int i3, g g4) {
            int obj2;
            obj2 = i3 &= 1 != 0 ? 0 : obj2;
            super(http2Stream, obj2);
        }

        private final void emitFrame(boolean z) {
            okhttp3.internal.http2.Http2Stream.StreamTimeout writeTimeout$okhttp;
            int errorCode$okhttp;
            long size;
            long writeBytesMaximum;
            int obj12;
            final okhttp3.internal.http2.Http2Stream this$0 = this.this$0;
            this.this$0.getWriteTimeout$okhttp().enter();
            synchronized (this$0) {
                while (Long.compare(writeBytesTotal, writeBytesMaximum) >= 0) {
                    if (!this.finished) {
                    }
                    if (!this.closed) {
                    }
                    if (this.this$0.getErrorCode$okhttp() == null) {
                    }
                    this.this$0.waitForIo$okhttp();
                }
                this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                this.this$0.checkOutNotClosed$okhttp();
                long size2 = this.sendBuffer.size();
                final long l = Math.min(writeBytesMaximum2 -= writeBytesTotal3, obj2);
                size = this.this$0;
                size.setWriteBytesTotal$okhttp(writeBytesTotal2 += l);
                if (z != null && Long.compare(l, size) == 0 && this.this$0.getErrorCode$okhttp() == null) {
                    if (Long.compare(l, size) == 0) {
                        obj12 = this.this$0.getErrorCode$okhttp() == null ? 1 : 0;
                    } else {
                    }
                } else {
                }
                obj12 = w.a;
                this.this$0.getWriteTimeout$okhttp().enter();
                this.this$0.getConnection().writeData(this.this$0.getId(), obj12, this.sendBuffer, l);
                this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // l.b0
        public void close() {
            boolean connection;
            boolean assertionsEnabled;
            int i;
            int i4;
            w headerList;
            int i5;
            int i2;
            int i6;
            int i3;
            okhttp3.internal.http2.Http2Stream this$0 = this.this$0;
            if (Util.assertionsEnabled) {
                if (Thread.holdsLock(this$0)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                Thread currentThread = Thread.currentThread();
                n.e(currentThread, "Thread.currentThread()");
                stringBuilder.append(currentThread.getName());
                stringBuilder.append(" MUST NOT hold lock on ");
                stringBuilder.append(this$0);
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
            okhttp3.internal.http2.Http2Stream this$02 = this.this$0;
            synchronized (this$02) {
            }
            i2 = 0;
            connection = Long.compare(size2, i2) > 0 ? i7 : i4;
            headerList = this.trailers != null ? i7 : i4;
            if (headerList != null) {
            } else {
                if (connection != null) {
                } else {
                    if (i != 0) {
                        this.this$0.getConnection().writeData(this.this$0.getId(), true, 0, 0);
                    }
                }
            }
            okhttp3.internal.http2.Http2Stream this$04 = this.this$0;
            this.closed = i7;
            w wVar = w.a;
            this.this$0.getConnection().flush();
            this.this$0.cancelStreamIfNecessary$okhttp();
            return;
            synchronized (this$04) {
                this$04 = this.this$0;
                this.closed = i7;
                wVar = w.a;
                this.this$0.getConnection().flush();
                this.this$0.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // l.b0
        public void flush() {
            okhttp3.internal.http2.Http2Stream connection;
            boolean assertionsEnabled;
            int i;
            okhttp3.internal.http2.Http2Stream this$0 = this.this$0;
            if (Util.assertionsEnabled) {
                if (Thread.holdsLock(this$0)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                Thread currentThread = Thread.currentThread();
                n.e(currentThread, "Thread.currentThread()");
                stringBuilder.append(currentThread.getName());
                stringBuilder.append(" MUST NOT hold lock on ");
                stringBuilder.append(this$0);
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
            connection = this.this$0;
            this.this$0.checkOutNotClosed$okhttp();
            w wVar = w.a;
            synchronized (connection) {
                connection = this.this$0;
                this.this$0.checkOutNotClosed$okhttp();
                wVar = w.a;
            }
            while (Long.compare(size, i) > 0) {
                emitFrame(false);
                this.this$0.getConnection().flush();
            }
        }

        @Override // l.b0
        public final boolean getClosed() {
            return this.closed;
        }

        @Override // l.b0
        public final boolean getFinished() {
            return this.finished;
        }

        @Override // l.b0
        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // l.b0
        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // l.b0
        public final void setFinished(boolean z) {
            this.finished = z;
        }

        @Override // l.b0
        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // l.b0
        public e0 timeout() {
            return this.this$0.getWriteTimeout$okhttp();
        }

        @Override // l.b0
        public void write(f f, long l2) {
            f sendBuffer;
            boolean assertionsEnabled;
            Object obj3;
            n.f(f, "source");
            okhttp3.internal.http2.Http2Stream this$0 = this.this$0;
            if (Util.assertionsEnabled) {
                if (Thread.holdsLock(this$0)) {
                } else {
                }
                StringBuilder obj4 = new StringBuilder();
                obj4.append("Thread ");
                Thread obj5 = Thread.currentThread();
                n.e(obj5, "Thread.currentThread()");
                obj4.append(obj5.getName());
                obj4.append(" MUST NOT hold lock on ");
                obj4.append(this$0);
                obj3 = new AssertionError(obj4.toString());
                throw obj3;
            }
            this.sendBuffer.write(f, l2);
            while (Long.compare(obj3, sendBuffer) >= 0) {
                emitFrame(null);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0010\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0008\u0000\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020 ¢\u0006\u0004\u0008.\u0010/J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008!\u0010\"\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R\u0019\u0010'\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008'\u0010\u001d\u001a\u0004\u0008(\u0010\u001fR\"\u0010)\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008)\u0010\"\u001a\u0004\u0008*\u0010$\"\u0004\u0008+\u0010&R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008,\u0010-¨\u00060", d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Ll/d0;", "", "read", "Lkotlin/w;", "updateConnectionFlowControl", "(J)V", "Ll/f;", "sink", "byteCount", "(Ll/f;J)J", "Ll/h;", "source", "receive$okhttp", "(Ll/h;J)V", "receive", "Ll/e0;", "timeout", "()Ll/e0;", "close", "()V", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "receiveBuffer", "Ll/f;", "getReceiveBuffer", "()Ll/f;", "", "closed", "Z", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "readBuffer", "getReadBuffer", "finished", "getFinished$okhttp", "setFinished$okhttp", "maxByteCount", "J", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class FramingSource implements d0 {

        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final f readBuffer;
        private final f receiveBuffer;
        final okhttp3.internal.http2.Http2Stream this$0;
        private Headers trailers;
        public FramingSource(okhttp3.internal.http2.Http2Stream http2Stream, long l2, boolean z3) {
            this.this$0 = http2Stream;
            super();
            this.maxByteCount = l2;
            this.finished = obj4;
            f obj1 = new f();
            this.receiveBuffer = obj1;
            obj1 = new f();
            this.readBuffer = obj1;
        }

        private final void updateConnectionFlowControl(long l) {
            boolean assertionsEnabled;
            okhttp3.internal.http2.Http2Stream this$0 = this.this$0;
            if (Util.assertionsEnabled) {
                if (Thread.holdsLock(this$0)) {
                } else {
                }
                StringBuilder obj5 = new StringBuilder();
                obj5.append("Thread ");
                Thread currentThread = Thread.currentThread();
                n.e(currentThread, "Thread.currentThread()");
                obj5.append(currentThread.getName());
                obj5.append(" MUST NOT hold lock on ");
                obj5.append(this$0);
                AssertionError obj4 = new AssertionError(obj5.toString());
                throw obj4;
            }
            this.this$0.getConnection().updateConnectionFlowControl$okhttp(l);
        }

        @Override // l.d0
        public void close() {
            okhttp3.internal.http2.Http2Stream this$0 = this.this$0;
            this.closed = true;
            long size = this.readBuffer.size();
            this.readBuffer.a();
            okhttp3.internal.http2.Http2Stream this$03 = this.this$0;
            synchronized (this$0) {
                this$03.notifyAll();
                w wVar = w.a;
                if (Long.compare(size, i2) > 0) {
                }
                this.this$0.cancelStreamIfNecessary$okhttp();
            }
            updateConnectionFlowControl(size);
        }

        @Override // l.d0
        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        @Override // l.d0
        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        @Override // l.d0
        public final f getReadBuffer() {
            return this.readBuffer;
        }

        @Override // l.d0
        public final f getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @Override // l.d0
        public final Headers getTrailers() {
            return this.trailers;
        }

        @Override // l.d0
        public long read(f f, long l2) {
            int i3;
            int finished;
            int i4;
            w wVar;
            int errorException$okhttp;
            int readBytesTotal;
            int i2;
            okhttp3.internal.http2.Http2Stream this$0;
            okhttp3.internal.http2.Http2Stream cmp;
            okhttp3.internal.http2.ErrorCode errorCode$okhttp;
            int i;
            long read;
            long readBytesAcknowledged;
            final Object obj2 = this;
            Object obj = f;
            int i5 = l2;
            n.f(obj, "sink");
            errorException$okhttp = Long.compare(i5, i3) >= 0 ? 1 : 0;
            if (errorException$okhttp == 0) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(i5);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException;
        }

        @Override // l.d0
        public final void receive$okhttp(h h, long l2) {
            okhttp3.internal.http2.Http2Stream cmp;
            boolean assertionsEnabled;
            okhttp3.internal.http2.Http2Stream this$0;
            long size;
            Object readBuffer;
            int receiveBuffer2;
            int i3;
            f receiveBuffer;
            int i2;
            int i;
            int obj11;
            n.f(h, "source");
            cmp = this.this$0;
            if (Util.assertionsEnabled) {
                if (Thread.holdsLock(cmp)) {
                } else {
                }
                obj11 = new StringBuilder();
                obj11.append("Thread ");
                Thread obj12 = Thread.currentThread();
                n.e(obj12, "Thread.currentThread()");
                obj11.append(obj12.getName());
                obj11.append(" MUST NOT hold lock on ");
                obj11.append(cmp);
                AssertionError obj10 = new AssertionError(obj11.toString());
                throw obj10;
            }
            int i4 = 0;
            while (Long.compare(obj11, i4) > 0) {
                okhttp3.internal.http2.Http2Stream this$02 = this.this$0;
                i2 = 0;
                if (Long.compare(i5, maxByteCount) > 0) {
                } else {
                }
                i3 = i2;
                w wVar = w.a;
                long read = h.read(this.receiveBuffer, obj11);
                obj11 -= read;
                this$0 = this.this$0;
                if (Long.compare(size2, i4) == 0) {
                } else {
                }
                receiveBuffer = i2;
                this.readBuffer.W0(this.receiveBuffer);
                size = i4;
                if (Long.compare(size, i4) > 0) {
                }
                i4 = 0;
                updateConnectionFlowControl(size);
                readBuffer = this.this$0;
                readBuffer.notifyAll();
                size = this.receiveBuffer.size();
                this.receiveBuffer.a();
                i3 = receiveBuffer;
            }
        }

        @Override // l.d0
        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        @Override // l.d0
        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        @Override // l.d0
        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // l.d0
        public e0 timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\u0008\u0007\u0010\u0008J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\u0008\t\u0010\u0004¨\u0006\u000c", d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Ll/d;", "Lkotlin/w;", "timedOut", "()V", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "exitAndThrowIfTimedOut", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class StreamTimeout extends d {

        final okhttp3.internal.http2.Http2Stream this$0;
        public StreamTimeout(okhttp3.internal.http2.Http2Stream http2Stream) {
            this.this$0 = http2Stream;
            super();
        }

        @Override // l.d
        public final void exitAndThrowIfTimedOut() {
            if (exit()) {
            } else {
            }
            throw newTimeoutException(0);
        }

        @Override // l.d
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // l.d
        protected void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }
    }
    static {
        Http2Stream.Companion companion = new Http2Stream.Companion(0);
        Http2Stream.Companion = companion;
    }

    public Http2Stream(int i, okhttp3.internal.http2.Http2Connection http2Connection2, boolean z3, boolean z4, Headers headers5) {
        ArrayDeque obj4;
        int obj5;
        n.f(http2Connection2, "connection");
        super();
        this.id = i;
        this.connection = http2Connection2;
        this.writeBytesMaximum = (long)obj4;
        obj4 = new ArrayDeque();
        this.headersQueue = obj4;
        Http2Stream.FramingSource framingSource = new Http2Stream.FramingSource(this, (long)obj5, obj2, z4);
        this.source = framingSource;
        obj5 = new Http2Stream.FramingSink(this, z3);
        this.sink = obj5;
        obj5 = new Http2Stream.StreamTimeout(this);
        this.readTimeout = obj5;
        obj5 = new Http2Stream.StreamTimeout(this);
        this.writeTimeout = obj5;
        if (headers5 != null) {
            if (obj5 ^= 1 == 0) {
            } else {
                obj4.add(headers5);
            }
            obj4 = new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            throw obj4;
        }
        if (!isLocallyInitiated()) {
        } else {
        }
        obj4 = new IllegalStateException("remotely-initiated streams should have headers".toString());
        throw obj4;
    }

    private final boolean closeInternal(okhttp3.internal.http2.ErrorCode errorCode, IOException iOException2) {
        boolean assertionsEnabled;
        boolean finished$okhttp;
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            obj4.append(currentThread.getName());
            obj4.append(" MUST NOT hold lock on ");
            obj4.append(this);
            AssertionError obj3 = new AssertionError(obj4.toString());
            throw obj3;
        }
        int i = 0;
        synchronized (this) {
            return i;
        }
    }

    public final void addBytesToWriteWindow(long l) {
        this.writeBytesMaximum = writeBytesMaximum += l;
        if (Long.compare(l, i2) > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() {
        boolean assertionsEnabled;
        boolean finished$okhttp;
        int cANCEL;
        int open;
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        synchronized (this) {
            if (this.source.getClosed$okhttp()) {
                if (!this.sink.getFinished()) {
                    cANCEL = this.sink.getClosed() ? 1 : 0;
                } else {
                }
            } else {
            }
            w wVar = w.a;
            if (cANCEL != 0) {
            } else {
                if (!isOpen()) {
                    this.connection.removeStream$okhttp(this.id);
                }
            }
        }
        close(ErrorCode.CANCEL, 0);
    }

    public final void checkOutNotClosed$okhttp() {
        IOException streamResetException;
        okhttp3.internal.http2.ErrorCode errorCode;
        if (this.sink.getClosed()) {
        } else {
            if (this.sink.getFinished()) {
            } else {
                if (this.errorCode != null) {
                    if (this.errorException != null) {
                    } else {
                        errorCode = this.errorCode;
                        n.d(errorCode);
                        streamResetException = new StreamResetException(errorCode);
                    }
                    throw streamResetException;
                }
            }
            IOException iOException2 = new IOException("stream finished");
            throw iOException2;
        }
        IOException iOException = new IOException("stream closed");
        throw iOException;
    }

    public final void close(okhttp3.internal.http2.ErrorCode errorCode, IOException iOException2) {
        n.f(errorCode, "rstStatusCode");
        if (!closeInternal(errorCode, iOException2)) {
        }
        this.connection.writeSynReset$okhttp(this.id, errorCode);
    }

    public final void closeLater(okhttp3.internal.http2.ErrorCode errorCode) {
        n.f(errorCode, "errorCode");
        if (!closeInternal(errorCode, 0)) {
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode);
    }

    public final void enqueueTrailers(Headers headers) {
        int i;
        n.f(headers, "trailers");
        synchronized (this) {
            if (headers.size() != 0) {
            } else {
                i = 0;
            }
            if (i == 0) {
            } else {
                this.sink.setTrailers(headers);
                w obj3 = w.a;
            }
            try {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("trailers.size() == 0".toString());
                throw illegalArgumentException;
                IllegalStateException illegalStateException = new IllegalStateException("already finished".toString());
                throw illegalStateException;
                throw headers;
            }
        }
    }

    public final okhttp3.internal.http2.Http2Connection getConnection() {
        return this.connection;
    }

    public final okhttp3.internal.http2.ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
        synchronized (this) {
            return this.errorCode;
        }
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final okhttp3.internal.http2.Http2Stream.StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final b0 getSink() {
        int i;
        boolean hasResponseHeaders;
        synchronized (this) {
            try {
                if (isLocallyInitiated()) {
                } else {
                }
                i = 0;
                i = 1;
                if (i == 0) {
                } else {
                }
                w wVar = w.a;
                return this.sink;
                IllegalStateException illegalStateException = new IllegalStateException("reply before requesting the sink".toString());
                throw illegalStateException;
                throw th;
            }
        }
    }

    public final okhttp3.internal.http2.Http2Stream.FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final d0 getSource() {
        return this.source;
    }

    public final okhttp3.internal.http2.Http2Stream.FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final okhttp3.internal.http2.Http2Stream.StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        int i2;
        int i;
        i = 1;
        final int i5 = 0;
        i2 = i3 &= i == i ? i : i5;
        if (this.connection.getClient$okhttp() == i2) {
        } else {
            i = i5;
        }
        return i;
    }

    public final boolean isOpen() {
        boolean hasResponseHeaders;
        final int i2 = 0;
        synchronized (this) {
            try {
                return i2;
            }
            if (this.source.getClosed$okhttp()) {
                if (!this.sink.getFinished()) {
                    if (this.sink.getClosed() && this.hasResponseHeaders) {
                        if (this.hasResponseHeaders) {
                            return i2;
                        }
                    }
                } else {
                }
            }
            try {
                return 1;
                throw th;
            }
        }
    }

    public final e0 readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(h h, int i2) {
        boolean assertionsEnabled;
        n.f(h, "source");
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder obj5 = new StringBuilder();
            obj5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            obj5.append(currentThread.getName());
            obj5.append(" MUST NOT hold lock on ");
            obj5.append(this);
            AssertionError obj4 = new AssertionError(obj5.toString());
            throw obj4;
        }
        this.source.receive$okhttp(h, (long)i2);
    }

    public final void receiveHeaders(Headers headers, boolean z2) {
        boolean assertionsEnabled;
        Object headersQueue;
        Object obj3;
        w obj4;
        n.f(headers, "headers");
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            obj4 = new StringBuilder();
            obj4.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            obj4.append(currentThread.getName());
            obj4.append(" MUST NOT hold lock on ");
            obj4.append(this);
            obj3 = new AssertionError(obj4.toString());
            throw obj3;
        }
        int i = 1;
        synchronized (this) {
            if (!z2) {
                this.hasResponseHeaders = i;
                this.headersQueue.add(headers);
            } else {
                this.source.setTrailers(headers);
            }
            if (z2) {
                this.source.setFinished$okhttp(i);
            }
            notifyAll();
            obj4 = w.a;
            if (!isOpen()) {
            }
        }
        this.connection.removeStream$okhttp(this.id);
    }

    public final void receiveRstStream(okhttp3.internal.http2.ErrorCode errorCode) {
        n.f(errorCode, "errorCode");
        synchronized (this) {
            try {
                this.errorCode = errorCode;
                notifyAll();
                throw errorCode;
            }
        }
    }

    public final void setErrorCode$okhttp(okhttp3.internal.http2.ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long l) {
        this.readBytesAcknowledged = l;
    }

    public final void setReadBytesTotal$okhttp(long l) {
        this.readBytesTotal = l;
    }

    public final void setWriteBytesMaximum$okhttp(long l) {
        this.writeBytesMaximum = l;
    }

    public final void setWriteBytesTotal$okhttp(long l) {
        this.writeBytesTotal = l;
    }

    public final Headers takeHeaders() {
        okhttp3.internal.http2.Http2Stream.StreamTimeout readTimeout2;
        IOException streamResetException;
        Object readTimeout;
        this.readTimeout.enter();
        synchronized (this) {
            try {
                while (this.headersQueue.isEmpty()) {
                    if (this.errorCode == null) {
                    }
                    waitForIo$okhttp();
                }
                if (this.errorCode == null) {
                }
                waitForIo$okhttp();
                this.readTimeout.exitAndThrowIfTimedOut();
                if (empty ^= 1 != 0) {
                }
                Object first = this.headersQueue.removeFirst();
                n.e(first, "headersQueue.removeFirst()");
                return (Headers)first;
            } catch (Throwable th) {
            }
            try {
                if (this.errorException != null) {
                } else {
                }
                readTimeout = this.errorCode;
                n.d(readTimeout);
                streamResetException = new StreamResetException(readTimeout);
                throw streamResetException;
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
                throw th;
            }
        }
    }

    public final Headers trailers() {
        IOException streamResetException;
        boolean finished$okhttp;
        int i;
        Headers eMPTY_HEADERS;
        okhttp3.internal.http2.ErrorCode errorCode;
        synchronized (this) {
            try {
                if (this.errorException != null) {
                } else {
                }
                errorCode = this.errorCode;
                n.d(errorCode);
                streamResetException = new StreamResetException(errorCode);
                throw streamResetException;
                if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().b0() && this.source.getReadBuffer().b0()) {
                } else {
                }
                if (this.source.getReceiveBuffer().b0()) {
                } else {
                }
                if (this.source.getReadBuffer().b0()) {
                } else {
                }
                i = 1;
                i = 0;
                if (i == 0) {
                } else {
                }
                if (this.source.getTrailers() != null) {
                } else {
                }
                eMPTY_HEADERS = Util.EMPTY_HEADERS;
                return eMPTY_HEADERS;
                IllegalStateException illegalStateException = new IllegalStateException("too early; can't read the trailers yet".toString());
                throw illegalStateException;
                throw th;
            }
        }
    }

    public final void waitForIo$okhttp() {
        try {
            wait();
            Thread interruptedIOException = Thread.currentThread();
            interruptedIOException.interrupt();
            interruptedIOException = new InterruptedIOException();
            throw interruptedIOException;
        }
    }

    public final void writeHeaders(List<okhttp3.internal.http2.Header> list, boolean z2, boolean z3) {
        boolean assertionsEnabled;
        int i;
        okhttp3.internal.http2.Http2Stream.FramingSink sink;
        w cmp;
        long writeBytesMaximum;
        Object obj6;
        int obj8;
        n.f(list, "responseHeaders");
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder obj7 = new StringBuilder();
            obj7.append("Thread ");
            obj8 = Thread.currentThread();
            n.e(obj8, "Thread.currentThread()");
            obj7.append(obj8.getName());
            obj7.append(" MUST NOT hold lock on ");
            obj7.append(this);
            obj6 = new AssertionError(obj7.toString());
            throw obj6;
        }
        i = 1;
        this.hasResponseHeaders = i;
        synchronized (this) {
            this.sink.setFinished(i);
            cmp = w.a;
            if (z3 == 0) {
            }
            this.connection.writeHeaders$okhttp(this.id, z2, list);
            if (obj8 != null) {
                this.connection.flush();
            }
        }
        obj8 = this.connection;
        synchronized (obj8) {
            obj8 = i;
        }
    }

    public final e0 writeTimeout() {
        return this.writeTimeout;
    }
}
