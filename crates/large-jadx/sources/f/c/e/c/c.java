package f.c.e.c;

import android.accounts.Account;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class c extends z<f.c.e.c.c, f.c.e.c.c.b> implements u0 {

    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final f.c.e.c.c DEFAULT_INSTANCE = null;
    public static final int DOCUMENTS_FIELD_NUMBER = 2;
    public static final int MASK_FIELD_NUMBER = 3;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    private static volatile d1<f.c.e.c.c> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private int consistencySelectorCase_ = 0;
    private Object consistencySelector_;
    private String database_;
    private c0.j<String> documents_;
    private f.c.e.c.k mask_;

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

    public static final class b extends z.a<f.c.e.c.c, f.c.e.c.c.b> implements u0 {
        private b() {
            super(c.b());
        }

        b(f.c.e.c.c.a c$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.c.b b(String string) {
            copyOnWrite();
            c.d((c)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.c.b c(String string) {
            copyOnWrite();
            c.c((c)this.instance, string);
            return this;
        }
    }
    static {
        c cVar = new c();
        c.DEFAULT_INSTANCE = cVar;
        z.registerDefaultInstance(c.class, cVar);
    }

    private c() {
        super();
        int i = 0;
        this.database_ = "";
        this.documents_ = z.emptyProtobufList();
    }

    static f.c.e.c.c b() {
        return c.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.c c, String string2) {
        c.i(string2);
    }

    static void d(f.c.e.c.c c, String string2) {
        c.e(string2);
    }

    private void e(String string) {
        string.getClass();
        f();
        this.documents_.add(string);
    }

    private void f() {
        c0.j mutableCopy;
        mutableCopy = this.documents_;
        if (!mutableCopy.c2()) {
            this.documents_ = z.mutableCopy(mutableCopy);
        }
    }

    public static f.c.e.c.c g() {
        return c.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.c.b h() {
        return (c.b)c.DEFAULT_INSTANCE.createBuilder();
    }

    private void i(String string) {
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
                obj2 = new c();
                return obj2;
            case 2:
                obj2 = new c.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[7];
                obj2[obj3] = "consistencySelectorCase_";
                obj2[2] = "database_";
                obj2[3] = "documents_";
                obj2[4] = "mask_";
                obj2[5] = w.class;
                obj2[6] = r1.class;
                return z.newMessageInfo(c.DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0007\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ț\u0003\t\u0004=\u0000\u0005<\u0000\u0007<\u0000", obj2);
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
