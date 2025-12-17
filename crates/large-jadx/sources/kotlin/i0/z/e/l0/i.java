package kotlin.i0.z.e.l0;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class i implements kotlin.i0.z.e.l0.d<Method> {

    private final Type a;
    private final Method b;
    private final List<Type> c;

    public static final class a extends kotlin.i0.z.e.l0.i implements kotlin.i0.z.e.l0.c {

        private final Object d;
        public a(Method method, Object object2) {
            n.f(method, "unboxMethod");
            super(method, p.g(), 0);
            this.d = object2;
        }

        @Override // kotlin.i0.z.e.l0.i
        public Object call(Object[] objectArr) {
            n.f(objectArr, "args");
            d(objectArr);
            return c(this.d, objectArr);
        }
    }

    public static final class b extends kotlin.i0.z.e.l0.i {
        public b(Method method) {
            n.f(method, "unboxMethod");
            super(method, p.b(method.getDeclaringClass()), 0);
        }

        @Override // kotlin.i0.z.e.l0.i
        public Object call(Object[] objectArr) {
            int str;
            Object[] obj5;
            n.f(objectArr, "args");
            d(objectArr);
            str = 0;
            kotlin.i0.z.e.l0.e.d dVar = e.e;
            final int i = 1;
            if (objectArr.length <= i) {
                obj5 = new Object[str];
            } else {
                Objects.requireNonNull(i.j(objectArr, i, objectArr.length), "null cannot be cast to non-null type kotlin.Array<T>");
            }
            return c(objectArr[str], obj5);
        }
    }
    private i(Method method, List<? extends Type> list2) {
        super();
        this.b = method;
        this.c = list2;
        final Class obj1 = method.getReturnType();
        n.e(obj1, "unboxMethod.returnType");
        this.a = obj1;
    }

    public i(Method method, List list2, g g3) {
        super(method, list2);
    }

    public final List<Type> a() {
        return this.c;
    }

    @Override // kotlin.i0.z.e.l0.d
    public Member b() {
        return e();
    }

    @Override // kotlin.i0.z.e.l0.d
    protected final Object c(Object object, Object[] object2Arr2) {
        n.f(object2Arr2, "args");
        return this.b.invoke(object, Arrays.copyOf(object2Arr2, object2Arr2.length));
    }

    @Override // kotlin.i0.z.e.l0.d
    public void d(Object[] objectArr) {
        n.f(objectArr, "args");
        d.a.a(this, objectArr);
    }

    @Override // kotlin.i0.z.e.l0.d
    public final Method e() {
        return null;
    }

    @Override // kotlin.i0.z.e.l0.d
    public final Type getReturnType() {
        return this.a;
    }
}
