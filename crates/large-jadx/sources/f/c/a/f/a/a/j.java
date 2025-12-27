package f.c.a.f.a.a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.a;
import com.google.android.play.core.tasks.d;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class j implements b {

    private final s a;
    private final Context b;
    j(s sVar, g gVar, Context context) {
        super();
        final Handler handler = new Handler(Looper.getMainLooper());
        this.a = sVar;
        this.b = context;
    }

    public final d<a> a() {
        return this.a.e(this.b.getPackageName());
    }

    public final boolean b(a aVar, int i, Activity activity, int i2) {
        if (activity == null) {
            return false;
        }
        return c(aVar, new i(this, activity), d.c(i), i2);
    }

    public final boolean c(a aVar, a aVar2, d dVar, int i) {
        return false;
    }
}
