package app.dogo.com.dogo_android.s.b;

import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n0 implements Callable {

    public final /* synthetic */ Boolean a;
    public /* synthetic */ n0(Boolean boolean) {
        super();
        this.a = boolean;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        UserRepository.j(this.a);
        return this.a;
    }
}
