package f.c.a.f.a.d;

import android.util.Log;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class q implements Runnable {

    final /* synthetic */ a a;
    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a.k();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
            return;
        }
    }

    q(a aVar) {
        this.a = aVar;
        super();
    }
}
