package i.b.m0.e.b;

import i.b.h;
import i.b.m0.b.b;
import i.b.m0.c.a;
import i.b.m0.i.b;
import i.b.m0.i.d;
import i.b.m0.i.g;
import i.b.m0.j.d;
import io.reactivex.exceptions.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;

/* loaded from: classes3.dex */
public final class q<T>  extends h<T> {

    final Iterable<? extends T> b;

    static abstract class a extends b<T> {

        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;
        a(Iterator<? extends T> iterator) {
            super();
            this.it = iterator;
        }

        @Override // i.b.m0.i.b
        abstract void a();

        @Override // i.b.m0.i.b
        abstract void b(long l);

        @Override // i.b.m0.i.b
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // i.b.m0.i.b
        public final void clear() {
            this.it = 0;
        }

        @Override // i.b.m0.i.b
        public final boolean isEmpty() {
            int i;
            Iterator next;
            next = this.it;
            if (next != null) {
                if (!next.hasNext()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public final T poll() {
            int next;
            Iterator it = this.it;
            int i = 0;
            if (it == null) {
                return i;
            }
            if (!this.once) {
                this.once = true;
            } else {
                if (!it.hasNext()) {
                    return i;
                }
            }
            Object next2 = this.it.next();
            b.e(next2, "Iterator.next() returned a null value");
            return next2;
        }

        @Override // i.b.m0.i.b
        public final void request(long l) {
            boolean validate;
            int i;
            if (g.validate(l) && Long.compare(l2, i) == 0) {
                if (Long.compare(l2, i) == 0) {
                    if (Long.compare(l, l3) == 0) {
                        a();
                    } else {
                        b(l);
                    }
                }
            }
        }

        @Override // i.b.m0.i.b
        public final int requestFusion(int i) {
            return i &= 1;
        }
    }

    static final class b extends i.b.m0.e.b.q.a<T> {

        private static final long serialVersionUID = -6022804456014692607L;
        final a<? super T> downstream;
        b(a<? super T> a, Iterator<? extends T> iterator2) {
            super(iterator2);
            this.downstream = a;
        }

        @Override // i.b.m0.e.b.q$a
        void a() {
            boolean next;
            boolean cancelled;
            Iterator it = this.it;
            final a downstream = this.downstream;
            while (this.cancelled) {
                Object next2 = it.next();
                downstream.c(next2);
            }
        }

        @Override // i.b.m0.e.b.q$a
        void b(long l) {
            int cmp2;
            int i;
            int cmp;
            boolean next;
            Throwable obj9;
            final Iterator it = this.it;
            final a downstream = this.downstream;
            final int i2 = 0;
            while (/* condition */) {
                while (Long.compare(i, obj9) != 0) {
                    Object next2 = it.next();
                    if (downstream.c(next2)) {
                    }
                    i += cmp;
                }
                i = i2;
                next2 = it.next();
                if (downstream.c(next2)) {
                }
                i += cmp;
            }
        }
    }

    static final class c extends i.b.m0.e.b.q.a<T> {

        private static final long serialVersionUID = -6022804456014692607L;
        final b<? super T> downstream;
        c(b<? super T> b, Iterator<? extends T> iterator2) {
            super(iterator2);
            this.downstream = b;
        }

        @Override // i.b.m0.e.b.q$a
        void a() {
            boolean next;
            boolean cancelled;
            Iterator it = this.it;
            final b downstream = this.downstream;
            while (this.cancelled) {
                Object next2 = it.next();
                downstream.onNext(next2);
            }
        }

        @Override // i.b.m0.e.b.q$a
        void b(long l) {
            int cmp2;
            int i;
            int cmp;
            boolean cancelled;
            Throwable obj9;
            final Iterator it = this.it;
            final b downstream = this.downstream;
            final int i2 = 0;
            while (/* condition */) {
                while (Long.compare(i, obj9) != 0) {
                    Object next = it.next();
                    downstream.onNext(next);
                    i += cmp;
                }
                i = i2;
                next = it.next();
                downstream.onNext(next);
                i += cmp;
            }
        }
    }
    public q(Iterable<? extends T> iterable) {
        super();
        this.b = iterable;
    }

    public static <T> void g0(b<? super T> b, Iterator<? extends T> iterator2) {
        i.b.m0.e.b.q.a bVar2;
        b bVar;
        try {
            if (!iterator2.hasNext()) {
            }
            d.complete(b);
            bVar2 = new q.b((a)b, iterator2);
            b.onSubscribe(bVar2);
        }
        bVar2 = new q.c(b, iterator2);
        b.onSubscribe(bVar2);
    }

    public void c0(b<? super T> b) {
        try {
            q.g0(b, this.b.iterator());
            a.b(th);
            d.error(th, b);
        }
    }
}
