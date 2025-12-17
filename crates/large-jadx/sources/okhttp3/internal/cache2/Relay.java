package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import l.d0;
import l.e0;
import l.f;
import l.i;
import l.i.a;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\r\u0018\u0000 E2\u00020\u0001:\u0002EFB5\u0008\u0002\u0012\u0008\u0010;\u001a\u0004\u0018\u00010:\u0012\u0008\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\u0008C\u0010DJ'\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u0015\u0010\u000c\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u000c\u0010\u000bJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\u0008\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\u00048\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008 \u0010!\u001a\u0004\u0008\"\u0010\u0011\"\u0004\u0008#\u0010$R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008%\u0010\u001d\u001a\u0004\u0008&\u0010\u001f\"\u0004\u0008'\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010(R\u0019\u0010*\u001a\u00020)8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008*\u0010+\u001a\u0004\u0008,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008/\u00100\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\"\u00105\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u00085\u00106\u001a\u0004\u00087\u0010\u0014\"\u0004\u00088\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008;\u0010<\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R\u0019\u0010A\u001a\u00020)8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008A\u0010+\u001a\u0004\u0008B\u0010-¨\u0006G", d2 = {"Lokhttp3/internal/cache2/Relay;", "", "Ll/i;", "prefix", "", "upstreamSize", "metadataSize", "Lkotlin/w;", "writeHeader", "(Ll/i;JJ)V", "writeMetadata", "(J)V", "commit", "metadata", "()Ll/i;", "Ll/d0;", "newSource", "()Ll/d0;", "", "isClosed", "()Z", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "bufferMaxSize", "J", "getBufferMaxSize", "()J", "upstream", "Ll/d0;", "getUpstream", "setUpstream", "(Ll/d0;)V", "upstreamPos", "getUpstreamPos", "setUpstreamPos", "Ll/i;", "Ll/f;", "upstreamBuffer", "Ll/f;", "getUpstreamBuffer", "()Ll/f;", "", "sourceCount", "I", "getSourceCount", "()I", "setSourceCount", "(I)V", "complete", "Z", "getComplete", "setComplete", "(Z)V", "Ljava/io/RandomAccessFile;", "file", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "buffer", "getBuffer", "<init>", "(Ljava/io/RandomAccessFile;Ll/d0;JLl/i;J)V", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Relay {

    public static final okhttp3.internal.cache2.Relay.Companion Companion = null;
    private static final long FILE_HEADER_SIZE = 32L;
    public static final i PREFIX_CLEAN = null;
    public static final i PREFIX_DIRTY = null;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final f buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final i metadata;
    private int sourceCount;
    private d0 upstream;
    private final f upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00088\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0016¨\u0006\u001a", d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "Ljava/io/File;", "file", "Ll/d0;", "upstream", "Ll/i;", "metadata", "", "bufferMaxSize", "Lokhttp3/internal/cache2/Relay;", "edit", "(Ljava/io/File;Ll/d0;Ll/i;J)Lokhttp3/internal/cache2/Relay;", "read", "(Ljava/io/File;)Lokhttp3/internal/cache2/Relay;", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Ll/i;", "PREFIX_DIRTY", "", "SOURCE_FILE", "I", "SOURCE_UPSTREAM", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.cache2.Relay edit(File file, d0 d02, i i3, long l4) {
            n.f(file, "file");
            n.f(d02, "upstream");
            n.f(i3, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            final g gVar = l4;
            super(randomAccessFile, d02, 0, obj5, i3, gVar, obj8, 0);
            randomAccessFile.setLength(0);
            Relay.access$writeHeader(obj11, Relay.PREFIX_DIRTY, -1, obj5);
            return obj11;
        }

        public final okhttp3.internal.cache2.Relay read(File file) {
            n.f(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            n.e(channel, "randomAccessFile.channel");
            FileOperator obj12 = new FileOperator(channel);
            f fVar = new f();
            int i6 = 0;
            obj12.read(i6, obj5, fVar);
            i pREFIX_CLEAN = Relay.PREFIX_CLEAN;
            if (z ^= 1 != 0) {
            } else {
                long long2 = fVar.readLong();
                f fVar2 = new f();
                obj12.read(long2 + i4, obj5, fVar2);
                super(randomAccessFile, 0, long2, obj5, fVar2.Y0(), 0, obj8, 0);
                return obj12;
            }
            obj12 = new IOException("unreadable cache file");
            throw obj12;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\t\u0010\u0013¨\u0006\u0016", d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Ll/d0;", "Ll/f;", "sink", "", "byteCount", "read", "(Ll/f;J)J", "Ll/e0;", "timeout", "()Ll/e0;", "Lkotlin/w;", "close", "()V", "sourcePos", "J", "Lokhttp3/internal/cache2/FileOperator;", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "Ll/e0;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class RelaySource implements d0 {

        private okhttp3.internal.cache2.FileOperator fileOperator;
        private long sourcePos;
        final okhttp3.internal.cache2.Relay this$0;
        private final e0 timeout;
        public RelaySource(okhttp3.internal.cache2.Relay relay) {
            this.this$0 = relay;
            super();
            e0 e0Var = new e0();
            this.timeout = e0Var;
            RandomAccessFile obj3 = relay.getFile();
            n.d(obj3);
            obj3 = obj3.getChannel();
            n.e(obj3, "file!!.channel");
            FileOperator fileOperator = new FileOperator(obj3);
            this.fileOperator = fileOperator;
        }

        @Override // l.d0
        public void close() {
            int i;
            int sourceCount;
            int this$0;
            if (this.fileOperator == null) {
            }
            i = 0;
            this.fileOperator = i;
            final okhttp3.internal.cache2.Relay this$02 = this.this$0;
            okhttp3.internal.cache2.Relay this$03 = this.this$0;
            this$03.setSourceCount(sourceCount2--);
            synchronized (this$02) {
                this.this$0.setFile(i);
                i = sourceCount;
                w wVar = w.a;
                if (i != 0) {
                }
            }
            Util.closeQuietly(i);
        }

        @Override // l.d0
        public long read(f f, long l2) {
            int timeout;
            int cmp;
            int buffer;
            Object upstreamBuffer;
            int i3;
            okhttp3.internal.cache2.Relay this$0;
            long size;
            Thread currentThread;
            int i;
            int i2;
            long bufferMaxSize;
            long sourcePos;
            final Object obj = this;
            long l = l2;
            Object obj2 = f;
            n.f(obj2, "sink");
            timeout = obj.fileOperator != null ? i3 : 0;
            if (timeout == 0) {
            } else {
                okhttp3.internal.cache2.Relay this$032 = obj.this$0;
                synchronized (this$032) {
                    int i11 = 2;
                    i = -1;
                    while (Long.compare(sourcePos8, upstreamPos3) != 0) {
                        obj.timeout.waitUntilNotified(obj.this$0);
                        i11 = 2;
                        i = -1;
                    }
                    upstreamPos7 -= size3;
                    if (Long.compare(sourcePos, i2) < 0) {
                        i3 = i11;
                        int i18 = 32;
                        if (i3 == i11) {
                        }
                        int i17 = 0;
                        d0 upstream = obj.this$0.getUpstream();
                        n.d(upstream);
                        long read = upstream.read(obj.this$0.getUpstreamBuffer(), obj.this$0.getBufferMaxSize());
                        if (Long.compare(read, i) == 0) {
                            okhttp3.internal.cache2.Relay this$05 = obj.this$0;
                            this$05.commit(this$05.getUpstreamPos());
                            okhttp3.internal.cache2.Relay this$025 = obj.this$0;
                            obj.this$0.setUpstreamReader(i17);
                            okhttp3.internal.cache2.Relay this$07 = obj.this$0;
                            synchronized (this$025) {
                                this$07.notifyAll();
                                w wVar = w.a;
                                return i;
                            }
                        }
                        long l10 = Math.min(read, obj15);
                        obj.this$0.getUpstreamBuffer().j(f, 0, obj2);
                        obj.sourcePos = sourcePos3 += l10;
                        okhttp3.internal.cache2.FileOperator fileOperator3 = obj.fileOperator;
                        n.d(fileOperator3);
                        long l4 = read;
                        fileOperator3.write(upstreamPos2 += i18, obj15, obj.this$0.getUpstreamBuffer().c());
                        okhttp3.internal.cache2.Relay this$026 = obj.this$0;
                        obj.this$0.getBuffer().write(obj.this$0.getUpstreamBuffer(), l4);
                        synchronized (this$026) {
                            obj.this$0.getBuffer().skip(size2 -= bufferMaxSize);
                            okhttp3.internal.cache2.Relay this$015 = obj.this$0;
                            this$015.setUpstreamPos(upstreamPos5 += l4);
                            w wVar2 = w.a;
                            okhttp3.internal.cache2.Relay this$027 = obj.this$0;
                            obj.this$0.setUpstreamReader(i17);
                            okhttp3.internal.cache2.Relay this$017 = obj.this$0;
                            synchronized (this$027) {
                                this$015 = obj.this$0;
                                this$015.setUpstreamPos(upstreamPos5 += l4);
                                wVar2 = w.a;
                                this$027 = obj.this$0;
                                obj.this$0.setUpstreamReader(i17);
                                this$017 = obj.this$0;
                            }
                        }
                        try {
                            this$017.notifyAll();
                            return l10;
                            NullPointerException nullPointerException2 = new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            throw nullPointerException2;
                            throw th;
                            throw th;
                            okhttp3.internal.cache2.Relay this$024 = obj1.this$0;
                            long l3 = obj1.this$0;
                            l3.setUpstreamReader(obj8);
                            l3 = obj1.this$0;
                            if (l3 == 0) {
                            }
                            l3 = "null cannot be cast to non-null type java.lang.Object";
                            NullPointerException th = new NullPointerException(l3);
                            throw th;
                            l3.notifyAll();
                            l3 = w.a;
                            throw th;
                            throw th;
                            throw th;
                            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                            throw illegalStateException;
                        } catch (Throwable th) {
                        }
                    }
                    long l11 = Math.min(l, l3);
                    obj.this$0.getBuffer().j(f, sourcePos6 - i2, obj2);
                    obj.sourcePos = sourcePos4 += l11;
                    return l11;
                }
                long l9 = Math.min(l, l3);
                okhttp3.internal.cache2.FileOperator fileOperator2 = obj.fileOperator;
                n.d(fileOperator2);
                fileOperator2.read(sourcePos5 += i18, i3, f);
                obj.sourcePos = sourcePos2 += l9;
                return l9;
            }
        }

        @Override // l.d0
        public e0 timeout() {
            return this.timeout;
        }
    }
    static {
        Relay.Companion companion = new Relay.Companion(0);
        Relay.Companion = companion;
        i.a aVar = i.v;
        Relay.PREFIX_CLEAN = aVar.d("OkHttp cache v1\n");
        Relay.PREFIX_DIRTY = aVar.d("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, d0 d02, long l3, i i4, long l5) {
        int obj1;
        super();
        this.file = randomAccessFile;
        this.upstream = d02;
        this.upstreamPos = l3;
        this.metadata = l5;
        this.bufferMaxSize = obj6;
        obj1 = new f();
        this.upstreamBuffer = obj1;
        obj1 = d02 == null ? 1 : 0;
        this.complete = obj1;
        obj1 = new f();
        this.buffer = obj1;
    }

    public Relay(RandomAccessFile randomAccessFile, d0 d02, long l3, i i4, long l5, g g6) {
        super(randomAccessFile, d02, l3, i4, l5, g6, obj7);
    }

    public static final void access$writeHeader(okhttp3.internal.cache2.Relay relay, i i2, long l3, long l4) {
        relay.writeHeader(i2, l3, l4);
    }

    private final void writeHeader(i i, long l2, long l3) {
        int obj7;
        f fVar = new f();
        fVar.e0(i);
        fVar.I0(l2);
        fVar.I0(obj10);
        obj7 = Long.compare(obj7, obj9) == 0 ? 1 : 0;
        if (obj7 == null) {
        } else {
            obj7 = this.file;
            n.d(obj7);
            obj7 = obj7.getChannel();
            n.e(obj7, "file!!.channel");
            FileOperator fileOperator = new FileOperator(obj7);
            fileOperator.write(0, obj2, fVar);
        }
        obj7 = new IllegalArgumentException("Failed requirement.".toString());
        throw obj7;
    }

    private final void writeMetadata(long l) {
        f fVar = new f();
        fVar.e0(this.metadata);
        RandomAccessFile file = this.file;
        n.d(file);
        FileChannel channel = file.getChannel();
        final String str = "file!!.channel";
        n.e(channel, str);
        FileOperator fileOperator = new FileOperator(channel);
        fileOperator.write(i += l, str, fVar);
    }

    public final void commit(long l) {
        writeMetadata(l);
        RandomAccessFile file = this.file;
        n.d(file);
        final int i2 = 0;
        file.getChannel().force(i2);
        this.writeHeader(Relay.PREFIX_CLEAN, l, obj5);
        RandomAccessFile obj9 = this.file;
        n.d(obj9);
        obj9.getChannel().force(i2);
        this.complete = true;
        obj9 = w.a;
        obj9 = this.upstream;
        synchronized (this) {
            writeMetadata(l);
            file = this.file;
            n.d(file);
            i2 = 0;
            file.getChannel().force(i2);
            this.writeHeader(Relay.PREFIX_CLEAN, l, obj5);
            obj9 = this.file;
            n.d(obj9);
            obj9.getChannel().force(i2);
            this.complete = true;
            obj9 = w.a;
            obj9 = this.upstream;
        }
        Util.closeQuietly(obj9);
        this.upstream = 0;
    }

    public final f getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final d0 getUpstream() {
        return this.upstream;
    }

    public final f getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        int i;
        i = this.file == null ? 1 : 0;
        return i;
    }

    public final i metadata() {
        return this.metadata;
    }

    public final d0 newSource() {
        synchronized (this) {
            try {
                return null;
                this.sourceCount = sourceCount++;
                Relay.RelaySource relaySource = new Relay.RelaySource(this);
                return relaySource;
            }
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final void setUpstream(d0 d0) {
        this.upstream = d0;
    }

    public final void setUpstreamPos(long l) {
        this.upstreamPos = l;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }
}
