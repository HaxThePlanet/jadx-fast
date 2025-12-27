package io.grpc.j1;

import com.google.common.base.n;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: AtomicBackoff.java */
/* loaded from: classes3.dex */
public final class h {

    private static final Logger c;
    private final String a;
    private final AtomicLong b = new AtomicLong();

    static class a {
    }

    public final class b {

        private final long a;
        final /* synthetic */ h b;
        /* synthetic */ b(long j, h.a aVar) {
            this(hVar, j, r3);
        }

        public void a() {
            long max = Math.max(2L * l2, this.a);
            if (this.b.b.compareAndSet(this.a, max)) {
                Object[] arr = new Object[2];
                int i = 1;
                arr[i] = Long.valueOf(max);
                h.c.log(Level.WARNING, "Increased {0} to {1}", arr);
            }
        }

        public long b() {
            return this.a;
        }

        private b(long j) {
            this.b = hVar;
            super();
            this.a = j;
        }

    }
    static {
        h.c = Logger.getLogger(h.class.getName());
    }

    public h(String str, long j) {
        boolean z = true;
        super();
        int r1 = j > 0 ? 1 : 0;
        n.e((j > 0 ? 1 : 0), "value must be positive");
        this.a = str;
        new AtomicLong().set(j);
    }

    static /* synthetic */ AtomicLong a(h hVar) {
        return hVar.b;
    }

    static /* synthetic */ String b(h hVar) {
        return hVar.a;
    }

    static /* synthetic */ Logger c() {
        return h.c;
    }

    public h.b d() {
        return new h.b(this, this.b.get(), r2, 0);
    }
}
