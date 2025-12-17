package f.c.g;

import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.e;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;

/* loaded from: classes2.dex */
public final class a extends z<f.c.g.a, f.c.g.a.b> implements u0 {

    public static final int CODE_FIELD_NUMBER = 1;
    private static final f.c.g.a DEFAULT_INSTANCE = null;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile d1<f.c.g.a> PARSER;
    private int code_;
    private c0.j<e> details_;
    private String message_;

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

    public static final class b extends z.a<f.c.g.a, f.c.g.a.b> implements u0 {
        private b() {
            super(a.b());
        }

        b(f.c.g.a.a a$a) {
            super();
        }
    }
    static {
        a aVar = new a();
        a.DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    private a() {
        super();
        this.message_ = "";
        this.details_ = z.emptyProtobufList();
    }

    static f.c.g.a b() {
        return a.DEFAULT_INSTANCE;
    }

    public static f.c.g.a d() {
        return a.DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.z
    public int c() {
        return this.code_;
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
                obj2 = new Object[4];
                obj2[obj3] = "message_";
                obj2[2] = "details_";
                obj2[3] = e.class;
                return z.newMessageInfo(a.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u001b", obj2);
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
    public String e() {
        return this.message_;
    }
}
