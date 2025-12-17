package i.b.m0.j;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class c extends AtomicReference<Throwable> {

    private static final long serialVersionUID = 3949248817947090603L;
    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean a(Throwable throwable) {
        return k.a(this, throwable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public Throwable b() {
        return k.b(this);
    }
}
