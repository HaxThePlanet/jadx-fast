package app.dogo.com.dogo_android.s.a;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class u0 implements Callable {

    public final Boolean a;
    public u0(Boolean boolean) {
        super();
        this.a = boolean;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final Boolean bool = this.a;
        n3.e(bool);
        return bool;
    }
}
