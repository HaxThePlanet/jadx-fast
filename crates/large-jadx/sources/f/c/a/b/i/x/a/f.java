package f.c.a.b.i.x.a;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class f {

    private final long a;
    private final long b;

    public static final class a {

        private long a = 0;
        private long b = 0;
        a() {
            super();
            final int i = 0;
        }

        public f.c.a.b.i.x.a.f a() {
            f fVar = new f(this.a, obj2, this.b, obj4);
            return fVar;
        }

        public f.c.a.b.i.x.a.f.a b(long l) {
            this.b = l;
            return this;
        }

        public f.c.a.b.i.x.a.f.a c(long l) {
            this.a = l;
            return this;
        }
    }
    static {
        f.a aVar = new f.a();
        aVar.a();
    }

    f(long l, long l2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    public static f.c.a.b.i.x.a.f.a c() {
        f.a aVar = new f.a();
        return aVar;
    }

    public long a() {
        return this.b;
    }

    public long b() {
        return this.a;
    }
}
