package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a0;
import kotlin.i0.z.e.m0.d.a.i0.b;
import kotlin.i0.z.e.m0.d.a.i0.r;
import kotlin.i0.z.e.m0.d.a.i0.r.a;
import kotlin.i0.z.e.m0.d.a.i0.x;

/* loaded from: classes3.dex */
public final class s extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r implements r {

    private final Method a;
    public s(Method method) {
        n.f(method, "member");
        super();
        this.a = method;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public boolean L() {
        return r.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public Member T() {
        return V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public Method V() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w W() {
        java.lang.reflect.Type genericReturnType = V().getGenericReturnType();
        n.e(genericReturnType, "member.genericReturnType");
        return w.a.a(genericReturnType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public x getReturnType() {
        return W();
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.x> getTypeParameters() {
        int i;
        java.lang.reflect.TypeVariable typeVariable;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.x xVar;
        java.lang.reflect.TypeVariable[] typeParameters = V().getTypeParameters();
        n.e(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        i = 0;
        while (i < typeParameters.length) {
            xVar = new x(typeParameters[i]);
            arrayList.add(xVar);
            i++;
        }
        return arrayList;
    }

    public List<a0> h() {
        java.lang.reflect.Type[] genericParameterTypes = V().getGenericParameterTypes();
        n.e(genericParameterTypes, "member.genericParameterTypes");
        java.lang.annotation.Annotation[][] parameterAnnotations = V().getParameterAnnotations();
        n.e(parameterAnnotations, "member.parameterAnnotations");
        return U(genericParameterTypes, parameterAnnotations, V().isVarArgs());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public b t() {
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d.a aVar;
        Object defaultValue = V().getDefaultValue();
        if (defaultValue == null) {
        } else {
            i = d.b.a(defaultValue, 0);
        }
        return i;
    }
}
