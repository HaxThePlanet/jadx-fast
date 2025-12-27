package com.bumptech.glide.o;

import com.bumptech.glide.r.k.h;
import com.bumptech.glide.t.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class u implements m {

    private final Set<h<?>> a;
    public u() {
        super();
        this.a = Collections.newSetFromMap(new WeakHashMap());
    }

    public void a() {
        this.a.clear();
    }

    public List<h<?>> b() {
        return l.i(this.a);
    }

    public void c(h<?> hVar) {
        this.a.add(hVar);
    }

    public void d(h<?> hVar) {
        this.a.remove(hVar);
    }

    public void onDestroy() {
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            (h)it.next().onDestroy();
        }
    }

    public void onStart() {
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            (h)it.next().onStart();
        }
    }

    public void onStop() {
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            (h)it.next().onStop();
        }
    }
}
