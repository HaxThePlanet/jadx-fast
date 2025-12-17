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
import java.util.Map;

/* loaded from: classes2.dex */
public final class p extends z<f.c.e.c.p, f.c.e.c.p.b> implements u0 {

    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final f.c.e.c.p DEFAULT_INSTANCE = null;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile d1<f.c.e.c.p> PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private String database_;
    private n0<String, String> labels_;
    private int targetChangeCase_ = 0;
    private Object targetChange_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            p.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            p.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            p.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            p.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            p.a.a[z.f.GET_PARSER.ordinal()] = 5;
            p.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            p.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    private static final class c {

        static final m0<String, String> a;
        static {
            y1.b sTRING = y1.b.STRING;
            final String str = "";
            p.c.a = m0.d(sTRING, str, sTRING, str);
        }
    }

    public static final class b extends z.a<f.c.e.c.p, f.c.e.c.p.b> implements u0 {
        private b() {
            super(p.b());
        }

        b(f.c.e.c.p.a p$a) {
            super();
        }

        public f.c.e.c.p.b b(Map<String, String> map) {
            copyOnWrite();
            p.c((p)this.instance).putAll(map);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.p.b c(f.c.e.c.u u) {
            copyOnWrite();
            p.e((p)this.instance, u);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.p.b d(String string) {
            copyOnWrite();
            p.d((p)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.p.b e(int i) {
            copyOnWrite();
            p.f((p)this.instance, i);
            return this;
        }
    }
    static {
        p pVar = new p();
        p.DEFAULT_INSTANCE = pVar;
        z.registerDefaultInstance(p.class, pVar);
    }

    private p() {
        super();
        int i = 0;
        this.labels_ = n0.e();
        this.database_ = "";
    }

    static f.c.e.c.p b() {
        return p.DEFAULT_INSTANCE;
    }

    static Map c(f.c.e.c.p p) {
        return p.h();
    }

    static void d(f.c.e.c.p p, String string2) {
        p.l(string2);
    }

    static void e(f.c.e.c.p p, f.c.e.c.u u2) {
        p.k(u2);
    }

    static void f(f.c.e.c.p p, int i2) {
        p.m(i2);
    }

    public static f.c.e.c.p g() {
        return p.DEFAULT_INSTANCE;
    }

    private Map<String, String> h() {
        return i();
    }

    private n0<String, String> i() {
        boolean z;
        if (!this.labels_.j()) {
            this.labels_ = this.labels_.m();
        }
        return this.labels_;
    }

    public static f.c.e.c.p.b j() {
        return (p.b)p.DEFAULT_INSTANCE.createBuilder();
    }

    private void k(f.c.e.c.u u) {
        u.getClass();
        this.targetChange_ = u;
        this.targetChangeCase_ = 2;
    }

    private void l(String string) {
        string.getClass();
        this.database_ = string;
    }

    private void m(int i) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i);
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
                obj2 = new p();
                return obj2;
            case 2:
                obj2 = new p.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[6];
                obj2[obj3] = "targetChangeCase_";
                obj2[2] = "database_";
                obj2[3] = u.class;
                obj2[4] = "labels_";
                obj2[5] = p.c.a;
                return z.newMessageInfo(p.DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", obj2);
            case 4:
                return p.DEFAULT_INSTANCE;
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
        obj3 = p.class;
        synchronized (obj3) {
            obj2 = new z.b(p.DEFAULT_INSTANCE);
            p.PARSER = obj2;
        }
    }
}
