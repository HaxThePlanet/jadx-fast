package f.c.a.b.i.x.a;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: LogEventDropped.java */
/* loaded from: classes.dex */
public final class c {

    private final long a;
    private final c.b b;

    public static final class a {

        private long a = 0;
        private c.b b;
        a() {
            super();
            this.b = c.b.REASON_UNKNOWN;
        }

        public c a() {
            return new c(this.a, r2, this.b);
        }

        public c.a b(long j) {
            this.a = j;
            return this;
        }

        public c.a c(c.b bVar) {
            this.b = bVar;
            return this;
        }
    }

    public enum b implements ProtoEnum {

        CACHE_FULL,
        INVALID_PAYLOD,
        MAX_RETRIES_REACHED,
        MESSAGE_TOO_OLD,
        PAYLOAD_TOO_BIG,
        REASON_UNKNOWN,
        SERVER_ERROR;

        private final int number_;
        @Override // java.lang.Enum
        public int getNumber() {
            return this.number_;
        }
    }
    static {
        new c.a().a();
    }

    c(long j, c.b bVar) {
        super();
        this.a = j;
        this.b = bVar;
    }

    public static c.a c() {
        return new c.a();
    }

    public long a() {
        return this.a;
    }

    public c.b b() {
        return this.b;
    }
}
