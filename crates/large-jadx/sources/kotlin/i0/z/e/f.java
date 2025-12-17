package kotlin.i0.z.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.d0.a;
import kotlin.d0.c.a;
import kotlin.d0.d.d;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.c;
import kotlin.i0.k;
import kotlin.i0.k.a;
import kotlin.i0.o;
import kotlin.i0.p;
import kotlin.i0.t;
import kotlin.i0.z.b;
import kotlin.i0.z.c;
import kotlin.i0.z.e.l0.d;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class f<R>  implements c<R>, kotlin.i0.z.e.z {

    private final kotlin.i0.z.e.c0.a<List<Annotation>> a;
    private final kotlin.i0.z.e.c0.a<ArrayList<k>> b;
    private final kotlin.i0.z.e.c0.a<kotlin.i0.z.e.w> c;
    private final kotlin.i0.z.e.c0.a<List<kotlin.i0.z.e.y>> v;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"R", "", "", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements a<List<? extends Annotation>> {

        final kotlin.i0.z.e.f this$0;
        a(kotlin.i0.z.e.f f) {
            this.this$0 = f;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<Annotation> invoke() {
            return j0.d(this.this$0.y());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"R", "Ljava/util/ArrayList;", "Lkotlin/i0/k;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/ArrayList;"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<ArrayList<k>> {

        final kotlin.i0.z.e.f this$0;
        b(kotlin.i0.z.e.f f) {
            this.this$0 = f;
            super(0);
        }

        public final ArrayList<k> a() {
            b aVar;
            int i;
            int i2;
            kotlin.i0.z.e.p pVar;
            kotlin.i0.z.e.f pVar2;
            String pVar3;
            k.a iNSTANCE;
            kotlin.i0.z.e.f.b.b bVar;
            k.a eXTENSION_RECEIVER;
            kotlin.i0.z.e.f.b.c cVar;
            aVar = this.this$0.y();
            ArrayList arrayList = new ArrayList();
            i2 = 0;
            final int i3 = 1;
            if (!this.this$0.A()) {
                kotlin.reflect.jvm.internal.impl.descriptors.r0 r0Var = j0.g(aVar);
                if (r0Var != null) {
                    bVar = new f.b.b(r0Var);
                    pVar = new p(this.this$0, i2, k.a.INSTANCE, bVar);
                    arrayList.add(pVar);
                    i = i3;
                } else {
                    i = i2;
                }
                pVar = aVar.m0();
                if (pVar != null) {
                    cVar = new f.b.c(pVar);
                    pVar2 = new p(this.this$0, i, k.a.EXTENSION_RECEIVER, cVar);
                    arrayList.add(pVar2);
                    i = bVar;
                }
            } else {
                i = i2;
            }
            List list = aVar.h();
            n.e(list, "descriptor.valueParameters");
            while (i2 < list.size()) {
                cVar = new f.b.d(aVar, i2);
                pVar3 = new p(this.this$0, i, k.a.VALUE, cVar);
                arrayList.add(pVar3);
                i2++;
                i = bVar;
            }
            if (this.this$0.z() && aVar instanceof b && arrayList.size() > i3) {
                if (aVar instanceof b) {
                    if (arrayList.size() > i3) {
                        aVar = new f.b.a();
                        p.x(arrayList, aVar);
                    }
                }
            }
            arrayList.trimToSize();
            return arrayList;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"R", "Lkotlin/i0/z/e/w;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/i0/z/e/w;"}, k = 3, mv = {1, 4, 1})
    static final class c extends p implements a<kotlin.i0.z.e.w> {

        final kotlin.i0.z.e.f this$0;
        c(kotlin.i0.z.e.f f) {
            this.this$0 = f;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final kotlin.i0.z.e.w a() {
            kotlin.i0.z.e.m0.l.b0 returnType = this.this$0.y().getReturnType();
            n.d(returnType);
            n.e(returnType, "descriptor.returnType!!");
            f.c.a aVar = new f.c.a(this);
            w wVar = new w(returnType, aVar);
            return wVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\u0008\u0000\u0010\u0000 \u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"R", "", "Lkotlin/i0/z/e/y;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class d extends p implements a<List<? extends kotlin.i0.z.e.y>> {

        final kotlin.i0.z.e.f this$0;
        d(kotlin.i0.z.e.f f) {
            this.this$0 = f;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        public final List<kotlin.i0.z.e.y> invoke() {
            int next;
            kotlin.i0.z.e.y yVar;
            kotlin.i0.z.e.f this$0;
            String str;
            List typeParameters = this.this$0.y().getTypeParameters();
            n.e(typeParameters, "descriptor.typeParameters");
            ArrayList arrayList = new ArrayList(p.r(typeParameters, 10));
            Iterator iterator = typeParameters.iterator();
            for (z0 next : iterator) {
                n.e(next, "descriptor");
                yVar = new y(this.this$0, next);
                arrayList.add(yVar);
            }
            return arrayList;
        }
    }
    public f() {
        super();
        f.a aVar = new f.a(this);
        kotlin.i0.z.e.c0.a aVar2 = c0.d(aVar);
        n.e(aVar2, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.a = aVar2;
        f.b bVar = new f.b(this);
        kotlin.i0.z.e.c0.a aVar3 = c0.d(bVar);
        n.e(aVar3, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.b = aVar3;
        f.c cVar = new f.c(this);
        kotlin.i0.z.e.c0.a aVar4 = c0.d(cVar);
        n.e(aVar4, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.c = aVar4;
        f.d dVar = new f.d(this);
        kotlin.i0.z.e.c0.a aVar5 = c0.d(dVar);
        n.e(aVar5, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.v = aVar5;
    }

    public static final Type l(kotlin.i0.z.e.f f) {
        return f.u();
    }

    private final R r(Map<k, ? extends Object> map) {
        int next;
        Object obj;
        List parameters = getParameters();
        ArrayList arrayList = new ArrayList(p.r(parameters, 10));
        Iterator iterator = parameters.iterator();
        for (k next : iterator) {
            obj = t(next.getType());
            arrayList.add(obj);
            obj = 0;
        }
        d obj5 = x();
        if (obj5 == null) {
        } else {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array == null) {
            } else {
                return obj5.call(array);
            }
            obj5 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            throw obj5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("This callable does not support a default call: ");
        stringBuilder.append(y());
        obj5 = new a0(stringBuilder.toString());
        throw obj5;
    }

    private final Object t(o o) {
        Class obj4 = a.b(b.b(o));
        if (!obj4.isArray()) {
        } else {
            obj4 = Array.newInstance(obj4.getComponentType(), 0);
            n.e(obj4, "type.jvmErasure.java.run…\"\n            )\n        }");
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot instantiate the default empty array of type ");
        stringBuilder.append(obj4.getSimpleName());
        stringBuilder.append(", because it is not an array type");
        a0 a0Var = new a0(stringBuilder.toString());
        throw a0Var;
    }

    private final Type u() {
        b lowerBounds;
        Type rawType;
        boolean i;
        int i2;
        Class<d> obj;
        i2 = 0;
        if (!lowerBounds instanceof x) {
            lowerBounds = i2;
        }
        if (lowerBounds != null && (x)lowerBounds.isSuspend() == 1 && !lowerBounds instanceof ParameterizedType) {
            if (lowerBounds.isSuspend() == 1) {
                if (!lowerBounds instanceof ParameterizedType) {
                    lowerBounds = i2;
                }
                if ((ParameterizedType)lowerBounds != null) {
                    rawType = (ParameterizedType)lowerBounds.getRawType();
                } else {
                    rawType = i2;
                }
                Type[] actualTypeArguments = lowerBounds.getActualTypeArguments();
                n.e(actualTypeArguments, "continuationType.actualTypeArguments");
                if (n.b(rawType, d.class) && !lowerBounds instanceof WildcardType) {
                    actualTypeArguments = lowerBounds.getActualTypeArguments();
                    n.e(actualTypeArguments, "continuationType.actualTypeArguments");
                    if (!lowerBounds instanceof WildcardType) {
                        lowerBounds = i2;
                    }
                    lowerBounds = (WildcardType)lowerBounds.getLowerBounds();
                    if (lowerBounds != null && lowerBounds != null) {
                        lowerBounds = lowerBounds.getLowerBounds();
                        if (lowerBounds != null) {
                            i2 = lowerBounds;
                        }
                    }
                }
            }
        }
        return i2;
    }

    @Override // kotlin.i0.c
    public abstract boolean A();

    public R call(Object... objectArr) {
        n.f(objectArr, "args");
        return v().call(objectArr);
    }

    public R callBy(Map<k, ? extends Object> map) {
        boolean z;
        Object obj2;
        n.f(map, "args");
        if (z()) {
            obj2 = r(map);
        } else {
            obj2 = s(map, 0);
        }
        return obj2;
    }

    public List<Annotation> getAnnotations() {
        Object invoke = this.a.invoke();
        n.e(invoke, "_annotations()");
        return (List)invoke;
    }

    public List<k> getParameters() {
        Object invoke = this.b.invoke();
        n.e(invoke, "_parameters()");
        return (List)invoke;
    }

    @Override // kotlin.i0.c
    public o getReturnType() {
        Object invoke = this.c.invoke();
        n.e(invoke, "_returnType()");
        return (o)invoke;
    }

    public List<p> getTypeParameters() {
        Object invoke = this.v.invoke();
        n.e(invoke, "_typeParameters()");
        return (List)invoke;
    }

    @Override // kotlin.i0.c
    public t getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u visibility = y().getVisibility();
        n.e(visibility, "descriptor.visibility");
        return j0.o(visibility);
    }

    @Override // kotlin.i0.c
    public boolean isAbstract() {
        int i;
        i = y().i() == z.ABSTRACT ? 1 : 0;
        return i;
    }

    @Override // kotlin.i0.c
    public boolean isFinal() {
        int i;
        i = y().i() == z.FINAL ? 1 : 0;
        return i;
    }

    @Override // kotlin.i0.c
    public boolean isOpen() {
        int i;
        i = y().i() == z.OPEN ? 1 : 0;
        return i;
    }

    public final R s(Map<k, ? extends Object> map, d<?> d2) {
        int i;
        int i2;
        boolean z;
        int i4;
        k.a aVar;
        k.a vALUE;
        Object i3;
        boolean key;
        n.f(map, "args");
        List parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        final int i5 = 1;
        ArrayList arrayList2 = new ArrayList(i5);
        Iterator iterator = parameters.iterator();
        final int i6 = 0;
        i4 = i2;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (i != 0 && i % 32 == 0) {
            }
            arrayList.add(t(next2.getType()));
            if (next2.f() == k.a.VALUE) {
            }
            i++;
            if (j0.i(next2.getType())) {
            } else {
            }
            i3 = j0.e(c.f(next2.getType()));
            arrayList.add(i3);
            i4 = i9;
            i2 = i5;
            arrayList.add(map.get(next2));
            if (i % 32 == 0) {
            }
            arrayList2.add(Integer.valueOf(i4));
            i4 = i6;
        }
        if (d2 != null) {
            arrayList.add(d2);
        }
        String obj12 = "null cannot be cast to non-null type kotlin.Array<T>";
        if (i2 == 0) {
            Object[] obj13 = arrayList.toArray(new Object[i6]);
            Objects.requireNonNull(obj13, obj12);
            return call(Arrays.copyOf(obj13, obj13.length));
        }
        arrayList2.add(Integer.valueOf(i4));
        obj13 = x();
        if (obj13 == null) {
        } else {
            arrayList.addAll(arrayList2);
            arrayList.add(0);
            Object[] array = arrayList.toArray(new Object[i6]);
            if (array == null) {
            } else {
                return obj13.call(array);
            }
            obj13 = new NullPointerException(obj12);
            throw obj13;
        }
        obj13 = new StringBuilder();
        obj13.append("This callable does not support a default call: ");
        obj13.append(y());
        obj12 = new a0(obj13.toString());
        throw obj12;
    }

    public abstract d<?> v();

    @Override // kotlin.i0.c
    public abstract kotlin.i0.z.e.j w();

    public abstract d<?> x();

    @Override // kotlin.i0.c
    public abstract b y();

    @Override // kotlin.i0.c
    protected final boolean z() {
        boolean annotation;
        int i;
        if (n.b(getName(), "<init>") && w().d().isAnnotation()) {
            i = w().d().isAnnotation() ? 1 : 0;
        } else {
        }
        return i;
    }
}
