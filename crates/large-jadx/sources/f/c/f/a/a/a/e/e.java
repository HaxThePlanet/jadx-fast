package f.c.f.a.a.a.e;

import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import f.c.f.a.a.a.c;
import java.util.List;

/* loaded from: classes2.dex */
public final class e extends z<f.c.f.a.a.a.e.e, f.c.f.a.a.a.e.e.b> implements u0 {

    private static final f.c.f.a.a.a.e.e DEFAULT_INSTANCE = null;
    public static final int EXPIRATION_EPOCH_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile d1<f.c.f.a.a.a.e.e> PARSER;
    private long expirationEpochTimestampMillis_;
    private c0.j<c> messages_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            e.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            e.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            e.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            e.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            e.a.a[z.f.GET_PARSER.ordinal()] = 5;
            e.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            e.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.f.a.a.a.e.e, f.c.f.a.a.a.e.e.b> implements u0 {
        private b() {
            super(e.b());
        }

        b(f.c.f.a.a.a.e.e.a e$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.f.a.a.a.e.e.b b(long l) {
            copyOnWrite();
            e.c((e)this.instance, l);
            return this;
        }
    }
    static {
        e eVar = new e();
        e.DEFAULT_INSTANCE = eVar;
        z.registerDefaultInstance(e.class, eVar);
    }

    private e() {
        super();
        this.messages_ = z.emptyProtobufList();
    }

    static f.c.f.a.a.a.e.e b() {
        return e.DEFAULT_INSTANCE;
    }

    static void c(f.c.f.a.a.a.e.e e, long l2) {
        e.h(l2);
    }

    public static f.c.f.a.a.a.e.e d() {
        return e.DEFAULT_INSTANCE;
    }

    public static f.c.f.a.a.a.e.e.b g() {
        return (e.b)e.DEFAULT_INSTANCE.createBuilder();
    }

    private void h(long l) {
        this.expirationEpochTimestampMillis_ = l;
    }

    public static d1<f.c.f.a.a.a.e.e> parser() {
        return e.DEFAULT_INSTANCE.getParserForType();
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
                obj2 = new e();
                return obj2;
            case 2:
                obj2 = new e.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = c.class;
                obj2[2] = "expirationEpochTimestampMillis_";
                return z.newMessageInfo(e.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", obj2);
            case 4:
                return e.DEFAULT_INSTANCE;
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
        obj3 = e.class;
        synchronized (obj3) {
            obj2 = new z.b(e.DEFAULT_INSTANCE);
            e.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public long e() {
        return this.expirationEpochTimestampMillis_;
    }

    public List<c> f() {
        return this.messages_;
    }
}
