package f.c.h;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class c extends z<f.c.h.c, f.c.h.c.b> implements u0 {

    private static final f.c.h.c DEFAULT_INSTANCE = null;
    public static final int HOURS_FIELD_NUMBER = 1;
    public static final int MINUTES_FIELD_NUMBER = 2;
    public static final int NANOS_FIELD_NUMBER = 4;
    private static volatile d1<f.c.h.c> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 3;
    private int hours_;
    private int minutes_;
    private int nanos_;
    private int seconds_;

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

    public static final class b extends z.a<f.c.h.c, f.c.h.c.b> implements u0 {
        private b() {
            super(c.b());
        }

        b(f.c.h.c.a c$a) {
            super();
        }
    }
    static {
        c cVar = new c();
        c.DEFAULT_INSTANCE = cVar;
        z.registerDefaultInstance(c.class, cVar);
    }

    static f.c.h.c b() {
        return c.DEFAULT_INSTANCE;
    }

    public static f.c.h.c c() {
        return c.DEFAULT_INSTANCE;
    }

    public static f.c.h.c.b d(f.c.h.c c) {
        return (c.b)c.DEFAULT_INSTANCE.createBuilder(c);
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
                obj2 = new Object[4];
                obj2[obj3] = "minutes_";
                obj2[2] = "seconds_";
                obj2[3] = "nanos_";
                return z.newMessageInfo(c.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004", obj2);
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
