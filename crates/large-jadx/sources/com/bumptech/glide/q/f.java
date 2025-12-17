package com.bumptech.glide.q;

import com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    private final List<com.bumptech.glide.q.f.a<?>> a;

    private static final class a {

        private final Class<T> a;
        final k<T> b;
        a(Class<T> class, k<T> k2) {
            super();
            this.a = class;
            this.b = k2;
        }

        boolean a(Class<?> class) {
            return this.a.isAssignableFrom(class);
        }
    }
    public f() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public <Z> void a(Class<Z> class, k<Z> k2) {
        f.a aVar = new f.a(class, k2);
        this.a.add(aVar);
        return;
        synchronized (this) {
            aVar = new f.a(class, k2);
            this.a.add(aVar);
        }
    }

    public <Z> k<Z> b(Class<Z> class) {
        int i;
        Object obj;
        boolean z;
        i = 0;
        synchronized (this) {
            while (i < this.a.size()) {
                obj = this.a.get(i);
                i++;
            }
            return 0;
        }
    }
}
