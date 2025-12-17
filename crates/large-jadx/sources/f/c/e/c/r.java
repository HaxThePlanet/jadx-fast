package f.c.e.c;

import com.google.protobuf.d1;
import com.google.protobuf.m0;
import com.google.protobuf.n0;
import com.google.protobuf.u0;
import com.google.protobuf.y1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class r extends z<f.c.e.c.r, f.c.e.c.r.b> implements u0 {

    private static final f.c.e.c.r DEFAULT_INSTANCE = null;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.c.r> PARSER;
    private n0<String, f.c.e.c.x> fields_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            r.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            r.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            r.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            r.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            r.a.a[z.f.GET_PARSER.ordinal()] = 5;
            r.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            r.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    private static final class c {

        static final m0<String, f.c.e.c.x> a;
        static {
            r.c.a = m0.d(y1.b.STRING, "", y1.b.MESSAGE, x.q());
        }
    }

    public static final class b extends z.a<f.c.e.c.r, f.c.e.c.r.b> implements u0 {
        private b() {
            super(r.b());
        }

        b(f.c.e.c.r.a r$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public boolean b(String string) {
            string.getClass();
            return (r)this.instance.f().containsKey(string);
        }

        public f.c.e.c.r.b c(Map<String, f.c.e.c.x> map) {
            copyOnWrite();
            r.c((r)this.instance).putAll(map);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.r.b d(String string, f.c.e.c.x x2) {
            string.getClass();
            x2.getClass();
            copyOnWrite();
            r.c((r)this.instance).put(string, x2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.r.b e(String string) {
            string.getClass();
            copyOnWrite();
            r.c((r)this.instance).remove(string);
            return this;
        }
    }
    static {
        r rVar = new r();
        r.DEFAULT_INSTANCE = rVar;
        z.registerDefaultInstance(r.class, rVar);
    }

    private r() {
        super();
        this.fields_ = n0.e();
    }

    static f.c.e.c.r b() {
        return r.DEFAULT_INSTANCE;
    }

    static Map c(f.c.e.c.r r) {
        return r.i();
    }

    public static f.c.e.c.r d() {
        return r.DEFAULT_INSTANCE;
    }

    private Map<String, f.c.e.c.x> i() {
        return k();
    }

    private n0<String, f.c.e.c.x> j() {
        return this.fields_;
    }

    private n0<String, f.c.e.c.x> k() {
        boolean z;
        if (!this.fields_.j()) {
            this.fields_ = this.fields_.m();
        }
        return this.fields_;
    }

    public static f.c.e.c.r.b l() {
        return (r.b)r.DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj2;
        int obj3;
        int obj4;
        obj3 = 1;
        obj4 = 0;
        switch (obj2) {
            case 1:
                obj2 = new r();
                return obj2;
            case 2:
                obj2 = new r.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = r.c.a;
                return z.newMessageInfo(r.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", obj2);
            case 4:
                return r.DEFAULT_INSTANCE;
            case 5:
                return obj2;
            case 6:
                return Byte.valueOf(obj3);
            case 7:
                return obj4;
            default:
                obj2 = new UnsupportedOperationException();
                throw obj2;
        }
        obj3 = r.class;
        synchronized (obj3) {
            obj2 = new z.b(r.DEFAULT_INSTANCE);
            r.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public int e() {
        return j().size();
    }

    public Map<String, f.c.e.c.x> f() {
        return Collections.unmodifiableMap(j());
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.x g(String string, f.c.e.c.x x2) {
        Object obj3;
        Object obj4;
        string.getClass();
        final n0 n0Var = j();
        if (n0Var.containsKey(string)) {
            obj4 = obj3;
        }
        return obj4;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.x h(String string) {
        string.getClass();
        final n0 n0Var = j();
        if (!n0Var.containsKey(string)) {
        } else {
            return (x)n0Var.get(string);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }
}
