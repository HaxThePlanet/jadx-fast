package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.io.b;
import l.f;
import l.f.a;
import l.i;
import l.j;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u000c\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0017¨\u0006\u001a", d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "Ll/f;", "Ll/i;", "suffix", "", "endsWith", "(Ll/f;Ll/i;)Z", "buffer", "Lkotlin/w;", "deflate", "(Ll/f;)V", "close", "()V", "deflatedBytes", "Ll/f;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "noContextTakeover", "Z", "Ll/j;", "deflaterSink", "Ll/j;", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MessageDeflater implements Closeable {

    private final f deflatedBytes;
    private final Deflater deflater;
    private final j deflaterSink;
    private final boolean noContextTakeover;
    public MessageDeflater(boolean z) {
        super();
        this.noContextTakeover = z;
        f obj4 = new f();
        this.deflatedBytes = obj4;
        Deflater deflater = new Deflater(-1, 1);
        this.deflater = deflater;
        j jVar = new j(obj4, deflater);
        this.deflaterSink = jVar;
    }

    private final boolean endsWith(f f, i i2) {
        return f.K0(size -= l, obj1);
    }

    @Override // java.io.Closeable
    public void close() {
        this.deflaterSink.close();
    }

    @Override // java.io.Closeable
    public final void deflate(f f) {
        int i3;
        boolean noContextTakeover;
        Object deflatedBytes;
        int i;
        int i2;
        n.f(f, "buffer");
        int i5 = 1;
        i = 0;
        i3 = Long.compare(size, i6) == 0 ? i5 : i;
        if (i3 == 0) {
        } else {
            if (this.noContextTakeover) {
                this.deflater.reset();
            }
            this.deflaterSink.write(f, f.size());
            this.deflaterSink.flush();
            i iVar = MessageDeflaterKt.access$getEMPTY_DEFLATE_BLOCK$p();
            if (endsWith(this.deflatedBytes, iVar)) {
                i2 = 0;
                deflatedBytes = f.F(this.deflatedBytes, i2, i5, i2);
                deflatedBytes.e(size3 -= l);
                b.a(deflatedBytes, i2);
            } else {
                this.deflatedBytes.z0(i);
            }
            f deflatedBytes6 = this.deflatedBytes;
            f.write(deflatedBytes6, deflatedBytes6.size());
        }
        IllegalArgumentException obj7 = new IllegalArgumentException("Failed requirement.".toString());
        throw obj7;
    }
}
