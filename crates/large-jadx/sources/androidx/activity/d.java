package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class d {

    private boolean a;
    private CopyOnWriteArrayList<androidx.activity.c> b;
    public d(boolean z) {
        super();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.b = copyOnWriteArrayList;
        this.a = z;
    }

    void a(androidx.activity.c c) {
        this.b.add(c);
    }

    public abstract void b();

    public final boolean c() {
        return this.a;
    }

    public final void d() {
        Object next;
        Iterator iterator = this.b.iterator();
        for (c next : iterator) {
            next.cancel();
        }
    }

    void e(androidx.activity.c c) {
        this.b.remove(c);
    }

    public final void f(boolean z) {
        this.a = z;
    }
}
