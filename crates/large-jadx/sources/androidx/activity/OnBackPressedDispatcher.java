package androidx.activity;

import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.j.c;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    private final Runnable a;
    final ArrayDeque<androidx.activity.d> b;

    private class a implements androidx.activity.c {

        private final androidx.activity.d a;
        final androidx.activity.OnBackPressedDispatcher b;
        a(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, androidx.activity.d d2) {
            this.b = onBackPressedDispatcher;
            super();
            this.a = d2;
        }

        @Override // androidx.activity.c
        public void cancel() {
            onBackPressedDispatcher.b.remove(this.a);
            this.a.e(this);
        }
    }

    private class LifecycleOnBackPressedCancellable implements n, androidx.activity.c {

        private final j a;
        private final androidx.activity.d b;
        private androidx.activity.c c;
        final androidx.activity.OnBackPressedDispatcher v;
        LifecycleOnBackPressedCancellable(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, j j2, androidx.activity.d d3) {
            this.v = onBackPressedDispatcher;
            super();
            this.a = j2;
            this.b = d3;
            j2.a(this);
        }

        @Override // androidx.lifecycle.n
        public void c(q q, j.b j$b2) {
            Object obj1;
            Object obj2;
            if (b2 == j.b.ON_START) {
                this.c = this.v.c(this.b);
            } else {
                if (b2 == j.b.ON_STOP) {
                    obj1 = this.c;
                    if (obj1 != null) {
                        obj1.cancel();
                    }
                } else {
                    if (b2 == j.b.ON_DESTROY) {
                        cancel();
                    }
                }
            }
        }

        @Override // androidx.lifecycle.n
        public void cancel() {
            androidx.activity.c cVar;
            this.a.c(this);
            this.b.e(this);
            cVar = this.c;
            if (cVar != null) {
                cVar.cancel();
                this.c = 0;
            }
        }
    }
    public OnBackPressedDispatcher(Runnable runnable) {
        super();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.b = arrayDeque;
        this.a = runnable;
    }

    public void a(androidx.activity.d d) {
        c(d);
    }

    public void b(q q, androidx.activity.d d2) {
        final j obj3 = q.getLifecycle();
        if (obj3.b() == j.c.DESTROYED) {
        }
        OnBackPressedDispatcher.LifecycleOnBackPressedCancellable lifecycleOnBackPressedCancellable = new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(this, obj3, d2);
        d2.a(lifecycleOnBackPressedCancellable);
    }

    androidx.activity.c c(androidx.activity.d d) {
        this.b.add(d);
        OnBackPressedDispatcher.a aVar = new OnBackPressedDispatcher.a(this, d);
        d.a(aVar);
        return aVar;
    }

    public void d() {
        Object next;
        boolean z;
        Iterator descendingIterator = this.b.descendingIterator();
        for (d next : descendingIterator) {
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
