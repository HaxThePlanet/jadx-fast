package f.c.f.a.a.a.e;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class c extends z<f.c.f.a.a.a.e.c, f.c.f.a.a.a.e.c.b> implements u0 {

    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int APP_INSTANCE_ID_TOKEN_FIELD_NUMBER = 3;
    private static final f.c.f.a.a.a.e.c DEFAULT_INSTANCE = null;
    public static final int GMP_APP_ID_FIELD_NUMBER = 1;
    private static volatile d1<f.c.f.a.a.a.e.c> PARSER;
    private String appInstanceIdToken_;
    private String appInstanceId_;
    private String gmpAppId_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            c.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            c.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            c.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            c.a.a[z.f.GET_PARSER.ordinal()] = 5;
            c.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            c.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.f.a.a.a.e.c, f.c.f.a.a.a.e.c.b> implements u0 {
        private b() {
            super(c.b());
        }

        b(f.c.f.a.a.a.e.c.a c$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.c.b b(String string) {
            copyOnWrite();
            c.d((c)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.c.b c(String string) {
            copyOnWrite();
            c.e((c)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.c.b d(String string) {
            copyOnWrite();
            c.c((c)this.instance, string);
            return this;
        }
    }
    static {
        c cVar = new c();
        c.DEFAULT_INSTANCE = cVar;
        z.registerDefaultInstance(c.class, cVar);
    }

    private c() {
        super();
        final String str = "";
        this.gmpAppId_ = str;
        this.appInstanceId_ = str;
        this.appInstanceIdToken_ = str;
    }

    static f.c.f.a.a.a.e.c b() {
        return c.DEFAULT_INSTANCE;
    }

    static void c(f.c.f.a.a.a.e.c c, String string2) {
        c.h(string2);
    }

    static void d(f.c.f.a.a.a.e.c c, String string2) {
        c.setAppInstanceId(string2);
    }

    static void e(f.c.f.a.a.a.e.c c, String string2) {
        c.g(string2);
    }

    public static f.c.f.a.a.a.e.c.b f() {
        return (c.b)c.DEFAULT_INSTANCE.createBuilder();
    }

    private void g(String string) {
        string.getClass();
        this.appInstanceIdToken_ = string;
    }

    private void h(String string) {
        string.getClass();
        this.gmpAppId_ = string;
    }

    private void setAppInstanceId(String string) {
        string.getClass();
        this.appInstanceId_ = string;
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
                obj2 = new c();
                return obj2;
            case 2:
                obj2 = new c.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "appInstanceId_";
                obj2[2] = "appInstanceIdToken_";
                return z.newMessageInfo(c.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", obj2);
            case 4:
                return c.DEFAULT_INSTANCE;
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
        obj3 = c.class;
        synchronized (obj3) {
            obj2 = new z.b(c.DEFAULT_INSTANCE);
            c.PARSER = obj2;
        }
    }
}
