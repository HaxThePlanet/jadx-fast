package kotlin.i0.z.e;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.l;
import kotlin.i0.l.b;
import kotlin.i0.n;
import kotlin.i0.n.a;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;

/* loaded from: classes3.dex */
public class r<T, V>  extends kotlin.i0.z.e.t<V> implements n<T, V> {

    private final kotlin.i0.z.e.c0.b<kotlin.i0.z.e.r.a<T, V>> D;
    private final h<Field> E;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0004\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002\"\u0004\u0008\u0000\u0010\u0000\"\u0006\u0008\u0001\u0010\u0001 \u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"T", "V", "Lkotlin/i0/z/e/r$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/r$a;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<kotlin.i0.z.e.r.a<T, ? extends V>> {

        final kotlin.i0.z.e.r this$0;
        b(kotlin.i0.z.e.r r) {
            this.this$0 = r;
            super(0);
        }

        public final kotlin.i0.z.e.r.a<T, V> a() {
            r.a aVar = new r.a(this.this$0);
            return aVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\u0004\u0008\u0000\u0010\u0000\"\u0006\u0008\u0001\u0010\u0001 \u0001H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"T", "V", "Ljava/lang/reflect/Field;", "a", "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 4, 1})
    static final class c extends p implements a<Field> {

        final kotlin.i0.z.e.r this$0;
        c(kotlin.i0.z.e.r r) {
            this.this$0 = r;
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

    public static final class a extends kotlin.i0.z.e.t.b<V> implements n.a<T, V> {

        private final kotlin.i0.z.e.r<T, V> z;
        public a(kotlin.i0.z.e.r<T, ? extends V> r) {
            n.f(r, "property");
            super();
            this.z = r;
        }

        @Override // kotlin.i0.z.e.t$b
        public kotlin.i0.z.e.t C() {
            return E();
        }

        public kotlin.i0.z.e.r<T, V> E() {
            return this.z;
        }

        public V invoke(T t) {
            return E().get(t);
        }

        @Override // kotlin.i0.z.e.t$b
        public l j() {
            return E();
        }
    }
    public r(kotlin.i0.z.e.j j, String string2, String string3, Object object4) {
        n.f(j, "container");
        n.f(string2, "name");
        n.f(string3, "signature");
        super(j, string2, string3, object4);
        r.b obj2 = new r.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Getter(this) }");
        this.D = obj2;
        r.c obj3 = new r.c(this);
        this.E = j.a(m.PUBLICATION, obj3);
    }

    public r(kotlin.i0.z.e.j j, o0 o02) {
        n.f(j, "container");
        n.f(o02, "descriptor");
        super(j, o02);
        r.b obj2 = new r.b(this);
        obj2 = c0.b(obj2);
        n.e(obj2, "ReflectProperties.lazy { Getter(this) }");
        this.D = obj2;
        r.c obj3 = new r.c(this);
        this.E = j.a(m.PUBLICATION, obj3);
    }

    @Override // kotlin.i0.z.e.t
    public kotlin.i0.z.e.t.b F() {
        return I();
    }

    public kotlin.i0.z.e.r.a<T, V> I() {
        Object invoke = this.D.invoke();
        n.e(invoke, "_getter()");
        return (r.a)invoke;
    }

    public V get(T t) {
        Object[] arr = new Object[1];
        return I().call(t);
    }

    @Override // kotlin.i0.z.e.t
    public l.b getGetter() {
        return I();
    }

    @Override // kotlin.i0.z.e.t
    public n.a getGetter() {
        return I();
    }

    public V invoke(T t) {
        return get(t);
    }
}
