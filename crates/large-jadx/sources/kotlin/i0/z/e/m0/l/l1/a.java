package kotlin.i0.z.e.m0.l.l1;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class a extends ArrayList<kotlin.i0.z.e.m0.l.l1.k> implements kotlin.i0.z.e.m0.l.l1.j {
    public a(int i) {
        super(i);
    }

    @Override // java.util.ArrayList
    public boolean b(kotlin.i0.z.e.m0.l.l1.k k) {
        return super.contains(k);
    }

    @Override // java.util.ArrayList
    public final boolean contains(Object object) {
        if (!object instanceof k) {
            return 0;
        }
        return b((k)object);
    }

    @Override // java.util.ArrayList
    public int d() {
        return super.size();
    }

    @Override // java.util.ArrayList
    public int g(kotlin.i0.z.e.m0.l.l1.k k) {
        return super.indexOf(k);
    }

    @Override // java.util.ArrayList
    public int h(kotlin.i0.z.e.m0.l.l1.k k) {
        return super.lastIndexOf(k);
    }

    @Override // java.util.ArrayList
    public final int indexOf(Object object) {
        if (!object instanceof k) {
            return -1;
        }
        return g((k)object);
    }

    @Override // java.util.ArrayList
    public boolean l(kotlin.i0.z.e.m0.l.l1.k k) {
        return super.remove(k);
    }

    @Override // java.util.ArrayList
    public final int lastIndexOf(Object object) {
        if (!object instanceof k) {
            return -1;
        }
        return h((k)object);
    }

    @Override // java.util.ArrayList
    public final boolean remove(Object object) {
        if (!object instanceof k) {
            return 0;
        }
        return l((k)object);
    }

    @Override // java.util.ArrayList
    public final int size() {
        return d();
    }
}
