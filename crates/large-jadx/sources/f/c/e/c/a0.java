package f.c.e.c;

import android.accounts.Account;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.m0;
import com.google.protobuf.n0;
import com.google.protobuf.u0;
import com.google.protobuf.y1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class a0 extends z<f.c.e.c.a0, f.c.e.c.a0.b> implements u0 {

    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final f.c.e.c.a0 DEFAULT_INSTANCE = null;
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile d1<f.c.e.c.a0> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private String database_;
    private n0<String, String> labels_;
    private String streamId_;
    private j streamToken_;
    private c0.j<f.c.e.c.y> writes_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a0.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            a0.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            a0.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            a0.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            a0.a.a[z.f.GET_PARSER.ordinal()] = 5;
            a0.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            a0.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    private static final class c {

        static final m0<String, String> a;
        static {
            y1.b sTRING = y1.b.STRING;
            final String str = "";
            a0.c.a = m0.d(sTRING, str, sTRING, str);
        }
    }

    public static final class b extends z.a<f.c.e.c.a0, f.c.e.c.a0.b> implements u0 {
        private b() {
            super(a0.b());
        }

        b(f.c.e.c.a0.a a0$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.a0.b b(f.c.e.c.y y) {
            copyOnWrite();
            a0.e((a0)this.instance, y);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.a0.b c(String string) {
            copyOnWrite();
            a0.c((a0)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.a0.b d(j j) {
            copyOnWrite();
            a0.d((a0)this.instance, j);
            return this;
        }
    }
    static {
        a0 a0Var = new a0();
        a0.DEFAULT_INSTANCE = a0Var;
        z.registerDefaultInstance(a0.class, a0Var);
    }

    private a0() {
        super();
        this.labels_ = n0.e();
        String str = "";
        this.database_ = str;
        this.streamId_ = str;
        this.writes_ = z.emptyProtobufList();
        this.streamToken_ = j.a;
    }

    private void addWrites(f.c.e.c.y y) {
        y.getClass();
        ensureWritesIsMutable();
        this.writes_.add(y);
    }

    static f.c.e.c.a0 b() {
        return a0.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.a0 a0, String string2) {
        a0.h(string2);
    }

    static void d(f.c.e.c.a0 a0, j j2) {
        a0.i(j2);
    }

    static void e(f.c.e.c.a0 a0, f.c.e.c.y y2) {
        a0.addWrites(y2);
    }

    private void ensureWritesIsMutable() {
        c0.j mutableCopy;
        mutableCopy = this.writes_;
        if (!mutableCopy.c2()) {
            this.writes_ = z.mutableCopy(mutableCopy);
        }
    }

    public static f.c.e.c.a0 f() {
        return a0.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.a0.b g() {
        return (a0.b)a0.DEFAULT_INSTANCE.createBuilder();
    }

    private void h(String string) {
        string.getClass();
        this.database_ = string;
    }

    private void i(j j) {
        j.getClass();
        this.streamToken_ = j;
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
                obj2 = new a0();
                return obj2;
            case 2:
                obj2 = new a0.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[7];
                obj2[obj3] = "streamId_";
                obj2[2] = "writes_";
                obj2[3] = y.class;
                obj2[4] = "streamToken_";
                obj2[5] = "labels_";
                obj2[6] = a0.c.a;
                return z.newMessageInfo(a0.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\n\u00052", obj2);
            case 4:
                return a0.DEFAULT_INSTANCE;
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
        obj3 = a0.class;
        synchronized (obj3) {
            obj2 = new z.b(a0.DEFAULT_INSTANCE);
            a0.PARSER = obj2;
        }
    }
}
