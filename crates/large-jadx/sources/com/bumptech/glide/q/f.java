package com.bumptech.glide.q;

import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    private final List<f.a<?>> a = new ArrayList<>();

    private static final class a<T> {

        private final Class<T> a;
        final k<T> b;
        a(Class<T> cls, k<T> kVar) {
            super();
            this.a = cls;
            this.b = kVar;
        }

        boolean a(Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }
    public f() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    public synchronized <Z> void a(Class<Z> cls, k<Z> kVar) {
        this.a.add(new f.a(cls, kVar));
    }

    public synchronized <Z> k<Z> b(Class<Z> cls) {
        int i = 0;
        i = 0;
        Object item = this.a.get(i);
        return null;
    }
}
