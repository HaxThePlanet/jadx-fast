package f.c.e.c;

import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class e extends z<f.c.e.c.e, f.c.e.c.e.b> implements u0 {

    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final f.c.e.c.e DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.e> PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    public static final int WRITES_FIELD_NUMBER = 2;
    private String database_;
    private j transaction_;
    private c0.j<f.c.e.c.y> writes_;

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

    public static final class b extends z.a<f.c.e.c.e, f.c.e.c.e.b> implements u0 {
        private b() {
            super(e.b());
        }

        b(f.c.e.c.e.a e$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.e.b b(f.c.e.c.y y) {
            copyOnWrite();
            e.d((e)this.instance, y);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.e.b c(String string) {
            copyOnWrite();
            e.c((e)this.instance, string);
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
        this.database_ = "";
        this.writes_ = z.emptyProtobufList();
        this.transaction_ = j.a;
    }

    private void addWrites(f.c.e.c.y y) {
        y.getClass();
        ensureWritesIsMutable();
        this.writes_.add(y);
    }

    static f.c.e.c.e b() {
        return e.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.e e, String string2) {
        e.g(string2);
    }

    static void d(f.c.e.c.e e, f.c.e.c.y y2) {
        e.addWrites(y2);
    }

    public static f.c.e.c.e e() {
        return e.DEFAULT_INSTANCE;
    }

    private void ensureWritesIsMutable() {
        c0.j mutableCopy;
        mutableCopy = this.writes_;
        if (!mutableCopy.c2()) {
            this.writes_ = z.mutableCopy(mutableCopy);
        }
    }

    public static f.c.e.c.e.b f() {
        return (e.b)e.DEFAULT_INSTANCE.createBuilder();
    }

    private void g(String string) {
        string.getClass();
        this.database_ = string;
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
                obj2 = new Object[4];
                obj2[obj3] = "writes_";
                obj2[2] = y.class;
                obj2[3] = "transaction_";
                return z.newMessageInfo(e.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\n", obj2);
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
}
