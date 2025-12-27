package f.c.a.f.a.d;

import android.util.Log;
import java.util.Set;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class r implements Runnable {

    final /* synthetic */ Set a;
    final /* synthetic */ a b;
    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.i(this.a);
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
            return;
        }
    }

    r(a aVar, Set set) {
        this.b = aVar;
        this.a = set;
        super();
    }
}
