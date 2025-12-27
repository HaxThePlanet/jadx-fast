package app.dogo.com.dogo_android.s.a;

import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class u0 implements Callable {

    public final /* synthetic */ Boolean a;
    public /* synthetic */ u0(Boolean boolean) {
        super();
        this.a = boolean;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        SubscribeInteractor.n(this.a);
        return this.a;
    }
}
