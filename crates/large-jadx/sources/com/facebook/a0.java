package com.facebook;

import android.os.Handler;
import com.facebook.internal.g0.i.a;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000cH\u0002J\u0008\u0010\u0019\u001a\u00020\u0017H\u0016J\u0008\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\u0008\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010#\u001a\u00020!H\u0016R\u001e\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lcom/facebook/ProgressOutputStream;", "Ljava/io/FilterOutputStream;", "Lcom/facebook/RequestOutputStream;", "out", "Ljava/io/OutputStream;", "requests", "Lcom/facebook/GraphRequestBatch;", "progressMap", "", "Lcom/facebook/GraphRequest;", "Lcom/facebook/RequestProgress;", "maxProgress", "", "(Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V", "<set-?>", "batchProgress", "getBatchProgress", "()J", "currentRequestProgress", "lastReportedProgress", "getMaxProgress", "threshold", "addProgress", "", "size", "close", "reportBatchProgress", "setCurrentRequest", "request", "write", "buffer", "", "offset", "", "length", "oneByte", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a0 extends FilterOutputStream implements com.facebook.b0 {

    private final long a;
    private long b;
    private long c;
    private com.facebook.c0 v;
    private final com.facebook.r w;
    private final Map<com.facebook.p, com.facebook.c0> x;
    private final long y;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        final com.facebook.a0 a;
        final com.facebook.r.a b;
        a(com.facebook.a0 a0, com.facebook.r.a r$a2) {
            this.a = a0;
            this.b = a2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            (r.b)this.b.b(a0.c(this.a), this.a.f(), obj4);
        }
    }
    public a0(OutputStream outputStream, com.facebook.r r2, Map<com.facebook.p, com.facebook.c0> map3, long l4) {
        n.f(outputStream, "out");
        n.f(r2, "requests");
        n.f(map3, "progressMap");
        super(outputStream);
        this.w = r2;
        this.x = map3;
        this.y = l4;
        this.a = o.t();
    }

    public static final com.facebook.r c(com.facebook.a0 a0) {
        return a0.w;
    }

    private final void e(long l) {
        int obj5;
        com.facebook.c0 c0Var = this.v;
        if (c0Var != null) {
            c0Var.a(l);
        }
        l2 += l;
        this.b = i;
        if (Long.compare(i, obj5) < 0) {
            if (Long.compare(i, obj5) >= 0) {
                j();
            }
        } else {
        }
    }

    private final void j() {
        int cmp;
        Object next;
        long l2;
        com.facebook.a0.a aVar;
        Object obj;
        com.facebook.r rVar;
        long l;
        long l3;
        if (Long.compare(l4, l2) > 0) {
            Iterator iterator = this.w.u().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (next instanceof r.b != 0) {
                }
                l2 = this.w.t();
                if (l2 != 0) {
                } else {
                }
                (r.b)(r.a)next.b(this.w, this.b, obj7);
                aVar = new a0.a(this, next);
                l2.post(aVar);
            }
            this.c = this.b;
        }
    }

    @Override // java.io.FilterOutputStream
    public void a(com.facebook.p p) {
        Map map;
        Object obj2;
        if (p != null) {
            obj2 = this.x.get(p);
        } else {
            obj2 = 0;
        }
        this.v = obj2;
    }

    @Override // java.io.FilterOutputStream
    public void close() {
        Object next;
        super.close();
        Iterator iterator = this.x.values().iterator();
        for (c0 next : iterator) {
            next.c();
        }
        j();
    }

    @Override // java.io.FilterOutputStream
    public final long f() {
        return this.b;
    }

    @Override // java.io.FilterOutputStream
    public final long i() {
        return this.y;
    }

    @Override // java.io.FilterOutputStream
    public void write(int i) {
        this.out.write(i);
        e(1);
    }

    @Override // java.io.FilterOutputStream
    public void write(byte[] bArr) {
        n.f(bArr, "buffer");
        this.out.write(bArr);
        e((long)obj3);
    }

    @Override // java.io.FilterOutputStream
    public void write(byte[] bArr, int i2, int i3) {
        n.f(bArr, "buffer");
        this.out.write(bArr, i2, i3);
        e((long)i3);
    }
}
