package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class u<T>  {

    private final com.google.android.exoplayer2.util.i a;
    private final com.google.android.exoplayer2.util.s b;
    private final com.google.android.exoplayer2.util.u.b<T> c;
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.util.u.c<T>> d;
    private final ArrayDeque<Runnable> e;
    private final ArrayDeque<Runnable> f;
    private boolean g;

    public interface a {
        public abstract void invoke(T t);
    }

    public interface b {
        public abstract void a(T t, com.google.android.exoplayer2.util.q q2);
    }

    private static final class c {

        public final T a;
        private com.google.android.exoplayer2.util.q.b b;
        private boolean c;
        private boolean d;
        public c(T t) {
            super();
            this.a = t;
            q.b obj1 = new q.b();
            this.b = obj1;
        }

        public void a(int i, com.google.android.exoplayer2.util.u.a<T> u$a2) {
            int z;
            int obj2;
            if (!this.d && i != -1) {
                if (i != -1) {
                    this.b.a(i);
                }
                this.c = true;
                a2.invoke(this.a);
            }
        }

        public void b(com.google.android.exoplayer2.util.u.b<T> u$b) {
            boolean z;
            Object obj;
            if (!this.d && this.c) {
                if (this.c) {
                    q.b bVar2 = new q.b();
                    this.b = bVar2;
                    this.c = false;
                    b.a(this.a, this.b.e());
                }
            }
        }

        public void c(com.google.android.exoplayer2.util.u.b<T> u$b) {
            boolean z;
            com.google.android.exoplayer2.util.q qVar;
            this.d = true;
            if (this.c) {
                b.a(this.a, this.b.e());
            }
        }

        public boolean equals(Object object) {
            Class<com.google.android.exoplayer2.util.u.c> obj;
            Class class;
            if (this == object) {
                return 1;
            }
            if (object != null && u.c.class != object.getClass()) {
                if (u.c.class != object.getClass()) {
                }
                return this.a.equals(object.a);
            }
            return 0;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }
    public u(Looper looper, com.google.android.exoplayer2.util.i i2, com.google.android.exoplayer2.util.u.b<T> u$b3) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        super(copyOnWriteArraySet, looper, i2, b3);
    }

    private u(CopyOnWriteArraySet<com.google.android.exoplayer2.util.u.c<T>> copyOnWriteArraySet, Looper looper2, com.google.android.exoplayer2.util.i i3, com.google.android.exoplayer2.util.u.b<T> u$b4) {
        super();
        this.a = i3;
        this.d = copyOnWriteArraySet;
        this.c = b4;
        ArrayDeque obj1 = new ArrayDeque();
        this.e = obj1;
        obj1 = new ArrayDeque();
        this.f = obj1;
        obj1 = new b(this);
        this.b = i3.c(looper2, obj1);
    }

    private boolean d(Message message) {
        boolean next;
        int i;
        Iterator obj3 = this.d.iterator();
        while (obj3.hasNext()) {
            (u.c)obj3.next().b(this.c);
            if (!this.b.e(0)) {
            }
        }
        return 1;
    }

    public static boolean e(com.google.android.exoplayer2.util.u u, Message message2) {
        return u.d(message2);
    }

    static void f(CopyOnWriteArraySet copyOnWriteArraySet, int i2, com.google.android.exoplayer2.util.u.a u$a3) {
        Object next;
        final Iterator obj1 = copyOnWriteArraySet.iterator();
        for (u.c next : obj1) {
            next.a(i2, a3);
        }
    }

    public void a(T t) {
        if (this.g) {
        }
        g.e(t);
        u.c cVar = new u.c(t);
        this.d.add(cVar);
    }

    public com.google.android.exoplayer2.util.u<T> b(Looper looper, com.google.android.exoplayer2.util.u.b<T> u$b2) {
        u uVar = new u(this.d, looper, this.a, b2);
        return uVar;
    }

    public void c() {
        boolean z;
        int i;
        int i2;
        if (this.f.isEmpty()) {
        }
        i2 = 0;
        if (!this.b.e(i2)) {
            z = this.b;
            z.d(z.c(i2));
        }
        this.e.addAll(this.f);
        this.f.clear();
        if (empty2 ^= 1 != 0) {
        }
        while (!this.e.isEmpty()) {
            (Runnable)this.e.peekFirst().run();
            this.e.removeFirst();
        }
    }

    public void g(int i, com.google.android.exoplayer2.util.u.a<T> u$a2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.d);
        a aVar = new a(copyOnWriteArraySet, i, a2);
        this.f.add(aVar);
    }

    public void h() {
        Object next;
        com.google.android.exoplayer2.util.u.b bVar;
        Iterator iterator = this.d.iterator();
        for (u.c next : iterator) {
            next.c(this.c);
        }
        this.d.clear();
        this.g = true;
    }

    public void i(T t) {
        Object next;
        boolean equals;
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next.a.equals(t)) {
            }
            (u.c)next.c(this.c);
            this.d.remove(next);
        }
    }

    public void j(int i, com.google.android.exoplayer2.util.u.a<T> u$a2) {
        g(i, a2);
        c();
    }
}
