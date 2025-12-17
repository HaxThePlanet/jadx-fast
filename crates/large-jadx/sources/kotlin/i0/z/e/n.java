package kotlin.i0.z.e;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.c.q;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.h;
import kotlin.i0.h.a;
import kotlin.i0.l;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.w;

/* loaded from: classes3.dex */
public final class n<D, E, V>  extends kotlin.i0.z.e.s<D, E, V> implements l, p, h {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.n.a<D, E, V>> F;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0005\u001a.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0004*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00030\u0003\"\u0004\u0008\u0000\u0010\u0000\"\u0004\u0008\u0001\u0010\u0001\"\u0004\u0008\u0002\u0010\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006", d2 = {"D", "E", "V", "Lkotlin/i0/z/e/n$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/n$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.n.a<D, E, V>> {

        final kotlin.i0.z.e.n this$0;
        b(kotlin.i0.z.e.n n) {
            this.this$0 = n;
            super(0);
        }

        public final kotlin.i0.z.e.n.a<D, E, V> a() {
            n.a aVar = new n.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    public static final class a extends kotlin.i0.z.e.t.c<V> implements h.a, q {

        private final kotlin.i0.z.e.n<D, E, V> z;
        public a(kotlin.i0.z.e.n<D, E, V> n) {
            n.f(n, "property");
            super();
            this.z = n;
        }

        @Override // kotlin.i0.z.e.t$c
        public kotlin.i0.z.e.t C() {
            return E();
        }

        public kotlin.i0.z.e.n<D, E, V> E() {
            return this.z;
        }

        public void F(D d, E e2, V v3) {
            E().L(d, e2, v3);
        }

        @Override // kotlin.i0.z.e.t$c
        public Object invoke(Object object, Object object2, Object object3) {
            F(object, object2, object3);
            return w.a;
        }

        @Override // kotlin.i0.z.e.t$c
        public l j() {
            return E();
        }
    }
    public n(kotlin.i0.z.e.j j, o0 o02) {
        n.f(j, "container");
        n.f(o02, "descriptor");
        super(j, o02);
        n.b obj2 = new n.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Setter(this) }");
        this.F = obj2;
    }

    public kotlin.i0.z.e.n.a<D, E, V> K() {
        Object invoke = this.F.invoke();
        n.e(invoke, "_setter()");
        return (n.a)invoke;
    }

    public void L(D d, E e2, V v3) {
        Object[] arr = new Object[3];
        K().call(d, e2, v3);
    }

    @Override // kotlin.i0.z.e.s
    public h.a getSetter() {
        return K();
    }
}
