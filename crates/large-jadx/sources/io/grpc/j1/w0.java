package io.grpc.j1;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class w0<T>  {

    private final Set<T> a;
    public w0() {
        super();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.a = Collections.newSetFromMap(identityHashMap);
    }

    public final boolean a(Object... objectArr) {
        int i;
        boolean contains;
        Set set;
        final int i2 = 0;
        i = i2;
        while (i < objectArr.length) {
            i++;
        }
        return i2;
    }

    protected abstract void b();

    protected abstract void c();

    public final boolean d() {
        return empty ^= 1;
    }

    public final void e(T t, boolean z2) {
        boolean obj2;
        Set obj3;
        int size = this.a.size();
        if (z2) {
            this.a.add(t);
            if (size == 0) {
                b();
            }
        } else {
            if (this.a.remove(t) && size == 1) {
                if (size == 1) {
                    c();
                }
            }
        }
    }
}
