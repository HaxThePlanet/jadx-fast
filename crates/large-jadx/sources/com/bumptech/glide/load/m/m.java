package com.bumptech.glide.load.m;

import com.bumptech.glide.t.h;
import com.bumptech.glide.t.l;
import java.util.Queue;

/* loaded from: classes.dex */
public class m<A, B>  {

    private final h<com.bumptech.glide.load.m.m.b<A>, B> a;

    static final class b {

        private static final Queue<com.bumptech.glide.load.m.m.b<?>> d;
        private int a;
        private int b;
        private A c;
        static {
            m.b.d = l.e(0);
        }

        static <A> com.bumptech.glide.load.m.m.b<A> a(A a, int i2, int i3) {
            Object bVar;
            final Queue queue = m.b.d;
            synchronized (queue) {
                queue = m.b.d;
            }
            bVar = new m.b();
            bVar.b(a, i2, i3);
            return bVar;
        }

        private void b(A a, int i2, int i3) {
            this.c = a;
            this.b = i2;
            this.a = i3;
        }

        public void c() {
            final Queue queue = m.b.d;
            queue.offer(this);
            return;
            synchronized (queue) {
                queue = m.b.d;
                queue.offer(this);
            }
        }

        public boolean equals(Object object) {
            boolean i3;
            int i;
            int i2;
            Object obj4;
            i = 0;
            if (object instanceof m.b && this.b == object.b && this.a == object.a && this.c.equals(object.c)) {
                if (this.b == object.b) {
                    if (this.a == object.a) {
                        if (this.c.equals(object.c)) {
                            i = 1;
                        }
                    }
                }
            }
            return i;
        }

        public int hashCode() {
            return i4 += i7;
        }
    }

    class a extends h<com.bumptech.glide.load.m.m.b<A>, B> {
        a(com.bumptech.glide.load.m.m m, long l2) {
            super(l2, obj3);
        }

        @Override // com.bumptech.glide.t.h
        protected void j(Object object, Object object2) {
            n((m.b)object, object2);
        }

        protected void n(com.bumptech.glide.load.m.m.b<A> m$b, B b2) {
            b.c();
        }
    }
    public m(long l) {
        super();
        m.a aVar = new m.a(this, l, obj3);
        this.a = aVar;
    }

    public B a(A a, int i2, int i3) {
        final com.bumptech.glide.load.m.m.b obj1 = m.b.a(a, i2, i3);
        obj1.c();
        return this.a.g(obj1);
    }

    public void b(A a, int i2, int i3, B b4) {
        this.a.k(m.b.a(a, i2, i3), b4);
    }
}
