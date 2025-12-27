package i.b.j0;

import i.b.m0.j.k;
import i.b.m0.j.p;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompositeDisposable.java */
/* loaded from: classes3.dex */
public final class a implements b, i.b.m0.a.b {

    p<b> a;
    volatile boolean b;
    public boolean a(b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    public boolean b(b bVar) {
        p pVar;
        b.e(bVar, "disposable is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        if (this.a == null) {
                            this.a = new p();
                        }
                        pVar.a(bVar);
                        return true;
                    }
                } catch (Throwable th) {
                }
            }
        }
        th.dispose();
        return false;
    }

    public boolean c(b bVar) {
        b.e(bVar, "disposables is null");
        final boolean z4 = false;
        if (this.b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return false;
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void d() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
            } catch (Throwable th) {
            }
        }
        e(pVar);
    }

    public void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
            } catch (Throwable th) {
            }
        }
        e(pVar);
    }

    void e(p<b> pVar) {
        Iterable iterable = null;
        int i;
        Throwable th;
        Object obj;
        if (pVar == null) {
            return;
        }
        int i2 = 0;
        Object[] objArr = pVar.b();
        i = 0;
        for (Object obj : objArr) {
            z = obj instanceof b;
            a.b(th);
            arrayList.add(th);
        }
        if (iterable != null) {
            if (iterable.size() == 1) {
                throw k.e((Throwable)iterable.get(i));
            }
            throw new CompositeException(iterable);
        }
    }

    public int f() {
        int i = 0;
        i = 0;
        if (this.b) {
            return i;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return i;
                }
                if (this.a != null) {
                    i = this.a.g();
                }
                return i;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean isDisposed() {
        return this.b;
    }
}
