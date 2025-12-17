package f.c.e.c;

import com.google.protobuf.d1;
import com.google.protobuf.r1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class s extends z<f.c.e.c.s, f.c.e.c.s.b> implements u0 {

    private static final f.c.e.c.s DEFAULT_INSTANCE = null;
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.c.s> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            s.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            s.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            s.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            s.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            s.a.a[z.f.GET_PARSER.ordinal()] = 5;
            s.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            s.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum c {

        EXISTS(true),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(false);

        private final int value;
        public static f.c.e.c.s.c forNumber(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return s.c.UPDATE_TIME;
                }
                return s.c.EXISTS;
            }
            return s.c.CONDITIONTYPE_NOT_SET;
        }

        @Deprecated
        public static f.c.e.c.s.c valueOf(int i) {
            return s.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class b extends z.a<f.c.e.c.s, f.c.e.c.s.b> implements u0 {
        private b() {
            super(s.b());
        }

        b(f.c.e.c.s.a s$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.s.b b(boolean z) {
            copyOnWrite();
            s.c((s)this.instance, z);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.s.b c(r1 r1) {
            copyOnWrite();
            s.d((s)this.instance, r1);
            return this;
        }
    }
    static {
        s sVar = new s();
        s.DEFAULT_INSTANCE = sVar;
        z.registerDefaultInstance(s.class, sVar);
    }

    private s() {
        super();
        final int i = 0;
    }

    static f.c.e.c.s b() {
        return s.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.s s, boolean z2) {
        s.j(z2);
    }

    static void d(f.c.e.c.s s, r1 r12) {
        s.k(r12);
    }

    public static f.c.e.c.s f() {
        return s.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.s.b i() {
        return (s.b)s.DEFAULT_INSTANCE.createBuilder();
    }

    private void j(boolean z) {
        this.conditionTypeCase_ = 1;
        this.conditionType_ = Boolean.valueOf(z);
    }

    private void k(r1 r1) {
        r1.getClass();
        this.conditionType_ = r1;
        this.conditionTypeCase_ = 2;
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
                obj2 = new s();
                return obj2;
            case 2:
                obj2 = new s.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = "conditionTypeCase_";
                obj2[2] = r1.class;
                return z.newMessageInfo(s.DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000", obj2);
            case 4:
                return s.DEFAULT_INSTANCE;
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
        obj3 = s.class;
        synchronized (obj3) {
            obj2 = new z.b(s.DEFAULT_INSTANCE);
            s.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.s.c e() {
        return s.c.forNumber(this.conditionTypeCase_);
    }

    @Override // com.google.protobuf.z
    public boolean g() {
        if (this.conditionTypeCase_ == 1) {
            return (Boolean)this.conditionType_.booleanValue();
        }
        return 0;
    }

    @Override // com.google.protobuf.z
    public r1 h() {
        if (this.conditionTypeCase_ == 2) {
            return (r1)this.conditionType_;
        }
        return r1.e();
    }
}
