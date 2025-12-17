package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class a0 {

    final androidx.recyclerview.widget.a0.b a;
    androidx.recyclerview.widget.a0.a b;

    static class a {

        int a = 0;
        int b;
        int c;
        int d;
        int e;
        a() {
            super();
            final int i = 0;
        }

        void a(int i) {
            this.a = i |= i2;
        }

        boolean b() {
            int i7;
            int i;
            int i5;
            int i8;
            int i4;
            int i6;
            int i2;
            int i9;
            int i3;
            i7 = this.a;
            final int i19 = 0;
            if (i7 & 7 != 0 && i7 &= i4 == 0) {
                if (i7 &= i4 == 0) {
                    return i19;
                }
            }
            i = this.a;
            if (i & 112 != 0 && i &= i6 == 0) {
                if (i &= i6 == 0) {
                    return i19;
                }
            }
            i5 = this.a;
            if (i5 & 1792 != 0 && i5 &= i2 == 0) {
                if (i5 &= i2 == 0) {
                    return i19;
                }
            }
            i8 = this.a;
            if (i8 & 28672 != 0 && i8 &= i9 == 0) {
                if (i8 &= i9 == 0) {
                    return i19;
                }
            }
            return 1;
        }

        int c(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            if (i == i2) {
                return 2;
            }
            return 4;
        }

        void d() {
            this.a = 0;
        }

        void e(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    interface b {
        public abstract View a(int i);

        public abstract int b(View view);

        public abstract int c();

        public abstract int d();

        public abstract int e(View view);
    }
    a0(androidx.recyclerview.widget.a0.b a0$b) {
        super();
        this.a = b;
        a0.a obj1 = new a0.a();
        this.b = obj1;
    }

    View a(int i, int i2, int i3, int i4) {
        int i5;
        int i8;
        View view;
        int i6;
        int i7;
        androidx.recyclerview.widget.a0.a aVar;
        int obj9;
        i5 = i2 > i ? 1 : -1;
        i8 = 0;
        while (obj9 != i2) {
            view = this.a.a(obj9);
            this.b.e(this.a.c(), this.a.d(), this.a.b(view), this.a.e(view));
            this.b.d();
            this.b.a(i4);
            if (i4 != 0 && this.b.b()) {
            }
            obj9 += i5;
            this.b.d();
            this.b.a(i4);
            if (this.b.b()) {
            }
            i8 = view;
            this.b.d();
            this.b.a(i3);
        }
        return i8;
    }

    boolean b(View view, int i2) {
        this.b.e(this.a.c(), this.a.d(), this.a.b(view), this.a.e(view));
        if (i2 != 0) {
            this.b.d();
            this.b.a(i2);
            return this.b.b();
        }
        return 0;
    }
}
