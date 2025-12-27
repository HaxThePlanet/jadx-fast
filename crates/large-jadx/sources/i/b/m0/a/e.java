package i.b.m0.a;

import i.b.m0.j.k;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes3.dex */
public final class e implements i.b.j0.b, b {

    List<i.b.j0.b> a;
    volatile boolean b;
    public boolean a(i.b.j0.b bVar) {
        if (c(bVar)) {
            bVar.dispose();
            return true;
        }
        return false;
    }

    public boolean b(i.b.j0.b bVar) {
        List list;
        b.e(bVar, "d is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        if (this.a == null) {
                            this.a = new LinkedList();
                        }
                        list.add(bVar);
                        return true;
                    }
                } catch (Throwable th) {
                }
            }
        }
        th.dispose();
        return false;
    }

    public boolean c(i.b.j0.b bVar) {
        b.e(bVar, "Disposable item is null");
        final boolean z3 = false;
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

    void d(List<i.b.j0.b> list) {
        Iterable iterable = null;
        Throwable th;
        if (list == null) {
            return;
        }
        int i = 0;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                (b)it.next().dispose();
            } catch (Throwable th) {
                a.b(th);
            }
        }
        if (iterable != null) {
            if (iterable.size() == 1) {
                throw k.e((Throwable)iterable.get(0));
            }
            throw new CompositeException(iterable);
        }
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
        d(list);
    }

    public boolean isDisposed() {
        return this.b;
    }
}
