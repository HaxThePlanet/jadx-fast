package io.grpc.j1;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: InUseStateAggregator.java */
/* loaded from: classes3.dex */
public abstract class w0<T> {

    private final Set<T> a;
    public w0() {
        super();
        this.a = Collections.newSetFromMap(new IdentityHashMap());
    }

    public final boolean a(Object... objectArr) {
        int i;
        i = 0;
        for (Object obj : objectArr) {
            if (this.a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final boolean d() {
        return !this.a.isEmpty();
    }

    public final void e(T t, boolean z) {
        int size = this.a.size();
        if (z) {
            this.a.add(t);
            if (size == 0) {
                b();
            }
        } else {
            if (this.a.remove(t) && size == 1) {
                c();
            }
        }
    }

    protected abstract void b();

    protected abstract void c();
}
