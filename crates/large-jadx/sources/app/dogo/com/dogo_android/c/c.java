package app.dogo.com.dogo_android.c;

/* loaded from: classes.dex */
public final class c implements Runnable {

    public final app.dogo.com.dogo_android.c.g a;
    public c(app.dogo.com.dogo_android.c.g g) {
        super();
        this.a = g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.b.f(this.a);
    }
}
