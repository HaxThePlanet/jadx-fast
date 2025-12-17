package f.c.e.b;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import f.c.e.c.t;

/* loaded from: classes2.dex */
public final class a extends z<f.c.e.b.a, f.c.e.b.a.b> implements u0 {

    private static final f.c.e.b.a DEFAULT_INSTANCE = null;
    public static final int LIMIT_TYPE_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.b.a> PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    private int limitType_;
    private String parent_;
    private int queryTypeCase_ = 0;
    private Object queryType_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            a.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            a.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            a.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            a.a.a[z.f.GET_PARSER.ordinal()] = 5;
            a.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            a.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum c implements c0.c {

        FIRST(false),
        LAST(true),
        UNRECOGNIZED(-1);

        private final int value;
        public static f.c.e.b.a.c forNumber(int i) {
            if (i != 0 && i != 1) {
                if (i != 1) {
                    return null;
                }
                return a.c.LAST;
            }
            return a.c.FIRST;
        }

        public static c0.d<f.c.e.b.a.c> internalGetValueMap() {
            return a.c.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return a.c.b.a;
        }

        @Deprecated
        public static f.c.e.b.a.c valueOf(int i) {
            return a.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            if (this == a.c.UNRECOGNIZED) {
            } else {
                return this.value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
            throw illegalArgumentException;
        }
    }

    public static final class b extends z.a<f.c.e.b.a, f.c.e.b.a.b> implements u0 {
        private b() {
            super(a.b());
        }

        b(f.c.e.b.a.a a$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.b.a.b b(f.c.e.b.a.c a$c) {
            copyOnWrite();
            a.e((a)this.instance, c);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.b.a.b c(String string) {
            copyOnWrite();
            a.c((a)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.b.a.b d(t t) {
            copyOnWrite();
            a.d((a)this.instance, t);
            return this;
        }
    }
    static {
        a aVar = new a();
        a.DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    private a() {
        super();
        int i = 0;
        this.parent_ = "";
    }

    static f.c.e.b.a b() {
        return a.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.b.a a, String string2) {
        a.l(string2);
    }

    static void d(f.c.e.b.a a, t t2) {
        a.m(t2);
    }

    static void e(f.c.e.b.a a, f.c.e.b.a.c a$c2) {
        a.k(c2);
    }

    public static f.c.e.b.a.b i() {
        return (a.b)a.DEFAULT_INSTANCE.createBuilder();
    }

    public static f.c.e.b.a j(byte[] bArr) {
        return (a)z.parseFrom(a.DEFAULT_INSTANCE, bArr);
    }

    private void k(f.c.e.b.a.c a$c) {
        this.limitType_ = c.getNumber();
    }

    private void l(String string) {
        string.getClass();
        this.parent_ = string;
    }

    private void m(t t) {
        t.getClass();
        this.queryType_ = t;
        this.queryTypeCase_ = 2;
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
                obj2 = new a();
                return obj2;
            case 2:
                obj2 = new a.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "queryTypeCase_";
                obj2[2] = "parent_";
                obj2[3] = t.class;
                obj2[4] = "limitType_";
                return z.newMessageInfo(a.DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003\u000c", obj2);
            case 4:
                return a.DEFAULT_INSTANCE;
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
        obj3 = a.class;
        synchronized (obj3) {
            obj2 = new z.b(a.DEFAULT_INSTANCE);
            a.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public f.c.e.b.a.c f() {
        f.c.e.b.a.c uNRECOGNIZED;
        if (a.c.forNumber(this.limitType_) == null) {
            uNRECOGNIZED = a.c.UNRECOGNIZED;
        }
        return uNRECOGNIZED;
    }

    @Override // com.google.protobuf.z
    public String g() {
        return this.parent_;
    }

    @Override // com.google.protobuf.z
    public t h() {
        if (this.queryTypeCase_ == 2) {
            return (t)this.queryType_;
        }
        return t.m();
    }
}
