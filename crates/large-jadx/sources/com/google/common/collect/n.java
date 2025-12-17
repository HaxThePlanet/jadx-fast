package com.google.common.collect;

import f.c.c.b.a;
import f.c.c.b.b;
import java.util.Comparator;

/* loaded from: classes2.dex */
public abstract class n {

    private static final com.google.common.collect.n a;
    private static final com.google.common.collect.n b;
    private static final com.google.common.collect.n c;

    class a extends com.google.common.collect.n {
        a() {
            super(0);
        }

        @Override // com.google.common.collect.n
        public com.google.common.collect.n d(int i, int i2) {
            return j(b.d(i, i2));
        }

        public <T> com.google.common.collect.n e(T t, T t2, Comparator<T> comparator3) {
            return j(comparator3.compare(t, t2));
        }

        @Override // com.google.common.collect.n
        public com.google.common.collect.n f(boolean z, boolean z2) {
            return j(a.a(z, z2));
        }

        @Override // com.google.common.collect.n
        public com.google.common.collect.n g(boolean z, boolean z2) {
            return j(a.a(z2, z));
        }

        @Override // com.google.common.collect.n
        public int h() {
            return 0;
        }

        @Override // com.google.common.collect.n
        com.google.common.collect.n j(int i) {
            com.google.common.collect.n obj1;
            if (i < 0) {
                obj1 = n.a();
            } else {
                if (i > 0) {
                    obj1 = n.b();
                } else {
                    obj1 = n.c();
                }
            }
            return obj1;
        }
    }

    private static final class b extends com.google.common.collect.n {

        final int d;
        b(int i) {
            super(0);
            this.d = i;
        }

        @Override // com.google.common.collect.n
        public com.google.common.collect.n d(int i, int i2) {
            return this;
        }

        public <T> com.google.common.collect.n e(T t, T t2, Comparator<T> comparator3) {
            return this;
        }

        @Override // com.google.common.collect.n
        public com.google.common.collect.n f(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.n
        public com.google.common.collect.n g(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.n
        public int h() {
            return this.d;
        }
    }
    static {
        n.a aVar = new n.a();
        n.a = aVar;
        n.b bVar = new n.b(-1);
        n.b = bVar;
        n.b bVar2 = new n.b(1);
        n.c = bVar2;
    }

    n(com.google.common.collect.n.a n$a) {
        super();
    }

    static com.google.common.collect.n a() {
        return n.b;
    }

    static com.google.common.collect.n b() {
        return n.c;
    }

    static com.google.common.collect.n c() {
        return n.a;
    }

    public static com.google.common.collect.n i() {
        return n.a;
    }

    public abstract com.google.common.collect.n d(int i, int i2);

    public abstract <T> com.google.common.collect.n e(T t, T t2, Comparator<T> comparator3);

    public abstract com.google.common.collect.n f(boolean z, boolean z2);

    public abstract com.google.common.collect.n g(boolean z, boolean z2);

    public abstract int h();
}
