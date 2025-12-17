package kotlin.i0.z.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.a;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.o;
import kotlin.d0.d.p;
import kotlin.d0.d.x;
import kotlin.i0.e;
import kotlin.i0.l;
import kotlin.i0.q;
import kotlin.i0.q.a;
import kotlin.i0.z.b;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.j;
import kotlin.m;
import kotlin.n;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class w implements o {

    static final l[] w;
    private final kotlin.i0.z.e.c0.a<Type> a;
    private final kotlin.i0.z.e.c0.a b;
    private final kotlin.i0.z.e.c0.a c;
    private final b0 v;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "Lkotlin/i0/q;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements a<List<? extends q>> {

        final a $computeJavaType;
        final kotlin.i0.z.e.w this$0;
        a(kotlin.i0.z.e.w w, a a2) {
            this.this$0 = w;
            this.$computeJavaType = a2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<q> invoke() {
            int i2;
            q qVar;
            Object next;
            int i;
            int i3;
            boolean wVar;
            b0 type;
            kotlin.i0.z.e.w.a.a $computeJavaType;
            List list = this.this$0.l().K0();
            if (list.isEmpty()) {
                return p.g();
            }
            w.a.b bVar = new w.a.b(this);
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            i2 = 0;
            Iterator iterator = list.iterator();
            for (Object next : iterator) {
                i3 = 0;
                type = next.getType();
                n.e(type, "typeProjection.type");
                if (this.$computeJavaType == null) {
                } else {
                }
                $computeJavaType = new w.a.a(i2, this, j.a(m.PUBLICATION, bVar), i3);
                i3 = $computeJavaType;
                wVar = new w(type, i3);
                int i6 = v.a[next.a().ordinal()];
                qVar = q.d.d(wVar);
                arrayList.add(qVar);
                i2 = i;
                qVar = q.d.a(wVar);
                qVar = q.d.b(wVar);
                qVar = q.d.c();
            }
            return arrayList;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/i0/e;", "a", "()Lkotlin/i0/e;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<e> {

        final kotlin.i0.z.e.w this$0;
        b(kotlin.i0.z.e.w w) {
            this.this$0 = w;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final e a() {
            kotlin.i0.z.e.w this$0 = this.this$0;
            return w.d(this$0, this$0.l());
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        Class<kotlin.i0.z.e.w> obj = w.class;
        l[] arr = new l[2];
        x xVar = new x(c0.b(obj), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;");
        x xVar2 = new x(c0.b(obj), "arguments", "getArguments()Ljava/util/List;");
        w.w = arr;
    }

    public w(b0 b0, a<? extends Type> a2) {
        int i;
        Object obj2;
        n.f(b0, "type");
        super();
        this.v = b0;
        obj2 = !a2 instanceof c0.a ? i : a2;
        if ((c0.a)obj2 != null) {
            i = obj2;
        } else {
            if (a2 != null) {
                i = c0.d(a2);
            }
        }
        this.a = i;
        obj2 = new w.b(this);
        this.b = c0.d(obj2);
        obj2 = new w.a(this, a2);
        this.c = c0.d(obj2);
    }

    public w(b0 b0, a a2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(b0, obj2);
    }

    public static final e d(kotlin.i0.z.e.w w, b0 b02) {
        return w.j(b02);
    }

    private final e j(b0 b0) {
        Class cls;
        Object obj4;
        kotlin.reflect.jvm.internal.impl.descriptors.h hVar = b0.L0().c();
        final int i = 0;
        cls = j0.n((e)hVar);
        obj4 = p.B0(b0.K0());
        obj4 = (v0)obj4.getType();
        if (hVar instanceof e && cls != null && cls.isArray() && obj4 != null && obj4 != null) {
            cls = j0.n((e)hVar);
            if (cls != null) {
                if (cls.isArray()) {
                    obj4 = p.B0(b0.K0());
                    if ((v0)obj4 != null) {
                        obj4 = (v0)obj4.getType();
                        if (obj4 != null) {
                            n.e(obj4, "type.arguments.singleOrN…return KClassImpl(jClass)");
                            obj4 = j(obj4);
                            if (obj4 == null) {
                            } else {
                                h hVar2 = new h(b.a(a.b(b.a(obj4))));
                                return hVar2;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Cannot determine classifier for array element type: ");
                            stringBuilder.append(this);
                            obj4 = new a0(stringBuilder.toString());
                            throw obj4;
                        }
                    }
                    obj4 = new h(cls);
                    return obj4;
                }
                Class cls2 = b.f(cls);
                if (!c1.l(b0) && cls2 != null) {
                    cls2 = b.f(cls);
                    if (cls2 != null) {
                        cls = cls2;
                    }
                    obj4 = new h(cls);
                    return obj4;
                }
                obj4 = new h(cls);
                return obj4;
            }
            return i;
        }
        if (hVar instanceof z0) {
            obj4 = new y(i, (z0)hVar);
            return obj4;
        }
        if (hVar instanceof y0) {
        } else {
            return i;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("An operation is not implemented: ");
        stringBuilder2.append("Type alias classifiers are not yet supported");
        obj4 = new n(stringBuilder2.toString());
        throw obj4;
    }

    @Override // kotlin.d0.d.o
    public Type a() {
        Object invoke;
        kotlin.i0.z.e.c0.a aVar = this.a;
        if (aVar != null) {
            invoke = aVar.invoke();
        } else {
            invoke = 0;
        }
        return invoke;
    }

    public List<q> b() {
        return (List)this.c.b(this, w.w[1]);
    }

    @Override // kotlin.d0.d.o
    public e c() {
        return (e)this.b.b(this, w.w[0]);
    }

    @Override // kotlin.d0.d.o
    public boolean e() {
        return this.v.M0();
    }

    @Override // kotlin.d0.d.o
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof w && n.b(this.v, object.v)) {
            obj2 = n.b(this.v, object.v) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public List<Annotation> getAnnotations() {
        return j0.d(this.v);
    }

    @Override // kotlin.d0.d.o
    public int hashCode() {
        return this.v.hashCode();
    }

    @Override // kotlin.d0.d.o
    public final b0 l() {
        return this.v;
    }

    @Override // kotlin.d0.d.o
    public String toString() {
        return f0.b.h(this.v);
    }
}
