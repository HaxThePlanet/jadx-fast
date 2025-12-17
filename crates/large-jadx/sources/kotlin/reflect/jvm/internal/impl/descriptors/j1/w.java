package kotlin.reflect.jvm.internal.impl.descriptors.j1;

import java.util.List;
import java.util.Set;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class w implements kotlin.reflect.jvm.internal.impl.descriptors.j1.v {

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> a;
    private final Set<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> b;
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> c;
    public w(List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> list, Set<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> set2, List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> list3, Set<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> set4) {
        n.f(list, "allDependencies");
        n.f(set2, "modulesWhoseInternalsAreVisible");
        n.f(list3, "directExpectedByDependencies");
        n.f(set4, "allExpectedByDependencies");
        super();
        this.a = list;
        this.b = set2;
        this.c = list3;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> a() {
        return this.a;
    }

    public Set<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> b() {
        return this.b;
    }

    public List<kotlin.reflect.jvm.internal.impl.descriptors.j1.x> c() {
        return this.c;
    }
}
