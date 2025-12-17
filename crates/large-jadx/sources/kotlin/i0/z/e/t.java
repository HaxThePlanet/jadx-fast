package kotlin.i0.z.e;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.a;
import kotlin.d0.d.c;
import kotlin.d0.d.c0;
import kotlin.d0.d.d;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.g;
import kotlin.i0.h.a;
import kotlin.i0.l;
import kotlin.i0.l.a;
import kotlin.i0.l.b;
import kotlin.i0.z.e.l0.d;
import kotlin.i0.z.e.l0.h;
import kotlin.i0.z.e.m0.d.a.l;
import kotlin.i0.z.e.m0.e.a0.b.e.a;
import kotlin.i0.z.e.m0.e.a0.b.h;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public abstract class t<V>  extends kotlin.i0.z.e.f<V> implements l<V> {

    private static final Object C;
    private final String A;
    private final Object B;
    private final kotlin.i0.z.e.c0.b<Field> w;
    private final kotlin.i0.z.e.c0.a<o0> x;
    private final kotlin.i0.z.e.j y;
    private final String z;

    public static abstract class a extends kotlin.i0.z.e.f<ReturnType> implements g<ReturnType>, l.a<PropertyType> {
        @Override // kotlin.i0.z.e.f
        public boolean A() {
            return C().A();
        }

        @Override // kotlin.i0.z.e.f
        public abstract n0 B();

        public abstract kotlin.i0.z.e.t<PropertyType> C();

        @Override // kotlin.i0.z.e.f
        public boolean isSuspend() {
            return B().isSuspend();
        }

        @Override // kotlin.i0.z.e.f
        public kotlin.i0.z.e.j w() {
            return C().w();
        }

        public d<?> x() {
            return 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"V", "Lkotlin/reflect/jvm/internal/impl/descriptors/o0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/o0;"}, k = 3, mv = {1, 4, 1})
    static final class d extends p implements a<o0> {

        final kotlin.i0.z.e.t this$0;
        d(kotlin.i0.z.e.t t) {
            this.this$0 = t;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final o0 a() {
            return this.this$0.w().x(this.this$0.getName(), this.this$0.H());
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0002\u0010\u0003", d2 = {"V", "Ljava/lang/reflect/Field;", "a", "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 4, 1})
    static final class e extends p implements a<Field> {

        final kotlin.i0.z.e.t this$0;
        e(kotlin.i0.z.e.t t) {
            this.this$0 = t;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final Field a() {
            Class enclosingClass;
            boolean o0Var;
            Field declaredField;
            e.a aVar;
            kotlin.i0.z.e.m0.e.n nVar;
            kotlin.i0.z.e.m0.e.z.c cVar;
            kotlin.i0.z.e.m0.e.z.g gVar;
            int i3;
            int i2;
            int i;
            enclosingClass = g0.b.f(this.this$0.E());
            declaredField = 0;
            if (enclosingClass instanceof e.c) {
                o0Var = (e.c)enclosingClass.b();
                aVar = h.d(h.a, enclosingClass.e(), enclosingClass.d(), enclosingClass.g(), false, 8, 0);
                if (aVar != null) {
                    if (!l.e(o0Var)) {
                        if (h.f(enclosingClass.e())) {
                            enclosingClass = this.this$0.w().d().getEnclosingClass();
                        } else {
                            kotlin.reflect.jvm.internal.impl.descriptors.m mVar = o0Var.b();
                            if (mVar instanceof e) {
                                enclosingClass = j0.n((e)mVar);
                            } else {
                                enclosingClass = this.this$0.w().d();
                            }
                        }
                    } else {
                    }
                    if (enclosingClass != null) {
                        declaredField = enclosingClass.getDeclaredField(aVar.c());
                    }
                }
                return declaredField;
            } else {
                if (enclosingClass instanceof e.a) {
                    declaredField = (e.a)enclosingClass.b();
                } else {
                    if (enclosingClass instanceof e.b) {
                    } else {
                        if (!enclosingClass instanceof e.d) {
                        } else {
                        }
                    }
                }
            }
            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            throw noWhenBranchMatchedException;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    public static abstract class b extends kotlin.i0.z.e.t.a<V, V> implements l.b<V> {

        static final l[] y;
        private final kotlin.i0.z.e.c0.a w;
        private final kotlin.i0.z.e.c0.b x;
        static {
            Class<kotlin.i0.z.e.t.b> obj = t.b.class;
            l[] arr = new l[2];
            x xVar = new x(c0.b(obj), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;");
            x xVar2 = new x(c0.b(obj), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;");
            t.b.y = arr;
        }

        public b() {
            super();
            t.b.b bVar = new t.b.b(this);
            this.w = c0.d(bVar);
            t.b.a aVar2 = new t.b.a(this);
            this.x = c0.b(aVar2);
        }

        @Override // kotlin.i0.z.e.t$a
        public n0 B() {
            return D();
        }

        @Override // kotlin.i0.z.e.t$a
        public p0 D() {
            return (p0)this.w.b(this, t.b.y[0]);
        }

        @Override // kotlin.i0.z.e.t$a
        public String getName() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<get-");
            stringBuilder.append(C().getName());
            stringBuilder.append('>');
            return stringBuilder.toString();
        }

        public d<?> v() {
            return (d)this.x.b(this, t.b.y[1]);
        }

        @Override // kotlin.i0.z.e.t$a
        public b y() {
            return D();
        }
    }

    public static abstract class c extends kotlin.i0.z.e.t.a<V, kotlin.w> implements h.a<V> {

        static final l[] y;
        private final kotlin.i0.z.e.c0.a w;
        private final kotlin.i0.z.e.c0.b x;
        static {
            Class<kotlin.i0.z.e.t.c> obj = t.c.class;
            l[] arr = new l[2];
            x xVar = new x(c0.b(obj), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;");
            x xVar2 = new x(c0.b(obj), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;");
            t.c.y = arr;
        }

        public c() {
            super();
            t.c.b bVar = new t.c.b(this);
            this.w = c0.d(bVar);
            t.c.a aVar2 = new t.c.a(this);
            this.x = c0.b(aVar2);
        }

        @Override // kotlin.i0.z.e.t$a
        public n0 B() {
            return D();
        }

        @Override // kotlin.i0.z.e.t$a
        public q0 D() {
            return (q0)this.w.b(this, t.c.y[0]);
        }

        @Override // kotlin.i0.z.e.t$a
        public String getName() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<set-");
            stringBuilder.append(C().getName());
            stringBuilder.append('>');
            return stringBuilder.toString();
        }

        public d<?> v() {
            return (d)this.x.b(this, t.c.y[1]);
        }

        @Override // kotlin.i0.z.e.t$a
        public b y() {
            return D();
        }
    }
    static {
        Object object = new Object();
        t.C = object;
    }

    public t(kotlin.i0.z.e.j j, String string2, String string3, Object object4) {
        n.f(j, "container");
        n.f(string2, "name");
        n.f(string3, "signature");
        super(j, string2, string3, 0, object4);
    }

    private t(kotlin.i0.z.e.j j, String string2, String string3, o0 o04, Object object5) {
        super();
        this.y = j;
        this.z = string2;
        this.A = string3;
        this.B = object5;
        t.e obj1 = new t.e(this);
        obj1 = c0.b(obj1);
        n.e(obj1, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.w = obj1;
        obj1 = new t.d(this);
        obj1 = c0.c(o04, obj1);
        n.e(obj1, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.x = obj1;
    }

    public t(kotlin.i0.z.e.j j, o0 o02) {
        n.f(j, "container");
        n.f(o02, "descriptor");
        final String str4 = o02.getName().c();
        n.e(str4, "descriptor.name.asString()");
        super(j, str4, g0.b.f(o02).a(), o02, c.NO_RECEIVER);
    }

    @Override // kotlin.i0.z.e.f
    public boolean A() {
        return z ^= 1;
    }

    @Override // kotlin.i0.z.e.f
    protected final Field B() {
        Field field;
        if (E().N()) {
            field = G();
        } else {
            field = 0;
        }
        return field;
    }

    @Override // kotlin.i0.z.e.f
    public final Object C() {
        return h.a(this.B, E());
    }

    @Override // kotlin.i0.z.e.f
    protected final Object D(Field field, Object object2) {
        Object obj;
        int obj2;
        try {
            if (object2 == t.C) {
            }
            if (E().m0() == null) {
            } else {
            }
            StringBuilder obj3 = new StringBuilder();
            obj3.append('\'');
            obj3.append(this);
            obj3.append("' is not an extension property and thus getExtensionDelegate() ");
            obj3.append("is not going to work, use getDelegate() instead");
            obj2 = new RuntimeException(obj3.toString());
            throw obj2;
            if (field != null) {
            } else {
            }
            obj2 = field.get(object2);
            obj2 = 0;
            return obj2;
            object2 = new IllegalPropertyDelegateAccessException(field);
            throw object2;
        }
    }

    @Override // kotlin.i0.z.e.f
    public o0 E() {
        Object invoke = this.x.invoke();
        n.e(invoke, "_descriptor()");
        return (o0)invoke;
    }

    public abstract kotlin.i0.z.e.t.b<V> F();

    @Override // kotlin.i0.z.e.f
    public final Field G() {
        return (Field)this.w.invoke();
    }

    @Override // kotlin.i0.z.e.f
    public final String H() {
        return this.A;
    }

    @Override // kotlin.i0.z.e.f
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object name;
        kotlin.i0.z.e.t obj4;
        obj4 = j0.c(object);
        i = 0;
        if (obj4 != null && n.b(w(), obj4.w()) && n.b(getName(), obj4.getName()) && n.b(this.A, obj4.A) && n.b(this.B, obj4.B)) {
            if (n.b(w(), obj4.w())) {
                if (n.b(getName(), obj4.getName())) {
                    if (n.b(this.A, obj4.A)) {
                        if (n.b(this.B, obj4.B)) {
                            i = 1;
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // kotlin.i0.z.e.f
    public String getName() {
        return this.z;
    }

    @Override // kotlin.i0.z.e.f
    public int hashCode() {
        return i4 += i7;
    }

    @Override // kotlin.i0.z.e.f
    public boolean isConst() {
        return E().isConst();
    }

    @Override // kotlin.i0.z.e.f
    public boolean isLateinit() {
        return E().r0();
    }

    @Override // kotlin.i0.z.e.f
    public boolean isSuspend() {
        return 0;
    }

    @Override // kotlin.i0.z.e.f
    public String toString() {
        return f0.b.g(E());
    }

    public d<?> v() {
        return F().v();
    }

    @Override // kotlin.i0.z.e.f
    public kotlin.i0.z.e.j w() {
        return this.y;
    }

    public d<?> x() {
        return F().x();
    }

    @Override // kotlin.i0.z.e.f
    public b y() {
        return E();
    }
}
