package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a0;
import kotlin.i0.z.e.m0.d.a.i0.k;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class m extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r implements k {

    private final Constructor<?> a;
    public m(Constructor<?> constructor) {
        n.f(constructor, "member");
        super();
        this.a = constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.r
    public Member T() {
        return V();
    }

    public Constructor<?> V() {
        return this.a;
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
        java.lang.reflect.Type[] genericParameterTypes;
        int i;
        Class declaringClass;
        java.lang.annotation.Annotation[][] parameterAnnotations;
        int length;
        int length2;
        genericParameterTypes = V().getGenericParameterTypes();
        n.e(genericParameterTypes, "types");
        int i2 = 1;
        i = genericParameterTypes.length == 0 ? i2 : 0;
        if (i != 0) {
            return p.g();
        }
        declaringClass = V().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            if (!Modifier.isStatic(declaringClass.getModifiers())) {
                genericParameterTypes = i.j(genericParameterTypes, i2, genericParameterTypes.length);
            }
        }
        parameterAnnotations = V().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
        } else {
            if (parameterAnnotations.length > genericParameterTypes.length) {
                n.e(parameterAnnotations, "annotations");
                parameterAnnotations = i.j(parameterAnnotations, length5 -= length7, parameterAnnotations.length);
            }
            n.e(genericParameterTypes, "realTypes");
            n.e(parameterAnnotations, "realAnnotations");
            return U(genericParameterTypes, parameterAnnotations, V().isVarArgs());
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Illegal generic signature: ", V()));
        throw illegalStateException;
    }
}
