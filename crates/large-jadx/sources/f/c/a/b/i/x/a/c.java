package f.c.a.b.i.x.a;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class c {

    private final long a;
    private final f.c.a.b.i.x.a.c.b b;

    public static final class a {

        private long a = 0;
        private f.c.a.b.i.x.a.c.b b = null;
        a() {
            super();
            int i = 0;
            f.c.a.b.i.x.a.c.b rEASON_UNKNOWN = c.b.REASON_UNKNOWN;
        }

        public f.c.a.b.i.x.a.c a() {
            c cVar = new c(this.a, obj2, this.b);
            return cVar;
        }

        public f.c.a.b.i.x.a.c.a b(long l) {
            this.a = l;
            return this;
        }

        public f.c.a.b.i.x.a.c.a c(f.c.a.b.i.x.a.c.b c$b) {
            this.b = b;
            return this;
        }
    }

    public static enum b implements ProtoEnum {

        REASON_UNKNOWN(false),
        MESSAGE_TOO_OLD(true),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int number_;
        @Override // java.lang.Enum
        public int getNumber() {
            return this.number_;
        }
    }
    static {
        c.a aVar = new c.a();
        aVar.a();
    }

    c(long l, f.c.a.b.i.x.a.c.b c$b2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    public static f.c.a.b.i.x.a.c.a c() {
        c.a aVar = new c.a();
        return aVar;
    }

    public long a() {
        return this.a;
    }

    public f.c.a.b.i.x.a.c.b b() {
        return this.b;
    }
}
