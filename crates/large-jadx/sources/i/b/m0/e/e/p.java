package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.m0.b.b;
import i.b.m0.c.j;
import i.b.m0.d.u;
import i.b.m0.f.a;
import i.b.m0.j.r;
import i.b.o0.e;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import io.reactivex.exceptions.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class p<T, U extends Collection<? super T>>  extends i.b.m0.e.e.a<T, U> {

    final long b;
    final long c;
    final TimeUnit v;
    final z w;
    final Callable<U> x;
    final int y;
    final boolean z;

    static final class a extends u<T, U, U> implements Runnable, b {

        final TimeUnit A;
        final int B;
        final boolean C;
        final z.c D;
        U E;
        b F;
        b G;
        long H;
        long I;
        final Callable<U> y;
        final long z;
        a(y<? super U> y, Callable<U> callable2, long l3, TimeUnit timeUnit4, int i5, boolean z6, z.c z$c7) {
            a aVar = new a();
            super(y, aVar);
            this.y = callable2;
            this.z = l3;
            this.A = i5;
            this.B = z6;
            this.C = c7;
            this.D = obj9;
        }

        @Override // i.b.m0.d.u
        public void b(y y, Object object2) {
            h(y, (Collection)object2);
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            boolean z;
            if (!this.v) {
                this.v = true;
                this.G.dispose();
                this.D.dispose();
                this.E = 0;
                synchronized (this) {
                    this.v = true;
                    this.G.dispose();
                    this.D.dispose();
                    this.E = 0;
                }
            }
        }

        public void h(y<? super U> y, U u2) {
            y.onNext(u2);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            Collection collection;
            int i;
            int i2;
            this.D.dispose();
            collection = this.E;
            this.E = 0;
            synchronized (this) {
                this.D.dispose();
                collection = this.E;
                this.E = 0;
            }
            this.c.offer(collection);
            this.w = true;
            if (d()) {
                r.c(this.c, this.b, false, this, this);
            }
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            this.E = 0;
            this.b.onError(throwable);
            this.D.dispose();
            return;
            synchronized (this) {
                this.E = 0;
                this.b.onError(throwable);
                this.D.dispose();
            }
        }

        public void onNext(T t) {
            int i;
            int i2;
            long l;
            long l2;
            TimeUnit time;
            boolean obj8;
            Collection collection = this.E;
            synchronized (this) {
                try {
                    collection.add(t);
                    if (collection.size() < this.B) {
                    }
                    this.E = 0;
                    final int i4 = 1;
                    this.H = l4 += i4;
                    if (this.C) {
                    }
                    this.F.dispose();
                    g(collection, false, this);
                    obj8 = this.y.call();
                    b.e(obj8, "The buffer supplied is null");
                    this.E = (Collection)obj8;
                    this.I = l3 += i4;
                    if (this.C) {
                    }
                    l2 = this.z;
                    this.F = this.D.d(this, l2, i4, l2);
                    throw t;
                    a.b(t);
                    this.b.onError(t);
                    dispose();
                    throw t;
                } catch (Throwable th) {
                }
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean validate;
            Object obj;
            long l2;
            long l;
            TimeUnit time;
            b obj8;
            if (c.validate(this.G, b)) {
                this.G = b;
                Object call = this.y.call();
                b.e(call, "The buffer supplied is null");
                this.E = (Collection)call;
                this.b.onSubscribe(this);
                l = this.z;
                this.F = this.D.d(this, l, obj3, l);
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            int cmp;
            long l;
            Object call = this.y.call();
            b.e(call, "The bufferSupplier returned a null buffer");
            Collection collection = this.E;
            synchronized (this) {
                if (Long.compare(l2, l) != 0) {
                }
                this.E = (Collection)call;
                g(collection, false, this);
            }
        }
    }

    static final class b extends u<T, U, U> implements Runnable, b {

        final TimeUnit A;
        final z B;
        b C;
        U D;
        final AtomicReference<b> E;
        final Callable<U> y;
        final long z;
        b(y<? super U> y, Callable<U> callable2, long l3, TimeUnit timeUnit4, z z5) {
            a aVar = new a();
            super(y, aVar);
            AtomicReference obj2 = new AtomicReference();
            this.E = obj2;
            this.y = callable2;
            this.z = l3;
            this.A = z5;
            this.B = obj7;
        }

        @Override // i.b.m0.d.u
        public void b(y y, Object object2) {
            h(y, (Collection)object2);
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            c.dispose(this.E);
            this.C.dispose();
        }

        public void h(y<? super U> y, U u2) {
            this.b.onNext(u2);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            int i;
            i = this.E.get() == c.DISPOSED ? 1 : 0;
            return i;
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            Collection collection;
            Object obj;
            int i;
            collection = this.D;
            final int i3 = 0;
            this.D = i3;
            synchronized (this) {
                collection = this.D;
                i3 = 0;
                this.D = i3;
            }
            try {
                this.c.offer(collection);
                this.w = true;
                if (d()) {
                }
                r.c(this.c, this.b, false, i3, this);
                c.dispose(this.E);
                throw th;
            }
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            this.D = 0;
            this.b.onError(throwable);
            c.dispose(this.E);
            return;
            synchronized (this) {
                this.D = 0;
                this.b.onError(throwable);
                c.dispose(this.E);
            }
        }

        public void onNext(T t) {
            final Collection collection = this.D;
            synchronized (this) {
                try {
                    collection.add(t);
                    throw t;
                }
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean compareAndSet;
            int i;
            long l2;
            long l;
            TimeUnit time;
            b obj8;
            this.C = b;
            obj8 = this.y.call();
            b.e(obj8, "The buffer supplied is null");
            this.D = (Collection)obj8;
            this.b.onSubscribe(this);
            l = this.z;
            obj8 = this.B.e(this, l, obj3, l);
            if (c.validate(this.C, b) && !this.v && !this.E.compareAndSet(0, obj8)) {
                this.C = b;
                obj8 = this.y.call();
                b.e(obj8, "The buffer supplied is null");
                this.D = (Collection)obj8;
                this.b.onSubscribe(this);
                if (!this.v) {
                    l = this.z;
                    obj8 = this.B.e(this, l, obj3, l);
                    if (!this.E.compareAndSet(0, obj8)) {
                        obj8.dispose();
                    }
                }
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            Object call = this.y.call();
            b.e(call, "The bufferSupplier returned a null buffer");
            Collection collection = this.D;
            synchronized (this) {
                this.D = (Collection)call;
                if (collection == null) {
                }
                f(collection, false, this);
            }
            c.dispose(this.E);
        }
    }

    static final class c extends u<T, U, U> implements Runnable, b {

        final long A;
        final TimeUnit B;
        final z.c C;
        final List<U> D;
        b E;
        final Callable<U> y;
        final long z;
        c(y<? super U> y, Callable<U> callable2, long l3, long l4, TimeUnit timeUnit5, z.c z$c6) {
            a aVar = new a();
            super(y, aVar);
            this.y = callable2;
            this.z = l3;
            this.A = timeUnit5;
            this.B = obj8;
            this.C = obj9;
            LinkedList obj2 = new LinkedList();
            this.D = obj2;
        }

        static void i(i.b.m0.e.e.p.c p$c, Object object2, boolean z3, b b4) {
            c.g(object2, z3, b4);
        }

        static void j(i.b.m0.e.e.p.c p$c, Object object2, boolean z3, b b4) {
            c.g(object2, z3, b4);
        }

        @Override // i.b.m0.d.u
        public void b(y y, Object object2) {
            h(y, (Collection)object2);
        }

        @Override // i.b.m0.d.u
        public void dispose() {
            boolean z;
            if (!this.v) {
                this.v = true;
                k();
                this.E.dispose();
                this.C.dispose();
            }
        }

        public void h(y<? super U> y, U u2) {
            y.onNext(u2);
        }

        @Override // i.b.m0.d.u
        public boolean isDisposed() {
            return this.v;
        }

        @Override // i.b.m0.d.u
        void k() {
            this.D.clear();
            return;
            synchronized (this) {
                this.D.clear();
            }
        }

        @Override // i.b.m0.d.u
        public void onComplete() {
            boolean z;
            List next2;
            boolean next;
            i.b.m0.c.i iVar;
            z.c cVar;
            ArrayList arrayList = new ArrayList(this.D);
            this.D.clear();
            Iterator iterator = arrayList.iterator();
            synchronized (this) {
                arrayList = new ArrayList(this.D);
                this.D.clear();
                iterator = arrayList.iterator();
            }
            try {
                for (Collection next2 : iterator) {
                    this.c.offer(next2);
                }
                this.c.offer((Collection)iterator.next());
                this.w = true;
                if (d()) {
                }
                r.c(this.c, this.b, false, this.C, this);
                throw th;
            }
        }

        @Override // i.b.m0.d.u
        public void onError(Throwable throwable) {
            this.w = true;
            k();
            this.b.onError(throwable);
            this.C.dispose();
        }

        public void onNext(T t) {
            Object next;
            Iterator iterator = this.D.iterator();
            synchronized (this) {
                try {
                    for (Collection next : iterator) {
                        next.add(t);
                    }
                    (Collection)iterator.next().add(t);
                    throw t;
                }
            }
        }

        @Override // i.b.m0.d.u
        public void onSubscribe(b b) {
            boolean validate;
            i.b.m0.e.e.p.c.b bVar;
            long l;
            long l3;
            long l2;
            TimeUnit time;
            b obj9;
            if (c.validate(this.E, b)) {
                this.E = b;
                Object call = this.y.call();
                b.e(call, "The buffer supplied is null");
                this.D.add((Collection)call);
                this.b.onSubscribe(this);
                l2 = this.A;
                l3 = l2;
                this.C.d(this, l3, obj4, l2);
                bVar = new p.c.b(this, call);
                this.C.c(bVar, this.z, l3);
            }
        }

        @Override // i.b.m0.d.u
        public void run() {
            if (this.v) {
            }
            Object call = this.y.call();
            b.e(call, "The bufferSupplier returned a null buffer");
            synchronized (this) {
            }
        }
    }
    public p(w<T> w, long l2, long l3, TimeUnit timeUnit4, z z5, Callable<U> callable6, int i7, boolean z8) {
        super(w);
        this.b = l2;
        this.c = timeUnit4;
        this.v = callable6;
        this.w = i7;
        this.x = z8;
        this.y = obj9;
        this.z = obj10;
    }

    protected void subscribeActual(y<? super U> y) {
        int cmp;
        int i;
        long l2 = this.b;
        if (Long.compare(l2, l) == 0 && this.y == Integer.MAX_VALUE) {
            if (this.y == Integer.MAX_VALUE) {
                e eVar = new e(y);
                super(eVar, this.x, l2, obj4, this.v, this.w);
                this.a.subscribe(bVar2);
            }
        }
        final z.c cVar2 = this.w.a();
        final long l3 = this.b;
        long l4 = this.c;
        if (Long.compare(l3, l4) == 0) {
            e eVar3 = new e(y);
            super(eVar3, this.x, l3, obj5, this.v, this.y, this.z, cVar2);
            this.a.subscribe(aVar2);
        }
        e eVar2 = new e(y);
        super(eVar2, this.x, l3, obj5, l4, obj7, this.v, cVar2);
        this.a.subscribe(cVar3);
    }
}
