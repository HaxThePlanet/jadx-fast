package i.b.j0;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
final class e extends i.b.j0.d<Runnable> {

    private static final long serialVersionUID = -8219729196779211169L;
    e(Runnable runnable) {
        super(runnable);
    }

    @Override // i.b.j0.d
    protected void a(Object object) {
        b((Runnable)object);
    }

    @Override // i.b.j0.d
    protected void b(Runnable runnable) {
        runnable.run();
    }

    @Override // i.b.j0.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunnableDisposable(disposed=");
        stringBuilder.append(isDisposed());
        stringBuilder.append(", ");
        stringBuilder.append(get());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
