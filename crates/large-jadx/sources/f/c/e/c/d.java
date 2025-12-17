package f.c.e.c;

import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class d extends z<f.c.e.c.d, f.c.e.c.d.b> implements u0 {

    private static final f.c.e.c.d DEFAULT_INSTANCE = null;
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile d1<f.c.e.c.d> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private r1 readTime_;
    private int resultCase_ = 0;
    private Object result_;
    private j transaction_ = null;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            d.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            d.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            d.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            d.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            d.a.a[z.f.GET_PARSER.ordinal()] = 5;
            d.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            d.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static enum c {

        FOUND(true),
        MISSING(2),
        RESULT_NOT_SET(false);

        private final int value;
        public static f.c.e.c.d.c forNumber(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return d.c.MISSING;
                }
                return d.c.FOUND;
            }
            return d.c.RESULT_NOT_SET;
        }

        @Deprecated
        public static f.c.e.c.d.c valueOf(int i) {
            return d.c.forNumber(i);
        }

        @Override // java.lang.Enum
        public int getNumber() {
            return this.value;
        }
    }

    public static final class b extends z.a<f.c.e.c.d, f.c.e.c.d.b> implements u0 {
        private b() {
            super(d.b());
        }

        b(f.c.e.c.d.a d$a) {
            super();
        }
    }
    static {
        d dVar = new d();
        d.DEFAULT_INSTANCE = dVar;
        z.registerDefaultInstance(d.class, dVar);
    }

    private d() {
        super();
        int i = 0;
        j jVar = j.a;
    }

    static f.c.e.c.d b() {
        return d.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.d c() {
        return d.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.h d() {
        if (this.resultCase_ == 1) {
            return (h)this.result_;
        }
        return h.f();
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
                obj2 = new d();
                return obj2;
            case 2:
                obj2 = new d.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[5];
                obj2[obj3] = "resultCase_";
                obj2[2] = h.class;
                obj2[3] = "transaction_";
                obj2[4] = "readTime_";
                return z.newMessageInfo(d.DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\n\u0004\t", obj2);
            case 4:
                return d.DEFAULT_INSTANCE;
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
        obj3 = d.class;
        synchronized (obj3) {
            obj2 = new z.b(d.DEFAULT_INSTANCE);
            d.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public String e() {
        Object result_;
        if (this.resultCase_ == 2) {
            result_ = this.result_;
        } else {
            result_ = "";
        }
        return result_;
    }

    @Override // com.google.protobuf.z
    public f.c.e.c.d.c f() {
        return d.c.forNumber(this.resultCase_);
    }

    @Override // com.google.protobuf.z
    public r1 getReadTime() {
        r1 readTime_;
        if (this.readTime_ == null) {
            readTime_ = r1.e();
        }
        return readTime_;
    }
}
