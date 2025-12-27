package d.h.i;

import android.graphics.Typeface;
import android.os.Handler;

/* compiled from: CallbackWithHandler.java */
/* loaded from: classes.dex */
class a {

    private final f.c a;
    private final Handler b;

    class a implements Runnable {

        final /* synthetic */ f.c a;
        final /* synthetic */ Typeface b;
        a(f.c cVar, Typeface typeface) {
            this.a = cVar;
            this.b = typeface;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.b);
        }
    }

    class b implements Runnable {

        final /* synthetic */ f.c a;
        final /* synthetic */ int b;
        b(f.c cVar, int i) {
            this.a = cVar;
            this.b = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }
    a(f.c cVar, Handler handler) {
        super();
        this.a = cVar;
        this.b = handler;
    }

    private void a(int i) {
        this.b.post(new a.b(this, this.a, i));
    }

    private void c(Typeface typeface) {
        this.b.post(new a.a(this, this.a, typeface));
    }

    void b(e.e eVar) {
        if (eVar.a()) {
            c(eVar.a);
        } else {
            a(eVar.b);
        }
    }
}
