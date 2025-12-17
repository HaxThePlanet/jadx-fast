package app.dogo.com.dogo_android.login_v2;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class n implements Callable {

    public final app.dogo.com.dogo_android.login_v2.b0.a a;
    public n(app.dogo.com.dogo_android.login_v2.b0.a b0$a) {
        super();
        this.a = a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final app.dogo.com.dogo_android.login_v2.b0.a aVar = this.a;
        b0.z(aVar);
        return aVar;
    }
}
