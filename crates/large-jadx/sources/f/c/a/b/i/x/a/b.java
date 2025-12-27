package f.c.a.b.i.x.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.proto.Protobuf;

/* compiled from: GlobalMetrics.java */
/* loaded from: classes.dex */
public final class b {

    private final e a;

    public static final class a {

        private e a = null;
        a() {
            super();
        }

        public b a() {
            return new b(this.a);
        }

        public b.a b(e eVar) {
            this.a = eVar;
            return this;
        }
    }
    static {
        new b.a().a();
    }

    b(e eVar) {
        super();
        this.a = eVar;
    }

    public static b.a b() {
        return new b.a();
    }

    @Encodable.Field(name = "storageMetrics")
    public e a() {
        return this.a;
    }
}
