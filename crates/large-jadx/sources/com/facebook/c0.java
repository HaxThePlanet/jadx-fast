package com.facebook;

import android.os.Handler;
import com.facebook.internal.g0.i.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0008J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0008J\u0006\u0010\u0014\u001a\u00020\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001e\u0010\r\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lcom/facebook/RequestProgress;", "", "callbackHandler", "Landroid/os/Handler;", "request", "Lcom/facebook/GraphRequest;", "(Landroid/os/Handler;Lcom/facebook/GraphRequest;)V", "lastReportedProgress", "", "<set-?>", "maxProgress", "getMaxProgress", "()J", "progress", "getProgress", "threshold", "addProgress", "", "size", "addToMax", "reportProgress", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class c0 {

    private final long a;
    private long b;
    private long c;
    private long d;
    private final Handler e;
    private final com.facebook.p f;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class a implements Runnable {

        final com.facebook.p.b a;
        final long b;
        final long c;
        a(com.facebook.p.b p$b, long l2, long l3) {
            this.a = b;
            this.b = l2;
            this.c = obj4;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.d(this)) {
            }
            (p.f)this.a.a(this.b, obj2);
        }
    }
    public c0(Handler handler, com.facebook.p p2) {
        n.f(p2, "request");
        super();
        this.e = handler;
        this.f = p2;
        this.a = o.t();
    }

    public final void a(long l) {
        int obj5;
        l2 += l;
        this.b = i;
        if (Long.compare(i, obj5) < 0) {
            if (Long.compare(i, obj5) >= 0) {
                c();
            }
        } else {
        }
    }

    public final void b(long l) {
        this.d = l2 += l;
    }

    public final void c() {
        int cmp;
        com.facebook.c0.a aVar;
        long l;
        long l3;
        long l2;
        com.facebook.c0.a aVar2;
        l = this.f.m();
        l2 = this.d;
        if (Long.compare(l4, l) > 0 && Long.compare(l2, i) > 0 && l instanceof p.f) {
            l = this.f.m();
            l2 = this.d;
            if (Long.compare(l2, i) > 0) {
                if (l instanceof p.f) {
                    l3 = this.b;
                    Handler handler = this.e;
                    if (handler != null) {
                        super(l, l3, obj4, l2, obj6);
                        handler.post(aVar2);
                    } else {
                        (p.f)l.a(l3, obj4);
                    }
                    this.c = this.b;
                }
            }
        }
    }
}
