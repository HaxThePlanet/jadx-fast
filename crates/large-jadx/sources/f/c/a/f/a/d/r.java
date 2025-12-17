package f.c.a.f.a.d;

import android.util.Log;
import java.util.Set;

/* loaded from: classes2.dex */
final class r implements Runnable {

    final Set a;
    final f.c.a.f.a.d.a b;
    r(f.c.a.f.a.d.a a, Set set2) {
        this.b = a;
        this.a = set2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a.e(this.b, this.a);
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", th);
        }
    }
}
