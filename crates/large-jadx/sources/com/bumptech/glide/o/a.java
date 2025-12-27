package com.bumptech.glide.o;

import com.bumptech.glide.t.l;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements l {

    private final Set<m> a;
    private boolean b;
    private boolean c;
    a() {
        super();
        this.a = Collections.newSetFromMap(new WeakHashMap());
    }

    public void a(m mVar) {
        this.a.add(mVar);
        if (this.c) {
            mVar.onDestroy();
        } else {
            if (this.b) {
                mVar.onStart();
            } else {
                mVar.onStop();
            }
        }
    }

    public void b(m mVar) {
        this.a.remove(mVar);
    }

    void c() {
        this.c = true;
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            (m)it.next().onDestroy();
        }
    }

    void d() {
        this.b = true;
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            (m)it.next().onStart();
        }
    }

    void e() {
        this.b = false;
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            (m)it.next().onStop();
        }
    }
}
