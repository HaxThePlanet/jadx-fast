package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.lang.annotation.Annotation;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;

/* loaded from: classes3.dex */
public final class b implements u0 {

    private final Annotation b;
    public b(Annotation annotation) {
        n.f(annotation, "annotation");
        super();
        this.b = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public v0 a() {
        final v0 v0Var = v0.a;
        n.e(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
    public final Annotation d() {
        return this.b;
    }
}
