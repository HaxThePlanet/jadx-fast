package androidx.activity.g;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class a {

    private final Set<androidx.activity.g.b> a;
    private volatile Context b;
    public a() {
        super();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.a = copyOnWriteArraySet;
    }

    public void a(androidx.activity.g.b b) {
        Context context;
        if (this.b != null) {
            b.a(this.b);
        }
        this.a.add(b);
    }

    public void b() {
        this.b = 0;
    }

    public void c(Context context) {
        Object next;
        this.b = context;
        Iterator iterator = this.a.iterator();
        for (b next : iterator) {
            next.a(context);
        }
    }

    public Context d() {
        return this.b;
    }

    public void e(androidx.activity.g.b b) {
        this.a.remove(b);
    }
}
