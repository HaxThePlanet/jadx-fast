package f.c.e.c;

import com.google.protobuf.a;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.List;

/* loaded from: classes2.dex */
public final class g extends z<f.c.e.c.g, f.c.e.c.g.b> implements u0 {

    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final f.c.e.c.g DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.g> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private c0.j<f.c.e.c.x> values_;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            g.a.a = iArr;
            iArr[z.f.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            g.a.a[z.f.NEW_BUILDER.ordinal()] = 2;
            g.a.a[z.f.BUILD_MESSAGE_INFO.ordinal()] = 3;
            g.a.a[z.f.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            g.a.a[z.f.GET_PARSER.ordinal()] = 5;
            g.a.a[z.f.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            g.a.a[z.f.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
        }
    }

    public static final class b extends z.a<f.c.e.c.g, f.c.e.c.g.b> implements u0 {
        private b() {
            super(g.b());
        }

        b(f.c.e.c.g.a g$a) {
            super();
        }

        public f.c.e.c.g.b b(Iterable<? extends f.c.e.c.x> iterable) {
            copyOnWrite();
            g.c((g)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.g.b c(boolean z) {
            copyOnWrite();
            g.d((g)this.instance, z);
            return this;
        }
    }
    static {
        g gVar = new g();
        g.DEFAULT_INSTANCE = gVar;
        z.registerDefaultInstance(g.class, gVar);
    }

    private g() {
        super();
        this.values_ = z.emptyProtobufList();
    }

    static f.c.e.c.g b() {
        return g.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.g g, Iterable iterable2) {
        g.e(iterable2);
    }

    static void d(f.c.e.c.g g, boolean z2) {
        g.j(z2);
    }

    private void e(Iterable<? extends f.c.e.c.x> iterable) {
        f();
        a.addAll(iterable, this.values_);
    }

    private void f() {
        c0.j mutableCopy;
        mutableCopy = this.values_;
        if (!mutableCopy.c2()) {
            this.values_ = z.mutableCopy(mutableCopy);
        }
    }

    public static f.c.e.c.g h() {
        return g.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.g.b i() {
        return (g.b)g.DEFAULT_INSTANCE.createBuilder();
    }

    private void j(boolean z) {
        this.before_ = z;
    }

    public List<f.c.e.c.x> a() {
        return this.values_;
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
                obj2 = new g();
                return obj2;
            case 2:
                obj2 = new g.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[3];
                obj2[obj3] = x.class;
                obj2[2] = "before_";
                return z.newMessageInfo(g.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", obj2);
            case 4:
                return g.DEFAULT_INSTANCE;
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
        obj3 = g.class;
        synchronized (obj3) {
            obj2 = new z.b(g.DEFAULT_INSTANCE);
            g.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public boolean g() {
        return this.before_;
    }
}
