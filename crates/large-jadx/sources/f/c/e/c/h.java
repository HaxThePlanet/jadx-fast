package f.c.e.c;

import com.google.protobuf.d1;
import com.google.protobuf.m0;
import com.google.protobuf.n0;
import com.google.protobuf.r1;
import com.google.protobuf.u0;
import com.google.protobuf.y1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class h extends z<f.c.e.c.h, f.c.e.c.h.b> implements u0 {

    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final f.c.e.c.h DEFAULT_INSTANCE = null;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.c.h> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private r1 createTime_;
    private n0<String, f.c.e.c.x> fields_;
    private String name_;
    private r1 updateTime_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            h.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            h.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            h.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            h.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            h.a.a[z.f.GET_PARSER.ordinal()] = 5;
            h.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            h.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    private static final class c {

        static final m0<String, f.c.e.c.x> a;
        static {
            h.c.a = m0.d(y1.b.STRING, "", y1.b.MESSAGE, x.q());
        }
    }

    public static final class b extends z.a<f.c.e.c.h, f.c.e.c.h.b> implements u0 {
        private b() {
            super(h.b());
        }

        b(f.c.e.c.h.a h$a) {
            super();
        }

        public f.c.e.c.h.b b(Map<String, f.c.e.c.x> map) {
            copyOnWrite();
            h.d((h)this.instance).putAll(map);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.h.b c(String string) {
            copyOnWrite();
            h.c((h)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.h.b d(r1 r1) {
            copyOnWrite();
            h.e((h)this.instance, r1);
            return this;
        }
    }
    static {
        h hVar = new h();
        h.DEFAULT_INSTANCE = hVar;
        z.registerDefaultInstance(h.class, hVar);
    }

    private h() {
        super();
        this.fields_ = n0.e();
        this.name_ = "";
    }

    static f.c.e.c.h b() {
        return h.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.h h, String string2) {
        h.setName(string2);
    }

    static Map d(f.c.e.c.h h) {
        return h.h();
    }

    static void e(f.c.e.c.h h, r1 r12) {
        h.n(r12);
    }

    public static f.c.e.c.h f() {
        return h.DEFAULT_INSTANCE;
    }

    private Map<String, f.c.e.c.x> h() {
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

    public static f.c.e.c.h.b l() {
        return (h.b)h.DEFAULT_INSTANCE.createBuilder();
    }

    public static f.c.e.c.h.b m(f.c.e.c.h h) {
        return (h.b)h.DEFAULT_INSTANCE.createBuilder(h);
    }

    private void n(r1 r1) {
        r1.getClass();
        this.updateTime_ = r1;
    }

    private void setName(String string) {
        string.getClass();
        this.name_ = string;
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
                obj2 = new h();
                return obj2;
            case 2:
                obj2 = new h.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "fields_";
                obj2[2] = h.c.a;
                obj2[3] = "createTime_";
                obj2[4] = "updateTime_";
                return z.newMessageInfo(h.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u00022\u0003\t\u0004\t", obj2);
            case 4:
                return h.DEFAULT_INSTANCE;
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
        obj3 = h.class;
        synchronized (obj3) {
            obj2 = new z.b(h.DEFAULT_INSTANCE);
            h.PARSER = obj2;
        }
    }

    public Map<String, f.c.e.c.x> g() {
        return Collections.unmodifiableMap(j());
    }

    @Override // com.google.protobuf.z
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.z
    public r1 i() {
        r1 updateTime_;
        if (this.updateTime_ == null) {
            updateTime_ = r1.e();
        }
        return updateTime_;
    }
}
