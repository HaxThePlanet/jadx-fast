package app.dogo.com.dogo_android.s.c;

import java.util.concurrent.Callable;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements Callable {

    public final /* synthetic */ g a;
    public /* synthetic */ d(g gVar) {
        super();
        this.a = gVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return AppUpdateRepository.b(this.a);
    }
}
