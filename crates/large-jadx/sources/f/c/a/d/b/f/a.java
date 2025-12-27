package f.c.a.d.b.f;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes2.dex */
public final class a {

    public static final int a = 0;
    static {
        sDK_INT2 = Build.VERSION.SDK_INT;
        final int i3 = 0;
        int length = 30;
    }

    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, 0, intent, i2);
    }
}
