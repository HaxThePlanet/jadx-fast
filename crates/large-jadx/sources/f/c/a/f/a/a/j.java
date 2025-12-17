package f.c.a.f.a.a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.a;
import com.google.android.play.core.tasks.d;

/* loaded from: classes2.dex */
final class j implements f.c.a.f.a.a.b {

    private final f.c.a.f.a.a.s a;
    private final Context b;
    j(f.c.a.f.a.a.s s, f.c.a.f.a.a.g g2, Context context3) {
        super();
        Handler obj3 = new Handler(Looper.getMainLooper());
        this.a = s;
        this.b = context3;
    }

    public final d<f.c.a.f.a.a.a> a() {
        return this.a.e(this.b.getPackageName());
    }

    @Override // f.c.a.f.a.a.b
    public final boolean b(f.c.a.f.a.a.a a, int i2, Activity activity3, int i4) {
        if (activity3 == null) {
            return 0;
        }
        i iVar = new i(this, activity3);
        return c(a, iVar, d.c(i2), i4);
    }

    @Override // f.c.a.f.a.a.b
    public final boolean c(f.c.a.f.a.a.a a, a a2, f.c.a.f.a.a.d d3, int i4) {
        boolean z;
        if (a != null && a2 != null && d3 != null && a.b(d3) && a.g()) {
            if (a2 != null) {
                if (d3 != null) {
                    if (a.b(d3)) {
                        if (a.g()) {
                        }
                        a.f();
                        a2.a(a.d(d3).getIntentSender(), i4, 0, 0, 0, 0, 0);
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
