package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.a0;
import kotlin.i0.z.e.m0.d.a.i0.x;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class y extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n implements a0 {

    private final kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w a;
    private final Annotation[] b;
    private final String c;
    private final boolean d;
    public y(kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w w, Annotation[] annotation2Arr2, String string3, boolean z4) {
        n.f(w, "type");
        n.f(annotation2Arr2, "reflectAnnotations");
        super();
        this.a = w;
        this.b = annotation2Arr2;
        this.c = string3;
        this.d = z4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c Q(b b) {
        n.f(b, "fqName");
        return g.a(this.b, b);
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.l1.b.c> R() {
        return g.b(this.b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public kotlin.reflect.jvm.internal.impl.descriptors.l1.b.w S() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean g() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public Collection getAnnotations() {
        return R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public e getName() {
        int i;
        String str = this.c;
        if (str == null) {
            i = 0;
        } else {
            i = e.i(str);
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public x getType() {
        return S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public boolean n() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public a o(b b) {
        return Q(b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.n
    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.class.getName());
        String str2 = ": ";
        stringBuilder.append(str2);
        str = g() ? "vararg " : "";
        stringBuilder.append(str);
        stringBuilder.append(getName());
        stringBuilder.append(str2);
        stringBuilder.append(S());
        return stringBuilder.toString();
    }
}
