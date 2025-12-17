package androidx.camera.core.impl;

import java.util.Set;

/* loaded from: classes.dex */
public interface m extends androidx.camera.core.impl.g {
    public <ValueT> ValueT a(androidx.camera.core.impl.g.a<ValueT> g$a, androidx.camera.core.impl.g.b g$b2) {
        return d().a(a, b2);
    }

    public Set<androidx.camera.core.impl.g.a<?>> b() {
        return d().b();
    }

    public Set<androidx.camera.core.impl.g.b> c(androidx.camera.core.impl.g.a<?> g$a) {
        return d().c(a);
    }

    @Override // androidx.camera.core.impl.g
    public abstract androidx.camera.core.impl.g d();
}
