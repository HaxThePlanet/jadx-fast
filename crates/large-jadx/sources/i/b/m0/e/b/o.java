package i.b.m0.e.b;

import i.b.h;
import i.b.m0.c.a;
import i.b.m0.i.g;
import i.b.m0.j.d;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableFromArray.java */
/* loaded from: classes3.dex */
public final class o<T> extends h<T> {

    final T[] b;

    static abstract class c<T> extends i.b.m0.i.b<T> {

        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;
        c(T[] tArr) {
            super();
            this.array = tArr;
        }

        @Override // i.b.m0.i.b
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // i.b.m0.i.b
        public final void clear() {
            this.index = this.array.length;
        }

        @Override // i.b.m0.i.b
        public final boolean isEmpty() {
            boolean z = true;
            int r0 = this.index == this.array.length ? 1 : 0;
            return (this.index == this.array.length ? 1 : 0);
        }

        @Override // i.b.m0.i.b
        public final T poll() {
            if (this.index == array2.length) {
                return null;
            }
            this.index++;
            Object obj = array2[index2];
            b.e(obj, "array element is null");
            return obj;
        }

        @Override // i.b.m0.i.b
        public final void request(long j) {
            if (g.validate(j)) {
                long l2 = d.a(this, j);
                long l = 0L;
                if (l2 == l) {
                    if (j == 9223372036854775807L) {
                        a();
                    } else {
                        b(j);
                    }
                }
            }
        }

        @Override // i.b.m0.i.b
        abstract void a();

        @Override // i.b.m0.i.b
        abstract void b(long j);

        @Override // i.b.m0.i.b
        public final int requestFusion(int i) {
            return i & 1;
        }
    }

    static final class a<T> extends o.c<T> {

        private static final long serialVersionUID = 2587302975077663557L;
        final a<? super T> downstream;
        a(a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.downstream = aVar;
        }

        @Override // i.b.m0.e.b.o$c
        void a() {
            int index2;
            while (this.index != array2.length) {
                Object obj = array2[index2];
                if (this.cancelled == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "The element at index ";
                    String str = " is null";
                    r1 = str2 + index2 + str;
                    this.downstream.onError(new NullPointerException(r1));
                    return;
                }
            }
            if (this.cancelled) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // i.b.m0.e.b.o$c
        void b(long j) {
            int index2;
            int i;
            int cmp2;
            boolean z = true;
            long andGet;
            final int length = array2.length;
            final long l = 0L;
            while (/* condition */) {
                while (i != andGet) {
                    andGet = get();
                    if (i == andGet) {
                        this.index = index2;
                        andGet = addAndGet(-i);
                    }
                    Object obj = array2[index2];
                    if (this.cancelled == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "The element at index ";
                        String str2 = " is null";
                        r12 = str + index2 + str2;
                        this.downstream.onError(new NullPointerException(r12));
                        return;
                    }
                }
                andGet = get();
                if (i == andGet) {
                    this.index = index2;
                    andGet = addAndGet(-i);
                }
                obj = array2[index2];
                if (this.cancelled == null) {
                    stringBuilder = new StringBuilder();
                    str = "The element at index ";
                    str2 = " is null";
                    r12 = str + index2 + str2;
                    this.downstream.onError(new NullPointerException(r12));
                    return;
                }
            }
        }
    }

    static final class b<T> extends o.c<T> {

        private static final long serialVersionUID = 2587302975077663557L;
        final m.c.b<? super T> downstream;
        b(m.c.b<? super T> bVar, T[] tArr) {
            super(tArr);
            this.downstream = bVar;
        }

        @Override // i.b.m0.e.b.o$c
        void a() {
            int index2;
            while (this.index != array2.length) {
                Object obj = array2[index2];
                if (this.cancelled == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "The element at index ";
                    String str = " is null";
                    r1 = str2 + index2 + str;
                    this.downstream.onError(new NullPointerException(r1));
                    return;
                }
            }
            if (this.cancelled) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // i.b.m0.e.b.o$c
        void b(long j) {
            int index2;
            int i;
            int cmp2;
            long andGet;
            final int length = array2.length;
            final long l = 0L;
            while (/* condition */) {
                while (i != andGet) {
                    andGet = get();
                    if (i == andGet) {
                        this.index = index2;
                        andGet = addAndGet(-i);
                    }
                    Object obj = array2[index2];
                    if (this.cancelled == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "The element at index ";
                        String str2 = " is null";
                        r12 = str + index2 + str2;
                        this.downstream.onError(new NullPointerException(r12));
                        return;
                    }
                }
                andGet = get();
                if (i == andGet) {
                    this.index = index2;
                    andGet = addAndGet(-i);
                }
                obj = array2[index2];
                if (this.cancelled == null) {
                    stringBuilder = new StringBuilder();
                    str = "The element at index ";
                    str2 = " is null";
                    r12 = str + index2 + str2;
                    this.downstream.onError(new NullPointerException(r12));
                    return;
                }
            }
        }
    }
    public o(T[] tArr) {
        super();
        this.b = tArr;
    }

    @Override // i.b.h
    public void c0(m.c.b<? super T> bVar) {
        if (bVar instanceof a) {
            bVar.onSubscribe(new o.a((a)bVar, this.b));
        } else {
            bVar.onSubscribe(new o.b(bVar, this.b));
        }
    }
}
