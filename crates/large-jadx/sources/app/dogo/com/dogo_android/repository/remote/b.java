package app.dogo.com.dogo_android.s.c;

import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements Callable {

    public final /* synthetic */ g a;
    public /* synthetic */ b(g gVar) {
        super();
        this.a = gVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return AppUpdateRepository.f(this.a);
    }
}
