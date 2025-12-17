package app.dogo.com.dogo_android.s.c;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class b implements Callable {

    public final app.dogo.com.dogo_android.s.c.g a;
    public b(app.dogo.com.dogo_android.s.c.g g) {
        super();
        this.a = g;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return g.j(this.a);
    }
}
