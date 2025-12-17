package f.c.e.c;

import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class n extends z<f.c.e.c.n, f.c.e.c.n.b> implements u0 {

    public static final int COUNT_FIELD_NUMBER = 2;
    private static final f.c.e.c.n DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.n> PARSER = null;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int count_;
    private int targetId_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            n.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            n.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            n.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            n.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            n.a.a[z.f.GET_PARSER.ordinal()] = 5;
            n.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            n.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.n, f.c.e.c.n.b> implements u0 {
        private b() {
            super(n.b());
        }

        b(f.c.e.c.n.a n$a) {
            super();
        }
    }
    static {
        n nVar = new n();
        n.DEFAULT_INSTANCE = nVar;
        z.registerDefaultInstance(n.class, nVar);
    }

    static f.c.e.c.n b() {
        return n.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.n c() {
        return n.DEFAULT_INSTANCE;
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
                obj2 = new n();
                return obj2;
            case 2:
                obj2 = new n.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = "count_";
                return z.newMessageInfo(n.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", obj2);
            case 4:
                return n.DEFAULT_INSTANCE;
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
        obj3 = n.class;
        synchronized (obj3) {
            obj2 = new z.b(n.DEFAULT_INSTANCE);
            n.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public int getCount() {
        return this.count_;
    }

    @Override // com.google.protobuf.z
    public int getTargetId() {
        return this.targetId_;
    }
}
