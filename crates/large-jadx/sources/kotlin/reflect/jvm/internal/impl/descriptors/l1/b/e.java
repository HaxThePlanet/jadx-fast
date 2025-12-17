package kotlin.reflect.jvm.internal.impl.descriptors.l1.b;

import java.lang.annotation.Annotation;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.a.i0.a;
import kotlin.i0.z.e.m0.d.a.i0.c;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public final class e extends kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d implements c {

    private final Annotation c;
    public e(e e, Annotation annotation2) {
        n.f(annotation2, "annotation");
        super(e);
        this.c = annotation2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l1.b.d
    public a a() {
        c cVar = new c(this.c);
        return cVar;
    }
}
