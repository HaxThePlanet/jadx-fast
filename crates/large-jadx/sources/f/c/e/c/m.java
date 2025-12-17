package f.c.e.c;

import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class m extends z<f.c.e.c.m, f.c.e.c.m.b> implements u0 {

    private static final f.c.e.c.m DEFAULT_INSTANCE = null;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile d1<f.c.e.c.m> PARSER;
    private String document_;
    private c0.j<f.c.e.c.m.c> fieldTransforms_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            m.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            m.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            m.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            m.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            m.a.a[z.f.GET_PARSER.ordinal()] = 5;
            m.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            m.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.m, f.c.e.c.m.b> implements u0 {
        private b() {
            super(m.b());
        }

        b(f.c.e.c.m.a m$a) {
            super();
        }
    }

    public static final class c extends z<f.c.e.c.m.c, f.c.e.c.m.c.a> implements u0 {

        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final f.c.e.c.m.c DEFAULT_INSTANCE = null;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile d1<f.c.e.c.m.c> PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private String fieldPath_;
        private int transformTypeCase_ = 0;
        private Object transformType_;
        static {
            m.c cVar = new m.c();
            m.c.DEFAULT_INSTANCE = cVar;
            z.registerDefaultInstance(m.c.class, cVar);
        }

        private c() {
            super();
            int i = 0;
            this.fieldPath_ = "";
        }

        static f.c.e.c.m.c b() {
            return m.c.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.c.m.c m$c, f.c.e.c.a a2) {
            c.o(a2);
        }

        static void d(f.c.e.c.m.c m$c, String string2) {
            c.p(string2);
        }

        static void e(f.c.e.c.m.c m$c, f.c.e.c.a a2) {
            c.r(a2);
        }

        static void f(f.c.e.c.m.c m$c, f.c.e.c.m.c.b m$c$b2) {
            c.s(b2);
        }

        static void g(f.c.e.c.m.c m$c, f.c.e.c.x x2) {
            c.q(x2);
        }

        public static f.c.e.c.m.c.a n() {
            return (m.c.a)m.c.DEFAULT_INSTANCE.createBuilder();
        }

        private void o(f.c.e.c.a a) {
            a.getClass();
            this.transformType_ = a;
            this.transformTypeCase_ = 6;
        }

        private void p(String string) {
            string.getClass();
            this.fieldPath_ = string;
        }

        private void q(f.c.e.c.x x) {
            x.getClass();
            this.transformType_ = x;
            this.transformTypeCase_ = 3;
        }

        private void r(f.c.e.c.a a) {
            a.getClass();
            this.transformType_ = a;
            this.transformTypeCase_ = 7;
        }

        private void s(f.c.e.c.m.c.b m$c$b) {
            this.transformType_ = Integer.valueOf(b.getNumber());
            this.transformTypeCase_ = 2;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj4;
            Class<f.c.e.c.a> obj5;
            Class<f.c.e.c.x> obj6;
            obj5 = a.class;
            obj6 = x.class;
            int i = 1;
            int i6 = 0;
            switch (obj4) {
                case 1:
                    obj4 = new m.c();
                    return obj4;
                case 2:
                    obj4 = new m.c.a(i6);
                    return obj4;
                case 3:
                    obj4 = new Object[8];
                    obj4[i] = "transformTypeCase_";
                    obj4[2] = "fieldPath_";
                    obj4[3] = obj6;
                    obj4[4] = obj6;
                    obj4[5] = obj6;
                    obj4[6] = obj5;
                    obj4[7] = obj5;
                    return z.newMessageInfo(m.c.DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", obj4);
                case 4:
                    return m.c.DEFAULT_INSTANCE;
                case 5:
                    return obj4;
                case 6:
                    return Byte.valueOf(i);
                case 7:
                    return i6;
                default:
                    obj4 = new UnsupportedOperationException();
                    throw obj4;
            }
            obj5 = m.c.class;
            synchronized (obj5) {
                obj4 = new z.b(m.c.DEFAULT_INSTANCE);
                m.c.PARSER = obj4;
            }
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.a h() {
            if (this.transformTypeCase_ == 6) {
                return (a)this.transformType_;
            }
            return a.i();
        }

        @Override // com.google.protobuf.z
        public String i() {
            return this.fieldPath_;
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.x j() {
            if (this.transformTypeCase_ == 3) {
                return (x)this.transformType_;
            }
            return x.q();
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.a k() {
            if (this.transformTypeCase_ == 7) {
                return (a)this.transformType_;
            }
            return a.i();
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.m.c.b l() {
            f.c.e.c.m.c.b uNRECOGNIZED;
            if (this.transformTypeCase_ == 2 && m.c.b.forNumber((Integer)this.transformType_.intValue()) == null) {
                if (m.c.b.forNumber((Integer)this.transformType_.intValue()) == null) {
                    uNRECOGNIZED = m.c.b.UNRECOGNIZED;
                }
                return uNRECOGNIZED;
            }
            return m.c.b.SERVER_VALUE_UNSPECIFIED;
        }

        @Override // com.google.protobuf.z
        public f.c.e.c.m.c.c m() {
            return m.c.c.forNumber(this.transformTypeCase_);
        }
    }
    static {
        m mVar = new m();
        m.DEFAULT_INSTANCE = mVar;
        z.registerDefaultInstance(m.class, mVar);
    }

    private m() {
        super();
        this.document_ = "";
        this.fieldTransforms_ = z.emptyProtobufList();
    }

    static f.c.e.c.m b() {
        return m.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.m c() {
        return m.DEFAULT_INSTANCE;
    }

    public List<f.c.e.c.m.c> d() {
        return this.fieldTransforms_;
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
                obj2 = new m();
                return obj2;
            case 2:
                obj2 = new m.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "fieldTransforms_";
                obj2[2] = m.c.class;
                return z.newMessageInfo(m.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", obj2);
            case 4:
                return m.DEFAULT_INSTANCE;
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
        obj3 = m.class;
        synchronized (obj3) {
            obj2 = new z.b(m.DEFAULT_INSTANCE);
            m.PARSER = obj2;
        }
    }
}
