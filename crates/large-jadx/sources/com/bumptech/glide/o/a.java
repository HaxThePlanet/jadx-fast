package com.bumptech.glide.o;

import com.bumptech.glide.t.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class a implements com.bumptech.glide.o.l {

    private final Set<com.bumptech.glide.o.m> a;
    private boolean b;
    private boolean c;
    a() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.a = Collections.newSetFromMap(weakHashMap);
    }

    @Override // com.bumptech.glide.o.l
    public void a(com.bumptech.glide.o.m m) {
        boolean z;
        this.a.add(m);
        if (this.c) {
            m.onDestroy();
        } else {
            if (this.b) {
                m.onStart();
            } else {
                m.onStop();
            }
        }
    }

    @Override // com.bumptech.glide.o.l
    public void b(com.bumptech.glide.o.m m) {
        this.a.remove(m);
    }

    @Override // com.bumptech.glide.o.l
    void c() {
        Object next;
        this.c = true;
        Iterator iterator = l.i(this.a).iterator();
        for (m next : iterator) {
            next.onDestroy();
        }
    }

    @Override // com.bumptech.glide.o.l
    void d() {
        Object next;
        this.b = true;
        Iterator iterator = l.i(this.a).iterator();
        for (m next : iterator) {
            next.onStart();
        }
    }

    @Override // com.bumptech.glide.o.l
    void e() {
        Object next;
        this.b = false;
        Iterator iterator = l.i(this.a).iterator();
        for (m next : iterator) {
            next.onStop();
        }
    }
}
