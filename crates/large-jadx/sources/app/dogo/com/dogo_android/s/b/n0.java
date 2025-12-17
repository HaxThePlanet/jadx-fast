package app.dogo.com.dogo_android.s.b;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class n0 implements Callable {

    public final Boolean a;
    public n0(Boolean boolean) {
        super();
        this.a = boolean;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final Boolean bool = this.a;
        p1.Q(bool);
        return bool;
    }
}
