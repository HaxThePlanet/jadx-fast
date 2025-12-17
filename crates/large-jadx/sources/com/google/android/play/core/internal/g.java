package com.google.android.play.core.internal;

import f.c.a.f.a.c.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class g<StateT>  {

    protected final Set<a<StateT>> a;
    public g() {
        super();
        HashSet hashSet = new HashSet();
        this.a = hashSet;
    }

    public final void a(a<StateT> a) {
        this.a.add(a);
        return;
        synchronized (this) {
            this.a.add(a);
        }
    }

    public final void b(a<StateT> a) {
        this.a.remove(a);
        return;
        synchronized (this) {
            this.a.remove(a);
        }
    }

    public final void c(StateT statet) {
        Object next;
        Iterator iterator = this.a.iterator();
        synchronized (this) {
            try {
                for (a next : iterator) {
                    next.a(statet);
                }
                (a)iterator.next().a(statet);
                throw statet;
            }
        }
    }
}
