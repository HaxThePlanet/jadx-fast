package kotlin.i0.z.e;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.h.a;
import kotlin.i0.i;
import kotlin.i0.i.a;
import kotlin.i0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.w;

/* loaded from: classes3.dex */
public final class l<V>  extends kotlin.i0.z.e.q<V> implements i<V> {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.l.a<V>> F;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0004\u0008\u0000\u0010\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"V", "Lkotlin/i0/z/e/l$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/l$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.l.a<V>> {

        final kotlin.i0.z.e.l this$0;
        b(kotlin.i0.z.e.l l) {
            this.this$0 = l;
            super(0);
        }

        public final kotlin.i0.z.e.l.a<V> a() {
            l.a aVar = new l.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    public static final class a extends kotlin.i0.z.e.t.c<R> implements i.a<R> {

        private final kotlin.i0.z.e.l<R> z;
        public a(kotlin.i0.z.e.l<R> l) {
            n.f(l, "property");
            super();
            this.z = l;
        }

        @Override // kotlin.i0.z.e.t$c
        public kotlin.i0.z.e.t C() {
            return E();
        }

        public kotlin.i0.z.e.l<R> E() {
            return this.z;
        }

        public void F(R r) {
            E().K(r);
        }

        @Override // kotlin.i0.z.e.t$c
        public Object invoke(Object object) {
            F(object);
            return w.a;
        }

        @Override // kotlin.i0.z.e.t$c
        public l j() {
            return E();
        }
    }
    public l(kotlin.i0.z.e.j j, String string2, String string3, Object object4) {
        n.f(j, "container");
        n.f(string2, "name");
        n.f(string3, "signature");
        super(j, string2, string3, object4);
        l.b obj2 = new l.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Setter(this) }");
        this.F = obj2;
    }

    public l(kotlin.i0.z.e.j j, o0 o02) {
        n.f(j, "container");
        n.f(o02, "descriptor");
        super(j, o02);
        l.b obj2 = new l.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Setter(this) }");
        this.F = obj2;
    }

    public kotlin.i0.z.e.l.a<V> J() {
        Object invoke = this.F.invoke();
        n.e(invoke, "_setter()");
        return (l.a)invoke;
    }

    public void K(V v) {
        Object[] arr = new Object[1];
        J().call(v);
    }

    @Override // kotlin.i0.z.e.q
    public h.a getSetter() {
        return J();
    }

    @Override // kotlin.i0.z.e.q
    public i.a getSetter() {
        return J();
    }
}
