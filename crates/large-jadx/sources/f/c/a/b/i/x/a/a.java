package f.c.a.b.i.x.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.proto.Protobuf;
import f.c.a.b.i.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    private final f.c.a.b.i.x.a.f a;
    private final List<f.c.a.b.i.x.a.d> b;
    private final f.c.a.b.i.x.a.b c;
    private final String d;

    public static final class a {

        private f.c.a.b.i.x.a.f a = null;
        private List<f.c.a.b.i.x.a.d> b;
        private f.c.a.b.i.x.a.b c = null;
        private String d;
        a() {
            super();
            int i = 0;
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.d = "";
        }

        public f.c.a.b.i.x.a.a.a a(f.c.a.b.i.x.a.d d) {
            this.b.add(d);
            return this;
        }

        public f.c.a.b.i.x.a.a b() {
            a aVar = new a(this.a, Collections.unmodifiableList(this.b), this.c, this.d);
            return aVar;
        }

        public f.c.a.b.i.x.a.a.a c(String string) {
            this.d = string;
            return this;
        }

        public f.c.a.b.i.x.a.a.a d(f.c.a.b.i.x.a.b b) {
            this.c = b;
            return this;
        }

        public f.c.a.b.i.x.a.a.a e(f.c.a.b.i.x.a.f f) {
            this.a = f;
            return this;
        }
    }
    static {
        a.a aVar = new a.a();
        aVar.b();
    }

    a(f.c.a.b.i.x.a.f f, List<f.c.a.b.i.x.a.d> list2, f.c.a.b.i.x.a.b b3, String string4) {
        super();
        this.a = f;
        this.b = list2;
        this.c = b3;
        this.d = string4;
    }

    public static f.c.a.b.i.x.a.a.a e() {
        a.a aVar = new a.a();
        return aVar;
    }

    public String a() {
        return this.d;
    }

    @Encodable$Field(name = "globalMetrics")
    public f.c.a.b.i.x.a.b b() {
        return this.c;
    }

    @Encodable$Field(name = "logSourceMetrics")
    public List<f.c.a.b.i.x.a.d> c() {
        return this.b;
    }

    @Encodable$Field(name = "window")
    public f.c.a.b.i.x.a.f d() {
        return this.a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
