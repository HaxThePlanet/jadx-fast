package f.c.a.f.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
final class c extends BroadcastReceiver {

    final f.c.a.f.a.c.d a;
    c(f.c.a.f.a.c.d d, f.c.a.f.a.c.b b2) {
        this.a = d;
        super();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent2) {
        this.a.a(context, intent2);
    }
}
