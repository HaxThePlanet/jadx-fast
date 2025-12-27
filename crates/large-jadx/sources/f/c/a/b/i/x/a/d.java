package f.c.a.b.i.x.a;

import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: LogSourceMetrics.java */
/* loaded from: classes.dex */
public final class d {

    private final String a;
    private final List<c> b;

    public static final class a {

        private String a = "";
        private List<c> b = new ArrayList<>();
        a() {
            super();
            ArrayList arrayList = new ArrayList();
        }

        public d a() {
            return new d(this.a, Collections.unmodifiableList(this.b));
        }

        public d.a b(List<c> list) {
            this.b = list;
            return this;
        }

        public d.a c(String str) {
            this.a = str;
            return this;
        }
    }
    static {
        new d.a().a();
    }

    d(String str, List<c> list) {
        super();
        this.a = str;
        this.b = list;
    }

    public static d.a c() {
        return new d.a();
    }

    @Encodable.Field(name = "logEventDropped")
    public List<c> a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }
}
