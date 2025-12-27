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

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class r {

    private final Set<d> a;
    private final Set<d> b = new HashSet<>();
    private boolean c;
    public r() {
        super();
        this.a = Collections.newSetFromMap(new WeakHashMap());
        HashSet hashSet = new HashSet();
    }

    public boolean a(d dVar) {
        boolean z = true;
        z = true;
        if (dVar == null) {
            return true;
        }
        if (!this.b.remove(dVar)) {
            if (!(this.a.remove(dVar))) {
                int i = 0;
            }
        }
        if (z) {
            dVar.clear();
        }
        return z;
    }

    public void b() {
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            a((d)it.next());
        }
        this.b.clear();
    }

    public void c() {
        this.c = true;
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }

    public void d() {
        this.c = true;
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }

    public void e() {
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
    }

    public void f() {
        this.c = false;
        Iterator it = l.i(this.a).iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        this.b.clear();
    }

    public void g(d dVar) {
        this.a.add(dVar);
        if (!this.c) {
            dVar.i();
        } else {
            dVar.clear();
            str = "RequestTracker";
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "Paused, delaying request");
            }
            this.b.add(dVar);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String object = super.toString();
        String str2 = "{numRequests=";
        int size = this.a.size();
        String str3 = ", isPaused=";
        String str4 = "}";
        str = object + str2 + size + str3 + this.c + str4;
        return str;
    }
}
