package i.b.m0.a;

import i.b.j0.b;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class a extends AtomicReferenceArray<b> implements b {

    private static final long serialVersionUID = 2746389416410565408L;
    public a(int i) {
        super(i);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean a(int i, b b2) {
        final Object obj = get(i);
        while ((b)obj == c.DISPOSED) {
            obj = get(i);
        }
        b2.dispose();
        return 0;
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public void dispose() {
        int i;
        Object length;
        i.b.m0.a.c dISPOSED2;
        i.b.m0.a.c dISPOSED;
        if (get(0) != c.DISPOSED) {
            while (i < length()) {
                dISPOSED = c.DISPOSED;
                dISPOSED2 = getAndSet(i, dISPOSED);
                if ((b)get(i) != dISPOSED && (b)dISPOSED2 != dISPOSED && (b)dISPOSED2 != null) {
                }
                i++;
                dISPOSED2 = getAndSet(i, dISPOSED);
                if ((b)(b)dISPOSED2 != dISPOSED) {
                }
                if ((b)(b)dISPOSED2 != null) {
                }
                (b)(b)dISPOSED2.dispose();
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceArray
    public boolean isDisposed() {
        int i;
        if (get(0) == c.DISPOSED) {
            i = 1;
        }
        return i;
    }
}
