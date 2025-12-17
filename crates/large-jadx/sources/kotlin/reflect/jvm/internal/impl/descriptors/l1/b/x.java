package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.y;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class x extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n implements kotlin.reflect.jvm.internal.impl.descriptors.l1.b.f, y {

    private final TypeVariable<?> a;
    public x(TypeVariable<?> typeVariable) {
        n.f(typeVariable, "typeVariable");
        super();
        this.a = typeVariable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c Q(b b) {
        return f.a.a(this, b);
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c> R() {
        return f.a.b(this);
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.l> S() {
        java.lang.reflect.Type type2;
        int i;
        java.lang.reflect.Type type;
        kotlin.reflect.jvm.internal.impl.descriptors.l1.b.l lVar;
        java.lang.reflect.Type[] bounds = this.a.getBounds();
        n.e(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        i = 0;
        while (i < bounds.length) {
            lVar = new l(bounds[i]);
            arrayList.add(lVar);
            i++;
        }
        Object obj = p.B0(arrayList);
        if ((l)obj == null) {
            type2 = 0;
        } else {
            type2 = (l)obj.Q();
        }
        if (n.b(type2, Object.class)) {
            return p.g();
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof x && n.b(this.a, object.a)) {
            obj2 = n.b(this.a, object.a) ? 1 : 0;
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
        TypeVariable typeVariable;
        if (typeVariable instanceof AnnotatedElement) {
        } else {
            typeVariable = 0;
        }
        return typeVariable;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public e getName() {
        e eVar = e.j(this.a.getName());
        n.e(eVar, "identifier(typeVariable.name)");
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection getUpperBounds() {
        return S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public int hashCode() {
        return this.a.hashCode();
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
        stringBuilder.append(x.class.getName());
        stringBuilder.append(": ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
