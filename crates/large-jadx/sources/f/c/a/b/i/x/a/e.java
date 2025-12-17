package f.c.a.b.i.x.a;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class e {

    private final long a;
    private final long b;

    public static final class a {

        private long a = 0;
        private long b = 0;
        a() {
            super();
            final int i = 0;
        }

        public f.c.a.b.i.x.a.e a() {
            e eVar = new e(this.a, obj2, this.b, obj4);
            return eVar;
        }

        public f.c.a.b.i.x.a.e.a b(long l) {
            this.a = l;
            return this;
        }

        public f.c.a.b.i.x.a.e.a c(long l) {
            this.b = l;
            return this;
        }
    }
    static {
        e.a aVar = new e.a();
        aVar.a();
    }

    e(long l, long l2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    public static f.c.a.b.i.x.a.e.a c() {
        e.a aVar = new e.a();
        return aVar;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
