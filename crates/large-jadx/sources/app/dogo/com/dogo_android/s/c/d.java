package app.dogo.com.dogo_android.s.c;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class d implements Callable {

    public final app.dogo.com.dogo_android.s.c.g a;
    public d(app.dogo.com.dogo_android.s.c.g g) {
        super();
        this.a = g;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return g.l(this.a);
    }
}
