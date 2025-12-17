package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.d0.a;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.a.a;
import kotlin.i0.z.e.m0.d.a.i0.b;
import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class c extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n implements a {

    private final Annotation a;
    public c(Annotation annotation) {
        n.f(annotation, "annotation");
        super();
        this.a = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public final Annotation Q() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.j R() {
        j jVar = new j(a.b(a.a(this.a)));
        return jVar;
    }

    public Collection<b> b() {
        int i;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d dVar;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d.a aVar;
        Object invoke;
        String str;
        Method[] declaredMethods = a.b(a.a(this.a)).getDeclaredMethods();
        n.e(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        final int i2 = 0;
        i = i2;
        while (i < declaredMethods.length) {
            Method method = declaredMethods[i];
            invoke = method.invoke(Q(), new Object[i2]);
            n.e(invoke, "method.invoke(annotation)");
            arrayList.add(d.b.a(invoke, e.j(method.getName())));
            i++;
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public a e() {
        return b.b(a.b(a.a(this.a)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof c && n.b(this.a, object.a)) {
            obj2 = n.b(this.a, object.a) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean f() {
        return a.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c.class.getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean w() {
        return a.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public g z() {
        return R();
    }
}
