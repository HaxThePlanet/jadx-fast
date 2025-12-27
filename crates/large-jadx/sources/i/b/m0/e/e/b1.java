package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.m0.d.c;
import i.b.r;
import i.b.y;

/* compiled from: ObservableFromArray.java */
/* loaded from: classes3.dex */
public final class b1<T> extends r<T> {

    final T[] a;

    static final class a<T> extends c<T> {

        final y<? super T> a;
        final T[] b;
        int c;
        boolean v;
        volatile boolean w;
        a(y<? super T> yVar, T[] tArr) {
            super();
            this.a = yVar;
            this.b = tArr;
        }

        @Override // i.b.m0.d.c
        void a() {
            int i = 0;
            Object obj;
            i = 0;
            while (i < objArr.length) {
                obj = objArr[i];
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "The element at index ";
                    String str = " is null";
                    r2 = str2 + i + str;
                    this.a.onError(new NullPointerException(r2));
                    return;
                }
            }
            if (!isDisposed()) {
                this.a.onComplete();
            }
        }

        @Override // i.b.m0.d.c
        public void clear() {
            this.c = this.b.length;
        }

        @Override // i.b.m0.d.c
        public void dispose() {
            this.w = true;
        }

        @Override // i.b.m0.d.c
        public boolean isDisposed() {
            return this.w;
        }

        @Override // i.b.m0.d.c
        public boolean isEmpty() {
            boolean z = true;
            int r0 = this.c == this.b.length ? 1 : 0;
            return (this.c == this.b.length ? 1 : 0);
        }

        @Override // i.b.m0.d.c
        public T poll() {
            if (this.c != objArr.length) {
                this.c++;
                Object obj = objArr[i];
                b.e(obj, "The array element is null");
                return obj;
            }
            return null;
        }

        @Override // i.b.m0.d.c
        public int requestFusion(int i) {
            final boolean z = true;
            if (i & z != 0) {
                this.v = z;
                return z;
            }
            return 0;
        }
    }
    public b1(T[] tArr) {
        super();
        this.a = tArr;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        final i.b.m0.e.e.b1.a aVar = new b1.a(yVar, this.a);
        yVar.onSubscribe(aVar);
        if (aVar.v) {
            return;
        }
        aVar.a();
    }
}
