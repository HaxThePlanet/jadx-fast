package i.b.j0;

import i.b.m0.a.b;
import i.b.m0.b.b;
import i.b.m0.j.k;
import i.b.m0.j.p;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class a implements i.b.j0.b, b {

    p<i.b.j0.b> a;
    volatile boolean b;
    @Override // i.b.j0.b
    public boolean a(i.b.j0.b b) {
        if (c(b)) {
            b.dispose();
            return 1;
        }
        return 0;
    }

    @Override // i.b.j0.b
    public boolean b(i.b.j0.b b) {
        boolean z;
        p pVar;
        b.e(b, "disposable is null");
        if (!this.b && !this.b && this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    pVar = new p();
                    this.a = pVar;
                }
                pVar.a(b);
                return 1;
            }
        }
        b.dispose();
        return 0;
    }

    @Override // i.b.j0.b
    public boolean c(i.b.j0.b b) {
        Object obj3;
        b.e(b, "disposables is null");
        final int i = 0;
        if (this.b) {
            return i;
        }
        synchronized (this) {
            return i;
        }
    }

    @Override // i.b.j0.b
    public void d() {
        if (this.b) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.j0.b
    public void dispose() {
        if (this.b) {
        }
        synchronized (this) {
        }
    }

    void e(p<i.b.j0.b> p) {
        int i2;
        int i;
        Throwable th;
        boolean z;
        if (p == null) {
        }
        i2 = 0;
        Object[] obj7 = p.b();
        final int i4 = 0;
        i = i4;
        while (i < obj7.length) {
            th = obj7[i];
            if (th instanceof b) {
            }
            i++;
            (b)th.dispose();
            a.b(th);
            if (arrayList == null) {
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(th);
        }
        if (i2 != 0 && i2.size() == 1) {
            if (i2.size() == 1) {
                throw k.e((Throwable)i2.get(i4));
            }
            obj7 = new CompositeException(i2);
            throw obj7;
        }
    }

    @Override // i.b.j0.b
    public int f() {
        int i;
        i = 0;
        if (this.b) {
            return i;
        }
        synchronized (this) {
            return i;
        }
    }

    @Override // i.b.j0.b
    public boolean isDisposed() {
        return this.b;
    }
}
