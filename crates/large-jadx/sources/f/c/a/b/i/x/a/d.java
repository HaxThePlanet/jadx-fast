package f.c.a.b.i.x.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    private final String a;
    private final List<f.c.a.b.i.x.a.c> b;

    public static final class a {

        private String a;
        private List<f.c.a.b.i.x.a.c> b;
        a() {
            super();
            this.a = "";
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
        }

        public f.c.a.b.i.x.a.d a() {
            d dVar = new d(this.a, Collections.unmodifiableList(this.b));
            return dVar;
        }

        public f.c.a.b.i.x.a.d.a b(List<f.c.a.b.i.x.a.c> list) {
            this.b = list;
            return this;
        }

        public f.c.a.b.i.x.a.d.a c(String string) {
            this.a = string;
            return this;
        }
    }
    static {
        d.a aVar = new d.a();
        aVar.a();
    }

    d(String string, List<f.c.a.b.i.x.a.c> list2) {
        super();
        this.a = string;
        this.b = list2;
    }

    public static f.c.a.b.i.x.a.d.a c() {
        d.a aVar = new d.a();
        return aVar;
    }

    @Encodable$Field(name = "logEventDropped")
    public List<f.c.a.b.i.x.a.c> a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }
}
