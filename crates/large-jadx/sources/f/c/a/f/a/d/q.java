package f.c.a.f.a.d;

import android.util.Log;

/* loaded from: classes2.dex */
final class q implements Runnable {

    final f.c.a.f.a.d.a a;
    q(f.c.a.f.a.d.a a) {
        this.a = a;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a.c(this.a).k();
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", th);
        }
    }
}
