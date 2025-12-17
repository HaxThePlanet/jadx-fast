package f.c.e.c;

import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class w extends z<f.c.e.c.w, f.c.e.c.w.b> implements u0 {

    private static final f.c.e.c.w DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.w> PARSER = null;
    public static final int READ_ONLY_FIELD_NUMBER = 2;
    public static final int READ_WRITE_FIELD_NUMBER = 3;
    private int modeCase_ = 0;
    private Object mode_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            w.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            w.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            w.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            w.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            w.a.a[z.f.GET_PARSER.ordinal()] = 5;
            w.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            w.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.w, f.c.e.c.w.b> implements u0 {
        private b() {
            super(w.b());
        }

        b(f.c.e.c.w.a w$a) {
            super();
        }
    }

    public static final class c extends z<f.c.e.c.w.c, f.c.e.c.w.c.a> implements u0 {

        private static final f.c.e.c.w.c DEFAULT_INSTANCE = null;
        private static volatile d1<f.c.e.c.w.c> PARSER = null;
        public static final int READ_TIME_FIELD_NUMBER = 2;
        private int consistencySelectorCase_ = 0;
        private Object consistencySelector_;
        static {
            w.c cVar = new w.c();
            w.c.DEFAULT_INSTANCE = cVar;
            z.registerDefaultInstance(w.c.class, cVar);
        }

        private c() {
            super();
            final int i = 0;
        }

        static f.c.e.c.w.c b() {
            return w.c.DEFAULT_INSTANCE;
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
                    obj2 = new w.c();
                    return obj2;
                case 2:
                    obj2 = new w.c.a(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[3];
                    obj2[obj3] = "consistencySelectorCase_";
                    obj2[2] = r1.class;
                    return z.newMessageInfo(w.c.DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002<\u0000", obj2);
                case 4:
                    return w.c.DEFAULT_INSTANCE;
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
            obj3 = w.c.class;
            synchronized (obj3) {
                obj2 = new z.b(w.c.DEFAULT_INSTANCE);
                w.c.PARSER = obj2;
            }
        }
    }

    public static final class d extends z<f.c.e.c.w.d, f.c.e.c.w.d.a> implements u0 {

        private static final f.c.e.c.w.d DEFAULT_INSTANCE = null;
        private static volatile d1<f.c.e.c.w.d> PARSER = null;
        public static final int RETRY_TRANSACTION_FIELD_NUMBER = 1;
        private j retryTransaction_;
        static {
            w.d dVar = new w.d();
            w.d.DEFAULT_INSTANCE = dVar;
            z.registerDefaultInstance(w.d.class, dVar);
        }

        private d() {
            super();
            this.retryTransaction_ = j.a;
        }

        static f.c.e.c.w.d b() {
            return w.d.DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj1;
            int obj2;
            int obj3;
            obj2 = 1;
            obj3 = 0;
            switch (obj1) {
                case 1:
                    obj1 = new w.d();
                    return obj1;
                case 2:
                    obj1 = new w.d.a(obj3);
                    return obj1;
                case 3:
                    obj1 = new Object[obj2];
                    obj1[0] = "retryTransaction_";
                    return z.newMessageInfo(w.d.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", obj1);
                case 4:
                    return w.d.DEFAULT_INSTANCE;
                case 5:
                    return obj1;
                case 6:
                    return Byte.valueOf(obj2);
                case 7:
                    return obj3;
                default:
                    obj1 = new UnsupportedOperationException();
                    throw obj1;
            }
            obj2 = w.d.class;
            synchronized (obj2) {
                obj1 = new z.b(w.d.DEFAULT_INSTANCE);
                w.d.PARSER = obj1;
            }
        }
    }
    static {
        w wVar = new w();
        w.DEFAULT_INSTANCE = wVar;
        z.registerDefaultInstance(w.class, wVar);
    }

    private w() {
        super();
        final int i = 0;
    }

    static f.c.e.c.w b() {
        return w.DEFAULT_INSTANCE;
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
                obj2 = new w();
                return obj2;
            case 2:
                obj2 = new w.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[4];
                obj2[obj3] = "modeCase_";
                obj2[2] = w.c.class;
                obj2[3] = w.d.class;
                return z.newMessageInfo(w.DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000", obj2);
            case 4:
                return w.DEFAULT_INSTANCE;
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
        obj3 = w.class;
        synchronized (obj3) {
            obj2 = new z.b(w.DEFAULT_INSTANCE);
            w.PARSER = obj2;
        }
    }
}
