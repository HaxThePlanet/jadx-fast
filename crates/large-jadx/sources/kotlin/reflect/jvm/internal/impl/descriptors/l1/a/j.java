package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.j.b.p;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public final class j implements p {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.j b;
    static {
        j jVar = new j();
        j.b = jVar;
    }

    @Override // kotlin.i0.z.e.m0.j.b.p
    public void a(b b) {
        n.f(b, "descriptor");
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Cannot infer visibility for ", b));
        throw illegalStateException;
    }

    public void b(e e, List<String> list2) {
        n.f(e, "descriptor");
        n.f(list2, "unresolvedSuperClasses");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Incomplete hierarchy for class ");
        stringBuilder.append(e.getName());
        stringBuilder.append(", unresolved classes ");
        stringBuilder.append(list2);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }
}
