package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.d0.d.n;
import l.f;
import l.f.a;
import l.g;
import l.i;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010%\u001a\u00020\u0014\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010&\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\u00084\u00105J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u000b\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00022\u0008\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\u0008\u000e\u0010\u0008J\u001d\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\u0008\u0011\u0010\u0008J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008!\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008#\u0010$R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008%\u0010\u0016R\u0016\u0010&\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008&\u0010\u0016R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008(\u0010)R\u0019\u0010+\u001a\u00020*8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008+\u0010,\u001a\u0004\u0008-\u0010.R\u0019\u00100\u001a\u00020/8\u0006@\u0006¢\u0006\u000c\n\u0004\u00080\u00101\u001a\u0004\u00082\u00103¨\u00066", d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "", "opcode", "Ll/i;", "payload", "Lkotlin/w;", "writeControlFrame", "(ILl/i;)V", "writePing", "(Ll/i;)V", "writePong", "code", "reason", "writeClose", "formatOpcode", "data", "writeMessageFrame", "close", "()V", "", "writerClosed", "Z", "Lokhttp3/internal/ws/MessageDeflater;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "Ll/f$a;", "maskCursor", "Ll/f$a;", "noContextTakeover", "Ll/f;", "messageBuffer", "Ll/f;", "sinkBuffer", "", "maskKey", "[B", "isClient", "perMessageDeflate", "", "minimumDeflateSize", "J", "Ll/g;", "sink", "Ll/g;", "getSink", "()Ll/g;", "Ljava/util/Random;", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "<init>", "(ZLl/g;Ljava/util/Random;ZZJ)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketWriter implements Closeable {

    private final boolean isClient;
    private final f.a maskCursor;
    private final byte[] maskKey = null;
    private final f messageBuffer;
    private okhttp3.internal.ws.MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final g sink;
    private final f sinkBuffer;
    private boolean writerClosed;
    public WebSocketWriter(boolean z, g g2, Random random3, boolean z4, boolean z5, long l6) {
        int obj3;
        n.f(g2, "sink");
        n.f(random3, "random");
        super();
        this.isClient = z;
        this.sink = g2;
        this.random = random3;
        this.perMessageDeflate = z4;
        this.noContextTakeover = z5;
        this.minimumDeflateSize = l6;
        f obj4 = new f();
        this.messageBuffer = obj4;
        this.sinkBuffer = g2.h();
        if (z) {
            obj4 = new byte[4];
        }
        obj4 = obj3;
        if (z) {
            obj3 = new f.a();
        }
        this.maskCursor = obj3;
    }

    private final void writeControlFrame(int i, i i2) {
        int maskKey;
        int i3;
        byte[] sinkBuffer;
        Object obj6;
        Object obj7;
        if (this.writerClosed) {
        } else {
            maskKey = i2.A();
            i3 = Long.compare(l, i4) <= 0 ? 1 : 0;
            if (i3 == 0) {
            } else {
                this.sinkBuffer.z0(i |= 128);
                if (this.isClient) {
                    this.sinkBuffer.z0(maskKey | 128);
                    byte[] maskKey2 = this.maskKey;
                    n.d(maskKey2);
                    this.random.nextBytes(maskKey2);
                    sinkBuffer = this.maskKey;
                    this.sinkBuffer.m0(sinkBuffer);
                    if (maskKey > 0) {
                        this.sinkBuffer.e0(i2);
                        obj7 = this.maskCursor;
                        n.d(obj7);
                        this.sinkBuffer.E(obj7);
                        this.maskCursor.f(this.sinkBuffer.size());
                        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.z0(maskKey);
                    this.sinkBuffer.e0(i2);
                }
                this.sink.flush();
            }
            obj6 = new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
            throw obj6;
        }
        obj6 = new IOException("closed");
        throw obj6;
    }

    @Override // java.io.Closeable
    public void close() {
        final okhttp3.internal.ws.MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    @Override // java.io.Closeable
    public final Random getRandom() {
        return this.random;
    }

    @Override // java.io.Closeable
    public final g getSink() {
        return this.sink;
    }

    @Override // java.io.Closeable
    public final void writeClose(int i, i i2) {
        i iNSTANCE;
        iNSTANCE = i.c;
        if (i == 0) {
            if (i2 != null && i != 0) {
                if (i != 0) {
                    WebSocketProtocol.INSTANCE.validateCloseCode(i);
                }
                f fVar = new f();
                fVar.L0(i);
                if (i2 != null) {
                    fVar.e0(i2);
                }
                iNSTANCE = fVar.Y0();
            }
        } else {
        }
        writeControlFrame(8, iNSTANCE);
        this.writerClosed = true;
    }

    @Override // java.io.Closeable
    public final void writeMessageFrame(int i, i i2) {
        int maskKey;
        boolean perMessageDeflate;
        long minimumDeflateSize;
        int obj6;
        Object obj7;
        n.f(i2, "data");
        if (this.writerClosed) {
        } else {
            this.messageBuffer.e0(i2);
            if (this.perMessageDeflate && Long.compare(perMessageDeflate, minimumDeflateSize) >= 0) {
                if (Long.compare(perMessageDeflate, minimumDeflateSize) >= 0) {
                    if (this.messageDeflater != null) {
                    } else {
                        obj7 = new MessageDeflater(this.noContextTakeover);
                        this.messageDeflater = obj7;
                    }
                    obj7.deflate(this.messageBuffer);
                    obj6 |= 64;
                }
            }
            long size = this.messageBuffer.size();
            this.sinkBuffer.z0(obj6);
            if (this.isClient) {
            } else {
                maskKey = obj6;
            }
            if (Long.compare(size, obj6) <= 0) {
                this.sinkBuffer.z0(obj6 |= maskKey);
            } else {
                if (Long.compare(size, obj6) <= 0) {
                    this.sinkBuffer.z0(maskKey | 126);
                    this.sinkBuffer.L0((int)size);
                } else {
                    this.sinkBuffer.z0(maskKey | 127);
                    this.sinkBuffer.I0(size);
                }
            }
            obj7 = this.maskKey;
            n.d(obj7);
            this.random.nextBytes(obj7);
            obj7 = this.maskKey;
            this.sinkBuffer.m0(obj7);
            obj6 = 0;
            if (this.isClient && Long.compare(size, obj6) > 0) {
                obj7 = this.maskKey;
                n.d(obj7);
                this.random.nextBytes(obj7);
                obj7 = this.maskKey;
                this.sinkBuffer.m0(obj7);
                obj6 = 0;
                if (Long.compare(size, obj6) > 0) {
                    minimumDeflateSize = this.maskCursor;
                    n.d(minimumDeflateSize);
                    this.messageBuffer.E(minimumDeflateSize);
                    this.maskCursor.f(obj6);
                    WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            this.sinkBuffer.write(this.messageBuffer, size);
            this.sink.G();
        }
        obj6 = new IOException("closed");
        throw obj6;
    }

    @Override // java.io.Closeable
    public final void writePing(i i) {
        n.f(i, "payload");
        writeControlFrame(9, i);
    }

    @Override // java.io.Closeable
    public final void writePong(i i) {
        n.f(i, "payload");
        writeControlFrame(10, i);
    }
}
