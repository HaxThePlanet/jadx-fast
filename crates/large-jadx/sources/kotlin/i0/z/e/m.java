package kotlin.i0.z.e;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.h.a;
import kotlin.i0.j;
import kotlin.i0.j.a;
import kotlin.i0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.w;

/* loaded from: classes3.dex */
public final class m<T, V>  extends kotlin.i0.z.e.r<T, V> implements j<T, V> {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.m.a<T, V>> F;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0004\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002\"\u0004\u0008\u0000\u0010\u0000\"\u0004\u0008\u0001\u0010\u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"T", "V", "Lkotlin/i0/z/e/m$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/m$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.m.a<T, V>> {

        final kotlin.i0.z.e.m this$0;
        b(kotlin.i0.z.e.m m) {
            this.this$0 = m;
            super(0);
        }

        public final kotlin.i0.z.e.m.a<T, V> a() {
            m.a aVar = new m.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    public static final class a extends kotlin.i0.z.e.t.c<V> implements j.a<T, V> {

        private final kotlin.i0.z.e.m<T, V> z;
        public a(kotlin.i0.z.e.m<T, V> m) {
            n.f(m, "property");
            super();
            this.z = m;
        }

        @Override // kotlin.i0.z.e.t$c
        public kotlin.i0.z.e.t C() {
            return E();
        }

        public kotlin.i0.z.e.m<T, V> E() {
            return this.z;
        }

        public void F(T t, V v2) {
            E().i(t, v2);
        }

        @Override // kotlin.i0.z.e.t$c
        public Object invoke(Object object, Object object2) {
            F(object, object2);
            return w.a;
        }

        @Override // kotlin.i0.z.e.t$c
        public l j() {
            return E();
        }
    }
    public m(kotlin.i0.z.e.j j, String string2, String string3, Object object4) {
        n.f(j, "container");
        n.f(string2, "name");
        n.f(string3, "signature");
        super(j, string2, string3, object4);
        m.b obj2 = new m.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Setter(this) }");
        this.F = obj2;
    }

    public m(kotlin.i0.z.e.j j, o0 o02) {
        n.f(j, "container");
        n.f(o02, "descriptor");
        super(j, o02);
        m.b obj2 = new m.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Setter(this) }");
        this.F = obj2;
    }

    public kotlin.i0.z.e.m.a<T, V> J() {
        Object invoke = this.F.invoke();
        n.e(invoke, "_setter()");
        return (m.a)invoke;
    }

    @Override // kotlin.i0.z.e.r
    public h.a getSetter() {
        return J();
    }

    @Override // kotlin.i0.z.e.r
    public j.a getSetter() {
        return J();
    }

    public void i(T t, V v2) {
        Object[] arr = new Object[2];
        J().call(t, v2);
    }
}
