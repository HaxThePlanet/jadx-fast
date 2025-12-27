package f.c.a.b.i.x.a;

import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: StorageMetrics.java */
/* loaded from: classes.dex */
public final class e {

    private final long a;
    private final long b;

    public static final class a {

        private long a = 0;
        private long b = 0;
        a() {
            super();
        }

        public e a() {
            return new e(this.a, r2, this.b, r4);
        }

        public e.a b(long j) {
            this.a = j;
            return this;
        }

        public e.a c(long j) {
            this.b = j;
            return this;
        }
    }
    static {
        new e.a().a();
    }

    e(long j, long j2) {
        super();
        this.a = j;
        this.b = j2;
    }

    public static e.a c() {
        return new e.a();
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
