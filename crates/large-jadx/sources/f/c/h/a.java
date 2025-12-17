package f.c.h;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class a extends z<f.c.h.a, f.c.h.a.b> implements u0 {

    public static final int DAY_FIELD_NUMBER = 3;
    private static final f.c.h.a DEFAULT_INSTANCE = null;
    public static final int MONTH_FIELD_NUMBER = 2;
    private static volatile d1<f.c.h.a> PARSER = null;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int day_;
    private int month_;
    private int year_;

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

    public static final class b extends z.a<f.c.h.a, f.c.h.a.b> implements u0 {
        private b() {
            super(a.b());
        }

        b(f.c.h.a.a a$a) {
            super();
        }
    }
    static {
        a aVar = new a();
        a.DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    static f.c.h.a b() {
        return a.DEFAULT_INSTANCE;
    }

    public static f.c.h.a c() {
        return a.DEFAULT_INSTANCE;
    }

    public static f.c.h.a.b d(f.c.h.a a) {
        return (a.b)a.DEFAULT_INSTANCE.createBuilder(a);
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
                obj2 = new Object[3];
                obj2[obj3] = "month_";
                obj2[2] = "day_";
                return z.newMessageInfo(a.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004", obj2);
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
}
