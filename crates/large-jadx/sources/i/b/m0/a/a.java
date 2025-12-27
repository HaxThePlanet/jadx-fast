package i.b.m0.a;

import i.b.j0.b;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ArrayCompositeDisposable.java */
/* loaded from: classes3.dex */
public final class a extends AtomicReferenceArray<b> implements b {

    private static final long serialVersionUID = 2746389416410565408L;
    public a(int i) {
        super(i);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean a(int i, b bVar) {
        final Object obj = get(i);
        while (obj == c.DISPOSED) {
            if (compareAndSet(i, obj, bVar)) {
            }
            obj = get(i);
        }
        bVar.dispose();
        return false;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void dispose() {
        int i = 0;
        i.b.m0.a.c dISPOSED2;
        i.b.m0.a.c dISPOSED22;
        i = 0;
        if (get(i) != c.DISPOSED) {
            while (i < length()) {
                dISPOSED22 = c.DISPOSED;
                i = i + 1;
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean isDisposed() {
        boolean z = false;
        if (get(0) == c.DISPOSED) {
            int i2 = 1;
        }
        return z;
    }
}
