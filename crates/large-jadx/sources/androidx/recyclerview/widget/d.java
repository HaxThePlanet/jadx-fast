package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class d<T>  {

    private static final Executor h;
    private final androidx.recyclerview.widget.r a;
    final androidx.recyclerview.widget.c<T> b;
    Executor c;
    private final List<androidx.recyclerview.widget.d.b<T>> d;
    private List<T> e;
    private List<T> f;
    int g;

    class a implements Runnable {

        final List a;
        final List b;
        final int c;
        final Runnable v;
        final androidx.recyclerview.widget.d w;
        a(androidx.recyclerview.widget.d d, List list2, List list3, int i4, Runnable runnable5) {
            this.w = d;
            this.a = list2;
            this.b = list3;
            this.c = i4;
            this.v = runnable5;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.a aVar = new d.a.a(this);
            d.a.b bVar = new d.a.b(this, h.b(aVar));
            dVar.c.execute(bVar);
        }
    }

    public interface b {
        public abstract void a(List<T> list, List<T> list2);
    }

    private static class c implements Executor {

        final Handler a;
        c() {
            super();
            Handler handler = new Handler(Looper.getMainLooper());
            this.a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }
    static {
        d.c cVar = new d.c();
        d.h = cVar;
    }

    public d(androidx.recyclerview.widget.r r, androidx.recyclerview.widget.c<T> c2) {
        Executor obj2;
        super();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList;
        this.f = Collections.emptyList();
        this.a = r;
        this.b = c2;
        if (c2.c() != null) {
            this.c = c2.c();
        } else {
            this.c = d.h;
        }
    }

    private void d(List<T> list, Runnable runnable2) {
        Object next;
        List list2;
        Iterator iterator = this.d.iterator();
        for (d.b next : iterator) {
            next.a(list, this.f);
        }
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    public void a(androidx.recyclerview.widget.d.b<T> d$b) {
        this.d.add(b);
    }

    public List<T> b() {
        return this.f;
    }

    void c(List<T> list, androidx.recyclerview.widget.h.e h$e2, Runnable runnable3) {
        this.e = list;
        this.f = Collections.unmodifiableList(list);
        e2.b(this.a);
        d(this.f, runnable3);
    }

    public void e(List<T> list) {
        f(list, 0);
    }

    public void f(List<T> list, Runnable runnable2) {
        final int i4 = i + 1;
        this.g = i4;
        final List list3 = this.e;
        if (list == list3 && runnable2 != null) {
            if (runnable2 != null) {
                runnable2.run();
            }
        }
        List list2 = this.f;
        int i2 = 0;
        if (list == null) {
            this.e = 0;
            this.f = Collections.emptyList();
            this.a.onRemoved(i2, list3.size());
            d(list2, runnable2);
        }
        if (list3 == null) {
            this.e = list;
            this.f = Collections.unmodifiableList(list);
            this.a.onInserted(i2, list.size());
            d(list2, runnable2);
        }
        super(this, list3, list, i4, runnable2);
        this.b.a().execute(aVar2);
    }
}
