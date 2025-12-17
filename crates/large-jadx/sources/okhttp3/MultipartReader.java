package okhttp3;

import java.io.Closeable;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import l.d0;
import l.e0;
import l.e0.b;
import l.f;
import l.h;
import l.i;
import l.i.a;
import l.q;
import l.t;
import l.t.a;
import okhttp3.internal.http1.HeadersReader;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\u0008!\u0010\"B\u0011\u0008\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\u0008!\u0010%J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\u000c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0008\u0018\u00010\u0012R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0016\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u000c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008 \u0010\u001c¨\u0006)", d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "", "maxResult", "currentPartBytesRemaining", "(J)J", "Lokhttp3/MultipartReader$Part;", "nextPart", "()Lokhttp3/MultipartReader$Part;", "Lkotlin/w;", "close", "()V", "", "closed", "Z", "", "partCount", "I", "Lokhttp3/MultipartReader$PartSource;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "", "boundary", "Ljava/lang/String;", "()Ljava/lang/String;", "noMoreParts", "Ll/i;", "crlfDashDashBoundary", "Ll/i;", "Ll/h;", "source", "Ll/h;", "dashDashBoundary", "<init>", "(Ll/h;Ljava/lang/String;)V", "Lokhttp3/ResponseBody;", "response", "(Lokhttp3/ResponseBody;)V", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MultipartReader implements Closeable {

    public static final okhttp3.MultipartReader.Companion Companion;
    private static final t afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final i crlfDashDashBoundary;
    private okhttp3.MultipartReader.PartSource currentPart;
    private final i dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final h source;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/MultipartReader$Companion;", "", "Ll/t;", "afterBoundaryOptions", "Ll/t;", "getAfterBoundaryOptions", "()Ll/t;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final t getAfterBoundaryOptions() {
            return MultipartReader.access$getAfterBoundaryOptions$cp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0006\u0010\u0008R\u0019\u0010\n\u001a\u00020\t8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\n\u0010\u000c¨\u0006\u000f", d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "Lkotlin/w;", "close", "()V", "Ll/h;", "body", "Ll/h;", "()Ll/h;", "Lokhttp3/Headers;", "headers", "Lokhttp3/Headers;", "()Lokhttp3/Headers;", "<init>", "(Lokhttp3/Headers;Ll/h;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Part implements Closeable {

        private final h body;
        private final okhttp3.Headers headers;
        public Part(okhttp3.Headers headers, h h2) {
            n.f(headers, "headers");
            n.f(h2, "body");
            super();
            this.headers = headers;
            this.body = h2;
        }

        @Override // java.io.Closeable
        public final h body() {
            return this.body;
        }

        @Override // java.io.Closeable
        public void close() {
            this.body.close();
        }

        @Override // java.io.Closeable
        public final okhttp3.Headers headers() {
            return this.headers;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u000e¨\u0006\u0011", d2 = {"Lokhttp3/MultipartReader$PartSource;", "Ll/d0;", "Lkotlin/w;", "close", "()V", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "Ll/e0;", "timeout", "()Ll/e0;", "Ll/e0;", "<init>", "(Lokhttp3/MultipartReader;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class PartSource implements d0 {

        final okhttp3.MultipartReader this$0;
        private final e0 timeout;
        public PartSource(okhttp3.MultipartReader multipartReader) {
            this.this$0 = multipartReader;
            super();
            e0 obj1 = new e0();
            this.timeout = obj1;
        }

        @Override // l.d0
        public void close() {
            boolean this$0;
            int i;
            if (n.b(MultipartReader.access$getCurrentPart$p(this.this$0), this)) {
                MultipartReader.access$setCurrentPart$p(this.this$0, 0);
            }
        }

        @Override // l.d0
        public long read(f f, long l2) {
            TimeUnit deadline;
            int i2;
            int cmp;
            boolean deadlineNanoTime;
            int cmp2;
            int i;
            long deadlineNanoTime2;
            int read2;
            int read;
            final Object obj2 = this;
            Object obj = f;
            int i3 = l2;
            n.f(obj, "sink");
            i = Long.compare(i3, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                if (!n.b(MultipartReader.access$getCurrentPart$p(obj2.this$0), obj2)) {
                } else {
                    e0 timeout = MultipartReader.access$getSource$p(obj2.this$0).timeout();
                    final e0 timeout2 = obj2.timeout;
                    final long timeoutNanos = timeout.timeoutNanos();
                    final long timeoutNanos2 = timeout2.timeoutNanos();
                    final TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
                    timeout.timeout(e0.Companion.a(timeoutNanos2, obj12), timeoutNanos2);
                    if (timeout.hasDeadline() && timeout2.hasDeadline()) {
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), obj14));
                        }
                        long l = MultipartReader.access$currentPartBytesRemaining(obj2.this$0, i3);
                        if (Long.compare(l, i4) == 0) {
                            read2 = -1;
                        } else {
                            read2 = MultipartReader.access$getSource$p(obj2.this$0).read(obj, l);
                        }
                        timeout.timeout(timeoutNanos, obj9);
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(timeout.deadlineNanoTime());
                        }
                        return read2;
                    }
                    if (timeout2.hasDeadline()) {
                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    long l3 = MultipartReader.access$currentPartBytesRemaining(obj2.this$0, i3);
                    if (Long.compare(l3, i5) == 0) {
                        read = -1;
                    } else {
                        read = MultipartReader.access$getSource$p(obj2.this$0).read(obj, l3);
                    }
                    timeout.timeout(timeoutNanos, obj9);
                    if (timeout2.hasDeadline()) {
                        timeout.clearDeadline();
                    }
                    return read;
                }
                IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
                throw illegalStateException;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(i3);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException;
        }

        @Override // l.d0
        public e0 timeout() {
            return this.timeout;
        }
    }
    static {
        MultipartReader.Companion companion = new MultipartReader.Companion(0);
        MultipartReader.Companion = companion;
        i[] arr = new i[4];
        i.a aVar2 = i.v;
        MultipartReader.afterBoundaryOptions = t.v.d(aVar2.d("\r\n"), aVar2.d("--"), aVar2.d(" "), aVar2.d("\t"));
    }

    public MultipartReader(h h, String string2) {
        n.f(h, "source");
        n.f(string2, "boundary");
        super();
        this.source = h;
        this.boundary = string2;
        f obj2 = new f();
        obj2.b1("--");
        obj2.b1(string2);
        this.dashDashBoundary = obj2.Y0();
        obj2 = new f();
        obj2.b1("\r\n--");
        obj2.b1(string2);
        this.crlfDashDashBoundary = obj2.Y0();
    }

    public MultipartReader(okhttp3.ResponseBody responseBody) {
        String str;
        Object obj3;
        n.f(responseBody, "response");
        obj3 = responseBody.contentType();
        if (obj3 == null) {
        } else {
            obj3 = obj3.parameter("boundary");
            if (obj3 == null) {
            } else {
                super(responseBody.source(), obj3);
            }
        }
        obj3 = new ProtocolException("expected the Content-Type to have a boundary parameter");
        throw obj3;
    }

    public static final long access$currentPartBytesRemaining(okhttp3.MultipartReader multipartReader, long l2) {
        return multipartReader.currentPartBytesRemaining(l2);
    }

    public static final t access$getAfterBoundaryOptions$cp() {
        return MultipartReader.afterBoundaryOptions;
    }

    public static final okhttp3.MultipartReader.PartSource access$getCurrentPart$p(okhttp3.MultipartReader multipartReader) {
        return multipartReader.currentPart;
    }

    public static final h access$getSource$p(okhttp3.MultipartReader multipartReader) {
        return multipartReader.source;
    }

    public static final void access$setCurrentPart$p(okhttp3.MultipartReader multipartReader, okhttp3.MultipartReader.PartSource multipartReader$PartSource2) {
        multipartReader.currentPart = partSource2;
    }

    private final long currentPartBytesRemaining(long l) {
        int l2;
        int cmp;
        long obj5;
        this.source.V1((long)i2);
        i crlfDashDashBoundary2 = this.crlfDashDashBoundary;
        l2 = this.source.h().a0(crlfDashDashBoundary2);
        if (Long.compare(l2, i3) == 0) {
            obj5 = Math.min(l, obj6);
        } else {
            obj5 = Math.min(l, obj6);
        }
        return obj5;
    }

    @Override // java.io.Closeable
    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable
    public void close() {
        if (this.closed) {
        }
        this.closed = true;
        this.currentPart = 0;
        this.source.close();
    }

    @Override // java.io.Closeable
    public final okhttp3.MultipartReader.Part nextPart() {
        int partCount;
        h source;
        int i;
        long l;
        i iVar;
        i currentPartBytesRemaining;
        int i4 = 1;
        if (closed ^= i4 == 0) {
        } else {
            int i5 = 0;
            if (this.noMoreParts) {
                return i5;
            }
            int i6 = 0;
            if (this.partCount == 0 && this.source.K0(i6, obj4)) {
                if (this.source.K0(i6, obj4)) {
                    this.source.skip((long)i8);
                }
            }
            i = 0;
            l = this.source.i2(MultipartReader.afterBoundaryOptions);
            currentPartBytesRemaining = "unexpected characters after boundary";
            while (l != -1) {
                if (l != 2 && l != 3) {
                } else {
                }
                i = i4;
                l = this.source.i2(MultipartReader.afterBoundaryOptions);
                currentPartBytesRemaining = "unexpected characters after boundary";
                if (l != 3) {
                } else {
                }
            }
            ProtocolException protocolException = new ProtocolException(currentPartBytesRemaining);
            throw protocolException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
        throw illegalStateException;
    }
}
