package f.c.e.a.a;

import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends z<f.c.e.a.a.a, f.c.e.a.a.a.b> implements u0 {

    private static final f.c.e.a.a.a DEFAULT_INSTANCE = null;
    public static final int FIELDS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.a.a.a> PARSER = null;
    public static final int QUERY_SCOPE_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 4;
    private c0.j<f.c.e.a.a.a.c> fields_;
    private String name_;
    private int queryScope_;
    private int state_;

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

    public static enum d implements c0.c {

        QUERY_SCOPE_UNSPECIFIED(false),
        COLLECTION(true),
        COLLECTION_GROUP(2),
        UNRECOGNIZED(-1);

        private final int value;
        public static f.c.e.a.a.a.d forNumber(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return a.d.COLLECTION_GROUP;
                }
                return a.d.COLLECTION;
            }
            return a.d.QUERY_SCOPE_UNSPECIFIED;
        }

        public static c0.d<f.c.e.a.a.a.d> internalGetValueMap() {
            return a.d.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return a.d.b.a;
        }

        @Deprecated
        public static f.c.e.a.a.a.d valueOf(int i) {
            return a.d.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            if (this == a.d.UNRECOGNIZED) {
            } else {
                return this.value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
            throw illegalArgumentException;
        }
    }

    public static final class b extends z.a<f.c.e.a.a.a, f.c.e.a.a.a.b> implements u0 {
        private b() {
            super(a.b());
        }

        b(f.c.e.a.a.a.a a$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.a.a.a.b b(f.c.e.a.a.a.c.b a$c$b) {
            copyOnWrite();
            a.d((a)this.instance, (a.c)b.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.a.a.a.b c(f.c.e.a.a.a.d a$d) {
            copyOnWrite();
            a.c((a)this.instance, d);
            return this;
        }
    }

    public static final class c extends z<f.c.e.a.a.a.c, f.c.e.a.a.a.c.b> implements u0 {

        public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
        private static final f.c.e.a.a.a.c DEFAULT_INSTANCE = null;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        private static volatile d1<f.c.e.a.a.a.c> PARSER;
        private String fieldPath_;
        private int valueModeCase_ = 0;
        private Object valueMode_;
        static {
            a.c cVar = new a.c();
            a.c.DEFAULT_INSTANCE = cVar;
            z.registerDefaultInstance(a.c.class, cVar);
        }

        private c() {
            super();
            int i = 0;
            this.fieldPath_ = "";
        }

        static f.c.e.a.a.a.c b() {
            return a.c.DEFAULT_INSTANCE;
        }

        static void c(f.c.e.a.a.a.c a$c, String string2) {
            c.j(string2);
        }

        static void d(f.c.e.a.a.a.c a$c, f.c.e.a.a.a.c.c a$c$c2) {
            c.k(c2);
        }

        static void e(f.c.e.a.a.a.c a$c, f.c.e.a.a.a.c.a a$c$a2) {
            c.i(a2);
        }

        public static f.c.e.a.a.a.c.b h() {
            return (a.c.b)a.c.DEFAULT_INSTANCE.createBuilder();
        }

        private void i(f.c.e.a.a.a.c.a a$c$a) {
            this.valueMode_ = Integer.valueOf(a.getNumber());
            this.valueModeCase_ = 3;
        }

        private void j(String string) {
            string.getClass();
            this.fieldPath_ = string;
        }

        private void k(f.c.e.a.a.a.c.c a$c$c) {
            this.valueMode_ = Integer.valueOf(c.getNumber());
            this.valueModeCase_ = 2;
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
                    obj2 = new a.c();
                    return obj2;
                case 2:
                    obj2 = new a.c.b(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[3];
                    obj2[obj3] = "valueModeCase_";
                    obj2[2] = "fieldPath_";
                    return z.newMessageInfo(a.c.DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", obj2);
                case 4:
                    return a.c.DEFAULT_INSTANCE;
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
            obj3 = a.c.class;
            synchronized (obj3) {
                obj2 = new z.b(a.c.DEFAULT_INSTANCE);
                a.c.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public String f() {
            return this.fieldPath_;
        }

        @Override // com.google.protobuf.z
        public f.c.e.a.a.a.c.d g() {
            return a.c.d.forNumber(this.valueModeCase_);
        }
    }
    static {
        a aVar = new a();
        a.DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    private a() {
        super();
        this.name_ = "";
        this.fields_ = z.emptyProtobufList();
    }

    static f.c.e.a.a.a b() {
        return a.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.a.a.a a, f.c.e.a.a.a.d a$d2) {
        a.j(d2);
    }

    static void d(f.c.e.a.a.a a, f.c.e.a.a.a.c a$c2) {
        a.e(c2);
    }

    private void e(f.c.e.a.a.a.c a$c) {
        c.getClass();
        f();
        this.fields_.add(c);
    }

    private void f() {
        c0.j mutableCopy;
        mutableCopy = this.fields_;
        if (!mutableCopy.c2()) {
            this.fields_ = z.mutableCopy(mutableCopy);
        }
    }

    public static f.c.e.a.a.a.b h() {
        return (a.b)a.DEFAULT_INSTANCE.createBuilder();
    }

    public static f.c.e.a.a.a i(byte[] bArr) {
        return (a)z.parseFrom(a.DEFAULT_INSTANCE, bArr);
    }

    private void j(f.c.e.a.a.a.d a$d) {
        this.queryScope_ = d.getNumber();
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
                obj2[obj3] = "queryScope_";
                obj2[2] = "fields_";
                obj2[3] = a.c.class;
                obj2[4] = "state_";
                return z.newMessageInfo(a.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u000c\u0003\u001b\u0004\u000c", obj2);
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

    public List<f.c.e.a.a.a.c> g() {
        return this.fields_;
    }
}
