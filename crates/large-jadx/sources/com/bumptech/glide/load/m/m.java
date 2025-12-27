package com.bumptech.glide.load.m;

import com.bumptech.glide.t.h;
import com.bumptech.glide.t.l;
import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class m<A, B> {

    private final h<m.b<A>, B> a = new m$a<>();

    static final class b<A> {

        private static final Queue<m.b<?>> d;
        private int a;
        private int b;
        private A c;
        static {
            m.b.d = l.e(0);
        }

        private b() {
            super();
        }

        static <A> m.b<A> a(A a, int i, int i2) {
            Object poll;
            final Queue queue = m.b.d;
            synchronized (queue) {
                try {
                } catch (Throwable th) {
                }
            }
            if ((m.b)queue.poll() == null) {
                com.bumptech.glide.load.m.m.b bVar = new m.b();
            }
            poll.b(th, i, i2);
            return poll;
        }

        private void b(A a, int i, int i2) {
            this.c = a;
            this.b = i;
            this.a = i2;
        }

        public void c() {
            final Queue queue = m.b.d;
            synchronized (queue) {
                try {
                    queue.offer(this);
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }

        public boolean equals(Object object) {
            boolean z2 = false;
            z = object instanceof m.b;
            int i4 = 0;
            if (object instanceof m.b) {
                if (this.b == object.b) {
                    if (this.a == object.a) {
                        if (this.c.equals(object.c)) {
                            int i5 = 1;
                        }
                    }
                }
            }
            return z2;
        }

        public int hashCode() {
            return (this.a * 31) + this.b * 31 + this.c.hashCode();
        }
    }

    class a extends h<m.b<A>, B> {
        a(long j) {
            super(j, r3);
        }

        @Override // com.bumptech.glide.t.h
        protected void n(m.b<A> bVar, B b) {
            bVar.c();
        }
    }
    public m(long j) {
        super();
        final com.bumptech.glide.load.m.m.a aVar = new m.a(this, j, r3);
    }

    public B a(A a, int i, int i2) {
        final com.bumptech.glide.load.m.m.b bVar = m.b.a(a, i, i2);
        bVar.c();
        return this.a.g(bVar);
    }

    public void b(A a, int i, int i2, B b) {
        this.a.k(m.b.a(a, i, i2), b);
    }
}
