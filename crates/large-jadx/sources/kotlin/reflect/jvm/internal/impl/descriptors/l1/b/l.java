package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.i;
import kotlin.i0.z.e.m0.d.a.i0.j;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.i0.z.e.m0.f.b;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class l extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w implements j {

    private final Type b;
    private final i c;
    public l(Type type) {
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n xVar;
        String str;
        Type obj4;
        n.f(type, "reflectType");
        super();
        this.b = type;
        obj4 = Q();
        if (obj4 instanceof Class) {
            xVar = new j((Class)obj4);
            this.c = xVar;
        } else {
            if (obj4 instanceof TypeVariable) {
                xVar = new x((TypeVariable)obj4);
            } else {
                if (!obj4 instanceof ParameterizedType) {
                } else {
                    obj4 = (ParameterizedType)obj4.getRawType();
                    Objects.requireNonNull(obj4, "null cannot be cast to non-null type java.lang.Class<*>");
                    xVar = new j((Class)obj4);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a classifier type (");
        stringBuilder.append(obj4.getClass());
        stringBuilder.append("): ");
        stringBuilder.append(obj4);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public List<x> F() {
        int i;
        List list = b.e(Q());
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (Type next2 : iterator) {
            arrayList.add(w.a.a(next2));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public Type Q() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public i c() {
        return this.c;
    }

    public Collection<a> getAnnotations() {
        return p.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public boolean n() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public a o(b b) {
        n.f(b, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public String q() {
        return Q().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public boolean x() {
        int i2;
        Type type;
        boolean str;
        int i;
        type = Q();
        final int i3 = 1;
        if (type instanceof Class) {
            java.lang.reflect.TypeVariable[] typeParameters = (Class)type.getTypeParameters();
            n.e(typeParameters, "getTypeParameters()");
            i2 = typeParameters.length == 0 ? i3 : i;
            if (i2 ^= i3 != 0) {
                i = i3;
            }
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w
    public String y() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(n.o("Type not found: ", Q()));
        throw unsupportedOperationException;
    }
}
