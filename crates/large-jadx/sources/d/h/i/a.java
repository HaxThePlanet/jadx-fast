package d.h.i;

import android.graphics.Typeface;
import android.os.Handler;

/* loaded from: classes.dex */
class a {

    private final d.h.i.f.c a;
    private final Handler b;

    class a implements Runnable {

        final d.h.i.f.c a;
        final Typeface b;
        a(d.h.i.a a, d.h.i.f.c f$c2, Typeface typeface3) {
            this.a = c2;
            this.b = typeface3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    class b implements Runnable {

        final d.h.i.f.c a;
        final int b;
        b(d.h.i.a a, d.h.i.f.c f$c2, int i3) {
            this.a = c2;
            this.b = i3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }
    a(d.h.i.f.c f$c, Handler handler2) {
        super();
        this.a = c;
        this.b = handler2;
    }

    private void a(int i) {
        a.b bVar = new a.b(this, this.a, i);
        this.b.post(bVar);
    }

    private void c(Typeface typeface) {
        a.a aVar = new a.a(this, this.a, typeface);
        this.b.post(aVar);
    }

    void b(d.h.i.e.e e$e) {
        Typeface obj2;
        if (e.a()) {
            c(e.a);
        } else {
            a(e.b);
        }
    }
}
