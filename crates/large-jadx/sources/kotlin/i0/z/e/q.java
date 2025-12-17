package kotlin.i0.z.e;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.l;
import kotlin.i0.l.b;
import kotlin.i0.m;
import kotlin.i0.m.a;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;

/* loaded from: classes3.dex */
public class q<V>  extends kotlin.i0.z.e.t<V> implements m<V> {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.q.a<V>> D;
    private final h<Object> E;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"V", "Lkotlin/i0/z/e/q$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/q$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.q.a<? extends V>> {

        final kotlin.i0.z.e.q this$0;
        b(kotlin.i0.z.e.q q) {
            this.this$0 = q;
            super(0);
        }

        public final kotlin.i0.z.e.q.a<V> a() {
            q.a aVar = new q.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0002\u0010\u0003", d2 = {"V", "", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class c extends p implements a<Object> {

        final kotlin.i0.z.e.q this$0;
        c(kotlin.i0.z.e.q q) {
            this.this$0 = q;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final Object invoke() {
            kotlin.i0.z.e.q this$0 = this.this$0;
            return this$0.D(this$0.B(), this.this$0.C());
        }
    }

    public static final class a extends kotlin.i0.z.e.t.b<R> implements m.a<R> {

        private final kotlin.i0.z.e.q<R> z;
        public a(kotlin.i0.z.e.q<? extends R> q) {
            n.f(q, "property");
            super();
            this.z = q;
        }

        @Override // kotlin.i0.z.e.t$b
        public kotlin.i0.z.e.t C() {
            return E();
        }

        public kotlin.i0.z.e.q<R> E() {
            return this.z;
        }

        public R invoke() {
            return E().get();
        }

        @Override // kotlin.i0.z.e.t$b
        public l j() {
            return E();
        }
    }
    public q(kotlin.i0.z.e.j j, String string2, String string3, Object object4) {
        n.f(j, "container");
        n.f(string2, "name");
        n.f(string3, "signature");
        super(j, string2, string3, object4);
        q.b obj2 = new q.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Getter(this) }");
        this.D = obj2;
        q.c obj3 = new q.c(this);
        this.E = j.a(m.PUBLICATION, obj3);
    }

    public q(kotlin.i0.z.e.j j, o0 o02) {
        n.f(j, "container");
        n.f(o02, "descriptor");
        super(j, o02);
        q.b obj2 = new q.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Getter(this) }");
        this.D = obj2;
        q.c obj3 = new q.c(this);
        this.E = j.a(m.PUBLICATION, obj3);
    }

    @Override // kotlin.i0.z.e.t
    public kotlin.i0.z.e.t.b F() {
        return I();
    }

    public kotlin.i0.z.e.q.a<V> I() {
        Object invoke = this.D.invoke();
        n.e(invoke, "_getter()");
        return (q.a)invoke;
    }

    public V get() {
        return I().call(new Object[0]);
    }

    @Override // kotlin.i0.z.e.t
    public Object getDelegate() {
        return this.E.getValue();
    }

    @Override // kotlin.i0.z.e.t
    public l.b getGetter() {
        return I();
    }

    @Override // kotlin.i0.z.e.t
    public m.a getGetter() {
        return I();
    }

    public V invoke() {
        return get();
    }
}
