package kotlin.i0.z.e.l0;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.n;
import kotlin.h0.d;
import kotlin.h0.f;
import kotlin.h0.f.a;
import kotlin.h0.g;
import kotlin.i0.z.e.a0;
import kotlin.i0.z.e.j0;
import kotlin.i0.z.e.m0.i.f;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.x;

/* loaded from: classes3.dex */
public final class g<M extends java.lang.reflect.Member>  implements kotlin.i0.z.e.l0.d<M> {

    private final kotlin.i0.z.e.l0.g.a a;
    private final kotlin.i0.z.e.l0.d<M> b;
    private final boolean c;

    private static final class a {

        private final f a;
        private final Method[] b;
        private final Method c;
        public a(f f, Method[] method2Arr2, Method method3) {
            n.f(f, "argumentRange");
            n.f(method2Arr2, "unbox");
            super();
            this.a = f;
            this.b = method2Arr2;
            this.c = method3;
        }

        public final f a() {
            return this.a;
        }

        public final Method[] b() {
            return this.b;
        }

        public final Method c() {
            return this.c;
        }
    }
    public g(b b, kotlin.i0.z.e.l0.d<? extends M> d2, boolean z3) {
        int i;
        int z;
        boolean z2;
        int type;
        int i2;
        Method[] arr;
        boolean str;
        String type2;
        int i3;
        int i4;
        boolean z4;
        kotlin.i0.z.e.l0.g.a obj8;
        f obj9;
        ArrayList obj10;
        n.f(b, "descriptor");
        n.f(d2, "caller");
        super();
        this.b = d2;
        this.c = z3;
        kotlin.i0.z.e.m0.l.b0 returnType = b.getReturnType();
        n.d(returnType);
        n.e(returnType, "descriptor.returnType!!");
        Class cls = h.i(returnType);
        int i7 = 0;
        if (cls != null) {
            i = h.d(cls, b);
        } else {
            i = i7;
        }
        i2 = 0;
        if (f.a(b)) {
            obj8 = new g.a(f.x.a(), new Method[i2], i);
            this.a = obj8;
        } else {
            str = "descriptor.containingDeclaration";
            i3 = -1;
            if (d2 instanceof e.h.c) {
            } else {
                if (b instanceof l) {
                    if (d2 instanceof c) {
                    } else {
                        i3 = i2;
                    }
                } else {
                    if (b.f0() != null && !d2 instanceof c) {
                        if (!d2 instanceof c) {
                            obj9 = b.b();
                            n.e(obj9, str);
                            if (f.b(obj9)) {
                            } else {
                                i3 = i4;
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
            obj9 = z3 ? 2 : i2;
            if (b instanceof x && (x)b.isSuspend()) {
                if ((x)b.isSuspend()) {
                } else {
                    i4 = i2;
                }
            } else {
            }
            obj10 = new ArrayList();
            kotlin.reflect.jvm.internal.impl.descriptors.r0 r0Var = b.m0();
            if (r0Var != null) {
                type = r0Var.getType();
            } else {
                type = i7;
            }
            if (type != null) {
                obj10.add(type);
            } else {
                if (b instanceof l) {
                    type = (l)b.z();
                    n.e(type, "descriptor.constructedClass");
                    if (type.k()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = type.b();
                        Objects.requireNonNull(mVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        obj10.add((e)mVar.q());
                    }
                } else {
                    type = b.b();
                    n.e(type, str);
                    if (type instanceof e && f.b(type)) {
                        if (f.b(type)) {
                            obj10.add((e)type.q());
                        }
                    }
                }
            }
            List list = b.h();
            n.e(list, "descriptor.valueParameters");
            Iterator iterator = list.iterator();
            for (c1 next2 : iterator) {
                obj10.add(next2.getType());
            }
            i8 += obj9;
            if (f.a(this) != z) {
            } else {
                obj9 = g.l(Math.max(i3, i2), size2 += i3);
                arr = new Method[z];
                while (i2 < z) {
                    z4 = h.i((b0)obj10.get(i2 - i3));
                    if (obj9.m(i2) && z4 != null) {
                    } else {
                    }
                    i4 = i7;
                    arr[i2] = i4;
                    i2++;
                    z4 = h.i((b0)obj10.get(i2 - i3));
                    if (z4 != null) {
                    } else {
                    }
                    i4 = h.f(z4, b);
                }
                obj8 = new g.a(obj9, arr, i);
            }
        }
        obj10 = new StringBuilder();
        obj10.append("Inconsistent number of parameters in the descriptor and Java reflection object: ");
        obj10.append(f.a(this));
        obj10.append(" != ");
        obj10.append(z);
        int i6 = 10;
        obj10.append(i6);
        obj10.append("Calling: ");
        obj10.append(b);
        obj10.append(i6);
        obj10.append("Parameter types: ");
        obj10.append(a());
        obj10.append(")\n");
        obj10.append("Default: ");
        obj10.append(this.c);
        obj9 = new a0(obj10.toString());
        throw obj9;
    }

    public List<Type> a() {
        return this.b.a();
    }

    public M b() {
        return this.b.b();
    }

    @Override // kotlin.i0.z.e.l0.d
    public Object call(Object[] objectArr) {
        Object invoke;
        int i2;
        Method[] arr2;
        int i;
        Object returnType;
        Object invoke2;
        Object[] arr;
        Object obj10;
        n.f(objectArr, "args");
        kotlin.i0.z.e.l0.g.a aVar = this.a;
        f fVar = aVar.a();
        invoke = aVar.c();
        Object[] copyOf = Arrays.copyOf(objectArr, objectArr.length);
        n.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        i2 = fVar.g();
        final int i4 = 0;
        if (fVar.d() <= i2) {
        }
        arr2 = new Object[1];
        arr2[i4] = this.b.call(copyOf);
        invoke = invoke.invoke(0, arr2);
        if (invoke != null && invoke != null) {
            arr2 = new Object[1];
            arr2[i4] = obj10;
            invoke = invoke.invoke(0, arr2);
            if (invoke != null) {
                obj10 = invoke;
            }
        }
        return obj10;
    }

    @Override // kotlin.i0.z.e.l0.d
    public Type getReturnType() {
        return this.b.getReturnType();
    }
}
