package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public abstract class g1 {

    private final String a;
    private final boolean b;
    protected g1(String string, boolean z2) {
        n.f(string, "name");
        super();
        this.a = string;
        this.b = z2;
    }

    public Integer a(kotlin.reflect.jvm.internal.impl.descriptors.g1 g1) {
        n.f(g1, "visibility");
        return f1.a.a(this, g1);
    }

    public String b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.g1 d() {
        return this;
    }

    public final String toString() {
        return b();
    }
}
