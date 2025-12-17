package f.c.d.a.a.a;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class b extends z<f.c.d.a.a.a.b, f.c.d.a.a.a.b.a> implements u0 {

    public static final int APP_VERSION_FIELD_NUMBER = 1;
    private static final f.c.d.a.a.a.b DEFAULT_INSTANCE = null;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    private static volatile d1<f.c.d.a.a.a.b> PARSER = null;
    public static final int PLATFORM_VERSION_FIELD_NUMBER = 2;
    public static final int TIME_ZONE_FIELD_NUMBER = 4;
    private String appVersion_;
    private String languageCode_;
    private String platformVersion_;
    private String timeZone_;

    public static final class a extends z.a<f.c.d.a.a.a.b, f.c.d.a.a.a.b.a> implements u0 {
        private a() {
            super(b.b());
        }

        a(f.c.d.a.a.a.a a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.d.a.a.a.b.a b(String string) {
            copyOnWrite();
            b.c((b)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.d.a.a.a.b.a c(String string) {
            copyOnWrite();
            b.f((b)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.d.a.a.a.b.a d(String string) {
            copyOnWrite();
            b.e((b)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.d.a.a.a.b.a e(String string) {
            copyOnWrite();
            b.d((b)this.instance, string);
            return this;
        }
    }
    static {
        b bVar = new b();
        b.DEFAULT_INSTANCE = bVar;
        z.registerDefaultInstance(b.class, bVar);
    }

    private b() {
        super();
        final String str = "";
        this.appVersion_ = str;
        this.platformVersion_ = str;
        this.languageCode_ = str;
        this.timeZone_ = str;
    }

    static f.c.d.a.a.a.b b() {
        return b.DEFAULT_INSTANCE;
    }

    static void c(f.c.d.a.a.a.b b, String string2) {
        b.h(string2);
    }

    static void d(f.c.d.a.a.a.b b, String string2) {
        b.setTimeZone(string2);
    }

    static void e(f.c.d.a.a.a.b b, String string2) {
        b.j(string2);
    }

    static void f(f.c.d.a.a.a.b b, String string2) {
        b.i(string2);
    }

    public static f.c.d.a.a.a.b.a g() {
        return (b.a)b.DEFAULT_INSTANCE.createBuilder();
    }

    private void h(String string) {
        string.getClass();
        this.appVersion_ = string;
    }

    private void i(String string) {
        string.getClass();
        this.languageCode_ = string;
    }

    private void j(String string) {
        string.getClass();
        this.platformVersion_ = string;
    }

    private void setTimeZone(String string) {
        string.getClass();
        this.timeZone_ = string;
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
                obj2 = new b();
                return obj2;
            case 2:
                obj2 = new b.a(obj4);
                return obj2;
            case 3:
                obj2 = new Object[4];
                obj2[obj3] = "platformVersion_";
                obj2[2] = "languageCode_";
                obj2[3] = "timeZone_";
                return z.newMessageInfo(b.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", obj2);
            case 4:
                return b.DEFAULT_INSTANCE;
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
        obj3 = b.class;
        synchronized (obj3) {
            obj2 = new z.b(b.DEFAULT_INSTANCE);
            b.PARSER = obj2;
        }
    }
}
