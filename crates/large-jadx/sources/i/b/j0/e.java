package i.b.j0;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RunnableDisposable.java */
/* loaded from: classes3.dex */
final class e extends d<Runnable> {

    private static final long serialVersionUID = -8219729196779211169L;
    e(Runnable runnable) {
        super(runnable);
    }

    @Override // i.b.j0.d
    protected void b(Runnable runnable) {
        runnable.run();
    }

    @Override // i.b.j0.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RunnableDisposable(disposed=";
        boolean disposed = isDisposed();
        String str3 = ", ";
        Object obj = get();
        String str4 = ")";
        str = str2 + disposed + str3 + obj + str4;
        return str;
    }
}
