package io.grpc.j1;

import com.google.common.base.n;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class h {

    private static final Logger c;
    private final String a;
    private final AtomicLong b;

    static class a {
    }

    public final class b {

        private final long a;
        final io.grpc.j1.h b;
        static {
        }

        private b(io.grpc.j1.h h, long l2) {
            this.b = h;
            super();
            this.a = l2;
        }

        b(io.grpc.j1.h h, long l2, io.grpc.j1.h.a h$a3) {
            super(h, l2, a3);
        }

        public void a() {
            long str2;
            boolean compareAndSet;
            long wARNING;
            long arr;
            int i;
            String str;
            long l = this.a;
            str2 = Math.max(i2 *= l, obj3);
            if (h.a(this.b).compareAndSet(this.a, obj4)) {
                arr = new Object[2];
                h.c().log(Level.WARNING, "Increased {0} to {1}", h.b(this.b), Long.valueOf(str2));
            }
        }

        public long b() {
            return this.a;
        }
    }
    static {
        h.c = Logger.getLogger(h.class.getName());
    }

    public h(String string, long l2) {
        int i;
        super();
        AtomicLong atomicLong = new AtomicLong();
        this.b = atomicLong;
        i = Long.compare(l2, i2) > 0 ? 1 : 0;
        n.e(i, "value must be positive");
        this.a = string;
        atomicLong.set(l2);
    }

    static AtomicLong a(io.grpc.j1.h h) {
        return h.b;
    }

    static String b(io.grpc.j1.h h) {
        return h.a;
    }

    static Logger c() {
        return h.c;
    }

    public io.grpc.j1.h.b d() {
        h.b bVar = new h.b(this, this.b.get(), obj2, 0);
        return bVar;
    }
}
