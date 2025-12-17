package f.c.h;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class b extends z<f.c.h.b, f.c.h.b.b> implements u0 {

    private static final f.c.h.b DEFAULT_INSTANCE = null;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile d1<f.c.h.b> PARSER;
    private double latitude_;
    private double longitude_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            b.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            b.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            b.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            b.a.a[z.f.GET_PARSER.ordinal()] = 5;
            b.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            b.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.h.b, f.c.h.b.b> implements u0 {
        private b() {
            super(b.b());
        }

        b(f.c.h.b.a b$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.h.b.b b(double d) {
            copyOnWrite();
            b.c((b)this.instance, d);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.h.b.b c(double d) {
            copyOnWrite();
            b.d((b)this.instance, d);
            return this;
        }
    }
    static {
        b bVar = new b();
        b.DEFAULT_INSTANCE = bVar;
        z.registerDefaultInstance(b.class, bVar);
    }

    static f.c.h.b b() {
        return b.DEFAULT_INSTANCE;
    }

    static void c(f.c.h.b b, double d2) {
        b.i(d2);
    }

    static void d(f.c.h.b b, double d2) {
        b.j(d2);
    }

    public static f.c.h.b e() {
        return b.DEFAULT_INSTANCE;
    }

    public static f.c.h.b.b h() {
        return (b.b)b.DEFAULT_INSTANCE.createBuilder();
    }

    private void i(double d) {
        this.latitude_ = d;
    }

    private void j(double d) {
        this.longitude_ = d;
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
                obj2 = new b.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "longitude_";
                return z.newMessageInfo(b.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", obj2);
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

    @Override // com.google.protobuf.z
    public double f() {
        return this.latitude_;
    }

    @Override // com.google.protobuf.z
    public double g() {
        return this.longitude_;
    }
}
