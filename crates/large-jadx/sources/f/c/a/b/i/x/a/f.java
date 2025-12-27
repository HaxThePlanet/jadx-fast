package f.c.a.b.i.x.a;

import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: TimeWindow.java */
/* loaded from: classes.dex */
public final class f {

    private final long a;
    private final long b;

    public static final class a {

        private long a = 0;
        private long b = 0;
        a() {
            super();
        }

        public f a() {
            return new f(this.a, r2, this.b, r4);
        }

        public f.a b(long j) {
            this.b = j;
            return this;
        }

        public f.a c(long j) {
            this.a = j;
            return this;
        }
    }
    static {
        new f.a().a();
    }

    f(long j, long j2) {
        super();
        this.a = j;
        this.b = j2;
    }

    public static f.a c() {
        return new f.a();
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }
}
