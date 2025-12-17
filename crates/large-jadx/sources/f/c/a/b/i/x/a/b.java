package f.c.a.b.i.x.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class b {

    private final f.c.a.b.i.x.a.e a;

    public static final class a {

        private f.c.a.b.i.x.a.e a = null;
        a() {
            super();
            final int i = 0;
        }

        public f.c.a.b.i.x.a.b a() {
            b bVar = new b(this.a);
            return bVar;
        }

        public f.c.a.b.i.x.a.b.a b(f.c.a.b.i.x.a.e e) {
            this.a = e;
            return this;
        }
    }
    static {
        b.a aVar = new b.a();
        aVar.a();
    }

    b(f.c.a.b.i.x.a.e e) {
        super();
        this.a = e;
    }

    public static f.c.a.b.i.x.a.b.a b() {
        b.a aVar = new b.a();
        return aVar;
    }

    @Encodable$Field(name = "storageMetrics")
    public f.c.a.b.i.x.a.e a() {
        return this.a;
    }
}
