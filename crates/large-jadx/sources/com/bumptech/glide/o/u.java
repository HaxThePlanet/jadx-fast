package com.bumptech.glide.o;

import com.bumptech.glide.r.k.h;
import com.bumptech.glide.t.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class u implements com.bumptech.glide.o.m {

    private final Set<h<?>> a;
    public u() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.a = Collections.newSetFromMap(weakHashMap);
    }

    @Override // com.bumptech.glide.o.m
    public void a() {
        this.a.clear();
    }

    public List<h<?>> b() {
        return l.i(this.a);
    }

    public void c(h<?> h) {
        this.a.add(h);
    }

    public void d(h<?> h) {
        this.a.remove(h);
    }

    @Override // com.bumptech.glide.o.m
    public void onDestroy() {
        Object next;
        Iterator iterator = l.i(this.a).iterator();
        for (h next : iterator) {
            next.onDestroy();
        }
    }

    @Override // com.bumptech.glide.o.m
    public void onStart() {
        Object next;
        Iterator iterator = l.i(this.a).iterator();
        for (h next : iterator) {
            next.onStart();
        }
    }

    @Override // com.bumptech.glide.o.m
    public void onStop() {
        Object next;
        Iterator iterator = l.i(this.a).iterator();
        for (h next : iterator) {
            next.onStop();
        }
    }
}
