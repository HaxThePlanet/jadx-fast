package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.d0.d.n;
import l.f;
import l.o;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\n\u0010\u000bR\u0016\u0010\u000c\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013¨\u0006\u0016", d2 = {"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "Ll/f;", "buffer", "Lkotlin/w;", "inflate", "(Ll/f;)V", "close", "()V", "", "noContextTakeover", "Z", "deflatedBytes", "Ll/f;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Ll/o;", "inflaterSource", "Ll/o;", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class MessageInflater implements Closeable {

    private final f deflatedBytes;
    private final Inflater inflater;
    private final o inflaterSource;
    private final boolean noContextTakeover;
    public MessageInflater(boolean z) {
        super();
        this.noContextTakeover = z;
        f obj3 = new f();
        this.deflatedBytes = obj3;
        Inflater inflater = new Inflater(1);
        this.inflater = inflater;
        o oVar = new o(obj3, inflater);
        this.inflaterSource = oVar;
    }

    @Override // java.io.Closeable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // java.io.Closeable
    public final void inflate(f f) {
        int i;
        boolean noContextTakeover;
        long size;
        long l;
        n.f(f, "buffer");
        i = Long.compare(size2, i4) == 0 ? 1 : 0;
        if (i == 0) {
        } else {
            if (this.noContextTakeover) {
                this.inflater.reset();
            }
            this.deflatedBytes.W0(f);
            this.deflatedBytes.G0(65535);
            this.inflaterSource.a(f, Long.MAX_VALUE);
            while (Long.compare(bytesRead2, i2) >= 0) {
                this.inflaterSource.a(f, Long.MAX_VALUE);
            }
        }
        IllegalArgumentException obj6 = new IllegalArgumentException("Failed requirement.".toString());
        throw obj6;
    }
}
