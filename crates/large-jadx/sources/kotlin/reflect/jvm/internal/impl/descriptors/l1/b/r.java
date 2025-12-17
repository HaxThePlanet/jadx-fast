package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.a0;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.q;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.f.g;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class r extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n implements kotlin.reflect.jvm.internal.impl.descriptors.l1.b.f, kotlin.reflect.jvm.internal.impl.descriptors.l1.b.t, q {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public int E() {
        return T().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public g P() {
        return S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c Q(b b) {
        return f.a.a(this, b);
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c> R() {
        return f.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j S() {
        Class declaringClass = T().getDeclaringClass();
        n.e(declaringClass, "member.declaringClass");
        j jVar = new j(declaringClass);
        return jVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public abstract Member T();

    protected final List<a0> U(Type[] typeArr, Annotation[][] annotation2Arr2Arr2, boolean z3) {
        int valueOf;
        int i4;
        int length;
        int i2;
        Object obj;
        int i3;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w wVar;
        int i5;
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.y yVar;
        n.f(typeArr, "parameterTypes");
        n.f(annotation2Arr2Arr2, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List list = a.a.b(T());
        int i6 = 0;
        if (list == null) {
            valueOf = i6;
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        final int i7 = 0;
        if (valueOf == 0) {
            i4 = i7;
        } else {
            intValue -= length;
        }
        length3--;
        if (i8 >= 0) {
            i2 = i7;
            i3 = i2 + 1;
            wVar = w.a.a(typeArr[i2]);
            while (list == null) {
                i5 = i6;
                if (z3 && i2 == i.B(typeArr)) {
                } else {
                }
                i = i7;
                yVar = new y(wVar, annotation2Arr2Arr2[i2], i5, i);
                arrayList.add(yVar);
                i2 = i3;
                i3 = i2 + 1;
                wVar = w.a.a(typeArr[i2]);
                if (i2 == i.B(typeArr)) {
                } else {
                }
                i = 1;
            }
            StringBuilder obj13 = new StringBuilder();
            obj13.append("No parameter with index ");
            obj13.append(i2);
            obj13.append('+');
            obj13.append(i4);
            obj13.append(" (name=");
            obj13.append(getName());
            obj13.append(" type=");
            obj13.append(wVar);
            obj13.append(") in ");
            obj13.append(list);
            obj13.append("@ReflectJavaMember");
            IllegalStateException obj14 = new IllegalStateException(obj13.toString().toString());
            throw obj14;
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof r && n.b(T(), (r)object.T())) {
            obj2 = n.b(T(), (r)object.T()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection getAnnotations() {
        return R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public AnnotatedElement getElement() {
        return (AnnotatedElement)T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public e getName() {
        int i;
        String str;
        String name = T().getName();
        if (name == null) {
            i = 0;
        } else {
            i = e.j(name);
        }
        if (i == 0) {
            n.e(g.a, "NO_NAME_PROVIDED");
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public g1 getVisibility() {
        return t.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public int hashCode() {
        return T().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean i() {
        return t.a.d(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean isAbstract() {
        return t.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean isFinal() {
        return t.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean n() {
        return f.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public a o(b b) {
        return Q(b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(T());
        return stringBuilder.toString();
    }
}
