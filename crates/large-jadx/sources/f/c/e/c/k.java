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
public final class k extends z<f.c.e.c.k, f.c.e.c.k.b> implements u0 {

    private static final f.c.e.c.k DEFAULT_INSTANCE = null;
    public static final int FIELD_PATHS_FIELD_NUMBER = 1;
    private static volatile d1<f.c.e.c.k> PARSER;
    private c0.j<String> fieldPaths_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            k.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            k.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            k.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            k.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            k.a.a[z.f.GET_PARSER.ordinal()] = 5;
            k.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            k.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.k, f.c.e.c.k.b> implements u0 {
        private b() {
            super(k.b());
        }

        b(f.c.e.c.k.a k$a) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.k.b b(String string) {
            copyOnWrite();
            k.c((k)this.instance, string);
            return this;
        }
    }
    static {
        k kVar = new k();
        k.DEFAULT_INSTANCE = kVar;
        z.registerDefaultInstance(k.class, kVar);
    }

    private k() {
        super();
        this.fieldPaths_ = z.emptyProtobufList();
    }

    static f.c.e.c.k b() {
        return k.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.k k, String string2) {
        k.d(string2);
    }

    private void d(String string) {
        string.getClass();
        e();
        this.fieldPaths_.add(string);
    }

    private void e() {
        c0.j fieldPaths_;
        fieldPaths_ = this.fieldPaths_;
        if (!fieldPaths_.c2()) {
            this.fieldPaths_ = z.mutableCopy(fieldPaths_);
        }
    }

    public static f.c.e.c.k f() {
        return k.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.k.b i() {
        return (k.b)k.DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj1;
        int obj2;
        int obj3;
        obj2 = 1;
        obj3 = 0;
        switch (obj1) {
            case 1:
                obj1 = new k();
                return obj1;
            case 2:
                obj1 = new k.b(obj3);
                return obj1;
            case 3:
                obj1 = new Object[obj2];
                obj1[0] = "fieldPaths_";
                return z.newMessageInfo(k.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", obj1);
            case 4:
                return k.DEFAULT_INSTANCE;
            case 5:
                return obj1;
            case 6:
                return Byte.valueOf(obj2);
            case 7:
                return obj3;
            default:
                obj1 = new UnsupportedOperationException();
                throw obj1;
        }
        obj2 = k.class;
        synchronized (obj2) {
            obj1 = new z.b(k.DEFAULT_INSTANCE);
            k.PARSER = obj1;
        }
    }

    @Override // com.google.protobuf.z
    public String g(int i) {
        return (String)this.fieldPaths_.get(i);
    }

    @Override // com.google.protobuf.z
    public int h() {
        return this.fieldPaths_.size();
    }
}
