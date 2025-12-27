package f.c.a.b.i.x.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.proto.Protobuf;
import f.c.a.b.i.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ClientMetrics.java */
/* loaded from: classes.dex */
public final class a {

    private final f a;
    private final List<d> b;
    private final b c;
    private final String d;

    public static final class a {

        private f a = null;
        private List<d> b = new ArrayList<>();
        private b c = null;
        private String d = "";
        a() {
            super();
            final ArrayList arrayList = new ArrayList();
        }

        public a.a a(d dVar) {
            this.b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.a, Collections.unmodifiableList(this.b), this.c, this.d);
        }

        public a.a c(String str) {
            this.d = str;
            return this;
        }

        public a.a d(b bVar) {
            this.c = bVar;
            return this;
        }

        public a.a e(f fVar) {
            this.a = fVar;
            return this;
        }
    }
    static {
        new a.a().b();
    }

    a(f fVar, List<d> list, b bVar, String str) {
        super();
        this.a = fVar;
        this.b = list;
        this.c = bVar;
        this.d = str;
    }

    public static a.a e() {
        return new a.a();
    }

    public String a() {
        return this.d;
    }

    @Encodable.Field(name = "globalMetrics")
    public b b() {
        return this.c;
    }

    @Encodable.Field(name = "logSourceMetrics")
    public List<d> c() {
        return this.b;
    }

    @Encodable.Field(name = "window")
    public f d() {
        return this.a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
