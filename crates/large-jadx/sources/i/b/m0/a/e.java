package i.b.m0.a;

import i.b.j0.b;
import i.b.m0.b.b;
import i.b.m0.j.k;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class e implements b, i.b.m0.a.b {

    List<b> a;
    volatile boolean b;
    @Override // i.b.j0.b
    public boolean a(b b) {
        if (c(b)) {
            b.dispose();
            return 1;
        }
        return 0;
    }

    @Override // i.b.j0.b
    public boolean b(b b) {
        boolean z;
        Object linkedList;
        b.e(b, "d is null");
        if (!this.b && !this.b && this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    linkedList = new LinkedList();
                    this.a = linkedList;
                }
                linkedList.add(b);
                return 1;
            }
        }
        b.dispose();
        return 0;
    }

    @Override // i.b.j0.b
    public boolean c(b b) {
        Object obj3;
        b.e(b, "Disposable item is null");
        final int i = 0;
        if (this.b) {
            return i;
        }
        synchronized (this) {
            return i;
        }
    }

    void d(List<b> list) {
        int i;
        Throwable next;
        if (list == null) {
        }
        i = 0;
        Iterator obj3 = list.iterator();
        for (b next : obj3) {
            next.dispose();
        }
        if (i != 0 && i.size() == 1) {
            if (i.size() == 1) {
                throw k.e((Throwable)i.get(0));
            }
            obj3 = new CompositeException(i);
            throw obj3;
        }
    }

    @Override // i.b.j0.b
    public void dispose() {
        if (this.b) {
        }
        synchronized (this) {
        }
    }

    @Override // i.b.j0.b
    public boolean isDisposed() {
        return this.b;
    }
}
