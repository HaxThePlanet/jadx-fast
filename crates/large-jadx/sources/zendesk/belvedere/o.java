package zendesk.belvedere;

import android.util.SparseArray;

/* loaded from: classes3.dex */
class o {

    private SparseArray<zendesk.belvedere.s> a;
    o() {
        super();
        SparseArray sparseArray = new SparseArray();
        this.a = sparseArray;
    }

    private int c() {
        int i;
        Object obj;
        i = 1600;
        while (i < 1650) {
            i++;
        }
        q.a("Belvedere", "No slot free. Clearing registry.");
        this.a.clear();
        return c();
    }

    void a(int i) {
        this.a.remove(i);
        return;
        synchronized (this) {
            this.a.remove(i);
        }
    }

    zendesk.belvedere.s b(int i) {
        return (s)this.a.get(i);
        synchronized (this) {
            return (s)this.a.get(i);
        }
    }

    int d() {
        final int i = c();
        this.a.put(i, s.c());
        return i;
        synchronized (this) {
            i = c();
            this.a.put(i, s.c());
            return i;
        }
    }

    void e(int i, zendesk.belvedere.s s2) {
        this.a.put(i, s2);
        return;
        synchronized (this) {
            this.a.put(i, s2);
        }
    }
}
