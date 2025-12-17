package f.c.e.c;

import com.google.protobuf.a;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends z<f.c.e.c.a, f.c.e.c.a.b> implements f.c.e.c.b {

    private static final f.c.e.c.a DEFAULT_INSTANCE = null;
    private static volatile d1<f.c.e.c.a> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private c0.j<f.c.e.c.x> values_;

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

    public static final class b extends z.a<f.c.e.c.a, f.c.e.c.a.b> implements f.c.e.c.b {
        private b() {
            super(a.b());
        }

        b(f.c.e.c.a.a a$a) {
            super();
        }

        public List<f.c.e.c.x> a() {
            return Collections.unmodifiableList((a)this.instance.a());
        }

        public f.c.e.c.a.b b(Iterable<? extends f.c.e.c.x> iterable) {
            copyOnWrite();
            a.d((a)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.a.b c(f.c.e.c.x x) {
            copyOnWrite();
            a.c((a)this.instance, x);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.x d(int i) {
            return (a)this.instance.j(i);
        }

        @Override // com.google.protobuf.z$a
        public int e() {
            return (a)this.instance.k();
        }

        @Override // com.google.protobuf.z$a
        public f.c.e.c.a.b f(int i) {
            copyOnWrite();
            a.e((a)this.instance, i);
            return this;
        }
    }
    static {
        a aVar = new a();
        a.DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    private a() {
        super();
        this.values_ = z.emptyProtobufList();
    }

    static f.c.e.c.a b() {
        return a.DEFAULT_INSTANCE;
    }

    static void c(f.c.e.c.a a, f.c.e.c.x x2) {
        a.g(x2);
    }

    static void d(f.c.e.c.a a, Iterable iterable2) {
        a.f(iterable2);
    }

    static void e(f.c.e.c.a a, int i2) {
        a.m(i2);
    }

    private void f(Iterable<? extends f.c.e.c.x> iterable) {
        h();
        a.addAll(iterable, this.values_);
    }

    private void g(f.c.e.c.x x) {
        x.getClass();
        h();
        this.values_.add(x);
    }

    private void h() {
        c0.j mutableCopy;
        mutableCopy = this.values_;
        if (!mutableCopy.c2()) {
            this.values_ = z.mutableCopy(mutableCopy);
        }
    }

    public static f.c.e.c.a i() {
        return a.DEFAULT_INSTANCE;
    }

    public static f.c.e.c.a.b l() {
        return (a.b)a.DEFAULT_INSTANCE.createBuilder();
    }

    private void m(int i) {
        h();
        this.values_.remove(i);
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
                obj2 = new a();
                return obj2;
            case 2:
                obj2 = new a.b(obj4);
                return obj2;
            case 3:
                obj2 = new Object[2];
                obj2[obj3] = x.class;
                return z.newMessageInfo(a.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", obj2);
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
    public f.c.e.c.x j(int i) {
        return (x)this.values_.get(i);
    }

    @Override // com.google.protobuf.z
    public int k() {
        return this.values_.size();
    }
}
