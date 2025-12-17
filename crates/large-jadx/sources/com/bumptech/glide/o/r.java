package com.bumptech.glide.o;

import android.util.Log;
import com.bumptech.glide.r.d;
import com.bumptech.glide.t.l;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class r {

    private final Set<d> a;
    private final Set<d> b;
    private boolean c;
    public r() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap();
        this.a = Collections.newSetFromMap(weakHashMap);
        HashSet hashSet = new HashSet();
        this.b = hashSet;
    }

    public boolean a(d d) {
        int i;
        if (d == null) {
            return 1;
        }
        if (!this.b.remove(d)) {
            if (this.a.remove(d)) {
            } else {
                i = 0;
            }
        }
        if (i != 0) {
            d.clear();
        }
        return i;
    }

    public void b() {
        Object next;
        Iterator iterator = l.i(this.a).iterator();
        for (d next : iterator) {
            a(next);
        }
        this.b.clear();
    }

    public void c() {
        Object next;
        boolean running;
        this.c = true;
        Iterator iterator = l.i(this.a).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!(d)next.isRunning()) {
            } else {
            }
            next.clear();
            this.b.add(next);
            if (next.k()) {
            }
        }
    }

    public void d() {
        Object next;
        boolean running;
        this.c = true;
        Iterator iterator = l.i(this.a).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((d)next.isRunning()) {
            }
            next.d();
            this.b.add(next);
        }
    }

    public void e() {
        Object next;
        boolean z;
        Iterator iterator = l.i(this.a).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!(d)next.k() && !next.g()) {
            }
            if (!next.g()) {
            }
            next.clear();
            if (!this.c) {
            } else {
            }
            this.b.add(next);
            next.i();
        }
    }

    public void f() {
        Object next;
        boolean running;
        this.c = false;
        Iterator iterator = l.i(this.a).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (!(d)next.k() && !next.isRunning()) {
            }
            if (!next.isRunning()) {
            }
            next.i();
        }
        this.b.clear();
    }

    public void g(d d) {
        boolean z;
        boolean loggable;
        String str;
        this.a.add(d);
        if (!this.c) {
            d.i();
        } else {
            d.clear();
            str = "RequestTracker";
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "Paused, delaying request");
            }
            this.b.add(d);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("{numRequests=");
        stringBuilder.append(this.a.size());
        stringBuilder.append(", isPaused=");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
