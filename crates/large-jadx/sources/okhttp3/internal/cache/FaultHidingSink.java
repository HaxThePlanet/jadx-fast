package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import l.b0;
import l.f;
import l.k;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0010\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000c¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u000b\u0010\nR%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000c8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014¨\u0006\u0019", d2 = {"Lokhttp3/internal/cache/FaultHidingSink;", "Ll/k;", "Ll/f;", "source", "", "byteCount", "Lkotlin/w;", "write", "(Ll/f;J)V", "flush", "()V", "close", "Lkotlin/Function1;", "Ljava/io/IOException;", "onException", "Lkotlin/d0/c/l;", "getOnException", "()Lkotlin/d0/c/l;", "", "hasErrors", "Z", "Ll/b0;", "delegate", "<init>", "(Ll/b0;Lkotlin/d0/c/l;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public class FaultHidingSink extends k {

    private boolean hasErrors;
    private final l<IOException, w> onException;
    public FaultHidingSink(b0 b0, l<? super IOException, w> l2) {
        n.f(b0, "delegate");
        n.f(l2, "onException");
        super(b0);
        this.onException = l2;
    }

    @Override // l.k
    public void close() {
        boolean hasErrors;
        int onException;
        if (this.hasErrors) {
        }
        super.close();
    }

    @Override // l.k
    public void flush() {
        boolean hasErrors;
        int onException;
        if (this.hasErrors) {
        }
        super.flush();
    }

    public final l<IOException, w> getOnException() {
        return this.onException;
    }

    @Override // l.k
    public void write(f f, long l2) {
        Object obj2;
        long obj3;
        n.f(f, "source");
        if (this.hasErrors) {
            f.skip(l2);
        }
        super.write(f, l2);
    }
}
