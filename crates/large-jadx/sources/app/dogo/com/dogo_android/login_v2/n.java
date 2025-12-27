package app.dogo.com.dogo_android.login_v2;

import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n implements Callable {

    public final /* synthetic */ b0.a a;
    public /* synthetic */ n(b0.a aVar) {
        super();
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        LoginViewModel.Q(this.a);
        return this.a;
    }
}
