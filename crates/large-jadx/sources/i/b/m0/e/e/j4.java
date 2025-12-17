package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.g;
import i.b.m0.c.i;
import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.m0.f.a;
import i.b.m0.j.n;
import i.b.o0.e;
import i.b.r;
import i.b.t0.e;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class j4<T>  extends i.b.m0.e.e.a<T, r<T>> {

    final long b;
    final long c;
    final TimeUnit v;
    final z w;
    final long x;
    final int y;
    final boolean z;

    static final class a extends u<T, Object, r<T>> implements b {

        final z A;
        final int B;
        final boolean C;
        final long D;
        final z.c E = null;
        long F;
        long G;
        b H;
        e<T> I;
        volatile boolean J;
        final g K;
        final long y;
        final TimeUnit z;
        a(y<? super r<T>> y, long l2, TimeUnit timeUnit3, z z4, int i5, long l6, boolean z7) {
            z.c obj2;
            a aVar = new a();
            super(y, aVar);
            obj2 = new g();
            this.K = obj2;
            this.y = l2;
            this.z = z4;
            this.A = i5;
            this.B = l6;
            this.D = z7;
            this.C = obj10;
            if (obj10 != null) {
                this.E = i5.a();
            } else {
                obj2 = 0;
            }
        }

        static boolean h(i.b.m0.e.e.j4.a j4$a) {
            return a.v;
        }

        static i i(i.b.m0.e.e.j4.a j4$a) {
            return a.c;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            this.v = true;
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        void j() {
            c.dispose(this.K);
            z.c cVar = this.E;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        @Override // i.b.m0.d.u
        void k() {
            e eVar;
            int i;
            boolean compareAndSet;
            Object poll;
            int i2;
            boolean z;
            int i3;
            long l;
            int cmp;
            TimeUnit time;
            i iVar = this.c;
            eVar = this.I;
            final int i7 = 1;
            i = i7;
            while (this.J) {
                poll = (a)iVar.poll();
                if (poll == null) {
                } else {
                }
                i2 = 0;
                z = poll instanceof j4.a.a;
                i3 = 0;
                if (z) {
                } else {
                }
                eVar.onNext(n.getValue(poll));
                i2 = 1;
                l3 += i2;
                cmp = Long.compare(compareAndSet, l6);
                if (cmp >= 0) {
                } else {
                }
                this.F = compareAndSet;
                this.G = l4 += i2;
                this.F = i3;
                eVar.onComplete();
                eVar = e.e(this.B);
                this.I = eVar;
                this.b.onNext(eVar);
                Object obj = this.K.get();
                (b)obj.dispose();
                j4.a.a aVar = new j4.a.a(this.G, i3, this);
                l = this.y;
                poll = this.E.d(aVar, l, i3, l);
                if (this.C && !this.K.compareAndSet(obj, poll)) {
                }
                obj = this.K.get();
                (b)obj.dispose();
                aVar = new j4.a.a(this.G, i3, this);
                l = this.y;
                poll = this.E.d(aVar, l, i3, l);
                if (!this.K.compareAndSet(obj, poll)) {
                }
                poll.dispose();
                if (this.C) {
                } else {
                }
                eVar.onComplete();
                this.F = i3;
                eVar = e.e(this.B);
                this.I = eVar;
                this.b.onNext(eVar);
                if (Long.compare(i2, l2) == 0) {
                }
                i2 = i7;
            }
            this.H.dispose();
            iVar.clear();
            j();
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            this.w = true;
            if (d()) {
                k();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            this.x = throwable;
            this.w = true;
            if (d()) {
                k();
            }
            this.b.onError(throwable);
        }

        public void onNext(T t) {
            Object eVar;
            int aVar;
            long l3;
            int i;
            long l;
            long l2;
            TimeUnit time;
            int obj8;
            if (this.J) {
            }
            if (e()) {
                eVar = this.I;
                eVar.onNext(t);
                i = 1;
                l4 += i;
                l2 = this.D;
                if (Long.compare(aVar, l2) >= 0) {
                    this.G = l5 += i;
                    this.F = 0;
                    eVar.onComplete();
                    obj8 = e.e(this.B);
                    this.I = obj8;
                    this.b.onNext(obj8);
                    if (this.C) {
                        (b)this.K.get().dispose();
                        aVar = new j4.a.a(this.G, i, this);
                        l = this.y;
                        c.replace(this.K, this.E.d(aVar, l, i, l));
                    }
                } else {
                    this.F = aVar;
                }
                if (c(-1) == 0) {
                }
            } else {
                this.c.offer(n.next(t));
                if (!d()) {
                }
            }
            k();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean validate;
            Object obj;
            i.b.m0.e.e.j4.a.a aVar;
            long l2;
            long l;
            TimeUnit time;
            b obj9;
            this.H = b;
            obj9 = this.b;
            obj9.onSubscribe(this);
            if (c.validate(this.H, b) && this.v) {
                this.H = b;
                obj9 = this.b;
                obj9.onSubscribe(this);
                if (this.v) {
                }
                e eVar = e.e(this.B);
                this.I = eVar;
                obj9.onNext(eVar);
                aVar = new j4.a.a(this.G, obj1, this);
                if (this.C) {
                    l = this.y;
                    obj9 = this.E.d(aVar, l, obj4, l);
                } else {
                    l = this.y;
                    obj9 = this.A.e(aVar, l, obj4, l);
                }
                this.K.a(obj9);
            }
        }
    }

    static final class b extends u<T, Object, r<T>> implements y<T>, b, Runnable {

        static final Object G;
        final z A;
        final int B;
        b C;
        e<T> D;
        final g E;
        volatile boolean F;
        final long y;
        final TimeUnit z;
        static {
            Object object = new Object();
            j4.b.G = object;
        }

        b(y<? super r<T>> y, long l2, TimeUnit timeUnit3, z z4, int i5) {
            a aVar = new a();
            super(y, aVar);
            g obj2 = new g();
            this.E = obj2;
            this.y = l2;
            this.z = z4;
            this.A = i5;
            this.B = obj7;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            this.v = true;
        }

        @Override // i.b.m0.d.u
        void h() {
            e eVar;
            int i;
            b value;
            Object obj;
            Object poll;
            i iVar = this.c;
            eVar = this.D;
            i = 1;
            poll = (a)iVar.poll();
            while (this.w) {
                if (poll == j4.b.G) {
                } else {
                }
                eVar.onNext(n.getValue(poll));
                poll = iVar.poll();
                eVar.onComplete();
                if (!this.F) {
                } else {
                }
                this.C.dispose();
                eVar = e.e(this.B);
                this.D = eVar;
                this.b.onNext(eVar);
            }
            this.D = 0;
            iVar.clear();
            Throwable th = this.x;
            if (th != null) {
                eVar.onError(th);
            } else {
                eVar.onComplete();
            }
            this.E.dispose();
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            this.w = true;
            if (d()) {
                h();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            this.x = throwable;
            this.w = true;
            if (d()) {
                h();
            }
            this.b.onError(throwable);
        }

        public void onNext(T t) {
            Object obj;
            int obj2;
            if (this.F) {
            }
            if (e()) {
                this.D.onNext(t);
                if (c(-1) == 0) {
                }
            } else {
                this.c.offer(n.next(t));
                if (!d()) {
                }
            }
            h();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean validate;
            Object obj;
            long l;
            long l2;
            TimeUnit time;
            b obj8;
            this.C = b;
            this.D = e.e(this.B);
            obj8 = this.b;
            obj8.onSubscribe(this);
            obj8.onNext(this.D);
            if (c.validate(this.C, b) && !this.v) {
                this.C = b;
                this.D = e.e(this.B);
                obj8 = this.b;
                obj8.onSubscribe(this);
                obj8.onNext(this.D);
                if (!this.v) {
                    l2 = this.y;
                    this.E.a(this.A.e(this, l2, obj3, l2));
                }
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            boolean z;
            if (this.v) {
                this.F = true;
            }
            this.c.offer(j4.b.G);
            if (d()) {
                h();
            }
        }
    }

    static final class c extends u<T, Object, r<T>> implements b, Runnable {

        final TimeUnit A;
        final z.c B;
        final int C;
        final List<e<T>> D;
        b E;
        volatile boolean F;
        final long y;
        final long z;
        c(y<? super r<T>> y, long l2, long l3, TimeUnit timeUnit4, z.c z$c5, int i6) {
            a aVar = new a();
            super(y, aVar);
            this.y = l2;
            this.z = timeUnit4;
            this.A = i6;
            this.B = obj8;
            this.C = obj9;
            LinkedList obj2 = new LinkedList();
            this.D = obj2;
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            this.v = true;
        }

        void h(e<T> e) {
            j4.c.b bVar = new j4.c.b(e, 0);
            this.c.offer(bVar);
            if (d()) {
                i();
            }
        }

        @Override // i.b.m0.d.u
        void i() {
            Object iterator;
            y next;
            Iterator iterator2;
            int next2;
            int i;
            boolean iterator3;
            Object poll;
            int aVar;
            boolean z;
            i iVar = this.c;
            final List list = this.D;
            next2 = 1;
            i = next2;
            while (this.F) {
                poll = (a)iVar.poll();
                if (poll == null) {
                } else {
                }
                aVar = 0;
                z = poll instanceof j4.c.b;
                if (z) {
                } else {
                }
                iterator3 = list.iterator();
                for (e aVar : iterator3) {
                    aVar.onNext(poll);
                }
                (e)iterator3.next().onNext(poll);
                if (poll.b) {
                } else {
                }
                list.remove(poll.a);
                poll.a.onComplete();
                if (list.isEmpty() && this.v) {
                }
                if (this.v) {
                }
                this.F = next2;
                if (this.v) {
                } else {
                }
                e eVar = e.e(this.C);
                list.add(eVar);
                this.b.onNext(eVar);
                aVar = new j4.c.a(this, eVar);
                this.B.c(aVar, this.y, obj9);
                aVar = next2;
            }
            this.E.dispose();
            iVar.clear();
            list.clear();
            this.B.dispose();
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            this.w = true;
            if (d()) {
                i();
            }
            this.b.onComplete();
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            this.x = throwable;
            this.w = true;
            if (d()) {
                i();
            }
            this.b.onError(throwable);
        }

        public void onNext(T t) {
            Object iterator;
            Object next;
            boolean obj3;
            if (e()) {
                iterator = this.D.iterator();
                for (e next : iterator) {
                    next.onNext(t);
                }
                if (c(-1) == 0) {
                }
            } else {
                this.c.offer(t);
                if (!d()) {
                }
            }
            i();
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean validate;
            i.b.m0.e.e.j4.c.a aVar;
            long l2;
            z.c cVar;
            Object obj;
            long l3;
            long l;
            TimeUnit time;
            Object obj12;
            this.E = b;
            this.b.onSubscribe(this);
            if (c.validate(this.E, b) && this.v) {
                this.E = b;
                this.b.onSubscribe(this);
                if (this.v) {
                }
                obj12 = e.e(this.C);
                this.D.add(obj12);
                this.b.onNext(obj12);
                aVar = new j4.c.a(this, obj12);
                this.B.c(aVar, this.y, obj3);
                l = this.z;
                this.B.d(this, l, obj7, l);
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            boolean z;
            j4.c.b bVar = new j4.c.b(e.e(this.C), 1);
            if (!this.v) {
                this.c.offer(bVar);
            }
            if (d()) {
                i();
            }
        }
    }
    public j4(w<T> w, long l2, long l3, TimeUnit timeUnit4, z z5, long l6, int i7, boolean z8) {
        super(w);
        this.b = l2;
        this.c = timeUnit4;
        this.v = l6;
        this.w = i7;
        this.x = z8;
        this.y = obj10;
        this.z = obj11;
    }

    public void subscribeActual(y<? super r<T>> y) {
        e eVar = new e(y);
        long l = this.b;
        long l3 = this.c;
        long l5 = this.x;
        if (Long.compare(l, l3) == 0 && Long.compare(l5, l4) == 0) {
            l5 = this.x;
            if (Long.compare(l5, l4) == 0) {
                super(eVar, this.b, obj3, this.v, this.w, this.y);
                this.a.subscribe(bVar2);
            }
            super(eVar, l, obj3, this.v, this.w, this.y, l5, obj8, this.z);
            this.a.subscribe(aVar2);
        }
        super(eVar, l, obj3, l3, obj5, this.v, this.w.a(), this.y);
        this.a.subscribe(cVar3);
    }
}
