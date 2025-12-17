package i.b.m0.e.b;

import i.b.h;
import i.b.m0.b.b;
import i.b.m0.c.a;
import i.b.m0.i.b;
import i.b.m0.i.g;
import i.b.m0.j.d;
import java.util.concurrent.atomic.AtomicLong;
import m.c.b;

/* loaded from: classes3.dex */
public final class o<T>  extends h<T> {

    final T[] b;

    static abstract class c extends b<T> {

        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;
        c(T[] tArr) {
            super();
            this.array = tArr;
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
            this.index = array.length;
        }

        @Override // i.b.m0.i.b
        public final boolean isEmpty() {
            int i;
            i = this.index == array.length ? 1 : 0;
            return i;
        }

        public final T poll() {
            int index = this.index;
            Object[] array = this.array;
            if (index == array.length) {
                return 0;
            }
            this.index = index + 1;
            Object obj = array[index];
            b.e(obj, "array element is null");
            return obj;
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

    static final class a extends i.b.m0.e.b.o.c<T> {

        private static final long serialVersionUID = 2587302975077663557L;
        final a<? super T> downstream;
        a(a<? super T> a, T[] t2Arr2) {
            super(t2Arr2);
            this.downstream = a;
        }

        @Override // i.b.m0.e.b.o$c
        void a() {
            int index;
            Object obj;
            Object[] array = this.array;
            final a downstream = this.downstream;
            index = this.index;
            while (index != array.length) {
                obj = array[index];
                downstream.c(obj);
                index++;
            }
            if (this.cancelled) {
            }
            downstream.onComplete();
        }

        @Override // i.b.m0.e.b.o$c
        void b(long l) {
            int index;
            int cmp2;
            int i;
            int cmp;
            long obj11;
            Object[] array = this.array;
            final int length = array.length;
            index = this.index;
            final a downstream = this.downstream;
            final int i2 = 0;
            while (/* condition */) {
                while (Long.compare(i, obj11) != 0) {
                    Object obj = array[index];
                    if (downstream.c(obj)) {
                    }
                    index++;
                    i += cmp;
                }
                this.index = index;
                i = i2;
                obj = array[index];
                if (downstream.c(obj)) {
                }
                index++;
                i += cmp;
            }
        }
    }

    static final class b extends i.b.m0.e.b.o.c<T> {

        private static final long serialVersionUID = 2587302975077663557L;
        final b<? super T> downstream;
        b(b<? super T> b, T[] t2Arr2) {
            super(t2Arr2);
            this.downstream = b;
        }

        @Override // i.b.m0.e.b.o$c
        void a() {
            int index;
            Object obj;
            Object[] array = this.array;
            final b downstream = this.downstream;
            index = this.index;
            while (index != array.length) {
                obj = array[index];
                downstream.onNext(obj);
                index++;
            }
            if (this.cancelled) {
            }
            downstream.onComplete();
        }

        @Override // i.b.m0.e.b.o$c
        void b(long l) {
            int index;
            int cmp;
            int i;
            int cmp2;
            long obj11;
            Object[] array = this.array;
            final int length = array.length;
            index = this.index;
            final b downstream = this.downstream;
            final int i2 = 0;
            while (/* condition */) {
                while (Long.compare(i, obj11) != 0) {
                    Object obj = array[index];
                    downstream.onNext(obj);
                    i += cmp2;
                    index++;
                }
                this.index = index;
                i = i2;
                obj = array[index];
                downstream.onNext(obj);
                i += cmp2;
                index++;
            }
        }
    }
    public o(T[] tArr) {
        super();
        this.b = tArr;
    }

    public void c0(b<? super T> b) {
        i.b.m0.e.b.o.c aVar;
        Object obj;
        Object[] objArr;
        if (b instanceof a) {
            aVar = new o.a((a)b, this.b);
            b.onSubscribe(aVar);
        } else {
            aVar = new o.b(b, this.b);
            b.onSubscribe(aVar);
        }
    }
}
