package kotlin.i0.z.e;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.l;
import kotlin.i0.l.b;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;

/* loaded from: classes3.dex */
public class s<D, E, V>  extends kotlin.i0.z.e.t<V> implements l, p {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.s.a<D, E, V>> D;
    private final h<Field> E;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0005\u001a.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0004*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00030\u0003\"\u0004\u0008\u0000\u0010\u0000\"\u0004\u0008\u0001\u0010\u0001\"\u0006\u0008\u0002\u0010\u0002 \u0001H\n¢\u0006\u0004\u0008\u0005\u0010\u0006", d2 = {"D", "E", "V", "Lkotlin/i0/z/e/s$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/s$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.s.a<D, E, ? extends V>> {

        final kotlin.i0.z.e.s this$0;
        b(kotlin.i0.z.e.s s) {
            this.this$0 = s;
            super(0);
        }

        public final kotlin.i0.z.e.s.a<D, E, V> a() {
            s.a aVar = new s.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0004\u0008\u0000\u0010\u0000\"\u0004\u0008\u0001\u0010\u0001\"\u0006\u0008\u0002\u0010\u0002 \u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"D", "E", "V", "Ljava/lang/reflect/Field;", "a", "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 4, 1})
    static final class c extends p implements a<Field> {

        final kotlin.i0.z.e.s this$0;
        c(kotlin.i0.z.e.s s) {
            this.this$0 = s;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final Field a() {
            return this.this$0.B();
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    public static final class a extends kotlin.i0.z.e.t.b<V> implements l.b, p {

        private final kotlin.i0.z.e.s<D, E, V> z;
        public a(kotlin.i0.z.e.s<D, E, ? extends V> s) {
            n.f(s, "property");
            super();
            this.z = s;
        }

        @Override // kotlin.i0.z.e.t$b
        public kotlin.i0.z.e.t C() {
            return E();
        }

        public kotlin.i0.z.e.s<D, E, V> E() {
            return this.z;
        }

        public V invoke(D d, E e2) {
            return E().I(d, e2);
        }

        @Override // kotlin.i0.z.e.t$b
        public l j() {
            return E();
        }
    }
    public s(kotlin.i0.z.e.j j, o0 o02) {
        n.f(j, "container");
        n.f(o02, "descriptor");
        super(j, o02);
        s.b obj2 = new s.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Getter(this) }");
        this.D = obj2;
        s.c obj3 = new s.c(this);
        this.E = j.a(m.PUBLICATION, obj3);
    }

    @Override // kotlin.i0.z.e.t
    public kotlin.i0.z.e.t.b F() {
        return J();
    }

    public V I(D d, E e2) {
        Object[] arr = new Object[2];
        return J().call(d, e2);
    }

    public kotlin.i0.z.e.s.a<D, E, V> J() {
        Object invoke = this.D.invoke();
        n.e(invoke, "_getter()");
        return (s.a)invoke;
    }

    @Override // kotlin.i0.z.e.t
    public l.b getGetter() {
        return J();
    }

    public V invoke(D d, E e2) {
        return I(d, e2);
    }
}
